/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Addresses;
import DBClasses.Clients;
import DBClasses.Employees;
import Tools.HibernateUtil;
import javax.swing.JPanel;
import org.hibernate.Session;
import DBClasses.Users;
import java.util.Date;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Adam, troche MG
 */



public class RegistrationController {
    
    private final String ADMIN_LOGIN = "Rav";
    
    public enum EmployeeTypes{
        Admin,
        Cashier
    }
    
    public Boolean register(String name, String surname, String city, String country, String street, String login, String password, String documentNumber)
    {
          Session s = HibernateUtil.getSessionFactory().openSession();
          if (s.createCriteria(Users.class).add(Restrictions.like("login", login)).list().size()>0) {
            // not correct login
            return false;
          
          }
          else{
           Transaction tr = s.beginTransaction();
           
           Addresses newAddress = new Addresses();
           newAddress.setCity(city);
           newAddress.setCountry(country);
           newAddress.setStreet(street);
              
           s.saveOrUpdate(newAddress);
           
           Users newUser = new Users();
           newUser.setLogin(login);
           newUser.setPassword(HashingHelper.sha256(password));
           newUser.setName(name);
           newUser.setSurname(surname);
           newUser.setDocumentnumber(documentNumber);
           newUser.setAddresses(newAddress);
           
           s.saveOrUpdate(newUser);
           
           Clients newClient = new Clients();
           newClient.setRegistrationdate(new Date());
           newClient.setUsers(newUser);  
           
           s.saveOrUpdate(newClient);
           
           if (login.equals(ADMIN_LOGIN)) {
             Employees newEmployee = new Employees();
             newEmployee.setRole(EmployeeTypes.Admin.toString());
             newEmployee.setUsers(newUser);
             s.saveOrUpdate(newEmployee);
           }
           
           tr.commit();
      
           return true;
          }

    }
    
    public void validateForm(JPanel loginPanel)
    {
        // Validating inputs ...
        // Triggering inserting new rows in DB ...
        loginPanel.getName();
    }
}
