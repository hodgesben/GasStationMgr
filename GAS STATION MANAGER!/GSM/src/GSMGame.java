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
  private static Store store = new Store("QuickTrip", 20000, "DownTown"); // Initializing  store class
  private static Employee employee = new Employee();
  private static Items items = new Items();
  private static int numOfDays = 1;
	
  public static void main(String[] args) 
  {
	items.loadItemsJSON();
//	items.printItemsInfo(items.getItemsArry());
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
  } // end displayMainMenu
	
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
		
	if(store.getEmployeeArry().size() > 0)    // If there is employees available to fire
	{
	  System.out.println("Give Employee Raise");
	  System.out.println("-------------------------------------------");
	  System.out.println("Select the Number of the Employee You wish to Give a raise\n");
	  System.out.println("Or type -1 to return to Manage Employee Main Menu\n");
	  System.out.println(store.printEmployeeInfo(store.getEmployeeArry()));
	  try
	  {
		int userPick = std.nextInt();	
		if(userPick == -1)
		{
		  manageEmployeesMenu();
		}
		else
		{
		  store.giveEmployeeRaise(userPick, store.getEmployeeArry());
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
		
	if(store.getEmployeeArry().size() > 0)    // If there is employees available to fire
	{
	  System.out.println("Fire Emplyee");
	  System.out.println("---------------------------------------------");
	  System.out.println("Heres a list of Your Employees at " + store.getName());
	  System.out.println("Select the Number of the Employee You wish to Fire");
	  System.out.println("Or type -1 to return to Manage Employee Main Menu\n");
	  System.out.println(store.printEmployeeInfo(store.getEmployeeArry()));
	  
	  try
	  {
		int userPick = std.nextInt();
		if(userPick == -1)
		{
		  manageEmployeesMenu();
		}
		else
		{
		  store.fireEmployee(userPick, employee.getEmployeeArry());
		}
	  }
	  catch(Exception e)
	  {
	  	System.out.println("Enter a Valid  Number\n");
	  	fireEmployee();
	  }
	}
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
		
	if(employee.getEmployeeArry().size() > 0)    // If there is employees available to hire
	{
	  System.out.println("Hire Employee");
	  System.out.println("---------------------------------------------");
	  System.out.println("Heres a list of possible Employees To Hire at " + store.getName());
	  System.out.println("Select the Number of the Employee You wish to hire");
	  System.out.println("Or type -1 to return to Manage Employee Main Menu\n");
	  System.out.println(store.printEmployeeInfo(employee.getEmployeeArry()));
	  
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
		  store.hireEmployee(userPick , employee.getEmployeeArry());
		}
	  }
	  catch(Exception e)
	  {
	  	System.out.println("Enter a Valid  Number\n");
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
	dailySim();
	System.out.println("Yesturday's Information");
	System.out.println("---------------------------");
	printDailyInfo();
	displayMainMenu();
  }
  
  // *********************************************************************
  
  // Simulates a day at the Gas Station
	
  private static void dailySim()
  {
	numOfDays++;  // increment number of days
	int j;
	
	// Checks the array of employees to see if any need their monthly paycheck
	for(int i=0; i<store.getEmployeeArry().size(); i++)
	{
		j = (store.getEmployeeArry().get(i).getHireDate());
		System.out.println(j);
	  if(((numOfDays - store.getEmployeeArry().get(i).getHireDate()) % 30) == 0)
	  {
		money -= store.getEmployeeArry().get(i).getWage();	
	  }
	}
  } // end dailySim
  
  // **********************************************************************
  
  // Prints the information that happened that day.

  private static void printDailyInfo()
  {
	System.out.println("Current Money: $" + money);
	System.out.println("Current Day: " + numOfDays);
	System.out.println("Number of Items Sold: ");
  }
  
  public int getNumOfDays()
  {
	return numOfDays;
  }
}  // end GSMGame
