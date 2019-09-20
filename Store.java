public class Store 
{
  String name;                       // name of the store
  private final int price;           // price to buy store
  private final String location;     // where store is located
  
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
} // end Store
