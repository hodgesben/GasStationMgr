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
	private static int money = 10000;        // amount of money Person has
	private static Store store = new Store("QuickTrip", 20000, "DownTown"); // Initializing  store class
	private static Employee employee = new Employee();
	
	public static void main(String[] args) 
  {
    employee.loadEmployees();
  	printInstructions();
  	displayMainMenu();
	} // end main
	
	//*********************************************************
	
	// Prints the opening instructions For the Basics of the Game

  private static void printInstructions()
	{
		System.out.println("Hello and Welcome to Gas Station Manager!");
		System.out.println("You've been hired as the new Manager for one of our 3 locations.");
		System.out.println("They each have a different price and location so choose wisely");
		System.out.println("You curently have $" + money + "\n");
	} // end printInstructions
  
	//*********************************************************
  
  // Prints out the Main Menu options

	private static void displayMainMenu()
	{
		Scanner std = new Scanner(System.in);
		int userPick = -1; 
		System.out.println("MAIN MENU\n");
		System.out.println("Enter the number of your Choosing");
		System.out.println("--------------------------");
		System.out.println("1. Sell Items/Day Advance");
		System.out.println("2. Buy Inventory");
		System.out.println("3. Manage Employees");
		System.out.println("4. Quit Game");
		
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
  	} while (userPick != 4);
  	std.close();
	}
	
	//*********************************************************
  
  // Prints out the buy Items

	private static void buyItems()
	{
		System.out.println("Buy Items Menu");
		System.out.println("-----------------------------------");
		System.out.println("Candy Items");
		System.out.println("Soda Items");
		System.out.println("Food Items");
	}

	//*********************************************************
  
  // Prints out the Manage Employees Menu options
	// Takes in input to see what sub menu to go to

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
  
  // 

	private static void giveEmployeeRaise()
	{
		Scanner std = new Scanner(System.in);
		
		if(store.Employees.size() > 0)    // If there is employees available to fire
		{
			System.out.println("Give Employee Raise");
			System.out.println("-------------------------------------------");
			System.out.println("Select the Number of the Employee You wish to Give a raise\n");
	  	System.out.println(store.printEmployeeInfo(store.Employees));
	  	try
	  	{
				int userPick = std.nextInt();	
				store.giveEmployeeRaise(userPick, store.Employees);
	  	}
	  	catch(Exception e)
	  	{
	  		System.out.println("Enter a Valid  Number\n");
	  		giveEmployeeRaise();
	  	}
			manageEmployeesMenu();
	  	
		}
		else
		{
			System.out.println("You do not have any employees at this time\n");
			System.out.println("Press Enter To Continue");
			std.nextLine();
			manageEmployeesMenu();
		}
	} // end giveEmployeeRaise
	
	//*********************************************************
  
  // Prints the list of Current Employees 
	// Lets you pick from the list
	// Updates the Available/Current List of Employees 

	private static void fireEmployee()
	{
		Scanner std = new Scanner(System.in);
		
		if(store.Employees.size() > 0)    // If there is employees available to fire
		{
			System.out.println("Fire Emplyee");
			System.out.println("---------------------------------------------");
			System.out.println("Heres a list of Your Employees at " + store.getName());
			System.out.println("Select the Number of the Employee You wish to Fire\n");
			
	  	System.out.println(store.printEmployeeInfo(store.Employees));
	  	try
	  	{
				int userPick = std.nextInt();	
				store.fireEmployee(userPick, employee.employeeList);
	  	}
	  	catch(Exception e)
	  	{
	  		System.out.println("Enter a Valid  Number\n");
	  		fireEmployee();
	  	}
			manageEmployeesMenu();
		}
		else
		{
			System.out.println("You do not have any employees at this time\n");
			System.out.println("Press Enter To Continue");
			std.nextLine();
			manageEmployeesMenu();
		}
	}

	//*********************************************************
  
  // Prints the list of Available Employees 
	// Lets you pick from the list
	// Updates the Available/Current List of EMployees and takes out money accordingly 
	
	private static void hireEmployee()
	{
		Scanner std = new Scanner(System.in);
		
		if(employee.employeeList.size() > 0)    // If there is employees available to hire
		{
			System.out.println("Hire Employee");
			System.out.println("---------------------------------------------");
			System.out.println("Heres a list of possible Employees To Hire at " + store.getName());
			System.out.println("Select the Number of the Employee You wish to hire\n");
	  	System.out.println(store.printEmployeeInfo(employee.employeeList));
	  	try
	  	{
				int userPick = std.nextInt();	
				store.hireEmployee(userPick , employee.employeeList);
	  	}
	  	catch(Exception e)
	  	{
	  		System.out.println("Enter a Valid  Number\n");
	  		hireEmployee();
	  	}
			manageEmployeesMenu();
		}
		else
		{
			System.out.println("There are No Employees To Hire at this Time try again later\n");
			System.out.println("Press Enter To Continue");
			std.nextLine();
			manageEmployeesMenu();
		}
	} // end hireEMployee

	private static void goToNextDay()
	{
		dailySim();
		System.out.println("Yesturday's Information");
		System.out.println("---------------------------");
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
}  // end GSMGame
