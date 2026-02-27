/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Business;
import Business.Person.Person;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmployeeDirectory {

    Business business;
    ArrayList<EmployeeProfile> employeelist;
    ArrayList<RegistrarProfile> registrarlist;
    ArrayList<FacultyProfile> facultylist;  

    public EmployeeDirectory(Business d) {

        business = d;
        employeelist = new ArrayList();
        registrarlist = new ArrayList();
        facultylist = new ArrayList();    

    }

    public EmployeeProfile newEmployeeProfile(Person p, String role) {

        EmployeeProfile sp = new EmployeeProfile(p, role);
        employeelist.add(sp);
        return sp;
    }
    
    public RegistrarProfile newRegistrarProfile(Person p) {

        RegistrarProfile rp = new RegistrarProfile(p);
        registrarlist.add(rp);
        return rp;
    }
     
    public FacultyProfile newFacultyProfile(Person p) {

        FacultyProfile fp = new FacultyProfile(p);
        facultylist.add(fp);
        return fp;
    }  

    public EmployeeProfile findEmployee(String id) {

        for (EmployeeProfile sp : employeelist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }

    
    //add a search by name method
    public ArrayList<EmployeeProfile> searchByName(String name) {
    ArrayList<EmployeeProfile> results = new ArrayList<>();
    for (EmployeeProfile ep : employeelist) {
        if (ep.getPerson().getFullname().toLowerCase().contains(name.toLowerCase())) {
            results.add(ep);
        }
    }
    return results;
}    
    
}
