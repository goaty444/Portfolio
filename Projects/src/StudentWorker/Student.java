package StudentWorker;

public abstract class Student {
	
	private String lname;
	private String fname;
	private double gpa;
	
	
	
	public Student(String lname, String fname) {
		this.lname = lname;
		this.fname = fname;
	}
	
	
	public String toString() {
		return "This is " + this.getFname() + " " + this.getLname();
	}

	
	public String getLname() {
		return lname;
	}

	
	public void setLname(String lname) {
		this.lname = lname;

	}

	
	public String getFname() {
		return fname;
	}

	
	public void setFname(String fname) {
		this.fname = fname;

	}

	
	public abstract String getId();

	
	public abstract boolean addId(String id);

	
	public double getGpa() {
		return this.gpa;
	}

	
	public void setGpa(double gpa) {
		if(gpa > 4.0)this.gpa = 4.0;

		else if(gpa < 1) this.gpa = 1;

		else this.gpa = gpa;

		

	}
	
	
	public boolean equals(Object other) {
		return ((Student) other).getFname().equalsIgnoreCase(fname) && ((Student) other).getLname().equalsIgnoreCase(lname);
	}
}
