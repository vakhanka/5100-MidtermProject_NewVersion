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
    LocalDateTime createdtimestamp; //add a variable to get created date

    public Person(String id) {
        this.id = id;
        this.createdtimestamp = LocalDateTime.now();
    }

    public String getPersonId() {
        return id;
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
