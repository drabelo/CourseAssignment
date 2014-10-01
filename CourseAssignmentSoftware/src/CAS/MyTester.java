/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS;

import CAS.Data.Course;
import CAS.Data.Instructor;
import java.io.File;

/**
 *
 * @author Sid
 */
public class MyTester {
    
    public static void main(String[] args)
    {
        final String DEFAULT_DIRECTORY = "user.dir";
        CourseAssignment ca = new CourseAssignment();
        String directory = System.getProperty(DEFAULT_DIRECTORY);
        try
        {
            ca.loadCourses(new File(directory + "/input/CourseSchedule.crs"), new File(directory + "/input/workAreas.wrk"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(Course course : ca.getCourses().values())
        {
            System.out.println(course);
        }
        
        try
        {
            ca.loadInstructors(new File(directory + "/input/TAF_simple.taf"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(Instructor instructor : ca.getInstructors().values())
        {
            System.out.println(instructor);
        }
        
        try
        {
            ca.loadSeniorityList(new File(directory + "/input/FakeSeniority.snr"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
         for(Instructor instructor : ca.getInstructors().values())
        {
            System.out.println(instructor);
        }
         
         ca.assignCourses();
         
        for(Course course : ca.getCourses().values())
        {
            System.out.println(course);
        }         
         for(Instructor instructor : ca.getInstructors().values())
        {
            System.out.println(instructor);
        }        
    }
    
}
