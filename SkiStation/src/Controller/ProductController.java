/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Product;
import DBClasses.Users;
import Tools.HibernateUtil;
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
}
