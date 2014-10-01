
package CAS.Data;

public class Time{
 private int hour;
 private int min;

 public Time(int hour, int min){
     setTime(hour, min);
 }
 
 public void setTime(int h, int m){
     hour =((h >= 0&& h < 24) ? h :0);
     min = ((m >= 0 && m < 60) ? m :0);
}
 
 public int getHour() {
     return hour;
 }
 
// convert to String in universal-time format (HH:MM)
 public String toUniversalString(){
     return String.format( "%02d:%02", hour, min);
 }
    
 // convert to String in standard-time format (H:MM AM PM)
 public String toString(){ 
     return String.format( "%d:%02%s",(( hour == 0 || hour == 12) ? 12 : hour % 12),min,(hour< 12?"AM":"PM"));
 }
}