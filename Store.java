public class Store 
{
  String name;        // name of the store
  int price;          // price to buy store
  String location;    // where store is located
  int businessHours;  // When store is open
  
  public Store(String name, int price, String location)
  {
  	this.name = name;
  	this.price = price;
  	this.location = location;
  } // end constructor
  
  // ***********************************************
  
  // Prints all known Information about the Store
  
  public String printInfo() 
  {
  	return "Name: " + this.name + "\nPrice: " 
      + this.price + "\nLocation: " + this.location + "\n";
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
	
	// Returns the BusinessHours of the store
	
	public int getBusinessHours()
	{
	  return this.businessHours;	
	} // end getBusinessHours
	
	//**************************************************
	
	// Returns the Location of the store
	
	public String getLocation()
	{
		return this.location;
	} // end getLocation

} // end Store
