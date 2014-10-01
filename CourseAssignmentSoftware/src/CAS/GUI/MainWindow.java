package CAS.GUI;

/* Richard Hayes */

import CAS.CourseAssignment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
    
    private CourseAssignment courseAssignment;
    private int round;
  
    private JPanel courseReportPanel;
//    private CourseReportPanel courseReportPanel;
    private JPanel instructorReportPanel;
//    private InstructorReportPanel instructorReportPanel;
    private JPanel coursePanel;
    //private CoursePanel coursePanel;
    private JPanel instructorPanel;
    //private InstructorPanel instructorPanel;
  
    private JPanel reportPanel;
    private JPanel detailsPanel;
  
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel middleLeftPanel;
    private JPanel middleRightPanel;
    private JPanel bottomPanel;
  
    private JButton detailsButton;
    private JButton assignButton;
    private JButton toggleButton;
    private JButton reportButton;
    private JButton printButton;
 
  public MainWindow(CourseAssignment courseAssignment)
  {
    super();
    setSize(640,480);
    setMaximumSize(new Dimension(640, 480));
    setMinimumSize(new Dimension(640, 480));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridBagLayout());
    
    this.courseAssignment = courseAssignment;
    round = 1;
    buildPanels();

    setVisible(true);
  }
  
  public void buildPanels() {
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    
    courseReportPanel = new JPanel();
//    courseReportPanel = new CourseReportPanel();
    courseReportPanel.setLayout(new BorderLayout());
    courseReportPanel.add(new JLabel("CourseReportPanel"), BorderLayout.NORTH);
    JTextArea courseReport = new JTextArea("Course : Instructor\nCourse : Instructor\nCourse : Instructor\n" +
            "Course : Instructor\nCourse : Instructor\nCourse : Instructor\n");
    courseReport.setEditable(false);
    courseReport.setLineWrap(true);
    courseReport.setWrapStyleWord(true);
    courseReportPanel.add(courseReport, BorderLayout.CENTER);
    courseReportPanel.setBackground(Color.GRAY);
                          
    instructorReportPanel = new JPanel();
//    instructorReportPanel = new InstructorReportPanel();
    instructorReportPanel.setLayout(new BorderLayout());
    instructorReportPanel.add(new JLabel("InstructorReportPanel"), BorderLayout.NORTH);
    JTextArea instructorReport = new JTextArea("Instructor:\n\tCourse 1\n\tCourse 2\n\tCourse 3\n" +
            "Instructor:\n\tCourse 1\n\tCourse 2\n\tCourse 3");
    instructorReport.setEditable(false);
    instructorReport.setLineWrap(true);
    instructorReport.setWrapStyleWord(true);
    instructorReportPanel.add(instructorReport, BorderLayout.CENTER);
    instructorReportPanel.setBackground(Color.GRAY);
                              
    coursePanel = new JPanel();
    //coursePanel = new CoursePanel();
    coursePanel.setLayout(new BorderLayout());
    coursePanel.add(new JLabel("Details Area"), BorderLayout.NORTH);
    JTextArea details = new JTextArea("This is the area where all the details" +
            " of a selected instructor or course would be displayed once the" +
            " \"details\" button was pressed.");
    details.setEditable(false);
    details.setLineWrap(true);
    details.setWrapStyleWord(true);
    coursePanel.add(details, BorderLayout.CENTER);
    coursePanel.setBackground(Color.LIGHT_GRAY);
                    
    instructorPanel = new JPanel();
    //instructorPanel = new InstructorPanel();
    instructorPanel.add(new JLabel("InstructorPanel"));
    instructorPanel.setBackground(Color.LIGHT_GRAY);
    
    reportPanel = courseReportPanel;
    detailsPanel = coursePanel;
    
    topPanel = new JPanel();
//    topPanel.setSize(640, 30);
//    topPanel.setLocation(0, 0);
    topPanel.setLayout(new GridBagLayout());
    constraints.weightx = 0.3;
    constraints.weighty = 1;
    constraints.gridx = 0;
    constraints.gridy = 0;
    topPanel.add(new JPanel(), constraints);
    detailsButton = new JButton("Details");
    detailsButton.setSize(100, 30);
    detailsButton.addActionListener(new ButtonListener());
    constraints.weightx = 0.2;
    constraints.weighty = 0.8;
    constraints.gridx = 1;
    constraints.gridy = 1;
    topPanel.add(detailsButton, constraints);
    constraints.weightx = 0.5;
    constraints.weighty = 1;
    constraints.gridx = 2;
    constraints.gridy = 0;
    topPanel.add(new JPanel(), constraints);
    constraints.weightx = 0.3;
    constraints.weighty = 0.1;
    constraints.gridx = 0;
    constraints.gridy = 0;
    topPanel.add(new JPanel(), constraints);
    constraints.weightx = 0.3;
    constraints.weighty = 0.1;
    constraints.gridx = 0;
    constraints.gridy = 2;
    topPanel.add(new JPanel(), constraints);
    
    middleRightPanel = new JPanel();
//    middleRightPanel.setSize(220, 300);
//    middleRightPanel.setLocation(370, 0);
    middleRightPanel.setLayout(new GridBagLayout());
    constraints.weightx = 0.3;
    constraints.weighty = 1;
    constraints.gridx = 0;
    constraints.gridy = 0;
    middleRightPanel.add(new JPanel(), constraints);
    constraints.weightx = 0.4;
    constraints.weighty = 0.6;
    constraints.gridx = 1;
    constraints.gridy = 0;
    detailsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    middleRightPanel.add(detailsPanel, constraints);
    constraints.weightx = 0.3;
    constraints.weighty = 1;
    constraints.gridx = 2;
    constraints.gridy = 0;
    middleRightPanel.add(new JPanel(), constraints);
    constraints.weightx = 1;
    constraints.weighty = 0.4;
    constraints.gridx = 1;
    constraints.gridy = 1;
    middleRightPanel.add(new JPanel(), constraints);
    
    middleLeftPanel = new JPanel();
//    middleLeftPanel.setSize(300, 350);
//    middleLeftPanel.setLocation(20, 0);
    middleLeftPanel.setLayout(new BorderLayout());
    middleLeftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    middleLeftPanel.add(reportPanel);
    
    middlePanel = new JPanel();
//    middlePanel.setSize(640, 375);
//    middlePanel.setLocation(0, 30);
    middlePanel.setLayout(new GridBagLayout());
    middlePanel.setBorder(BorderFactory.createLineBorder(Color.black));
    constraints.weightx = 0.5;
    constraints.weighty = 1;
    constraints.gridx = 0;
    constraints.gridy = 0;
    middlePanel.add(middleLeftPanel, constraints);
    constraints.gridx = 1;
    middlePanel.add(middleRightPanel, constraints);
                 
    bottomPanel = new JPanel();
//    bottomPanel.setSize(640, 40);
//    bottomPanel.setLocation(0, 405);
    bottomPanel.setLayout(new GridBagLayout());
    assignButton = new JButton("Round 1");
//    assignButton.setSize(100, 30);
//    assignButton.setLocation(85, 5);
    toggleButton = new JButton("Instructors");
//    toggleButton.setSize(100, 30);
//    toggleButton.setLocation(270, 5);
    reportButton = new JButton("Report");
//    reportButton.setSize(100, 30);
//    reportButton.setLocation(455, 5);
//    printButton = new JButton("Print");
//    printButton.setSize(100, 30);
//    printButton.setLocation(540, 20);
    assignButton.addActionListener(new ButtonListener());
    toggleButton.addActionListener(new ButtonListener());
    reportButton.addActionListener(new ButtonListener());
//    printButton.addActionListener(new ButtonListener());
    constraints.weightx = 0.1;
    constraints.weighty = 0.2;
    constraints.gridx = 0;
    constraints.gridy = 0;
    bottomPanel.add(new JPanel(), constraints);
    constraints.weightx = 0.1;
    constraints.weighty = 0.6;
    constraints.gridx = 0;
    constraints.gridy = 1;
    bottomPanel.add(new JPanel(), constraints);
    constraints.weightx = 0.2;
    constraints.weighty = 0.6;
    constraints.gridx = 1;
    constraints.gridy = 1;
    bottomPanel.add(assignButton, constraints);
    constraints.weightx = 0.1;
    constraints.weighty = 0.6;
    constraints.gridx = 2;
    constraints.gridy = 1;
    bottomPanel.add(new JPanel(), constraints);
    constraints.weightx = 0.2;
    constraints.weighty = 0.6;
    constraints.gridx = 3;
    constraints.gridy = 1;
    bottomPanel.add(toggleButton, constraints);
    constraints.weightx = 0.1;
    constraints.weighty = 0.6;
    constraints.gridx = 4;
    constraints.gridy = 1;
    bottomPanel.add(new JPanel(), constraints);
    constraints.weightx = 0.2;
    constraints.weighty = 0.6;
    constraints.gridx = 5;
    constraints.gridy = 1;
    bottomPanel.add(reportButton, constraints);
    constraints.weightx = 0.1;
    constraints.weighty = 0.6;
    constraints.gridx = 6;
    constraints.gridy = 1;
    bottomPanel.add(new JPanel(), constraints);
    constraints.weightx = 0.1;
    constraints.weighty = 0.2;
    constraints.gridx = 0;
    constraints.gridy = 2;
    bottomPanel.add(new JPanel(), constraints);
//    bottomPanel.add(printButton);
    
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weightx = 1;
    constraints.weighty = 0.1;
    
    add(topPanel, constraints);
    
    constraints.gridy = 1;
    constraints.weighty = 0.7;
    
    add(middlePanel, constraints);
    
    constraints.gridy = 2;
    constraints.weighty = 0.2;
    
    add(bottomPanel, constraints);
  }
  
  public static void main(String[] args)
  {
    new MainWindow(new CourseAssignment());
  }
  
   private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource() == toggleButton)
      {
        if(reportPanel.equals(courseReportPanel)) {
          middleLeftPanel.remove(reportPanel);
          reportPanel = instructorReportPanel;
          middleLeftPanel.add(reportPanel);
          middleLeftPanel.revalidate();
          toggleButton.setText("Courses");
          repaint();
        }
        else {
          middleLeftPanel.remove(reportPanel);
          reportPanel = courseReportPanel;
          middleLeftPanel.add(reportPanel);
          middleLeftPanel.revalidate();
          toggleButton.setText("Instructors");
          repaint();
        }
      }
      if (e.getSource() == reportButton) {
          JFrame jf = new JFrame();
          jf.setLayout(null);
          jf.setSize(300,300);
          JButton p = new JButton("Print");
          p.setSize(100, 30);
          p.setLocation(185, 230);
          JButton s = new JButton("Save");
          s.setSize(100, 30);
          s.setLocation(0, 230);
          JTextArea t = new JTextArea("This is the area where the report" +
                  " would go, and the buttons below would allow you to save" +
                  " the report to a file or to print it.");
          t.setEditable(false);
          t.setLineWrap(true);
          t.setWrapStyleWord(true);
          t.setSize(225, 200);
          t.setLocation(25, 0);
          t.setBorder(BorderFactory.createLineBorder(Color.black));
          jf.add(p);
          jf.add(s);
          jf.add(t);
          jf.setVisible(true);   
      }
      if (e.getSource() == detailsButton) {
          JOptionPane.showMessageDialog(null, "Clicking this would send the" +
                  " details of the currently selected instructor or course to" +
                  " the details box on the right.");
      }
      if (e.getSource() == assignButton) {
          if(round == 1) {
              courseAssignment.assignCourses();
              assignButton.setText("Round 2");
              round = 2;
          }
          else if(round == 2) {
              courseAssignment.assignCourses();
              assignButton.setText("Round 3");
              round = 3;
          }
          else if(round == 3) {
              courseAssignment.assignCourses();
              assignButton.setText("Done");
              assignButton.setEnabled(false);
              round = 4;
          }
      }
    }
  }
}