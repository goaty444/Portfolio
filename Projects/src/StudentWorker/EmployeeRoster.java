package StudentWorker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;



public class EmployeeRoster {

	private LinkedList<Employee> Roster = new LinkedList<Employee>();
	int badCount = 0;
	int invalidCount = 0;
	/*Read from text file <<fileName>>, load to an LinkedList of Employees, handle exceptions in this method.
	For each line in the text file:
	
	Tokens in text file is separated by #
	SM#Daffy#Duck#S913101#3.9#3000##  - SouthernStudentsMth example
    SH#Mickey#Mouse#S924111#2.9#12#35 - SouthernStudentHrly example
	1st Token:Employees are either SM - SouthernStudentsMth, SH - SouthernStudentHrly, otherwise throw an exception, include the message "Invalid Employee Type"
	2nd Token: First Name
	3rd Token: Last Name
	4th Token: Student ID
	5th Token: Student GPA
	6th Token: If this is a SouthernStudentsMth, then this token is for monthly pay amount. 
	           If this is a SouthernStudentsHrly, then this token is for hourly rate.
	7th Token: If this is a SouthernStudentsHrly, then this token is for hourly total hours worked.	
	           If this is a SouthernStudentsMth, then this token is for not used.
	If number of tokens is not exactly 7, throw an exception, include the message "Bad Record"
	
	Catch the exceptions, update the class field for each of the two exception messages outlined above
	Any IOExceptions should be handled by displaying the following message to the console "We had a problem locating the file" 
	*/
	//first check length make sure it is 7 if not then its a bad record 
	
	public void loadEmployeesFromFile(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while((line = reader.readLine()) !=null) {
				try {
				String[] info = line.split("#");
				
				if(info.length != 7 ) {
					this.badCount ++;
					throw new Exception ("Bad Record");
					
				}
				if (info[0].equals("SM")) {
					// create monthly employee
				SouthernStudentMth student = new SouthernStudentMth(info[1], info[2]);
				student.addId(info[3]);
				student.setGpa(Double.valueOf(info[4]));
				student.setMonthlyPay(Double.valueOf(info[5]));
				this.Roster.add(student);
				}
				
				else if (info[0].equals("SH")) {
					// create hourly employee
					SouthernStudentHrly student = new SouthernStudentHrly(info[1], info[2]);
					student.addId(info[3]);
					student.setGpa(Double.valueOf(info[4]));
					student.setHourlyRate(Double.valueOf(info[5]));
					student.setTotalHoursForWeek(Integer.valueOf(info[6].trim()));
					this.Roster.add(student);
				}else {
				if(!info[0].equals("SM")  || !info[0].equals("SH")) {
					this.invalidCount ++;
					throw new Exception ("Invalid Employee Type");
				}
				}
				}
				catch (Exception e) {
					System.out.println(e.getMessage());	
			}
		
			}	
		
		} catch (FileNotFoundException e) {
			System.out.println("We had a problem locating the file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("We had a problem locating the file");
		}
	//	catch (Exception e) {
		//	System.out.println(e.getMessage());
		
	}
	
	//Setter
	public void setRoster(LinkedList<Employee> roster) {
		this.Roster = roster;
		
		
	}

	//sum the pays of all employees
	public double computePayrollForAllEmployees() {
		double total = 0;
		for (int i = 0; i < this.Roster.size(); i++) {
			total += this.Roster.get(i).getPay();
		}
		
		return total;
	}
	/*
	 Writes to a text file <<filename>> handle exceptions in this method
	 This method uses the class field roster list, finds only the SouthernStudentsMth object and writes their info to a text file
	 Each line will have the toString info for one SouthernStudentsMonthly object
	 This method returns a count of how many employee objects were written to the file
	 
	 If the filename and path used belongs to an existing file, do not overwrite it. Instead display the following message to the console "Cannot overwrite an existing file!", then end the program. 
	 All other IOExceptions should be handled by displaying the following message to the console "We had a problem locating the file" 
	 */
	public int saveSouthernStudentsMonthlyOnly(String filename) {
		int counter = 0;
		try {
			File temp = new File(filename);
			if(temp.exists()) {
				throw new IOException("Cannot overwrite an existing file!");
				
				}
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			for(int i = 0; i < this.Roster.size();i++) {
				if(this.Roster.get(i) instanceof SouthernStudentMth) {
					bw.write(this.Roster.get(i).toString());
					bw.newLine();
					counter++;
					
				}	
			}
			bw.close();
			
		} catch (IOException e) {
			if(e.getMessage() != null ) {
				System.out.println(e.getMessage());
			}else 
				System.out.println("We had a problem locating the file");
				
			System.exit(1);
		}
		return counter;
	}

	//Getter
	public int getBadRecords() {
		return this.badCount;
	}
	//Getter
	public int getInvalidEmployeeType() {
		return this.invalidCount;
	}
	//Getter
	public LinkedList<Employee> getRoster() {
		return this.Roster;
	}
}
