/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.StudentDirectory;

import Business.UserAccounts.UserAccountDirectory;
import java.util.ArrayList;
import university.Department.Department; // Needed to store and manage university departments

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    PersonDirectory persondirectory; //all people profiles regardless of the role
    private Department department;
    EmployeeDirectory employeedirectory;
    UserAccountDirectory useraccountdirectory;
    StudentDirectory studentdirectory;
    
    // list of all departments in the university
    ArrayList<Department> departments;

    public Business(String n) {
        name = n;

        persondirectory = new PersonDirectory();
        employeedirectory = new EmployeeDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        
        department = new Department("Information Systems"); //bridge to the university package

        studentdirectory = new StudentDirectory();
        
        // initialize department list 
        departments = new ArrayList<>();
    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }


    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }

    public StudentDirectory getStudentDirectory(){
        return studentdirectory;
    }
    
    
    /**
     * Creates and registers a new Department in the university. Used during
     * system initialization.
     */
    public Department newDepartment(String name) {
        Department d = new Department(name);
        departments.add(d);
        return d;
    }

    /**
     * Returns the list of departments. 
     * Used by Registrar UI to populate department selection.
     */
    public ArrayList<Department> getDepartments() {
        return departments;
    }
    public university.Department.Department getDepartment(){
        if (!departments.isEmpty()) {
            return departments.get(0);
        }
        return department;
    }
    
    

}
