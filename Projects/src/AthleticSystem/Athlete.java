package AthleticSystem;

import java.util.ArrayList;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class Athlete {
	 
	/** 
	 * Constructor for the athlete class
	 * @param lName last name of the athlete
	 * @param fName first name of the athlete
	 * @param birthYear year the athlete was born
	 * @param birthMonth month the athlete was born
	 * @param birthDay day the athlete was born
	 */

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
	
	/**
	 * Method that computes the current age of the athlete.
	 * 
	 * The string should go years, then months, then days.
	 * The string should end with " old".
	 * Years should only be included if it's greater than 0.
	 * Months should only be included if it's greater than 0.
	 * Days should only be included if it's greater than 0.
	 * If any of years, months, or days are greater than 1, they should include an 's' at the end.
	 * If there are two terms, they should be separated by " and ".
	 * If there are three terms, the first two terms should be separated by ", "
	 * 	and the second and third terms should be separated by " and ".
	 * 
	 * Examples:
	 * "26 years, 3 months and 29 days old"
	 * "26 years and 5 months old"
	 * "5 months and 4 days old"
	 * "26 years old"
	 * "1 year, 1 month and 1 day old"
	 * 
	 * @return a string representation of the athlete's age.
	 */
	

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
	
	
	/**
	 * Method that computes the number of days between the athlete's birth to now
	 * @return a number representing days since birth
	 */
	
	public long daysSinceBirth() {
	long days = birthday.until(LocalDate.now(), ChronoUnit.DAYS);
	return days;
	}
	
	/**
	 * Method that returns the athlete's first name
	 * @return fName
	 */
	public String getFName() {
		return fName;
	}
	
	public void setFName(String fName) {
		this.fName = fName;
		
	}
	/**
	 * Method that returns the athlete's last name
	 * @return lName
	 */
	public String getLName() {
		return lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
		
	}
	/**
	 * method that returns the athlete's first name followed by last name followed by athlete's current age
	 * "Daffy Duck is 21 years and 1 day old"
	 */
	public String toString() {
		return this.fName + " " +  this.lName + " is " + this.computeAge();
	}
	
	/**
	 * Method that compares two athlete objects
	 * @return  true if first name and last name and days since birth are the same
	 * 			false otherwise
	 */
	public boolean equals(Object athlete) {
		return false;
	}
	
	/**
	 * Method that returns the arraylist of events that the athlete participates in
	 * @return events
	 */
	public ArrayList<String> getEvents() {
		return this.events;
	}
	
	/**
	 * Method that takes a event (a string) and adds it to the list of events that the Athlete participates in
	 * 
	 * @param event cannot be null
	 * @return 1 if the event was added successfully, 0 if the event is null or the event is already in the list
	 */
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


