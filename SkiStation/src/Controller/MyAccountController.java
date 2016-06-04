/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Employees;
import DBClasses.Users;
import Tools.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marzena
 */
public class MyAccountController {
    
    public static Users GetAccountDetails() {
        
        Session s = HibernateUtil.getSessionFactory().openSession();
        String login = SessionController.GetUserLogged();
        Query query = s.createQuery(String.format("FROM Users U WHERE U.login = '%s'", login) );
        if( query.list().isEmpty() || login.equals("") )
            return new Users();
        Users user;
        Employees employee= null;
            
        user = (Users)query.list().get(0);
        Query query2 = s.createQuery(String.format("FROM Employees E WHERE E.users = '%d'",user.getUserid()));
            
        if(query2.list().size() > 0)
        {
            employee =  (Employees)query2.list().get(0);
        }
        if (employee != null) {
            user.setUserid( employee.getEmployeeid() );
        }
        s.close();
        return user;
    }
    
    public static String UpdateAccountDetails( Users newUser ){
        Users oldUser = MyAccountController.GetAccountDetails();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = s.beginTransaction();
        if( newUser.getLogin().equals("") )
            return "Nieprawidłowy login";
        if( !( oldUser.getLogin().equals(newUser.getLogin()) ) )
        {
            if (s.createCriteria(Users.class).add(Restrictions.like("login", newUser.getLogin())).list().size()>0) {
            // incorrect login
            return "Login zajęty";
          
          }
        }
        newUser.setPassword(HashingHelper.sha256(newUser.getPassword()));
        newUser.getAddresses().setAddressid(oldUser.getAddresses().getAddressid());
        newUser.getAddresses().setUserses(oldUser.getAddresses().getUserses());
        newUser.setUserid(oldUser.getUserid());
        newUser.setClientses(oldUser.getClientses());
        newUser.setEmployeeses(oldUser.getEmployeeses());
        s.saveOrUpdate(newUser);
        tr.commit();
        s.close();
        return "Dane zaktualizowane";
    }
}
