




import java.util.Scanner;

public class GSMGame 
{
	static int money = 50000;
	
	
  public static void main(String[] args) 
  {
  	Store [] stores = new Store[3];         // Array of possible Stores
  	Employee [] employee = new Employee[3]; // Array of possible Employees
  	
  	
  	
  	createStores(stores);
  	createEmployees(employee);
  	printInstructions();
  	
  	
  	listStores(stores);
	} // end main
  

  // ********************************************************************************************
  
  // Creates an array of Store objects and sets with the Employee.json file
  
  private static void createEmployees(Employee[] employee)
	{
		
  	
	}

  // ********************************************************************************************
  
  // Creates an array of Store objects and sets with the Store.json file
  
	private static void createStores(Store[] stores)
	{
    String name= "";
    int price = 0;
    String location= "";
    
  	for ( int i=0; i<stores.length; i++) 
  	{
  	   stores[i]=  new Store(name, price, location);
  	}
	}

  // ********************************************************************************************
  
  // Lists the information for each of the stores in the declared Stores array
	
	private static void listStores(Store[] stores)
	{
		for(int i=0; i<stores.length; i++)
		{
			System.out.println(i+1 + ": " + stores[i].getName());
		}
	} // end listStores

	//****************************************************************************************
  
  // This prints the opening instructions to the Gas Station Manager game
  
  private static void printInstructions()
	{
		System.out.println("Hello and Welcome to Gas Station Manager!");
		System.out.println("You've been hired as the new Manager for one of our 3 locations.");
		System.out.println("They each have a different price and location so choose wisely");
		System.out.println("You curently have $" + money);
	} // end printInstructions

}  // end GSMGame
