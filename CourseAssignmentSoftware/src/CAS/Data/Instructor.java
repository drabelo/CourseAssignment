package CAS.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Instructor {

    private String name;
    private String phoneNumber;
    private HashMap<String, Integer> seniorities;
    private ArrayList<Course> courses;
    private TAF taf;

    public Instructor(TAF taf, String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.taf = taf;
        seniorities = new HashMap<String, Integer>();
        courses = new ArrayList<Course>();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public HashMap<String, Integer> getSeniorities() {
        return seniorities;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Date getDateOfSubmission() {
        return taf.getDateOfSubmission();
    }

    public ArrayList<Day> getPreferredDays() {
        return taf.getPreferredDays();
    }

    public ArrayList<TimeSchedule> getPreferredTimes() {
        return taf.getPreferredTimes();
    }

    // this method previously only returned a collection of strings,
    // we want the course objects!
    public ArrayDeque<Course> getPreferredCourses(HashMap<String, Course> courses) {
        ArrayDeque<String> prefCourseNames = taf.getPreferredCourses();
        ArrayDeque<Course> prefCourses = new ArrayDeque();
        
        // create a new ArrayDeque of type 'Course'
        while (!prefCourseNames.isEmpty() && prefCourseNames.peek() != null) {
            String courseName = prefCourseNames.pop();
            
            // add equivalent course objects to preferredList
            for (Course c : courses.values()) {
                if (c.getTitle().equals(courseName)) {
                    // this is the same addition logic being used in TAFReader,
                    // this ensures we keep the prefered course order the same.
                    prefCourses.offerLast(c); // adds the preferred course using fifo
                }
            }
        }
        
        return prefCourses;
    }
    
    public TAF getTAF() {
        return taf;
    }

    public int compareSeniorities(Instructor instructor, Course course) {
        String workArea = course.getWorkArea();
        int seniorityComparison = instructor.getSeniorities().get(workArea) - seniorities.get(workArea);
        if (seniorityComparison != 0) {
            return seniorityComparison;
        }
        else {
            int dateComparison = instructor.getTAF().getDateOfSubmission().compareTo(taf.getDateOfSubmission());
            return dateComparison;
        }
    }
    
    @Override
    public int hashCode() {
        String hash = name;
        return hash.hashCode();
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null) {            return false;        }
        if (object == this) {            return true;        }
        if (object instanceof Instructor) {
            Instructor other = (Instructor)object;
            return name.equals(other.getName()) && phoneNumber.equals(other.getPhoneNumber());
        }
        return false;
    }
}