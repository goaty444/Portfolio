package AthleticSystem;

import java.util.ArrayList;


public class Runner extends Athlete{
	
	private String country;
	
	public Runner(String lName, String fName, int birthYear, int birthMonth, int birthDay, String country) {
		super(lName, fName, birthYear, birthMonth, birthDay);
		this.country = country;
	}

	
	
	public String getCountry() {
		return this.country;
	}

	
	@Override
	public String toString() {
		
		return super.toString() + ", a citizen of " + this.getCountry() + " and is a sprinter who participates in these events:"
		+ super.getEvents();
		//.toString();
	}
	
	
	public int addEvent(String event) {
		if((event.equalsIgnoreCase("m100") || event.equalsIgnoreCase("m200") || event.equalsIgnoreCase("m400") || event.equalsIgnoreCase("m3000") 
				||event.equalsIgnoreCase("m5000") || event.equalsIgnoreCase("m10000") ) && (event != null)) {
		return super.addEvent(event);
			} 
		else { 
				return 0;
			}
		}


	
	
	public int addEvent(ArrayList<String> events) {
		for(int i = 0; i < events.size(); i++) {
			this.addEvent(events.get(i));
			}
		return -1;
	}
}


