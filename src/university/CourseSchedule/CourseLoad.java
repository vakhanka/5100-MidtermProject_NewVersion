/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.CourseSchedule;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {
    String semester;
    ArrayList<SeatAssignment> seatassignments;
    
    public CourseLoad(String s){
        seatassignments = new ArrayList();
        semester = s;
    }
    public SeatAssignment newSeatAssignment(CourseOffer co){
        
        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat==null) return null;
        SeatAssignment sa = seat.newSeatAssignment(this);
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public SeatAssignment findSeatAssignmentByCourseNumber(String courseNumber) {
        // Find the student's seat assignment for a specific course number
        for (SeatAssignment sa : seatassignments) {
            if (sa.getCourseOffer() != null && sa.getCourseOffer().getCourseNumber().equals(courseNumber)) {
                return sa;
            }
        }
        return null;
    }

    public boolean isAlreadyEnrolled(String courseNumber) {
        // Prevent duplicate enrollments in the same course
        return findSeatAssignmentByCourseNumber(courseNumber) != null;
    }

    public void dropCourse(String courseNumber) {
        // Drop a course: free the seat and remove the assignment from the student's courseload
        SeatAssignment sa = findSeatAssignmentByCourseNumber(courseNumber);
        if (sa == null) {
            return;
        }

        Seat seat = sa.getSeat();
        if (seat != null) {
            seat.releaseSeat(); // Free the seat in the course offering
        }

        seatassignments.remove(sa); // Remove from student's enrolled list
    }
    
    public void registerStudent(SeatAssignment sa){
        
        
        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }
    
    /* HL: commenting out because we are changing from float to string 
    public float getSemesterScore(){ //total score for a full semeter
        float sum = 0;
        for (SeatAssignment sa: seatassignments){
            sum = sum + sa.GetCourseStudentScore();
        }
        return sum;
    }*/
    
    public double getSemesterScore(){ //HL: total points for full semsester 
        double sum = 0;
        for (SeatAssignment sa : seatassignments){
            sum = sum + sa.getCourseStudentScore(); 
        }
        return sum; 
    }
    
    //HL: method to returns total credits for a semester, enforces 8-credit hours limit per semester (from instructions)
    public int getTotalCredits(){
        int total = 0;
        for (SeatAssignment sa : seatassignments){
            total = total + sa.getCreditHours();
        }
        return total; 
    }
    
    //HL: method to calculate Semester GPA (Transcript.java calls this method)
    public double getSemesterGPA(){
        int totalCredits = getTotalCredits();
        if (totalCredits == 0) return 0.0;
        return getSemesterScore() / totalCredits; 
    }
    
    
    
        public ArrayList<SeatAssignment> getSeatAssignments(){
            return seatassignments;
        }
            
}
