package StudentWorker;

public class A3Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SouthernStudentMth ssm1 = new SouthernStudentMth("Bunny", "Bugs");
		ssm1.setGpa(3.0);
		ssm1.setMonthlyPay(1500);
		ssm1.addId("S923555");
		System.out.println(ssm1);
		
		System.out.println("------------------------------------------------------------------");
		
		SouthernStudentMth ssm2 = new SouthernStudentMth("Fudd", "Elmer");
		ssm2.setGpa(3.9);
		ssm2.setMonthlyPay(3000);
		ssm2.addId("S914555");
		System.out.println(ssm2);
		
		System.out.println("------------------------------------------------------------------");
		
		SouthernStudentHrly ssh1 = new SouthernStudentHrly("Duck", "Daffy");
		ssh1.setGpa(3.25);
		ssh1.setHourlyRate(15);
		ssh1.setTotalHoursForWeek(25);
		ssh1.addId("S924555");
		System.out.println(ssh1);
		
		System.out.println("------------------------------------------------------------------");
		
		SouthernStudentHrly ssh2 = new SouthernStudentHrly("Sam", "Yosemite");
		ssh2.setGpa(2.5);
		ssh2.setHourlyRate(18);
		ssh2.setTotalHoursForWeek(25);
		ssh2.addId("S913555");
		System.out.println(ssh2);
		
		System.out.println("------------------------------------------------------------------");
		
		EasternStudentHrly esh1 = new EasternStudentHrly("Pig", "Porky");
		esh1.setGpa(2.8);
		esh1.setHourlyRate(14);
		esh1.setTotalHoursForWeek(35);
		esh1.addId("A3F3");
		System.out.println(esh1);
		
		System.out.println("------------------------------------------------------------------");
		
		EasternStudentHrly esh2 = new EasternStudentHrly("Martian", "Martin");
		esh2.setGpa(3.75);
		esh2.setHourlyRate(25);
		esh2.setTotalHoursForWeek(15);
		esh2.addId("B5C1");
		System.out.println(esh2);
	



	}

}
