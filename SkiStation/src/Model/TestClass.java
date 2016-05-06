/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBClasses.Addresses;
import Tools.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Adam
 */
public class TestClass {
    
    
    
    public static void test()
    {
        // Nawiązywanie połączenia z naszą bazą
        Session s = HibernateUtil.getSessionFactory().openSession();
        
        // Rozpoczynanie transakcji
       // Transaction tr = s.beginTransaction();
        
        // Przygotowanie obiektu do dodania, NIE ustawiamy ID - będzie się samo auto-incrementować w bazie
        //Addresses adr = new Addresses();
        //adr.setCity("Gliwice");
        //adr.setCountry("Poland");
        //adr.setStreet("Test");
        
        // Zapis lub aktualizacja obiektu w bazie
       // s.saveOrUpdate(adr);
        
        // Zatwierdzenie transakcji, bez tego dane się nie zapiszą w bazie
      //  tr.commit();
        // Odczyt z bazy 
        Query query = s.createQuery("From Addresses a");
        Addresses address = (Addresses) query.list().get(0);
        
        // Testowe wypisanie miasta
        System.out.println(address.getCity());
    }  
}
