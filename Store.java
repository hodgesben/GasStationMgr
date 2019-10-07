import java.util.ArrayList; // import the ArrayList class

public class Store 
{
  private String name;                                        // name of the store
  private final int price;                                    // price to buy store
  private final String location;                              // where store is located
	public ArrayList<Employee> PossEmployees = new ArrayList<Employee>(); // Create an ArrayList object
	public ArrayList<Employee> CurEmployees = new ArrayList<Employee>(); // Create an ArrayList object

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
	}

	//*********************************************************
  
  // This method is the basic way to add to the Employees to the Employee Array
	
	public void createEmployees()
	{
		//	employee[i] =  new Employee
		 //      (String name, int age, double wage,String rating,String strengths,String weaknesses);
		PossEmployees.add(new Employee("Ben Packer", 24, 12.5, "3/5 Stars", "Fast", "Incosistant"));
		PossEmployees.add(new Employee("Rachel Flower", 24, 12.5, "3/5 Stars", "Slow", "Does great job"));
		PossEmployees.add(new Employee("Ben Packer", 24, 12.5, "4/5 Stars", "Fast", "Incosistant"));
		
	} // end createEmployees

	public String printEmployeeInfo(ArrayList<Employee> curEmployees)
	{
		String tempString = "";
		for(int i=0; i<curEmployees.size(); i++)
		{
			tempString += i + ".\n" + curEmployees.get(i).printInfo() + "\n";
		}
		return tempString;
		
	}

	public void hireEmployee(int userPick)
	{
		
		String name;
		int age;
		double wage;
		String rating;
		String strength;
		String weekness;
		
		name = PossEmployees.get(userPick).name;
		age = PossEmployees.get(userPick).age;
		
		wage = PossEmployees.get(userPick).wage;
		rating = PossEmployees.get(userPick).rating;
		strength = PossEmployees.get(userPick).strengths;
		weekness = PossEmployees.get(userPick).weaknesses;
		
		CurEmployees.add(new Employee(name, age, wage, rating, strength, weekness));
		PossEmployees.remove(userPick);
		
		System.out.println(name + " successfully added as a new Employee\n");
	}
	
	public void fireEmployee(int userPick)
	{
		
		String name;
		int age;
		double wage;
		String rating;
		String strength;
		String weekness;
		
		name = CurEmployees.get(userPick).name;
		age = CurEmployees.get(userPick).age;
		
		wage = CurEmployees.get(userPick).wage;
		rating = CurEmployees.get(userPick).rating;
		strength = CurEmployees.get(userPick).strengths;
		weekness = CurEmployees.get(userPick).weaknesses;
		
		PossEmployees.add(new Employee(name, age, wage, rating, strength, weekness));
		CurEmployees.remove(userPick);
		
		System.out.println(name + " successfully fired as an Employee\n");
	}
	
} // end Store
