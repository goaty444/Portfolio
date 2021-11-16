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
