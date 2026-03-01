/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class StudentDirectory {


    ArrayList<StudentProfile> studentlist;

    public StudentDirectory() {

     studentlist = new ArrayList();

    }

    public ArrayList<StudentProfile> getStudentList() {
        return studentlist;
    }
    
    public StudentProfile newStudentProfile(Person p) {

        StudentProfile sp = new StudentProfile(p);
        studentlist.add(sp);
        return sp;
    }

    public StudentProfile findStudentbyID(String id) {

        for (StudentProfile sp : studentlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
    }
    
    //adding a method to search by name
    public ArrayList<StudentProfile> searchByName(String name) {
    ArrayList<StudentProfile> results = new ArrayList<>();
    for (StudentProfile sp : studentlist) {
        if (sp.getPerson().getFullname().toLowerCase().contains(name.toLowerCase())) {
            results.add(sp);
        }
    }
    return results;
}
    
    // Returns all students - used by faculty panels to iterate through enrolled students
    public ArrayList<StudentProfile> getStudentList() {
        return studentlist;
    }
    
}
