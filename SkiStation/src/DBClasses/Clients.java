package DBClasses;
// Generated 2016-05-01 18:16:39 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clients generated by hbm2java
 */
public class Clients  implements java.io.Serializable {


     private int clientid;
     private Users users;
     private Date registrationdate;
     private int points;
     private Set cardses = new HashSet(0);
     private Set chargeses = new HashSet(0);

    public Clients() {
    }

	
    public Clients(int clientid, Users users) {
        this.clientid = clientid;
        this.users = users;
    }
    public Clients(int clientid, Users users, Date registrationdate, Set cardses, Set chargeses) {
       this.clientid = clientid;
       this.users = users;
       this.registrationdate = registrationdate;
       this.cardses = cardses;
       this.chargeses = chargeses;
    }
   
    public int getClientid() {
        return this.clientid;
    }
    
    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public Date getRegistrationdate() {
        return this.registrationdate;
    }
    
    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }
    
    public int getPoints(){
        return this.points;
    }
    
    public void setPoints(int points){
        this.points = points;
    }
            
    public Set getCardses() {
        return this.cardses;
    }
    
    public void setCardses(Set cardses) {
        this.cardses = cardses;
    }
    public Set getChargeses() {
        return this.chargeses;
    }
    
    public void setChargeses(Set chargeses) {
        this.chargeses = chargeses;
    }




}


