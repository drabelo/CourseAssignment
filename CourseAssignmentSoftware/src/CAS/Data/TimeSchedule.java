/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS.Data;

/**
 *
 * @author Julian Kuk
 */
public class TimeSchedule {
    private Time startTime, endTime;
    
    public TimeSchedule(int startHour, int endHour) {
        startTime = new Time(startHour, 0);
        endTime = new Time(endHour, 0);
    }
    
    public Time getStartTime() {
        return startTime;
    }
    
    public Time getEndTime() {
        return endTime;
    }
    
    public boolean withinRange(TimeSchedule timeSchedule) {
        return withinRange(timeSchedule.getStartTime().getHour(), timeSchedule.getEndTime().getHour());
    }
    
    public boolean withinRange(int startHour, int endHour) {
        return (startHour >= startTime.getHour() && startHour < endTime.getHour()) &&
                (endHour > startTime.getHour() && endHour <= endTime.getHour());
    }
}