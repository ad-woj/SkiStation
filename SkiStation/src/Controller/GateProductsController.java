/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Cards;
import DBClasses.Product;
import DBClasses.Productitem;
import DBClasses.Terminal;
import Tools.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rafał
 */
public class GateProductsController {
    private Session s;
    
    public GateProductsController()
    {
        s = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List GetTerminals()
    {
        return s.createCriteria(Terminal.class).list();
    }
   
    public List GetProducts()
    {
        return s.createCriteria(Product.class).list();
    }
    
    public void addProductToTerminal(int terminalID, int productID, StringBuilder logger)
    {
        List terminals =  s.createQuery(String.format("FROM Terminal C WHERE C.terminalid = '%d'", terminalID )).list();
        List productItems =  s.createQuery(String.format("FROM Productitem C WHERE C.terminal = '%d'", terminalID )).list();
        List products =  s.createQuery(String.format("FROM Product C WHERE C.productid = '%d'", productID )).list();
        if (!productItems.isEmpty()) {
            for (Object productItemObj : productItems) {
                Productitem p = (Productitem)productItemObj;
                if (p.getProduct().getProductid() == productID) {
                    logger.append("Cant add twice the same product to terminal");
                    return;
                }
            }        
        }
        Product product = null;
        if (!products.isEmpty()) {
            product = (Product)products.get(0);
        }else{
             logger.append("Product not available");
             return;
        }
        
        Terminal terminal= null;
        if (!terminals.isEmpty()) {
            terminal = (Terminal)terminals.get(0);
        }else{
             logger.append("terminal not available");
             return;
        }
        
        Transaction tr = s.beginTransaction();
              
        Productitem p = new Productitem();
        p.setProduct(product);
        p.setTerminal(terminal);


        s.saveOrUpdate(p);

        tr.commit();
        
    }
    
    public void removeProductFromTerminal(int terminalID, int productID, StringBuilder logger)
    {
        List productItems =  s.createQuery(String.format("FROM Productitem C WHERE C.terminal = '%d' AND C.product = '%d'", terminalID,productID )).list(); 
        Productitem p = null;
        if (productItems.isEmpty()) {
            logger.append("This product is not available in this terminal");
            return;    
        }else{
            p = (Productitem)productItems.get(0);
        }       
        
        Transaction tr = s.beginTransaction();
    
        s.delete(p);

        tr.commit();
        
    }
}
