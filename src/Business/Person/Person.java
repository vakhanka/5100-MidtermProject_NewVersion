/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.time.LocalDateTime;

/**
 *
 * @author kal bugrara
 */
public class Person {

    String id;
    String fullname;
    LocalDateTime createdtimestamp; //variable to get created date
    

    public Person(String id, String fullname) {
        this.id = id;
        this.createdtimestamp = LocalDateTime.now();
        this.fullname = fullname;
    }

    public String getPersonId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }
    
    public void updatecreateddate(){
        this.createdtimestamp = LocalDateTime.now();
    }

    public LocalDateTime getCreatedtimestamp() {
        return createdtimestamp;
    }

    public void setCreatedtimestamp(LocalDateTime createdtimestamp) {
        this.createdtimestamp = createdtimestamp;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getPersonId();
    }


}
