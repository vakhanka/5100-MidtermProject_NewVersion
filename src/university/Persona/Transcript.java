/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.Persona;

import university.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.HashMap;
import university.CourseSchedule.CourseLoad;
import university.CourseSchedule.SeatAssignment;

/**
 *
 * @author kal bugrara
 */
public class Transcript {

    StudentProfile student;
    HashMap<String, CourseLoad> courseloadlist;
    CourseLoad currentcourseload;

    public Transcript(StudentProfile sp) {
        student = sp;
        courseloadlist = new HashMap();

    }

    /*HL: Commenting out for now as method is below, may need to revist if we need to rank by satisfaction
    public int getStudentSatisfactionIndex() {
        //for each courseload 
        //get seatassigmnets; 
        //for each seatassignment add 1 if like =true;
        return 0;
    }*/

    public CourseLoad newCourseLoad(String sem) {

        currentcourseload = new CourseLoad(sem);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }

    public CourseLoad getCurrentCourseLoad() {

        return currentcourseload;

    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return courseloadlist.get(semester);

    }

    /* HL: commenting out because changing grade from float to string 
    public float getStudentTotalScore() {

        float sum = 0;

        for (CourseLoad cl : courseloadlist.values()) {
            sum = sum + cl.getSemesterScore();

        }
        return sum;
    }*/ 
    
    public double getStudentTotalScore(){ //HL: total points for full semsester 
        double sum = 0; 
        for (CourseLoad cl : courseloadlist.values()){
            sum = sum + cl.getSemesterScore();
        }
        return sum; 
    }
    
    //HL: method to get GPA for a semester, used by TranscriptJPanel 
    public double getSemesterGPA(String semester){
        CourseLoad cl = courseloadlist.get(semester);
        if (cl == null) return 0.0;
        return cl.getSemesterGPA(); 
    }
    
    //HL: method to calculate toatl GPA from all semesters, used by TranscriptJPanel 
    public double getOverallGPA(){
        double totalQualityPoints = 0;
        int totalCredits = 0;
        for (CourseLoad cl : courseloadlist.values()){
            totalQualityPoints += cl.getSemesterScore();
            totalCredits += cl.getTotalCredits();
        }
        if (totalCredits == 0) return 0.0;
        return totalQualityPoints / totalCredits; 
    }
    
    //HL: method to determine a student's Academic Standing for a semester
    //HL: RULE 1: Overall GPA less than 3.0 = Academic Probation 
    //HL: RULE 2: Term GPA less than 3.0 = Academic Warning (even if overall GPA is greater than or equal to 3.0) 
    //HL: RULE 3: Both Overall & Term GPA are greater than or equal to 3.0 = Student is in Good Standing 
    public String getAcademicStanding(String semester){
        double overallGPA = getOverallGPA();
        double termGPA = getSemesterGPA(semester);
        
        if (overallGPA < 3.0) return "Academic Probation";
        if (termGPA < 3.0) return "Academic Warning";
        return "Good Standing"; 
    }
    
    //sat index means student rated their courses with likes;
    public int getStudentSatifactionIndex() { //HL: note, "Satifaction" is a typo but method is still working so not changing 
        ArrayList<SeatAssignment> courseregistrations = getCourseList();
        int sum = 0;
        for (SeatAssignment sa : courseregistrations) {

            if (sa.getLike()) {
                sum = sum + 1;
            }
        }
        return sum;
    }
    //generate a list of all courses taken so far (seetassignments) 
    //from multiple semesters (course loads)
    //from seat assignments we will be able to access the course offers

    public ArrayList<SeatAssignment> getCourseList() {
        ArrayList temp2;
        temp2 = new ArrayList();

        for (CourseLoad cl : courseloadlist.values()) { //extract cl list as objects --ignore label
            temp2.addAll(cl.getSeatAssignments()); //merge one array list to another
        }

        return temp2;

    }
    
    //HL: ArrayList to return semesters by name (ex. "Spring 2026"), used by TranscriptJPanel 
    public ArrayList<String> getSemesters(){
        return new ArrayList<>(courseloadlist.keySet()); 
    }

}
