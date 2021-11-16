package AthleticSystem;

import java.util.ArrayList;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class Athlete {
	
	private ArrayList<String> events = new ArrayList<String>();
	
	private String fName;
	private String lName;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	
	
	private LocalDate todayDate;
	private LocalDate birthday; 
	
	
	public Athlete(String lName, String fName, int birthYear, int birthMonth, int birthDay) {
		this.lName = lName;
		this.fName = fName;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.birthDay = birthDay;
		birthday = LocalDate.of(birthYear, birthMonth, birthDay);
	}
	
	
	

	public String computeAge() {
		todayDate = LocalDate.now();
		Period period = Period.between(birthday, todayDate);
		String age = " ";
		
		int year = period.getYears();
		int month = period.getMonths();
		int day = period.getDays();
		
		if (year > 0) {
			if(year == 1) 
				age = year + " year";
			else 
				age = year + " years";
		}
		
		if (month > 0) {
			if (age.length() > 0) {
				if(month == 1) {
					age += ", " + month + " month";
				}
				else {
					age += ", " + month + " months";
					}
			}
			else {
				if (month == 1)
					age = month + " month";
				else 
					age = month + " months";
			}
		
		}
		
		if (day > 0) {
			if(age.length()> 0) {
				if (day == 1) 
					age += " and " + day + " day old";
				else
					age += " and " + day + " days old";
			}
			
			else {
				if (day == 1)
					age = day + "day old";
				else 
					age = day + " days old";
			}
		}
		else {
			if(age.lastIndexOf(",") != -1) {
				age = age.substring(0, age.lastIndexOf(",")) + age.substring(age.lastIndexOf(",") + 1);
			}
		}
			return age;
		
	}
	
	
	
	
	public long daysSinceBirth() {
	long days = birthday.until(LocalDate.now(), ChronoUnit.DAYS);
	return days;
	}
	
	
	public String getFName() {
		return fName;
	}
	
	public void setFName(String fName) {
		this.fName = fName;
		
	}
	
	public String getLName() {
		return lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
		
	}
	
	public String toString() {
		return this.fName + " " +  this.lName + " is " + this.computeAge();
	}
	
	
	public boolean equals(Object athlete) {
		return false;
	}
	
	
	public ArrayList<String> getEvents() {
		return this.events;
	}
	
	
	public int addEvent(String event) {
		if((event == null) || (this.events.contains(event))) {
			return 0;
		}
		else {
			this.events.add(event);
			return 1;
		}
	}
}


