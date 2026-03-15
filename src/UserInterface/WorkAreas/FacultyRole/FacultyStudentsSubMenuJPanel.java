package UserInterface.WorkAreas.FacultyRole;

import Business.Business;
import javax.swing.*;
import java.awt.*;

/**
 * FacultyStudentsSubMenuJPanel.java
 * Faculty Sub-Menu - Student Management
 * @author Emmanuel Ould Tayeb
 * INFO 5100 - Application Engineering and Development
 * Team VTL - Faculty Role
 */
public class FacultyStudentsSubMenuJPanel extends JPanel {

    Business business;
    JPanel CardSequencePanel;

    public FacultyStudentsSubMenuJPanel(Business b, JPanel clp) {
        business = b;
        CardSequencePanel = clp;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Title
        JLabel lblTitle = new JLabel("Student Management");
        lblTitle.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        add(lblTitle, BorderLayout.NORTH);

        // Buttons panel - 3 rows x 2 cols
        JPanel buttonsPanel = new JPanel(new GridLayout(3, 2, 20, 20));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));

        JButton btnEnrolled = createButton("View Enrolled Students");
        JButton btnProgress = createButton("Student Progress Report");
        JButton btnTranscript = createButton("Student Transcript");
        JButton btnGrades = createButton("Grade Assignments");
        JButton btnRanking = createButton("Student Rankings");
        JButton btnPlaceholder = createButton("");
        btnPlaceholder.setEnabled(false);
        btnPlaceholder.setBackground(new Color(200, 200, 200));

        btnEnrolled.addActionListener(e -> {
            CardSequencePanel.removeAll();
            ViewEnrolledStudentJPanel panel = new ViewEnrolledStudentJPanel(business, CardSequencePanel);
            CardSequencePanel.add("View Students", panel);
            ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        });

        btnProgress.addActionListener(e -> {
            CardSequencePanel.removeAll();
            StudentProgressReportJPanel panel = new StudentProgressReportJPanel(business, CardSequencePanel);
            CardSequencePanel.add("Student Progress", panel);
            ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        });

        btnTranscript.addActionListener(e -> {
            CardSequencePanel.removeAll();
            StudentTranscriptViewJPanel panel = new StudentTranscriptViewJPanel(business, CardSequencePanel);
            CardSequencePanel.add("Student Transcript", panel);
            ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        });

        btnGrades.addActionListener(e -> {
            CardSequencePanel.removeAll();
            GradeAssignmentsJPanel panel = new GradeAssignmentsJPanel(business, CardSequencePanel);
            CardSequencePanel.add("Grade Assignments", panel);
            ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        });

        btnRanking.addActionListener(e -> {
            CardSequencePanel.removeAll();
            StudentRankingJPanel panel = new StudentRankingJPanel(business, CardSequencePanel);
            CardSequencePanel.add("Student Rankings", panel);
            ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        });

        buttonsPanel.add(btnEnrolled);
        buttonsPanel.add(btnProgress);
        buttonsPanel.add(btnTranscript);
        buttonsPanel.add(btnGrades);
        buttonsPanel.add(btnRanking);
        buttonsPanel.add(btnPlaceholder);

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
