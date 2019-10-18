import java.util.ArrayList;


public class Employee 
{
  private final String name;         // name of the Employee
  private int age;                   // age of Employee
  private double wage;               // Monthly Wage of Employee
  private String hireDate;              // Day that the employee gets hired
  private final int rating;          // Rating of Employee 0-5
  private String[] strength = {"Fast", "Friendly", "Happy"};
  private String[] weakness = {"Slow", "Mean", "Angry"};
	
  private static Cal calendar = new Cal();
  // Create an ArrayList of Possible Employees up for Hire
  private static ArrayList<Employee> EmployeesArry = new ArrayList<Employee>(); 
  
  // **********************************************************
	
  // Default Constructor
	
  public Employee()
  {
	this.name = "";
	this.age = 0;
	this.wage = 0;
	this.rating = 0;
  }
  
  // **********************************************************
	
  // Load in values to the EMployee object
  
  public Employee(String name, int age, double wage, int rating, String strengths, String weaknesses, String hireDay)
  {
	this.name = name;
	this.age = age;
	this.wage = wage;
	this.rating = rating;
	this.hireDate = hireDay;
  } // end constructor
	
  //*********************************************************
  
  // This method adds Employees objects to the Employees Array
	
  public void loadFiveEmployees()
  {
	for (int i=0; i<4; i++)
	{
		EmployeesArry.add(new Employee(combineName(), (int) (Math.random() * 45) + 18, 350, (int) (Math.random() * 4), 
			strength[(int) (Math.random() * strength.length)], weakness[(int) (Math.random() * weakness.length)], calendar.getDate()));
	}
  } // end loadEmployees
	
  // **********************************************************
  
  // Creates full name for employees
  
  private static String combineName()
  {
	  String[] firstName = {"Ben", "Brennan", "Katy", "Shean", "Calen", "Derek", "Dave"};
	  String[] lastName = {"Hodges", "Meyers", "Keeling", "Packer", "Flower", "Manning", "Maholmes"};
	  String fullName;	  
	  fullName = (firstName[(int) (Math.random() * firstName.length)] + 
			  " " + lastName[(int) (Math.random() * lastName.length)]);
	
	  return fullName;
  } //end combineName
  // **********************************************************
	
  // Returns a string of all the information about the Employee
	
  public String printInfo() 
  {
	return "Name: " + this.name + "\nAge: " + this.age 
	  + "\nWage: " + this.wage + "\nRating: " + this.rating + " star" 
	  +  "\nStrengths: " + "\nWeaknesses: " 
	  +  "\nDate of Hire: " + this.hireDate + "\n";
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
  
  public String getHireDate()
  {
	return this.hireDate;
  } // end getHireDate

  public int getRating()
  {
	return this.rating;
  } // end getRating
  
  public ArrayList<Employee> getEmployeeArry()
  {
	return EmployeesArry;
  } // end getEmployeeArry
  
  public void setWage(double wage)
  {
	this.wage = wage;
  } // end setWage
	
  public void setAge(int age)
  {
	this.age = age;
  } // end setAge

  public static String printEmployeeInfo()
  {
    String tempString = "";
	for(int i=0; i<EmployeesArry.size(); i++)
	{
	  tempString += i + ".\n" + EmployeesArry.get(i).printInfo() + "\n";
	}
	return tempString;
  } // end printEmployeeInfo
} // end Employee