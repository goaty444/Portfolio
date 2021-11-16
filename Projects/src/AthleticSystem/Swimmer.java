package AthleticSystem;

import java.util.ArrayList;



public class Swimmer extends Athlete {
	
	
	/**
	 * Constructor for the athlete class
	 * Don't forget to call the superclass constructor
	 * @param lName last name of the athlete
	 * @param fName first name of the athlete
	 * @param birthYear year the athlete was born
	 * @param birthMonth month the athlete was born
	 * @param birthDay day the athlete was born
	 * @param team name of professional team of the Swimmer
	 */
	public ArrayList<String> multiEvent = new ArrayList<String>();
	
	private String team;
	
	public Swimmer(String lName, String fName, int birthYear, int birthMonth, int birthDay, String team) {
		super(lName, fName, birthYear, birthMonth, birthDay);
		this.team = team;
	}
	
	/**
	 * Method that returns the team of the Swimmer
	 * @return team
	 */
	public String getTeam() {
		return this.team;
	}

	/**
	 * Method that takes a event (a string) and adds it to the list of events that the Swimmer participates in
	 * 
	 * @param event should not be null
	 * @return 1 if the event was added successfully, 0 if the event is not valid or the event is already in the list
	 */
	public int addEvent(String singleEvent) {
		if (singleEvent != null) {
			return super.addEvent(singleEvent);
		}
		
		else 
		return 0;
	}
	
	/**
	 * Method that takes a list of events (an arraylist of strings) and adds it to the list of events that the Swimmer participates in
	 * @param event cannot be null
	 * @return the sum of all valid events added to the list
	 */
	public int addEvent(ArrayList<String> multiEvent) {
		for(int i = 0; i < multiEvent.size(); i++) {
			this.addEvent(multiEvent.get(i));
		}
		return -1;
	}
	
	/**
	 *Returns a string about the Swimmer in the form 
	 * "Missy Franklin is 26 years, 3 months and 29 days old and is a swimmer for team: Colorado Stars and participates in the following events: [100M BACKSTOKE, 50M BACKSTOKE, 100M FREESTYLE]"
	 */
	public String toString() {
		return super.toString() + " and is a swimmer for team " + team + "and participates in the following events:"  + this.getEvents().toString();
	}
	

}



