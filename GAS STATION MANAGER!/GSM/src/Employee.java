import java.util.ArrayList;

public class Employee 
{
  private final String name;         // name of the Employee
  private int age;                   // age of Employee
  private double wage;               // Monthly Wage of Employee
  private final int rating;          // Rating of Employee 0-5
  private final String strengths;    // Strength of the Employee 
  private final String weaknesses;   // weakness of the Employee
	
  // Create an ArrayList of Possible Employees up for Hire
  private ArrayList<Employee> Employees = new ArrayList<Employee>(); 

	// **********************************************************
	
	// Constructor sets all the employee base information
	
	public Employee()
	{
		name = "";
		age = 0;
		wage = 0;
		rating = 0;
		strengths = "";
		weaknesses = "";
	}
	
	public Employee(String name, int age, double wage, int rating, String strengths, String weaknesses)
	{
		this.name = name;
		this.age = age;
		this.wage = wage;
		this.rating = rating;
		this.strengths = strengths;
		this.weaknesses = weaknesses;
	} // end constructor
	
	//*********************************************************
  
  // This method is the basic way to add to the Employees to the Employee Array
	
	public void loadEmployees()
	{
		//	employee[i] =  new Employee
		 //      (String name, int age, double wage,String rating,String strengths,String weaknesses);
		Employees.add(new Employee("Ben Packer", 24, 350, 3, "Fast", "Incosistant"));
		Employees.add(new Employee("Rachel Flower", 24, 350, 3, "Slow", "Does great job"));
		Employees.add(new Employee("Ben Packer", 24, 400, 4, "Fast", "Incosistant"));
		
	} // end loadEmployees
	
	// **********************************************************
	
	// Returns a string of all the information about the Employee
	
	public String printInfo() 
	{

		return "Name: " + this.name + "\nAge: " + this.age 
				+ "\nWage: " + this.wage + "\nRating: " + this.rating + " star" +
				"\nStrengths: " + this.strengths + "\nWeaknesses: " + 
				this.weaknesses + "\n";
	}  // end getInfo
	
	public double getWage()
	{
		return this.wage;
	} // end getWage
	
	public String getName()
	{
		return this.name;
	} // end getName
	
	public int getAge()
	{
		return this.age;
	} // end getAge
	
	public String getStrengths()
	{
		return this.strengths;
	} // end getStrengths
	
	public String getWeaknesses()
	{
		return this.weaknesses;
	} // end getWeaknesses
	
	public void setWage(double wage)
	{
		this.wage = wage;
	} // end setWage
	
  public void setAge(int age)
  {
	this.age = age;
  } // end setAge

  public int getRating()
  {
	return this.rating;
  }
  public ArrayList<Employee> getEmployeeArry()
  {
	return Employees;
  }
} // end Employee
