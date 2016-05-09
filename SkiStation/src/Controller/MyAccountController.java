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

/**
 *
 * @author Marzena
 */
public class MyAccountController {
    
    public static void GetAccountDetails( Integer id, StringBuilder login, StringBuilder name, 
                StringBuilder surname, StringBuilder street, StringBuilder city, StringBuilder country ) {
        
        login.append( SessionController.GetUserLogged() );
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery(String.format("FROM Users U WHERE U.login = '%s'", login) );
        if( query.list().isEmpty() || login.equals("") )
            return;
        Users user;
        Employees employee= null;
            
        user = (Users)query.list().get(0);
        Query query2 = s.createQuery(String.format("FROM Employees E WHERE E.users = '%d'",user.getUserid()));
            
        if(query2.list().size() > 0)
        {
            employee =  (Employees)query2.list().get(0);
        }
        if (employee == null) {
            id = user.getUserid();
        }else {
            id = employee.getEmployeeid();
        }
        name.append( user.getName() );
        surname.append( user.getSurname() );
        street.append( user.getAddresses().getStreet() );
        city.append( user.getAddresses().getCity() );
        country.append( user.getAddresses().getCountry() );
    }
}
