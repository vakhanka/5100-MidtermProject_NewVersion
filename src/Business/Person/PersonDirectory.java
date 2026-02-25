/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {
    
      ArrayList<Person> personlist ;
    
      public PersonDirectory (){
          
       personlist = new ArrayList();

    }
      //Auto ID Generation Method
    private static int counter = 1000;

    public static String generateId() {
    return "N" + String.format("%08d", counter++);
    }  

    public Person newPerson(String fullname) {

        String id = generateId();
        Person p = new Person(id, fullname);
        personlist.add(p);
        return p;
    }

    public Person findPersonbyID(String id) {

        for (Person p : personlist) {

            if (p.isMatch(id)) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }
    
    //Method for searching by partial name
    public ArrayList<Person> searchByName(String name) {
    ArrayList<Person> results = new ArrayList<>();
    for (Person p : personlist) {
        if (p.getFullname().toLowerCase().contains(name.toLowerCase())) {
            results.add(p);
        }
    }
    return results;
}
}
