package StudentWorker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasternStudentHrly extends Student implements HourlyEmployee {

	private int hoursWorked;
	private double perHour;
	private String id;

	  
	
	//constructor
	public EasternStudentHrly(String lname, String fname) {
		super(lname, fname);
	}

	//set the hourly pay rate for the student
	public void setHourlyRate(double perHour) {
		this.perHour = perHour;
	}

	//returns the student id
	public String getId() {
		return this.id;
	}

	//returns true if the id is of the correct pattern and update the field
	//The pattern is: Starts with A, B, C, D, E or F, followed by a digit, followed by A, B, C, D, E or F, followed by a digit
	//https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/String.html?is-external=true#matches(java.lang.String)
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

	//computes and returns the pay of the student
	//if hours below or equal max weekly hours, compute as hours * hourly rate
	//if hours exceed max weekly hours, compute the max weekly hours * hourly rate and add to
	//number of hours over max weekly hours * the overtime rate * hourly rate
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

	//sets the Student's total hours for the week
	public void setTotalHoursForWeek(int hoursWorked) {
		this.hoursWorked = hoursWorked;

	}

	//returns  a string similar to that shown in the assignment doc
	//super.toString()+" pay for the period is $"+String.format("%5.2f", this.getPay());
	public String toString() {
		return "This is " + super.getFname() + " " + super.getLname() + " pay for the period is $" +
		String.format("%.2f", getPay());
	}

	//returns the hourly rate of pay
	public double getHourlyRate() {
		return perHour;
	}

	//returns the total hours worked for the week
	public int getTotalHoursForWeek() {
		return hoursWorked;
	}
}
