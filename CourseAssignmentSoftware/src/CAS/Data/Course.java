package CAS.Data;

import java.util.ArrayList;

public class Course
{
 private int id;
 private String workArea;
 private Instructor instructor;
 private ArrayList<Day> days;
 private Time start;
 private Time end;
 private String subject;
 private String number;
 private String section;
 private int session;
 private String title;
 private int credits;
 private String campus;
 private String room;

 public Course(int id, String workArea, ArrayList<Day> days, Time start, Time end,
         String subject, String number, String section, int session, String title,
         int credits, String campus, String room){
     this.id = id;
     this.workArea = workArea;
     instructor = null;
     days = new ArrayList<Day>();
     this.subject = subject;
     this.number = number;
     this.section = section;
     this.title = title;
     this.credits = credits;
     this.campus = campus;
     this.room = room;
 }

 @Override
 public int hashCode(){
  String hash = subject + number;
  return hash.hashCode();
 }

 @Override
 public boolean equals(Object object){
     Course course = (Course)object;
  if(number != course.getNumber())
      return false;
  if(!subject.equals(course.getSubject()))
      return false;
  if(!title.equals(course.getTitle()))
      return false;
  if(credits != course.getCredits())
      return false;
  return true;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getWorkArea() {
  return workArea;
 }

 public void setWorkarea(String workArea) {
  this.workArea = workArea;
 }

 public Instructor getInstructor() {
  return instructor;
 }

 public void setInstructor(Instructor instructor) {
  this.instructor = instructor;
 }

 public ArrayList<Day> getDays() {
  return days;
 }

 public void setDays(ArrayList<Day> days) {
  this.days = days;
 }
 
 public void addDay(Day day) {
     days.add(day);
 }

 public Time getStart() {
  return start;
 }

 public void setStart(Time start) {
  this.start = start;
 }

 public Time getEnd() {
  return end;
 }

 public void setEnd(Time end) {
  this.end = end;
 }

 public String getSubject() {
  return subject;
 }

 public void setSubject(String subject) {
  this.subject = subject;
 }

 public String getSection() {
  return section;
 }

 public void setSection(String section) {
  this.section = section;
 }

 public int getSession() {
  return session;
 }

 public void setSession(int session) {
  this.session = session;
 }

 public int getCredits() {
  return credits;
 }

 public void setCredits(int credits) {
  this.credits = credits;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public String getCampus() {
  return campus;
 }

 public void setCampus(String campus) {
  this.campus = campus;
 }

 public String getRoom() {
  return room;
 }

 public void setRoom(String room) {
  this.room = room;
 }
 
 public void setNumber(String number){
  this.number = number;
 }
 
 public String getNumber(){
  return number;
 }
}