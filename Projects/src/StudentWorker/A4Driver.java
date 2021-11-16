package StudentWorker;

public class A4Driver {

	public static void main(String[] args) {
		EmployeeRoster er = new EmployeeRoster();
		er.loadEmployeesFromFile("empFile1.txt");
		System.out.println("Total emp added: "+er.getRoster().size()); // print number of employees uploaded from file
		System.out.println("Total bad records "+er.getBadRecords()); // print number of bad records identified during file upload
        System.out.println("Total Invalid Employee Type "+er.getInvalidEmployeeType());// print number of Invalid Employee Type identified during file upload
        for(int i=0; i<er.getRoster().size(); i++) { // Print all the employee objects details
        	System.out.println(er.getRoster().get(i));
        }
        
        System.out.println("Number of SouthernStudentsMth written "+er.saveSouthernStudentsMonthlyOnly("saveMth.txt")); //Print the count of objects written to text file
        System.out.println("Number of SouthernStudentsMth written "+er.saveSouthernStudentsMonthlyOnly("saveMth.txt")); //Should print -1 since the file already exist
	}

}
