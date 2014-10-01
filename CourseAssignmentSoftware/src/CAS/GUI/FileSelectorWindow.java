package CAS.GUI;

import CAS.CourseAssignment;
import CAS.GUI.Login.LoginFrame;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Julian Kuk
 */
public class FileSelectorWindow {

    private final String WORK_DIALOG_TITLE = "Select WORK AREA file...";
    private final String COURSE_DIALOG_TITLE = "Select COURSE file...";
    private final String TAF_DIALOG_TITLE = "Select TAF file...";
    private final String SENIORITY_DIALOG_TITLE = "Select SENIORITY file...";
    
    private final String WORK_EXTENSION = "wrk";
    private final String COURSE_EXTENSION = "crs";
    private final String TAF_EXTENSION = "taf";
    private final String SENIORITY_EXTENSION = "snr";
    
    private final String DEFAULT_DIRECTORY = "user.dir";
    private final String INPUT_FOLDER = "\\input\\";
    
    private final String WORK_LIST = "workAreas." + WORK_EXTENSION;
    private final String COURSE_LIST = "CourseSchedule." + COURSE_EXTENSION;
    private final String TAF_LIST = "TAF_simple." + TAF_EXTENSION;
    private final String SENIORITY_LIST = "FakeSeniority." + SENIORITY_EXTENSION;
    
    private final int CANCEL = -1;
    
    private CourseAssignment courseAssignment;
    private String directory;

    public FileSelectorWindow() {
        courseAssignment = new CourseAssignment();
        boolean ready = false;
        int entryPoint = 0;
        
        directory = System.getProperty(DEFAULT_DIRECTORY);
        System.out.println(directory + INPUT_FOLDER + WORK_LIST);
        File workAreasFile = new File(directory + INPUT_FOLDER + WORK_LIST);
        while (!ready) {
            switch (entryPoint++) {
                case 0:
                    if (!workAreasFile.exists()) {
                        workAreasFile = chooseFile(WORK_DIALOG_TITLE, WORK_EXTENSION);
                        if (workAreasFile == null) {
                            entryPoint = CANCEL;
                        }
                    }
                    break;

                case 1:
                    try {
                        courseAssignment.loadCourses(new File(directory + INPUT_FOLDER + COURSE_LIST), workAreasFile);
                    } catch (FileNotFoundException e) {
                        entryPoint = chooseCourseFile(entryPoint, workAreasFile);
                    }
                    break;

                case 2:
                    try {
                        courseAssignment.loadInstructors(new File(directory + INPUT_FOLDER + TAF_LIST));
                    } catch (FileNotFoundException e) {
                        entryPoint = chooseTAFFile(entryPoint);
                    }
                    break;

                case 3:
                    try {
                        courseAssignment.loadSeniorityList(new File(directory + INPUT_FOLDER + SENIORITY_LIST));
                    } catch (FileNotFoundException e) {
                        entryPoint = chooseSeniorityFile(entryPoint);
                    }
                    break;
                case 4:
                    ready = true;
                    new MainWindow(courseAssignment);
                    System.out.println(courseAssignment);
                    System.out.println(courseAssignment.getCourses());
                    System.out.println(courseAssignment.getInstructors());
                    break;
                default:
                    ready = true;
                    new LoginFrame();
                    break;
            }
        }
    }

    private int chooseCourseFile(int entryPoint, File workAreasFile) {
        File file = chooseFile(COURSE_DIALOG_TITLE, COURSE_EXTENSION);
        if (file == null) {
            return CANCEL;
        } else {
            try {
                courseAssignment.loadCourses(file, workAreasFile);
            } catch (FileNotFoundException e) {
            }
            return entryPoint;
        }
    }

    private int chooseTAFFile(int entryPoint) {
        File file = chooseFile(TAF_DIALOG_TITLE, TAF_EXTENSION);
        if (file == null) {
            return CANCEL;
        } else {
            try {
                courseAssignment.loadInstructors(file);
            } catch (FileNotFoundException e) {
            }
            return entryPoint;
        }
    }

    private int chooseSeniorityFile(int entryPoint) {
        File file = chooseFile(SENIORITY_DIALOG_TITLE, SENIORITY_EXTENSION);
        if (file == null) {
            return CANCEL;
        } else {
            try {
                courseAssignment.loadSeniorityList(file);
            } catch (FileNotFoundException e) {
            }
            return entryPoint;
        }
    }

    private File chooseFile(String dialogTitle, String fileExtension) {
        directory = System.getProperty(DEFAULT_DIRECTORY);
        JFileChooser chooser = new JFileChooser(new File(directory + INPUT_FOLDER));

        chooser.setDialogTitle(dialogTitle);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(fileExtension, fileExtension);
        chooser.setFileFilter(filter);
        if (chooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        } else {
            return null;
        }
    }
}