/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Addresses;
import DBClasses.Clients;
import DBClasses.Employees;
import DBClasses.Users;
import Tools.HibernateUtil;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rafał
 */
public class UserManagementAdminController {
    
    private Session s;
    
    public UserManagementAdminController()
    {
        s = HibernateUtil.getSessionFactory().openSession();
    }
    
    public boolean exist(String login)
    {
        return findUser(login) != null;
    }
    
    public Users findUser(String login)
    {
         List queryResult = s.createCriteria(Users.class).add(Restrictions.like("login", login)).list();
         Users user;
          if (queryResult.size()>0) {
            user = (Users)queryResult.get(0);
          }else{
            user = null;        
          }
          return user;     
    }
        
    private Employees getUserRole(Users user)
    {
        if (user == null) {
            return null;
        }
        System.out.println(user.getUserid());
         List quaryResult = s.createCriteria(Employees.class).add(Restrictions.eq("users", user)).list();
         Employees role;
          if (quaryResult.size()>0) {
            role = ((Employees)quaryResult.get(0));
          }else{
            role = null;      
          }

          return role;   
    }
    
    private boolean setUserRole(Users user, String role)
    {
         Transaction tr = s.beginTransaction();
         
         Employees employee = getUserRole(user);
         if (role == "User") {
             if (employee!=null) {
                s.delete(employee);  
             }
        }else{
             if (employee == null) {
                employee = new Employees();
                employee.setUsers(user);
             }
             employee.setRole(role);
             s.saveOrUpdate(employee);
         }
         tr.commit();

         return true;         
    }
    

        
    public String getUserRole(String login)
    {
         Users user = findUser(login);
         Employees role =  getUserRole(user);
                 
         if (role == null) {
            return "User";
        }else{
             return role.getRole();
         }
    }

    
    public boolean updateUser(String login, String role)
    {
        Users user = findUser(login);
        if (user==null) {
            return false;
        }else{
            setUserRole(user, role);
            return true;
        }
    }
    
    public boolean removeUser(String login)
    {
        Users user = findUser(login);
        if (user==null) {
            return false;
        }
        
        Transaction tr = s.beginTransaction();
        
        Employees role = getUserRole(user);  
        Addresses address = user.getAddresses();
        
        
        user.setAddresses(null);
        Object[] clients =  user.getClientses().toArray();
        for (Object client : clients) {
            Clients c = (Clients)client;
            c.setUsers(null);
        }
        
        
        if (address!=null) {
            s.delete(address);
        }
        if (role!=null) {
            s.delete(role);
        }
        s.delete(user);
        
        tr.commit();
        
        return true;
    }
}
