package StudentWorker;

public interface MonthlyEmployee extends Employee{

	//takes a dollar and cents amount for the month as an argument
	public void setMonthlyPay(double perMonth);

	//Returns the dollar and cents amount for the month
	public double getMonthlyPay();

}
