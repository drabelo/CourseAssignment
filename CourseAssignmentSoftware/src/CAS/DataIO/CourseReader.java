/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS.DataIO;

/**
 *
 * @author Justin
 */
import java.io.*;
import java.util.HashMap;
import CAS.Data.Course;
import CAS.Data.Day;
import CAS.Data.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseReader {
    /*
     public CourseReader(String filename) throws FileNotFoundException
     {
     super(filename);
     }
     * */

    public static HashMap<String, Course> loadCourses(String filename, String workAreaFilename) throws FileNotFoundException {
        return loadCourses(new File(filename), new File(workAreaFilename));
    }

    public static HashMap<String, Course> loadCourses(File file, File workAreaFile) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        HashMap<String, Course> courseList = new HashMap<String, Course>();
        
        /*
        final String DEFAULT_DIRECTORY = "user.dir";
        String directory = System.getProperty(DEFAULT_DIRECTORY);
        * */
        HashMap<String, String> workAreas = loadWorkAreas(workAreaFile);
        
        scan.nextLine();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] splitline = line.split("\\t");

            int id = Integer.parseInt(splitline[0]);
            String workArea = null;

            ArrayList<Day> days;
            Time start;
            Time end;

            if (splitline.length > 5) {
                days = new ArrayList<Day>();
                if (splitline[5].contains("M")) {
                    days.add(Day.MONDAY);
                }
                if (splitline[5].contains("T")) {
                    days.add(Day.TUESDAY);
                }
                if (splitline[5].contains("W")) {
                    days.add(Day.WEDNESDAY);
                }
                if (splitline[5].contains("R")) {
                    days.add(Day.THURSDAY);
                }
                if (splitline[5].contains("F")) {
                    days.add(Day.FRIDAY);
                }
                if (splitline[5].contains("Sa")) {
                    days.add(Day.SATURDAY);
                }
                if (splitline[5].contains("Su")) {
                    days.add(Day.SUNDAY);
                }

                String[] startTime = splitline[6].split(":");
                int hour = Integer.parseInt(startTime[0].trim());
                char[] startMin = startTime[1].toCharArray();
                String minString = String.valueOf(startMin[0]) + String.valueOf(startMin[1]);
                int min = Integer.parseInt(minString);
                if (startMin[2] == 'p') {
                    hour += 12;
                }
                start = new Time(hour, min);
                String[] endTime = splitline[7].split(":");
                hour = Integer.parseInt(endTime[0].trim());
                char[] endMin = endTime[1].toCharArray();
                minString = String.valueOf(endMin[0]) + String.valueOf(endMin[1]);
                min = Integer.parseInt(minString);
                if (endMin[2] == 'p') {
                    hour += 12;
                }
                end = new Time(hour, min);
            } else {
                days = null;
                start = null;
                end = null;
            }

            //System.out.println(workAreas);
            String[] subjectNumber = splitline[1].split("\\s");
            //System.out.println(subjectNumber[0] + subjectNumber[1]);
           // System.out.println(workAreas.get(subjectNumber[0] + subjectNumber[1]));
            /*
            switch (subjectNumber[0]) {
                case "BI":
                    if (subjectNumber[1].equals("113")
                            || subjectNumber[1].equals("115")
                            || subjectNumber[1].equals("116")) {
                        workArea = "Anatomy & Physiology";
                    }
                    if (subjectNumber[1].equals("101")
                            || subjectNumber[1].equals("102")
                            || subjectNumber[1].equals("110")
                            || subjectNumber[1].equals("120")
                            || subjectNumber[1].equals("210")) {
                        workArea = "Biology";
                    }
                    if (subjectNumber[1].equals("118")
                            || subjectNumber[1].equals("123")
                            || subjectNumber[1].equals("220")
                            || subjectNumber[1].equals("240")) {
                        workArea = "Microbiology";
                    }
                    break;
                case "BT":
                    workArea = "Biotechnology";
                    break;
                case "CH":
                    workArea = "Chemistry";
                    break;
                case "CS":
                    if (subjectNumber[1].equals("100")) {
                        workArea = "Computer Literacy";
                    } else {
                        workArea = "Computer Science";
                    }
                    break;
                case "EE":
                    workArea = "Engineering";
                    break;
                case "EV":
                    workArea = "Environmental Science";
                    break;
                case "MA":
                    if (subjectNumber[1].equals("105")) {
                        workArea = "Statistics";
                    } else {
                        workArea = "Mathematics";
                    }
                    break;
                case "MAC":
                    workArea = "Mathematics";
                    break;
                case "MN":
                    if (subjectNumber[1].equals("121")
                            || subjectNumber[1].equals("130")
                            || subjectNumber[1].equals("135")
                            || subjectNumber[1].equals("140")
                            || subjectNumber[1].equals("141")
                            || subjectNumber[1].equals("241")
                            || subjectNumber[1].equals("261")
                            || subjectNumber[1].equals("271")) {
                        workArea = "Mechanical CAD";
                    }
                    break;
                case "PY":
                    workArea = "Physics";
                    break;
                case "SC":
                    workArea = "Science";
                    break;
                default:
                    workArea = null;
                    break;
            }*/
            String subject = subjectNumber[0];
            String number = subjectNumber[1];
            String section = splitline[2];
            int session = 0;
            String title = splitline[3];
            int credits = 0;
            String campus = splitline[4];
            String room = null;
            
            workArea = workAreas.get(subjectNumber[0] + subjectNumber[1]);

            Course course = new Course(id, workArea, days, start, end, subject,
                    number, section, session, title, credits, campus, room);
            String key = course.getSubject() + course.getNumber() + course.getSection();
            courseList.put(key, course);
        }
        return courseList;
    }

    public static HashMap<String, String> loadWorkAreas(File file) {
        Scanner scan = null;
        try {
            scan = new Scanner(file);
            HashMap<String, String> workAreaList = new HashMap<String, String>();
            String area = null;

            while (scan.hasNext()) {
                String line = scan.nextLine();
                if (line.equals("")) {
                    area = null;
                } else {
                    if (area == null) {
                        area = line;
                    } else {
                        String[] split = line.replaceAll("[(),]", "").split(" ");
                        for (int i = 1; i < split.length; i++) {
                            workAreaList.put("" + split[0] + split[i], area);
                        }
                    }
                }
            }
            return workAreaList;
        } catch (IOException e) {
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return null;
    }
}
