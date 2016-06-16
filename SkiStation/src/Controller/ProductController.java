/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Itemprice;
import DBClasses.Pricelist;
import DBClasses.Product;
import Tools.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rafał
 */
public class ProductController {
    private Session s;
    
    public ProductController()
    {
        s = HibernateUtil.getSessionFactory().openSession();
    }
    
    public boolean CreateProduct(String newProductName,String newProductPrice, StringBuilder logger)
    {
        int price =0;
        try   {
            price = Integer.parseInt(newProductPrice);
        }catch(Exception e)
        {
            logger.append(e.getMessage());
            return false;
        }
        
        if (price <= 0) {
            logger.append("Price is too low");
            return false;               
        }
        
        if (newProductName.isEmpty()) {
            logger.append("Bad product name");
            return false;   
        }
        
        if (findProduct(newProductName)!=null) {
            logger.append("Product with the same name already exist");
            return false;                 
        }else{
            Transaction tr = s.beginTransaction();
            Product product = new Product();
            product.setName(newProductName);
            s.saveOrUpdate(product);
            tr.commit();
            
            Pricelist defaultPriceList = (Pricelist)getPriceListsList("1").get(0);
            addPriceItem(defaultPriceList, product, price); 
            
            logger.append("Added new product with name : " + newProductName);
            return true;
        }
    }
    
    public void addPriceItem(Pricelist priceList, Product product, int price)
    {
        Transaction tr = s.beginTransaction();
            Itemprice itemprice = new Itemprice();
            itemprice.setPricelist(priceList);
            itemprice.setProduct(product);
            itemprice.setPrice(price);
            s.saveOrUpdate(itemprice);
            tr.commit();
    }
    
    public boolean addPriceItem(Pricelist priceList, Product product, int price, StringBuilder sb)
    {
        if (price <= 0) {
            sb.append("Price is too low");
            return false;               
        }
        
        boolean existInList = false;
        for (Object itempriceObj : priceList.getItemprices()) {
            Itemprice itemPrice = (Itemprice)itempriceObj;
            if (itemPrice.getProduct() == product) {
                existInList = true;
                break;                        
            }
        }
        
        if (existInList) {
            sb.append("This product exist in this list");
            return false;
        }else  {
            addPriceItem(priceList, product, price);
            sb.append("Added !");
             return true;
        }     
       
        
    }
    
    public List getProductList()
    {
         List quaryResult = s.createCriteria(Product.class).list();
         return quaryResult;                
    }
    
    
    
    public List getProductList(String text)
    {
         List quaryResult = s.createCriteria(Product.class).add(Restrictions.like("name", ("%"+text+"%"))).list();
         return quaryResult;                
    }
        
    public List getPriceListsList()
    {
         List quaryResult = s.createCriteria(Pricelist.class).list();
         return quaryResult;                
    }  
    
    public List getPriceListsList(String text)
    {
        Integer id;
        try{
        id = Integer.parseInt(text);
        }catch(Exception e){
            id =null;
        }
             
        if (id == null) {
            return getPriceListsList();
        }else{
            List quaryResult = s.createCriteria(Pricelist.class).add(Restrictions.eq("pricelistid", id)).list();
            return quaryResult;  
        }     
    }
    
    public List getPriceItems(String id)
    {
        Pricelist priceList = (Pricelist)getPriceListsList(id).get(0);
         List quaryResult = s.createCriteria(Itemprice.class).add(Restrictions.eq("pricelist", priceList)).list();
         for (Object object : quaryResult) {
            Itemprice ip = (Itemprice)object;
            System.out.print(ip.getProduct().getName());
        }
         return quaryResult;                
    }  
                    
    private Product findProduct(String name)
    {
         List quaryResult = s.createCriteria(Product.class).add(Restrictions.like("name", name)).list();
         Product product;
          if (quaryResult.size()>0) {
            product = (Product)quaryResult.get(0);
          }else{
            product = null;        
          }
          return product;     
    }
    
        public boolean CreatePriceList(String from,String to, StringBuilder logger)
    {
        
        Date fromDate = getDateFromString(from);
        Date toDate = getDateFromString(to);
        if (fromDate == null || toDate == null) {
            logger.append("Date format error");
            return false;
        }else{
            Transaction tr = s.beginTransaction();
            Pricelist priceList = new Pricelist();
            priceList.setStartdate(fromDate);
            priceList.setEnddate(toDate);
            s.saveOrUpdate(priceList);
            tr.commit();
            logger.append("Added new Price List with ID :" + priceList.getPricelistid());
            return true;
        }
    }
        
        private Date getDateFromString(String text)
        {
            System.out.print(text);
            String[] dateStrings = text.split("-");
            try
            {
            int day=Integer.parseInt(dateStrings[0]);
            int month = Integer.parseInt(dateStrings[1]);
            int year = Integer.parseInt(dateStrings[2]);
            return new Date(year-1900,month-1,day);
            }catch(Exception e)
            {
                return null;
            }
            
        }
        public void addDefaultPriceListIfNotExist()
        {
            List list = getPriceListsList();
            if (list.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                CreatePriceList("1-1-2000","1-1-2099",sb);
            }
        }
    
    
        
    public int getActualProductPrice(Product product) {

        List queryResult = s.createCriteria(Itemprice.class).add(Restrictions.eq("product", product)).list(); // Retrieving all product prices, don't care about their dates 
        Itemprice mostActualPrice = null;

        if (!queryResult.isEmpty()) {
            for (Object itemPriceObj : queryResult) { // Looking for most actual product price based on pricelists and their start-end dates
                Itemprice itemPrice = (Itemprice) itemPriceObj;
                Pricelist pricelist = itemPrice.getPricelist();
                Date actDate = new Date();
              
                if (actDate.after(pricelist.getStartdate()) && actDate.before(pricelist.getEnddate())) {
                    if (mostActualPrice == null || (itemPrice.getItempriceid() > mostActualPrice.getItempriceid())) {
                        mostActualPrice = itemPrice;
                    }
                }
            }
            return (mostActualPrice != null) ? mostActualPrice.getPrice() : -1;
        } else {
            return -1; // Returning -1 if at least one price wasn't found
        }
    }
}
