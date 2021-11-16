package StudentWorker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SouthernStudentMth extends Student implements MonthlyEmployee{
	
	private double perMonth;
	private String id;

	  //constructor
	public SouthernStudentMth(String lname, String fname) {
		super(lname, fname);
	}

	//returns the id
	public String getId() {
		return this.id;
	}

	//returns true if the id is of the correct pattern and update the field
	//The pattern is: Starts with "S9", followed with either 1 or 2, followed by either 3 or 4 and three (3) other numbers
	//https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/String.html?is-external=true#matches(java.lang.String)
	public boolean addId(String id) {

		if (id == null) {

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
		

	//computes and return the pay as the perMonth plus a bonus equal to their GPA (e.g 4.0 GPA = 4%, 1.0 GPA = 1%)
	public double getPay() {
	return perMonth + (perMonth * (super.getGpa() / 100));
	}

	/*returns a string similar to that shown in the assignment doc
	* Example (Notice the newline):
	*
	* SOUTHERN NOT STATE!
	* This is Bugs Bunny with your 3.0 GPA, your monthly pay is $1545.00
	*/
	public String toString() {
		return "SOUTHERN NOT STATE!\nThis is " + super.getFname() + " " + super.getLname() + " with your " +
		String.format("%.1f", super.getGpa()) + " GPA, your monthly pay is $" + String.format("%5.2f", getPay());

		}

	//sets the value of the monthly pay. Should not allow negative value
	public void setMonthlyPay(double perMonth) {
		if (perMonth < 0) {
		} 
		else {
			this.perMonth = perMonth;
		}

		}

	//Returns the value of monthly pay
	public double getMonthlyPay() {
		return this.perMonth;
	}

}
