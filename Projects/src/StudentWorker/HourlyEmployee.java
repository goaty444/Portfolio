package StudentWorker;

public interface HourlyEmployee extends Employee{
	
	public final int MAX_WEEKLY_HOURS = 40;
	public final double OVERTIME_RATE = 1.50;
	
	//takes a dollar and cents amount for the hourly rate as an argument
	public void setHourlyRate(double perHour);
	
	//takes the number of hours worked for the week as an argument
	public void setTotalHoursForWeek(int hoursWorked);

	//returns the dollar and cents amount for the hourly rate
	public double getHourlyRate();
	
	//returns the number of hours worked for the week
	public int getTotalHoursForWeek();
}
