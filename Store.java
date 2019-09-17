import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class Store 
{
  String name;        // name of the store
  int price;          // price to buy store
  String location;    // where store is located
  int businessHours;  // When store is open
  
  public Store(String name2, int price2, String location2)
  {
  	this.name = name2;
  	this.price = price2;
  	this.location = location2;
  } // end constructor
  
  // ***********************************************
  
  // Prints all known Information about the Store
  
  public void getInfo() 
  {
  	
  }
  
  
  //*************************************************
  
  // Returns the name of the store
  
	public String getName() 
  {
	  return this.name;
  } // end getName
  
	//**************************************************
	
	// Returns the Price of the Store
	
	public int getPrice()
	{
		return this.price;
	}
	
	//**************************************************
	
	// Returns the BusinessHours of the Store
	
	public int getBusinessHours()
	{
	  return this.businessHours;	
	}
	
	//**************************************************
	
	// Returns the Location of the Store
	
	public String getLocation()
	{
		return this.location;
	}
	
	
	
  public void generateEmployees() 
  {
	  Employee Employee = new Employee();
	
    File file = new File("C:/Employees.json"); 
    Scanner sc = null;
	try 
	{
	  sc = new Scanner(file);
	} catch (FileNotFoundException e) 
	{
	  e.printStackTrace();
	} 
    while (sc.hasNextLine())
    {
      System.out.println(sc.nextLine()); 
    }
  } 

  public void generateProducts() 
  {
		
		
  }
}
