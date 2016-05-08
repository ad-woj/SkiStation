/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Addresses;
import DBClasses.Users;
import Tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MG
 */
public class UserPanelController {

    static public boolean updatePersonalData(int userID, String name, String surname, String city, String country, String street, String login, String password, String documentNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Users user = (Users) session.get(Users.class, userID);
            if (user == null)
                return false;
            Addresses address = user.getAddresses();
            if (address == null)
                return false;

            if (!name.equals("")) {
                user.setName(name);
            }
            if (!surname.equals("")) {
                user.setSurname(surname);
            }
            if (!city.equals("")) {
                address.setCity(city);
            }
            if (!country.equals("")) {
                address.setCountry(country);
            }
            if (!street.equals("")) {
                address.setStreet(street);
            }
            if (!login.equals("")) {
                user.setLogin(login);
            }
            if (!password.equals("")) {
                user.setPassword(HashingHelper.sha256(password));
            }
            if (!documentNumber.equals("")) {
                user.setDocumentnumber(documentNumber);
            }

            session.saveOrUpdate(user);
            session.saveOrUpdate(address);
            //session.update(user);
            tx.commit();
            System.out.println("Successfully changed data");
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Something went wrong");
            return false;
        } finally {
            session.close();
        }
    }

}
