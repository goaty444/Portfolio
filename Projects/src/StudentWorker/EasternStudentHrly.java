package StudentWorker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasternStudentHrly extends Student implements HourlyEmployee {

	private int hoursWorked;
	private double perHour;
	private String id;

	  
	
	
	public EasternStudentHrly(String lname, String fname) {
		super(lname, fname);
	}

	
	public void setHourlyRate(double perHour) {
		this.perHour = perHour;
	}

	
	public String getId() {
		return this.id;
	}

	
	public boolean addId(String id) {
		if (id==null) {
			return false;
		} 
		
		String pattern = "([A-F])(\\d)([A-F])(\\d)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(id);
		if (m.find()) {
			this.id = id;
			return true;
		}
		
		return false;
		
		
	
		}


	public double getPay() {
		double total = 0;
		if (hoursWorked <= HourlyEmployee.MAX_WEEKLY_HOURS) {
			total = hoursWorked * perHour;
		} 
		else if (hoursWorked > HourlyEmployee.MAX_WEEKLY_HOURS) {
			total = (HourlyEmployee.MAX_WEEKLY_HOURS * perHour) + ((hoursWorked - HourlyEmployee.MAX_WEEKLY_HOURS)
			* HourlyEmployee.OVERTIME_RATE * perHour);
		}
		return total;

		}

	
	public void setTotalHoursForWeek(int hoursWorked) {
		this.hoursWorked = hoursWorked;

	}

	
	public String toString() {
		return "This is " + super.getFname() + " " + super.getLname() + " pay for the period is $" +
		String.format("%.2f", getPay());
	}

	
	public double getHourlyRate() {
		return perHour;
	}

	
	public int getTotalHoursForWeek() {
		return hoursWorked;
	}
}
