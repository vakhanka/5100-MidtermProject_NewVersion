/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.CourseSchedule;

import university.Persona.Faculty.FacultyAssignment;
import university.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;
import university.CourseCatalog.Course;

/**
 *
 * @author kal bugrara
 */
public class CourseOffer {

    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassignment;
    
    private String room;
    private String timeSlot;

    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList();
    }
     
    public void AssignAsTeacher(FacultyProfile fp) {

        if (fp == null) {
            facultyassignment = null;
            return;
        }
        facultyassignment = fp.AssignAsTeacher(this);
    }

    public FacultyProfile getFacultyProfile() {
        return facultyassignment == null ? null : facultyassignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCOurseNumber();
    }

    public void generatSeats(int n) {

        for (int i = 0; i < n; i++) {

            seatlist.add(new Seat(this, i));

        }

    }

    public void addSeats(int additionalSeats) {
        int currentSize = seatlist.size();
        for (int i = 0; i < additionalSeats; i++) {
            seatlist.add(new Seat(this, currentSize + i));
        }
    }
    
    public Seat getEmptySeat() {

        for (Seat s : seatlist) {

            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    /**
     * Returns total seat capacity for this course offering. Capacity equals
     * number of generated Seat objects.
     */

    public int getCapacity() {
        return seatlist.size();
    }

    //Returns number of occupied seats (enrolled students).
    
    public int getEnrolledCount() {
        int count = 0;
        for (Seat s : seatlist) {
            if (s.isOccupied()) {
                count++;
            }
        }
        return count;
    }
    
    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); //seat is already linked to course offer
        cl.registerStudent(sa); //coures offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {

        int sum = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }
    public Course getSubjectCourse(){
        return course;
    }
    public int getCreditHours(){
        return course.getCredits();
    }
    
    // ROOM & TIME 
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    // Optional display helper for JTable
    public String getScheduleDisplay() {
        String r = (room == null) ? "" : room.trim();
        String t = (timeSlot == null) ? "" : timeSlot.trim();
        if (r.isEmpty() && t.isEmpty()) {
            return "";
        }
        if (r.isEmpty()) {
            return t;
        }
        if (t.isEmpty()) {
            return r;
        }
        return r + " | " + t;
    }

}
