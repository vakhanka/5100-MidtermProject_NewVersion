package UserInterface.WorkAreas.FacultyRole;

import Business.Business;
import javax.swing.*;
import java.awt.*;

/**
 * FacultyPerformanceSubMenuJPanel.java
 * Faculty Sub-Menu - Performance Reports
 * @author Emmanuel Ould Tayeb
 * INFO 5100 - Application Engineering and Development
 * Team VTL - Faculty Role
 */
public class FacultyPerformanceSubMenuJPanel extends JPanel {

    Business business;
    JPanel CardSequencePanel;

    public FacultyPerformanceSubMenuJPanel(Business b, JPanel clp) {
        business = b;
        CardSequencePanel = clp;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Title
        JLabel lblTitle = new JLabel("Performance Reports");
        lblTitle.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        add(lblTitle, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));

        JButton btnCoursePerformance = createButton("Course Performance");
        JButton btnTuitionInsight = createButton("Tuition Insight");

        btnCoursePerformance.addActionListener(e -> {
            CardSequencePanel.removeAll();
            CoursePerformanceJPanel panel = new CoursePerformanceJPanel(business, CardSequencePanel);
            CardSequencePanel.add("Course Performance", panel);
            ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        });

        btnTuitionInsight.addActionListener(e -> {
            CardSequencePanel.removeAll();
            TuitionInsightJPanel panel = new TuitionInsightJPanel(business, CardSequencePanel);
            CardSequencePanel.add("Tuition Insight", panel);
            ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        });

        buttonsPanel.add(btnCoursePerformance);
        buttonsPanel.add(btnTuitionInsight);

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
