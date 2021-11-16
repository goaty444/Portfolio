package StudentWorker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SouthernStudentMth extends Student implements MonthlyEmployee{
	
	private double perMonth;
	private String id;

	 
	public SouthernStudentMth(String lname, String fname) {
		super(lname, fname);
	}

	public String getId() {
		return this.id;
	}

	
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
		


	public double getPay() {
	return perMonth + (perMonth * (super.getGpa() / 100));
	}

	
	public String toString() {
		return "SOUTHERN NOT STATE!\nThis is " + super.getFname() + " " + super.getLname() + " with your " +
		String.format("%.1f", super.getGpa()) + " GPA, your monthly pay is $" + String.format("%5.2f", getPay());

		}

	
	public void setMonthlyPay(double perMonth) {
		if (perMonth < 0) {
		} 
		else {
			this.perMonth = perMonth;
		}

		}

	
	public double getMonthlyPay() {
		return this.perMonth;
	}

}
