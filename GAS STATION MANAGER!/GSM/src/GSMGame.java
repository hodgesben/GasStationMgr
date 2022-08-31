/********************************
 * Gas Station Manager Game
 * 
 * 
 * 
 * 
 *******************************/

import java.util.Scanner;

public class GSMGame 
{
  private static int money = 10000;                                       // amount of Player has
  private static Store store = new Store("QuickTrip", 20000, "DownTown"); // Initializing store class
  private static Employee employee = new Employee();
  private static Items items = new Items();
  private static Cal calendar = new Cal();

  public static void main(String[] args) 
  {
	printInstructions();
    
	items.loadItemsJSON();
//	items.printItemsInfo();
    employee.loadFiveEmployees();
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
	System.out.println("Today's Date: " +  calendar.getDate());
	System.out.println("MAIN MENU\n");
	System.out.println("Enter the number of your Choosing");
	System.out.println("--------------------------");
	System.out.println("1. Sell Items/Day Advance");
	System.out.println("2. Manage Inventory");
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
		  manageItemsMenu();
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
  } // end displayMainMenu
	
  private static void manageItemsMenu() 
  {
	int userPick = -1;
	System.out.println("Manage Employees Menu");
	System.out.println("Enter the number of your Choosing");
	System.out.println("--------------------------");
	System.out.println("1. Buy Items");
	System.out.println("2. Veiw Current Items");
	System.out.println("3. Main Menu");
	System.out.println("--------------------------");
			
	  	do {
	  	  Scanner std = new Scanner(System.in);
	  		
	      userPick = std.nextInt();
	    	
		  switch(userPick)
		  {
		  	case 1:
		  	  buyItems();
		  	  break;
		  	case 2:
		  	  if(!store.getItemsArry().isEmpty())
		  	  {
			  	  System.out.println(store.printItemsInfo());
		  	  }
		  	  else
		  	  {
		  		System.out.println("You do not have any items at this time");
		  		System.out.println("Press Enter To Continue\n");
		  		std.nextLine();
		  		manageItemsMenu();
		  	  }
		  	  break;
		  	case 3:
			  displayMainMenu();
			  break;
		  	default:
		  	  System.out.println("Enter a valid Number and Try again");
		  }
	  	} while(userPick != 3);
  } // end manageItemsMenu

  //*********************************************************
  
  // Prints out the buy Items

