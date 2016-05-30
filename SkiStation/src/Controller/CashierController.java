/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Users;
import Tools.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bluu
 */
public class CashierController {
 
    private Session s;
    
    public CashierController()
    {
        s = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List GetUsersList(String text)
    {
         List queryResult = s.createCriteria(Users.class).add(Restrictions.disjunction()
                 .add(Restrictions.like("login", text,MatchMode.ANYWHERE))
                 .add(Restrictions.like("name", text,MatchMode.ANYWHERE))
                 .add(Restrictions.like("surname", text,MatchMode.ANYWHERE))).list();
         
          return queryResult;     
    }
    
}
