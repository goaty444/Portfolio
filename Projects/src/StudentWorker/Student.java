package StudentWorker;

public abstract class Student {
	
	private String lname;
	private String fname;
	private double gpa;
	
	
	//constructor for class	
	public Student(String lname, String fname) {
		this.lname = lname;
		this.fname = fname;
	}
	
	//returns a string e.g "This is Bugs Bunny"
	public String toString() {
		return "This is " + this.getFname() + " " + this.getLname();
	}

	//returns the Student' last name
	public String getLname() {
		return lname;
	}

	//sets the student's last name
	public void setLname(String lname) {
		this.lname = lname;

	}

	//gets the Student's first name
	public String getFname() {
		return fname;
	}

	//sets the student's first name
	public void setFname(String fname) {
		this.fname = fname;

	}

	//abstract method
	//returns the student's id 
	public abstract String getId();

	//abstract method
	//use regex to only accept strings with ... see the child classes
	public abstract boolean addId(String id);

	//returns the student's gpa
	public double getGpa() {
		return this.gpa;
	}

	//sets the student gpa
	//GPA less than 1.0 set to 1.0, GPA greater than 4.0 set to 4.0, accept any other number in between
	public void setGpa(double gpa) {
		if(gpa > 4.0)this.gpa = 4.0;

		else if(gpa < 1) this.gpa = 1;

		else this.gpa = gpa;

		

	}
	
	//equal if both Students' first name and last names are the same
	public boolean equals(Object other) {
		return ((Student) other).getFname().equalsIgnoreCase(fname) && ((Student) other).getLname().equalsIgnoreCase(lname);
	}
}
