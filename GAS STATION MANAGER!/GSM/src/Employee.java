import java.util.ArrayList;

public class Employee 
{
  private final String name;         // name of the Employee
  private int age;                   // age of Employee
  private double wage;               // Monthly Wage of Employee
  private int hireDate;              // Day that the employee gets hired
  private final int rating;          // Rating of Employee 0-5
  private final String strengths;    // Strength of the Employee 
  private final String weaknesses;   // weakness of the Employee
	
  // Create an ArrayList of Possible Employees up for Hire
  private ArrayList<Employee> Employees = new ArrayList<Employee>(); 
  private static GSMGame game = new GSMGame();
  // **********************************************************
	
  // Default Constructor
	
  public Employee()
  {
	this.name = "";
	this.age = 0;
	this.wage = 0;
	this.rating = 0;
	this.strengths = "";
	this.weaknesses = "";
  }
	
  // **********************************************************
	
  // Load in values to the EMployee object
  
  public Employee(String name, int age, double wage, int rating, String strengths, String weaknesses, int hireDay)
  {
	this.name = name;
	this.age = age;
	this.wage = wage;
	this.rating = rating;
	this.strengths = strengths;
	this.weaknesses = weaknesses;
	this.hireDate = hireDay;
  } // end constructor
	
  //*********************************************************
  
  // This method adds Employees objects to the Employees Array
	
  public void loadEmployees()
  {
	Employees.add(new Employee("Ben Packer", 24, 350, 3, "Fast", "Incosistant", game.getNumOfDays()));
	Employees.add(new Employee("Rachel Flower", 24, 350, 3, "Slow", "Does great job", game.getNumOfDays()));
	Employees.add(new Employee("Ben Packer", 24, 400, 4, "Fast", "Incosistant", game.getNumOfDays()));	
  } // end loadEmployees
	
  // **********************************************************
	
  // Returns a string of all the information about the Employee
	
  public String printInfo() 
  {
	return "Name: " + this.name + "\nAge: " + this.age 
	  + "\nWage: " + this.wage + "\nRating: " + this.rating + " star" 
	  +  "\nStrengths: " + this.strengths + "\nWeaknesses: " 
	  + this.weaknesses + "\nDate of Hire: " + this.hireDate + "\n";
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
  
  public int getHireDate()
  {
	return this.hireDate;
  } // end getHireDate
	
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
