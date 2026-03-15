package UserInterface.WorkAreas.FacultyRole;

import Business.Business;
import javax.swing.*;
import java.awt.*;

/**
 * FacultyCoursesSubMenuJPanel.java
 * Faculty Sub-Menu - Course Management
 * @author Emmanuel Ould Tayeb
 * INFO 5100 - Application Engineering and Development
 * Team VTL - Faculty Role
 */
public class FacultyCoursesSubMenuJPanel extends JPanel {

    Business business;
    JPanel CardSequencePanel;

    public FacultyCoursesSubMenuJPanel(Business b, JPanel clp) {
        business = b;
        CardSequencePanel = clp;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Title
        JLabel lblTitle = new JLabel("Course Management");
        lblTitle.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        add(lblTitle, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));

        JButton btnViewCourses = createButton("View Assigned Courses");
        JButton btnUpdateDetails = createButton("Update Course Details");
        JButton btnSyllabus = createButton("Manage Syllabus");
        JButton btnEnrollment = createButton("Manage Enrollment");

        btnViewCourses.addActionListener(e -> {
            CardSequencePanel.removeAll();
            ViewAssignedCoursesJPanel panel = new ViewAssignedCoursesJPanel(business, CardSequencePanel);
            CardSequencePanel.add("View Courses", panel);
            ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        });

        btnUpdateDetails.addActionListener(e -> {
            CardSequencePanel.removeAll();
            UpdateCourseDetailsJPanel panel = new UpdateCourseDetailsJPanel(business, CardSequencePanel);
            CardSequencePanel.add("Update Course Details", panel);
            ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        });

        btnSyllabus.addActionListener(e -> {
            CardSequencePanel.removeAll();
            ManageSyllabusJPanel panel = new ManageSyllabusJPanel(business, CardSequencePanel);
            CardSequencePanel.add("Manage Syllabus", panel);
            ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        });

        btnEnrollment.addActionListener(e -> {
            CardSequencePanel.removeAll();
            ManageEnrollmentJPanel panel = new ManageEnrollmentJPanel(business, CardSequencePanel);
            CardSequencePanel.add("Manage Enrollment", panel);
            ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        });

        buttonsPanel.add(btnViewCourses);
        buttonsPanel.add(btnUpdateDetails);
        buttonsPanel.add(btnSyllabus);
        buttonsPanel.add(btnEnrollment);

        add(buttonsPanel, BorderLayout.CENTER);
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(102, 153, 255));
        btn.setForeground(Color.WHITE);
        btn.setFont(getFont());
        btn.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn.setPreferredSize(new Dimension(200, 40));
        return btn;
    }
}
