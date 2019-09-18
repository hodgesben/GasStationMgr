/********************************
 * Gas Station Manager Game
 * 
 * 
 * 
 * 
 *******************************/

import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GSMGame 
{
	public static int money = 50000;
	
	
  public static void main(String[] args) 
  {
  	Store [] stores = new Store[3];         // Array of possible Stores
  	Employee [] employee = new Employee[3]; // Array of possible Employees
  	
  	createStores(stores);
  	createEmployees(employee);
  	
  	printInstructions();
  	
  	
  	listStoresInfo(stores);
  	listEmployeesInfo(employee);
	} // end main
  

  // ********************************************************************************************
  
  // Creates an array of Store objects and sets with the Employee.json file
  
  private static void createEmployees(Employee[] employee)
	{
  	String name = "";
  	int age = 0;
  	double wage = 0;
  	String rating = "";
  	String strengths = "";
  	String weaknesses = "";
    
  	for (int i=0; i<employee.length; i++) 
  	{
  		employee[i] =  new Employee(name, age, wage, rating, strengths, weaknesses);
  	}
  	
	}

  // ********************************************************************************************
  
  // Creates an array of Store objects and sets with the Store.json file
  
	private static void createStores(Store[] stores)
	{
    String name= "Hy-vee";
    int price = 10000;
    String location= "City";
    
  	for (int i=0; i<stores.length; i++) 
  	{
  	   stores[i] =  new Store(name, price, location);
  	}
	}

  // ********************************************************************************************
  
  // Lists the information for each of the Stores in the game
	
	private static void listStoresInfo(Store[] stores)
	{
		System.out.println("STORES");
		
		for(int i=0; i<stores.length; i++)
		{
			System.out.println(i+1 + ")\n" + stores[i].printInfo());
		}
	} // end listStoresInfo
	
	
  // ********************************************************************************************
  
  // Lists the information for each of the Stores in the game
	
	private static void listEmployeesInfo(Employee[] employee)
	{
		System.out.println("EMPLOYEES");
		
		for(int i=0; i<employee.length; i++)
		{
			System.out.println(i+1 + ")\n" + employee[i].printInfo());
		}
	} // end listEmployeesInfo

	//****************************************************************************************
  
  // This prints the opening instructions to the Gas Station Manager game
  
  private static void printInstructions()
	{
		System.out.println("Hello and Welcome to Gas Station Manager!");
		System.out.println("You've been hired as the new Manager for one of our 3 locations.");
		System.out.println("They each have a different price and location so choose wisely");
		System.out.println("You curently have $" + money + "\n");
	} // end printInstructions
}  // end GSMGame
