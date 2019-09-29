import java.util.ArrayList;

public class Employee 
{
	private final String name;
	private int age;
	private double wage;
	private final String rating;
	private final String strengths;
	private final String weaknesses;
	
	// Create an ArrayList of Possible Employees up for Hire
	public ArrayList<Employee> employeeList = new ArrayList<Employee>(); 

	// **********************************************************
	
	// Constructor sets all the employee base information
	
	public Employee()
	{
		name = "";
		age = 0;
		wage = 0;
		rating = "";
		strengths = "";
		weaknesses = "";
	}
	
	public Employee(String name, int age, double wage, String rating, String strengths, String weaknesses)
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
		employeeList.add(new Employee("Ben Packer", 24, 12.5, "3/5 Stars", "Fast", "Incosistant"));
		employeeList.add(new Employee("Rachel Flower", 24, 12.5, "3/5 Stars", "Slow", "Does great job"));
		employeeList.add(new Employee("Ben Packer", 24, 12.5, "4/5 Stars", "Fast", "Incosistant"));
		
	} // end loadEmployees
	
	// **********************************************************
	
	// Returns a string of all the information about the Employee
	
	public String printInfo() 
	{

		return "Name: " + this.name + "\nAge: " + this.age 
				+ "\nWage: " + this.wage + "\nRating:  " + this.rating +
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

	public String getRating()
	{
		return this.rating;
	}
} // end Emmployee
