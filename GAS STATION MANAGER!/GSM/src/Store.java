import java.util.ArrayList; // import the ArrayList class

public class Store 
{
  private String name;                   // name of the store
  private final int price;               // price to buy store
  private final String location;         // where store is located
	
	// Create an ArrayList of Current Employees at the Store
	public ArrayList<Employee> Employees = new ArrayList<Employee>();  
	
	// Create an ArrayList of Items in the Store
	public ArrayList<Items> Items = new ArrayList<Items>();  

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
	
	//**************************************************
	
	// Sets the Name That you want to Call your Gas Station
	
	public void setName(String name)
	{
		this.name = name;
	} // end setName

	public String printEmployeeInfo(ArrayList<Employee> curEmployees)
	{
		String tempString = "";
		for(int i=0; i<curEmployees.size(); i++)
		{
			tempString += i + ".\n" + curEmployees.get(i).printInfo() + "\n";
		}
		return tempString;
		
	} // end printEmployeeInfo
	
	//**************************************************
	
	// Hires an employee from the list of employees
	// Puts it in the Employee Array List

	public void hireEmployee(int userPick, ArrayList<Employee> employee)
	{
		String name;
		int age;
		double wage;
		int rating;
		String strength;
		String weakness;
		
		try
		{
			name = employee.get(userPick).getName();
			age =  employee.get(userPick).getAge();
			
			wage =  employee.get(userPick).getWage();
			rating =  employee.get(userPick).getRating();
			strength =  employee.get(userPick).getStrengths();
			weakness =  employee.get(userPick).getWeaknesses();
			
			Employees.add(new Employee(name, age, wage, rating, strength, weakness));
			employee.remove(userPick);
			
			System.out.println(name + " successfully added as a new Employee\n");
		}
		catch(Exception e)
		{
			System.out.println("Try Again. Please select a valid Number\n");
		}
	}
	
	public void fireEmployee(int userPick, ArrayList<Employee> employee)
	{	
		String name;
		int age;
		double wage;
		int rating;
		String strength;
		String weekness;
		
		try
		{
			name = Employees.get(userPick).getName();
			age = Employees.get(userPick).getAge();
			wage = Employees.get(userPick).getWage();
			rating = Employees.get(userPick).getRating();
			strength = Employees.get(userPick).getStrengths();
			weekness = Employees.get(userPick).getWeaknesses();
			
			employee.add(new Employee(name, age, wage, rating, strength, weekness));
			Employees.remove(userPick);
			System.out.println(name + " successfully fired as an Employee\n");
		}
		catch(Exception e)
		{
			System.out.println("Try Again. Please select a valid Number\n");
		}
	}

	public void giveEmployeeRaise(int userPick, ArrayList<Employee> employee)
	{
		try
		{
			double curentWage = employee.get(userPick).getWage();
			
			employee.get(userPick).setWage(curentWage += .5);
			
			System.out.println("You succefully gave " + employee.get(userPick).getName() + " a 50\u00A2 raise.\n");
		}
		catch(Exception e)
		{
			System.out.println("Try Again. Please select a valid Number\n");
		}
	} // end giveEmployeeRaise
} // end Store
