/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Cards;
import DBClasses.Productitem;
import DBClasses.Terminal;
import Tools.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rafał
 */
public class Symulator {
        private Session s;
    
    public Symulator()
    {
        s = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List GetCards()
    {
        return s.createCriteria(Cards.class).list();
    }
    
    public int GetCardPoints(int cardID )
    {
        List list = s.createCriteria(Cards.class).add(Restrictions.like("cardid", cardID)).list();
        if (!list.isEmpty()) {
            return ((Cards)list.get(0)).getPoints();
        }else{
            return 0;
        }
    }
    
    public List GetTerminals()
    {
        return s.createCriteria(Terminal.class).list();
    }
    
   /* public void BuyProducts(List list, int cardID)
    {
        List cards =  s.createCriteria(Cards.class).add(Restrictions.like("cardid", cardID)).list();
        if (!cards.isEmpty()) {
            
        }
    }*/
    
    public void BuyProductsFor(int cardID, int sum)
    {
        List cards =  s.createQuery(String.format("FROM Cards C WHERE C.cardid = '%d'", cardID )).list();
        if (!cards.isEmpty()) {
            Cards card = (Cards)cards.get(0);
            Transaction tr = s.beginTransaction();
            card.setPoints(card.getPoints() - sum);
            s.saveOrUpdate(card);
            tr.commit();
        }
    }
    
}

