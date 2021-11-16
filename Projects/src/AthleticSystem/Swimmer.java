package AthleticSystem;

import java.util.ArrayList;



public class Swimmer extends Athlete {
	
	
	
	public ArrayList<String> multiEvent = new ArrayList<String>();
	
	private String team;
	
	public Swimmer(String lName, String fName, int birthYear, int birthMonth, int birthDay, String team) {
		super(lName, fName, birthYear, birthMonth, birthDay);
		this.team = team;
	}
	
	public String getTeam() {
		return this.team;
	}

	
	public int addEvent(String singleEvent) {
		if (singleEvent != null) {
			return super.addEvent(singleEvent);
		}
		
		else 
		return 0;
	}
	
	
	public int addEvent(ArrayList<String> multiEvent) {
		for(int i = 0; i < multiEvent.size(); i++) {
			this.addEvent(multiEvent.get(i));
		}
		return -1;
	}
	
	public String toString() {
		return super.toString() + " and is a swimmer for team " + team + "and participates in the following events:"  + this.getEvents().toString();
	}
	

}



