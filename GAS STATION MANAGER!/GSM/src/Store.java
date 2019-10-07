import java.util.ArrayList; // import the ArrayList class

public class Store 
{
  private String name;                   // name of the store
  private final int price;               // price to buy store
  private final String location;         // where store is located
  private static GSMGame game = new GSMGame();
  // Create an ArrayList of Current Employees at the Store
  private ArrayList<Employee> Employees = new ArrayList<Employee>();  
	
  // Create an ArrayList of Items in the Store
  private ArrayList<Items> Items = new ArrayList<Items>();  

  // ***********************************************
  
  //  Constructor sets all the base Store information
  
  public Store(String name, int price, String location)
  {
  	this.name = name;
  	this.price = price;
  	this.location = location;
  } // end constructor
  
  // ***********************************************
  
  // Returns a string of all the information about the Store
  
  public String printInfo() 
  {
  	return "Name: " + this.name + "\nPrice: " 
      + this.price + "\nLocation: " + this.location;
  } // end getInfo
  
  //*************************************************
  
  // Returns the name of the store
  
  public String getName() 
  {
    return this.name;
  } // end getName
  
  //**************************************************
	
  // Returns the Price of the store
	
  public int getPrice()
  {
    return this.price;
  } // end getPrice
	
  //**************************************************
	
  // Returns the Location of the store
	
  public String getLocation()
  {
	return this.location;
  } // end getLocation
	
  public ArrayList<Employee> getEmployeeArry()
  {
	return Employees;
  }
	
  public ArrayList<Items> getItemsArry()
  {
	return Items;
  }
	
  //**************************************************
	
  // Sets the Name That you want to Call your Gas Station
	
  public void setName(String name)
  {
    this.name = name;
  } // end setName

  public String printEmployeeInfo()
  {
	String tempString = "";
	for(int i=0; i<Employees.size(); i++)
	{
	  tempString += i + ".\n" + Employees.get(i).printInfo() + "\n";
	}
	return tempString;
  } // end printEmployeeInfo
	
  //**************************************************
	
	// Hires an employee from the list of employees
	// Puts it in the Employee Array List

  public void hireEmployee(Employee employee)
  {
    try
    {
	  String name = employee.getName();
	  int age =  employee.getAge();	
	  double wage =  employee.getWage();
	  int rating =  employee.getRating();
  	  String strength =  employee.getStrengths();
	  String weakness =  employee.getWeaknesses();
      int hireDay = game.getNumOfDays();
      
	  Employees.add(new Employee(name, age, wage, rating, strength, weakness, hireDay));
	  
	
	  System.out.println(name + " successfully added as a new Employee\n");
    }
    catch(Exception e)
    {
	  System.out.println("Try Again. Please select a valid Number\n");
    }
  }  // end hireEmployee
	
  public void fireEmployee(int userPick)
  {	
	name = Employees.get(userPick).getName();
	
	try
	{
	  Employees.remove(userPick);
	  System.out.println(name + " successfully fired as an Employee\n");
   	}
	catch(Exception e)
	{
	  System.out.println("Try Again. Please select a valid Number\n");
	}
  } // end fireEmployee
	
  // ***************************************************************
  
  //  Gives a Default raise of $50 dollars to the employee based on user pick
  
  public void giveEmployeeRaise(Employee employee)
  {
	try
	{
	  double curentWage = employee.getWage();
	  
	  employee.setWage(curentWage += 50);		
	  System.out.println("You succefully gave " + employee.getName() + " a $50 a month raise.\n");
	}
	catch(Exception e)
	{
	  System.out.println("Try Again. Please select a valid Number\n");
	}
  } // end giveEmployeeRaise

  public void reRollEmployees() 
  {
	
  } // end reRollEmployees
} // end Store