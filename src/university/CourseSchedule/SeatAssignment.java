/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.CourseSchedule;

import java.util.HashMap;
import university.CourseCatalog.Course;


/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {
    /*HL Edit: Assignment requires Letter Grades when displayed on a student transcript so need to change from float to string 
    float grade; //(Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, )*/
   
    //HL: Grade Map: single source of truth for grade points 
    //HL: Student GPA and Faculty grading bnoth reference this hasmap, do not redefine anywhere else 
    public static final HashMap<String, Double> GRADE_MAP = new HashMap<>(); //HL: added import using AltEnter 
    static {
        GRADE_MAP.put("A",  4.0);
        GRADE_MAP.put("A-", 3.7);
        GRADE_MAP.put("B+", 3.3);
        GRADE_MAP.put("B",  3.0);
        GRADE_MAP.put("B-", 2.7);
        GRADE_MAP.put("C+", 2.3);
        GRADE_MAP.put("C",  2.0);
        GRADE_MAP.put("C-", 1.7);
        GRADE_MAP.put("F",  0.0);
    }
    
    
    String grade; //HL: again, changed from float to String to meet assignment requirements 
    Seat seat;
    boolean like; //true means like and false means not like
    CourseLoad courseload;
    private String submissionNote = ""; //HL: from CourseWorkJPanel 
    
    
    public SeatAssignment(CourseLoad cl, Seat s){
        seat = s;
        courseload = cl;
        grade = null; //HL: this means the seat assignment has not yet received a grade 
    }

    //HL: setter method for grade - referenced by Faculty (Emmanuel's) grading panel 
    public void setGrade(String g){
        if (GRADE_MAP.containsKey(g)){
            grade = g;
        } else {
            System.out.println("Warning: Invalid grade '" + g + "' - grade not yet set."); 
        }
    }
    
    //HL: getter to return Letter grades (A, B, C, etc.), again why we use string instead of float
    //HL: N/A if grade is not yet assigned
    public String getGrade(){
        return (grade != null) ? grade : "N/A"; 
    }
    
    //HL: retrieve grade points from GRADE_MAP  (0.0 returned if grade is null/not found) 
    //HL: used by Course Load (get semeseter GPA) and Transcript GPA methods 
    public double getGradePoints(){
        if (grade == null) return 0.0;
        return GRADE_MAP.getOrDefault(grade, 0.0); 
    }
    
    //HL: grade points x credit hours - used to calculate semester GPA and overall GPA 
    public double getCourseStudentScore(){
        return getGradePoints() * getCreditHours(); 
    }
     
    public boolean getLike(){
        return like;
    }
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }
    
    public int getCreditHours(){
        return seat.getCourseCredits();
       
    }
    public Seat getSeat(){
        return seat;
    }
    public CourseOffer getCourseOffer(){
        
        return seat.getCourseOffer();
    }
    public Course getAssociatedCourse(){
        
        return getCourseOffer().getSubjectCourse();
    }
    
    /* HL: commenting out, changed from float to string 
    public float GetCourseStudentScore(){
        return getCreditHours()*grade;
    }*/

    
    //HL: method that returns the file path when student selects for submission, or empty if nothing has been submitted yet, called by CourseWorkJPanel 
    public String getSubmissionNote() {
        return submissionNote;
    }

    //HL: method to store file when student selects a file for assignemnt submission for a course, called by CourseWorkJPanel & clicks submit
    public void submitAssignment(String filePath) {
        if (filePath != null && !filePath.trim().isEmpty()) {
        this.submissionNote = filePath.trim();
    }
    }
    
    
    
}
