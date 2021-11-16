package StudentWorker;

import java.util.regex.*;

public class SouthernStudentHrly extends Student implements HourlyEmployee{
	
	private int hoursWorked;
	private double perHour;
	private String id;

	  
	
	//constructor
	public SouthernStudentHrly(String lname, String fname) {
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
	//The pattern is: Starts with "S9", followed with either 1 or 2, followed by either 3 or 4 and three (3) other numbers
	//https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/String.html?is-external=true#matches(java.lang.String)
	public boolean addId(String id) {
		if (id==null) {
			return false;
		}
		
		String pattern = "(S9)(1|2)(3|4)(\\d{3})";
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

		} else if (hoursWorked > HourlyEmployee.MAX_WEEKLY_HOURS) {

		total = (HourlyEmployee.MAX_WEEKLY_HOURS * perHour) + ((hoursWorked - HourlyEmployee.MAX_WEEKLY_HOURS)

		* HourlyEmployee.OVERTIME_RATE * perHour);

		}

		return total;
	}

	//sets the Student's total hours for the week
	public void setTotalHoursForWeek(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	/*returns a string similar to that shown in the assignment doc
	 * Example (Notice the newline):
	 * 
	 * SOUTHERN NOT STATE!
	 * This is Daffy Duck pay for the period is $375.00
	 */
	public String toString() {
		return "SOUTHERN NOT STATE!\nThis is " + super.getFname() + " " + super.getLname() + " pay for the period is $" +

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
