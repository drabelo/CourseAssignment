/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * @author Julian Kuk
 */
public class DataTester {
    public static void main(String[] args) {
        ArrayList<Day> days = new ArrayList<Day>();
        days.add(Day.MONDAY);
        days.add(Day.TUESDAY);
        days.add(Day.WEDNESDAY);
        Course course1 = new Course(1233, "workArea", days, new Time(11, 10), new Time(13, 30),
         "subject", "number1", "section", -1, "title",
         3, "WEL", "424");
        Course course2 = new Course(1234, "workArea", days, new Time(11, 10), new Time(13, 30),
         "subject", "number2", "section", -1, "title",
         3, "WEL", "424");
        Course course3 = new Course(1235, "workArea", days, new Time(11, 10), new Time(13, 30),
         "subject", "number3", "section", -1, "title",
         3, "WEL", "424");
        
        System.out.println(course1.equals(course2));
        System.out.println(course1.equals(course3));
        System.out.println(course2.equals(course2));
        System.out.println(course1.hashCode());
        
        ArrayList<Day> preferredDays = new ArrayList<Day>();
        preferredDays.add(Day.MONDAY);
        preferredDays.add(Day.TUESDAY);
        preferredDays.add(Day.WEDNESDAY);
        
        ArrayList<TimeSchedule> preferredTimes = new ArrayList<TimeSchedule>();
        preferredTimes.add(new TimeSchedule(10, 12));
        preferredTimes.add(new TimeSchedule(14, 16));
        
        ArrayDeque<String> preferredCourses = new ArrayDeque<String>();
        preferredCourses.offer("BI");
        preferredCourses.offer("CS");
        
        Instructor instructor = new Instructor(new TAF(preferredDays, preferredTimes, preferredCourses),
                "John", "123-123-1234");
        
        
    }
}
