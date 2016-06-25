/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Employees;
import DBClasses.Users;
import DBClasses.Addresses;
import Tools.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import Model.AccountInfo;

/**
 *
 * @author Marzena
 */
public class MyAccountController {
    
    public static Users GetAccountDetails( String login ) {
        
        Session s = HibernateUtil.getSessionFactory().openSession();
        if( login.isEmpty() )
            return null;
        Query query = s.createQuery(String.format("FROM Users U WHERE U.login = '%s'", login) );
        if( query.list().isEmpty() || login.equals("") )
            return new Users();
        
        Users user;            
        user = (Users)query.list().get(0);

        s.close();
        return user;
    }
    
    public static Addresses UpdateUserAddress( Addresses newAddress, String login ) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Addresses address = new Addresses();
        if( login.isEmpty() )
            login = SessionController.GetUserLogged();
        
        Transaction tr = s.beginTransaction();
        Query query = s.createQuery(String.format("FROM Users U WHERE U.login = '%s'", login) );
        if( query.list().isEmpty() || login.equals("") )
            return address;
        
        Users user;            
        user = (Users)query.list().get(0);
        
        query = s.createQuery(String.format("FROM Addresses U WHERE U.addressid = '%s'", user.getAddresses().getAddressid()) );
        if( query.list().isEmpty() )
            return address;
                  
        address = (Addresses)query.list().get(0);
        address.setStreet(newAddress.getStreet());
        address.setCountry(newAddress.getCountry());
        address.setCity(newAddress.getCity());
        
        s.saveOrUpdate(address);
        tr.commit();
        s.close();
        return address;
    }
    
    public static AccountInfo GetAccountInfoString( String login ) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        AccountInfo info = new AccountInfo();
        if( login == null || login.isEmpty() )
            return info;
        
        Query query = s.createQuery(String.format("FROM Users U WHERE U.login = '%s'", login) );
        if( query.list().isEmpty() || login.equals("") )
            return info;
        
        Users user = (Users)query.list().get(0);
        
        info.name = user.getName();
        info.surname = user.getSurname();
        info.login = user.getLogin();
        info.userID = Integer.toString(user.getUserid());
        Addresses address = user.getAddresses();
        if( address != null ) {
            info.street = address.getStreet();
            info.city = address.getCity();
            info.country = address.getCountry();
        }
        s.close();
        return info;
    }
    
    public static String GetLoginFromID( int userID ) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery(String.format("FROM Users U WHERE U.userid = '%s'", userID) );
        if( query.list().isEmpty() )
            return null;
        Users user = (Users)query.list().get(0);
        String login = user.getLogin();
        s.close();
        return login;
    }      
    
    public static String UpdateAccountDetails( Users newUser, int userID ){
        Session s = HibernateUtil.getSessionFactory().openSession();
        String login = GetLoginFromID( userID );
        Users oldUser = GetAccountDetails( login );
        if( oldUser == null )
            return "Błąd aktualizacji";
        UpdateUserAddress( newUser.getAddresses(), login );
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
        oldUser.setName(newUser.getName());
        oldUser.setSurname(newUser.getSurname());
        oldUser.setLogin(newUser.getLogin());
        oldUser.setDocumentnumber(newUser.getDocumentnumber());
        s.saveOrUpdate(oldUser);
        tr.commit();
        s.close();
        return "Dane zaktualizowane";
    }
}
