package CAS.Data;

public class Date {
	int day;
	int month;
	int year;
	
	public Date(int day, int month, int year) throws DateException{
		if(month>12 && month<1){
			throw new DateException("incorrect month");
		}
		else
			this.month=month;
		// check feb for up to 28 days
		if(month==2){
			if(day>28 && day<1){
				throw new DateException("Incorrect Day ");
			}
		}
		else if(day>31 && day<1){
			throw new DateException("Incorrect Day ");
		}
		else
			this.year=year;
		if(year<=0){
			throw new DateException("incorrect year");
		}
		else
			this.day=day;
	}
	
	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}
        
        public int compareTo(Date date) {
            int yearComparison = date.getYear() - year;
            if (yearComparison != 0) {
                return yearComparison;
            }
            else {
                int monthComparison = date.getMonth() - month;
                if (monthComparison != 0) {
                    return monthComparison;
                }
                else {
                    int dayComparison = date.getDay() - day;
                    return dayComparison;
                }
            }
        }
}