  private static void buyItems()
  {
	
    Scanner std = new Scanner(System.in);
	int userPick = -1; 
	System.out.println("Buy Items Menu");
	System.out.println("-----------------------------------");
	items.printCategories();
	do {
	      userPick = std.nextInt();
		  switch(userPick)
		  {
		  	case 1: case 2: case 3: case 4: case 5:
		  	  items.searchItems(userPick);
		  	  break;
		  	case 6:
		  	  displayMainMenu();
		  	  break;
		  	default:
		  	  System.out.println("Enter a valid Number and Try again");
		  }
	  	} while (userPick != 6);
	  	std.close();
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
  
  // Gives a Default raise of $50 dollars to the employee

  private static void giveEmployeeRaise()
  {
	Scanner std = new Scanner(System.in);
		
	if(!store.getEmployeeArry().isEmpty())    // If there is employees available to fire
	{
	  System.out.println("Give Employee Raise");
	  System.out.println("-------------------------------------------");
	  System.out.println("Select the Number of the Employee You wish to Give a raise\n");
	  System.out.println("Or type -1 to return to Manage Employee Main Menu\n");
	  System.out.println(store.printEmployeeInfo());
	  try
	  {
		int userPick = std.nextInt();	
		if(userPick == -1)
		{
		  manageEmployeesMenu();
		}
		else
		{
		  store.giveEmployeeRaise(store.getEmployeeArry().get(userPick));
		}
	  }
	  catch(Exception e)
	  {
	  	System.out.println("Enter a Valid  Number\n");
	  	giveEmployeeRaise();
	  }
	  manageEmployeesMenu();
	  	
	} // end if
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
		
	if(!store.getEmployeeArry().isEmpty())    // If there is employees available to fire
	{
	  System.out.println("Fire Emplyee");
	  System.out.println("---------------------------------------------");
	  System.out.println("Heres a list of Your Employees at " + store.getName());
	  System.out.println("Select the Number of the Employee You wish to Fire");
	  System.out.println("Or type -1 to return to Manage Employee Main Menu\n");
	  System.out.println(store.printEmployeeInfo());
	  
	  try
	  {
		int userPick = std.nextInt();
		if(userPick == -1)
		{
		  manageEmployeesMenu();
		}
		else
		{
		  store.fireEmployee(userPick);
		}
	  }
	  catch(Exception e)
	  {
	  	System.out.println("Enter a Valid  Number\n");
	  	fireEmployee();
	  }
	} // end if
	else
	{
	  System.out.println("You do not have any employees at this time\n");
	  System.out.println("Press Enter To Continue");
	  std.nextLine();
	}
	manageEmployeesMenu();
  } // end fireEmployee

	//*********************************************************
  
    // Prints the list of Available Employees to Hire
	// Lets you pick from the list
	// Updates the Available/Current List of EMployees and takes out money accordingly 
	
  private static void hireEmployee()
  {
	Scanner std = new Scanner(System.in);
		
	if(!employee.getEmployeeArry().isEmpty())    // If there is employees available to hire
	{
	  System.out.println("Hire Employee");
	  System.out.println("---------------------------------------------");
	  System.out.println("Heres a list of possible Employees To Hire at " + store.getName());
	  System.out.println("Select the Number of the Employee You wish to hire");
	  System.out.println("Or type -1 to return to Manage Employee Main Menu\n");
	  System.out.println(Employee.printEmployeeInfo());
	  
	  try
	  {
		int userPick = std.nextInt();
		if(userPick == -1)
		{
		  manageEmployeesMenu();
		}
		else
		{
		  money -= employee.getEmployeeArry().get(userPick).getWage();
		  store.hireEmployee(employee.getEmployeeArry().get(userPick));
		  // removes it from employee array after adding it to the store array
		  employee.getEmployeeArry().remove(userPick);    
		}
	  }
	  catch(Exception e)
	  {
	  	System.out.println("Enter a Valid Entry\n");
	  	hireEmployee();
	  }
	  manageEmployeesMenu();
	} // end if
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
	if(store.getEmployeeArry().isEmpty())
	{
	  System.out.println("You need to hire an employee before continuing\n");
	}
//	else if(store.getItemsArry().isEmpty())
//	{
	//  System.out.println("You don't have any items in your store.");
	//  System.out.println("Go to the Buy Inventory menu to purchase some before going to the next day.");
//	}
	else
	{
	  System.out.println(calendar.getDate() + " Sales Information");
	  System.out.println("---------------------------");
	  dailySim();
      printDailyInfo();
	}
	displayMainMenu();
  } // end goToNextDay
  
  // *********************************************************************
  
  // Simulates a day at the Gas Station
	
  private static void dailySim()
  {
	calendar.addDay(); // increment number of days in the cal Class

	// Checks the array of employees to see if any need their monthly paycheck
	for(int i=0; i<store.getEmployeeArry().size(); i++)
	{
	  String employeeDateString = store.getEmployeeArry().get(i).getHireDate();
	  
	  if((calendar.getDayOfMonth() == calendar.getEmployeeDayOfMonth(employeeDateString))
		&& (calendar.getMonth() != calendar.getEmployeeMonth(employeeDateString)))
	 {
		money -= store.getEmployeeArry().get(i).getWage();	
     }
	}
	
	 // checks to see if its a new week
	 // swaps a new 5 employees out and in every Sunday
	if(calendar.checkIfSunday())   
	{
	  calendar.incrementCurWeekOfYear();
	  store.reRollEmployees();
	}
  } // end dailySim

// **********************************************************************
  
  // Prints the information that happened that day.

  private static void printDailyInfo()
  {
	System.out.println("Current Money: $" + money);
	System.out.println("Number of Items Sold: ");
	System.out.println("-----------------------");
	System.out.println("");
  }
}  // end GSMGame