import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class Store 
{
  String name;
  
  public Store(String name)
  {
	  this.name = name;
  }
  
  public static void main(String[] args) 
  {
	System.out.println("Hello Welcome To Gas Station Manager!");
	Scanner std = new Scanner(System.in);
	
	Store Store = new Store(std.nextLine());
	
	System.out.println(Store.getName());
	
    generateEmployees();
    generateProducts();
		
   std.close();

  }
  
  private String getName() 
  {
	return this.name;
	
  }

  private static void generateEmployees() 
  {
	Employee Employee = new Employee();
	
    File file = new File("C:\\Users\\Ben\\document.json"); 
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

  private static void generateProducts() 
  {
		
		
  }
}
