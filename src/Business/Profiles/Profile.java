/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;

/**
 *
 * @author kal bugrara
 */
public abstract class Profile {
    Person person;
    private String email;
    private String phone;
    private String officeLocation;
    public Profile(Person p){
        person = p;
        this.email = email;
        this.phone = phone;        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    // For ManageProfile in Registrar 
    public String getOfficeLocation() {
        return officeLocation;
    }
    
    // For ManageProfile in Registrar 
    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    } 
    
    public abstract String getRole();
    
    public Person getPerson(){
        return person;
    }
     
    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

}
