/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Pricelist;
import DBClasses.Product;
import DBClasses.Users;
import Tools.HibernateUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
    
    public boolean CreateProduct(String newProductName, StringBuilder logger)
    {
        if (findProduct(newProductName)!=null) {
            logger.append("Product with the same name already exist");
            return false;                 
        }else{
            Transaction tr = s.beginTransaction();
            Product product = new Product();
            product.setName(newProductName);
            s.saveOrUpdate(product);
            tr.commit();
            logger.append("Added new product with name : " + newProductName);
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
            List quaryResult = s.createCriteria(Pricelist.class).add(Restrictions.eqOrIsNull("pricelistid", id)).list();
            return quaryResult;  
        }     
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
                for (String dateString : dateStrings) {
                    System.out.println(dateString);
                }
            int day=Integer.parseInt(dateStrings[0]);
            int month = Integer.parseInt(dateStrings[1]);
            int year = Integer.parseInt(dateStrings[2]);
            return new Date(year-1900,month-1,day);
            }catch(Exception e)
            {
                return null;
            }
            
        }
    
    
}
