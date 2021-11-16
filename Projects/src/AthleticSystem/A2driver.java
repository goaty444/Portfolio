package AthleticSystem;

import java.util.ArrayList;
import java.util.Arrays;


public class A2driver {

	public static void main(String[] args) {
		
		Athlete a =  new Athlete("Duck","Daffy", 2000, 9, 7);
		a.addEvent("Hotdog eating");
		a.addEvent("breakdancing");
		a.addEvent("breakdancing"); //breakdancing will only be added once
		System.out.println(a);
		System.out.println("It has been "+a.daysSinceBirth()+" days since Daff was born");

	
		Runner r = new Runner("Griffith", "Florence", 1959, 12, 21, "United States of America");
		r.addEvent("m100");
		r.addEvent("m200");
		r.addEvent("m200"); //200m will only be added once
		System.out.println(r); // ask why its not printing events in class 

		r.addEvent(new ArrayList<String>(Arrays.asList( "m200","M400"))); // M200 will not be added again
		System.out.println(r);

		
		Swimmer s = new Swimmer("Franklin", "Missy", 2020, 8, 7, "Colorado Stars");
		s.addEvent("100m backstoke");
		s.addEvent("50m backstoke");
		s.addEvent("50m backstoke"); //50m backstroke will only be added once
		s.addEvent("100m freestyle");
		System.out.println(s);

		s.addEvent(new ArrayList<String>(Arrays.asList( "200m backstroke","200m freestyle","100M FREESTYLE"))); // 100m freestyle will not be added again
		System.out.println(s);
		

	}

}

	


