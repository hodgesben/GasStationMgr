/********************************
 * Gas Station Manager Game
 * 
 * 
 * 
 * 
 *******************************/

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GSMGame 
{
	private static int money = 50000;        // amount of money Person has
	private static Store [] possStores = new Store[3];          // Array of current Stores
	private static Employee [] possEmployees = new Employee[3]; // Array of current Employees
	
	private static Store [] curStores = new Store[3];          // Array of possible Stores
	private static Employee [] curEmployees = new Employee[3]; // Array of possible Employees
	
	public static void main(String[] args) 
  {
		Scanner std = new Scanner(System.in);
		int userPick = -1; 

  	createStores(possStores);
  	createEmployees(possEmployees);
  	
  	printInstructions();
  	displayMainMenu();
  	
  	do {
    	userPick = std.nextInt();
	  	switch(userPick)
	  	{
	  		case 1:  // Advances to the next Day Sells Items
	  			goToNextDay();
	  			break;
	  		case 2:  // buyItemsMenu
	  			buyItems();
	  			break;
	  		case 3:  // Employee Menu
	  			manageEmployeesMenu();
	  			break;
	  		case 4:  // end game
	  			System.out.println("Thank you for playing!");
	  			break;
	  		default:
	  			System.out.println("Enter a valid Number and Try again");; 
	  	}
  	}while(userPick != 4);
  	
  	std.close();
	} // end main

	
	//*********************************************************
  
  // Prints out the buy Items

	private static void buyItems()
	{
		System.out.println("Buy Items Menu");
		System.out.println("----------------------------------------");
		System.out.println("Candy Items");
		System.out.println("Soda Items");
	}

	//*********************************************************
  
  // Prints out the Manage Employees Menu options

	private static void manageEmployeesMenu()
	{
		int userPick = -1;
		System.out.println("Manage Employees Menu");
		System.out.println("Enter the number of your Choosing");
		System.out.println("--------------------------");
		System.out.println("1. Hire Employee");
		System.out.println("2. Fire Employee");
		System.out.println("3. Give Raise");
		System.out.println("4. Main Menu");
		System.out.println("--------------------------");
		
  	do {
  		Scanner std = new Scanner(System.in);
  		
    	userPick = std.nextInt();
    	
	  	switch(userPick)
	  	{
	  		case 1:
	  			hireEmployee();
	  			break;
	  		case 2:
	  			fireEmployee();
	  			break;
	  		case 3:
	  			giveEmployeeRaise();
	  			break;
	  		case 4:
	  	  	displayMainMenu();
	  			break;
	  		default:
	  			System.out.println("Enter a valid Number and Try again");
	  	}
  	} while(userPick != 4);
	} // end manageEmplyeesMenu
	
	//*********************************************************
  
  // Prints out the Sell Items Menu options

	private static void giveEmployeeRaise()
	{
		System.out.println("Give Employee Raise");
		System.out.println("");
	}


	private static void fireEmployee()
	{
		System.out.println("Fire Emplyee");
		System.out.println("---------------------------------------------");
		System.out.println("Heres a list of possible Employees To Fire");
		System.out.println("Select the Number of the Employee You wish to Fire\n");
	//	 listEmployeesInfo(curEmployees);
			
	}

	//*********************************************************
  
  // Prints the list of Available Employees 
	// Lets you pick from the list
	// Updates the Available/Current List of EMployees and takes out money accordingly 
	
	private static void hireEmployee()
	{
		System.out.println("Hire Employee");
		System.out.println("---------------------------------------------");
		System.out.println("Heres a list of possible Employees To Hire");
		System.out.println("Select the Number of the Employee You wish to hire\n");
		
		
		// Prints the list of Available Employees 
		 listEmployeesInfo(possEmployees);
		 
	}

	private static void goToNextDay()
	{
		System.out.println("Yesturday's Information");
		System.out.println("---------------------------");
		dailySim();
		System.out.println(getDailyInfo());
		
		displayMainMenu();
	}
	
	private static void dailySim()
	{
		
	}


	private static String getDailyInfo()
	{
		return "";
	}

	//*********************************************************
  
  // Prints out the Main Menu options

	private static void displayMainMenu()
	{
		System.out.println("MAIN MENU\n");
		System.out.println("Enter the number of your Choosing");
		System.out.println("--------------------------");
		System.out.println("1. Sell Items/Day Advance");
		System.out.println("2. Buy Inventory");
		System.out.println("3. Manage Employees");
		System.out.println("4. Quit Game");
	}


	//*********************************************************
  
  // This method is the basic way to add to the stores to the stores Array
  
  private static void createStores(Store[] possStores)
  {
  	//  stores[i] =  new Store(String name, int price, String location);
  	possStores[0] =  new Store("QuickTrip", 20000, "DownTown");
  	possStores[1] =  new Store("Hy-Vee", 30000, "Suburbs");
  	possStores[2] =  new Store("Go-Mart", 15000, "Country");
	}

	//*********************************************************
  
  // This method is the basic way to add to the Employees to the Employee Array
  
  private static void createEmployees(Employee[] possEmployee)
  {
	//	employee[i] =  new Employee
 //      (String name, int age, double wage,String rating,String strengths,String weaknesses);
  	possEmployee[0] =  new Employee("Ben Packer", 24, 12.5, "3/5 Stars", "Fast", "Incosistant");
  	possEmployee[1] =  new Employee("Rachel Flower", 24, 12.5, "3/5 Stars", "Slow", "Does great job");
  	possEmployee[2] =  new Employee("Ben Packer", 24, 12.5, "4/5 Stars", "Fast", "Incosistant");
  }

  // ********************************************************************************************
  
  // Creates an array of Store objects and sets with the Employee.json file
  // DOSN'T WORK YET
  // DOSN'T WORK YET
  // DOSN'T WORK YET
  // DOSN'T WORK YET
  

  private static void createEmployeesJSON(Employee[] employee)
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
  // DOSN'T WORK YET
  // DOSN'T WORK YET
  // DOSN'T WORK YET
  
	@SuppressWarnings("unchecked")
	private static void createStoresJSON(Store[] stores)
	{
    JSONParser jsonParser = new JSONParser();
    
    try (FileReader reader = new FileReader("C:\\Stores.json"))
    {
        //Read JSON file
        Object obj = jsonParser.parse(reader);

        JSONArray storeList = (JSONArray) obj;
         
        //Iterate over employee array
        storeList.forEach(emp -> parseStoreObject( (JSONObject) emp, stores));
    }
	  catch (FileNotFoundException e) {e.printStackTrace(); } 
    catch (IOException e) {e.printStackTrace();}
    catch (ParseException e) {e.printStackTrace();}
    
	}

  // ********************************************************************************************
  
  // extracts each of the elements in the Stores.json file and returns 
	// them to be added to the each of the Store objects
  // DOSN'T WORK YET
  // DOSN'T WORK YET
  // DOSN'T WORK YET

	
  private static void parseStoreObject(JSONObject store, Store[] stores)
	{
  	String name;
  	String price;
  	String location;
  	
    //Get employee object within list
    JSONObject storeObject = (JSONObject) store.get("store");
     
    //Get store name
    name = (String) storeObject.get("name");   
     
    //Get store price
    price = (String) storeObject.get("price"); 
     
    //Get store location
    location = (String) storeObject.get("location");   
    
  	   stores[0] =  new Store(name, Integer.parseInt(price), location);
  	   stores[1] =  new Store(name, Integer.parseInt(price), location);
  	   stores[2] =  new Store(name, Integer.parseInt(price), location);
	} // end parseStoreObject


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
  
  // Lists the information for each of the Employees in the game
	
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
