package CAS.GUI;

import java.awt.*;
import javax.swing.*;
import CAS.CourseAssignment;
import CAS.Data.Course;


/**
 *
 * @author Pat
 */
public class CourseReportPanel extends JPanel {
    private JList<String> list;
    private JLabel label1;
    private DefaultListModel<String> listModel;
    private JScrollPane listScroller;
    private CourseAssignment courseAssignment;
    
    public CourseReportPanel(CourseAssignment courseAssignment) {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        this.courseAssignment = courseAssignment;
        setBackground(Color.GRAY);
        
        label1 = new JLabel("CourseReportPanel");
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.05;
        add(label1, c);
        
        listModel = new DefaultListModel<>();
        
        
        for (Course co : courseAssignment.getCourses().values()) {
            listModel.addElement(co.getWorkArea() + co.getNumber() + "-" + co.getSection() 
                    + " : " + co.getInstructor());
        }
        
        list = new JList<>(listModel);
        
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);

        listScroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 1;
        c.weightx = 1;
        
        add(listScroller, c);
        setVisible(true);
    }

}
