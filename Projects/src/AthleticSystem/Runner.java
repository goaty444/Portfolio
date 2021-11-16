package AthleticSystem;

import java.util.ArrayList;

//Don't forget to use extends
public class Runner extends Athlete{
	
	private String country;
	
	public Runner(String lName, String fName, int birthYear, int birthMonth, int birthDay, String country) {
		super(lName, fName, birthYear, birthMonth, birthDay);
		this.country = country;
	}

	/**
	 * Method that returns the country of the Runner
	 * @return team
	 */
	
	public String getCountry() {
		return this.country;
	}

	/**
	 *Returns a string about the Runner in the form 
	 *Florence Griffith is 61 years, 8 months and 18 days old, a citizen of United States of America and is a sprinter who participates in thses events: [M100, M200]
	 *If the Runner DOES NOT participate in m100, m200 and m400 then she is a "long-distance runner".
	 *If the Runner DOES NOT participate in m3000, m5000 and m10000 then she is a "sprinter".
	 *Otherwise she is a "super athlete"
	 */
	@Override
	public String toString() {
		
		return super.toString() + ", a citizen of " + this.getCountry() + " and is a sprinter who participates in these events:"
		+ super.getEvents();
		//.toString();
	}
	
	/**
	 * Method that takes a event (a string) and adds it to the list of events that the Runner participates in
	 * 
	 * @param event valid events are m100, m200, m400, m3000, m5000 and m10000
	 * @return 1 if the event was added successfully, 0 if the event is not valid or the event is already in the list
	 */
	public int addEvent(String event) {
		if((event.equalsIgnoreCase("m100") || event.equalsIgnoreCase("m200") || event.equalsIgnoreCase("m400") || event.equalsIgnoreCase("m3000") 
				||event.equalsIgnoreCase("m5000") || event.equalsIgnoreCase("m10000") ) && (event != null)) {
		return super.addEvent(event);
			} 
		else { 
				return 0;
			}
		}


	/**
	 * Method that takes a list of events (an arraylist of strings) and adds it to the list of events that the Runner participates in
	 * @param event valid events are m100, m200, m400, m3000, m5000 and m10000
	 * @return the sum of all valid events added to the list
	 */
	
	
	public int addEvent(ArrayList<String> events) {
		for(int i = 0; i < events.size(); i++) {
			this.addEvent(events.get(i));
			}
		return -1;
	}
}


