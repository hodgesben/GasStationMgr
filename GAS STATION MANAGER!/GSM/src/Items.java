import java.io.File;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

public class Items
{
  private final String category;                 // category of the item
  private final String name;                     // name of the item
  private int count;                             // how many of that specific items player has
  private final double buyPrice;                 // price that user will buy the item for
  private double sellPrice;                      // price that user is trying to sell item for
  private final String[] itemsCatagory = new String[] {"Beer", "Candy", "Food", "Drinks", "Snacks"};
  private ArrayList<Items> itemsArray = new ArrayList<Items>();  
	
  // ***********************************************
  
  //  Constructor sets all the base Item information
  
  public Items(String name, String catagory, double buyPrice)
  {
  	this.category = catagory;
  	this.name = name;
  	this.buyPrice = buyPrice;
  } // end constructor
	
  public Items()
  {
	category = "";
	name = "";
	buyPrice = 0;
	sellPrice = 0;
  } // end default constructor
  
  public ArrayList<Items> getItemsArry()
  {
	return itemsArray;
  } // end getItemsArry
  
  public String printInfo() 
  {
	return "Name: " + this.name + "\nCatagory: " + this.category 
	  + "\nBuy Price: $" + this.buyPrice + "\nSell Price: $" + this.sellPrice + "\n";
  }  // end getInfo
	
  public String getCatagory()
  {
	return this.category;
  } // end getCatagory
	
  public String getName()
  {
	return this.name;
  } // end getName
	
  public double getBuyPrice()
  {
	return this.buyPrice;
  } // end getPrice
	
  public void setSellPrice(double price)
  {
	this.sellPrice = price;
  } // end setSellPrice
	
  // ***********************************************
  
  //  Loads All the Items In the JASON File
	
  public void loadItemsJSON()
  {
	ObjectMapper mapper = new ObjectMapper();
	
	try 
	{
	  Items[] myPojo = mapper.readValue(
		new File("C:/Users/Ben/git/GasStationMgr/GAS STATION MANAGER!/GSM/Items.json"), Items[].class);
	  for(int i=0; i < myPojo.length; i++)
	  {
		itemsArray.add(new Items(myPojo[i].getName(), myPojo[i].getCatagory(), myPojo[i].getBuyPrice()));
	  }
	}
	catch(Exception e)
	{
	  System.out.println("ERROR Loading Items from JSON File");
	}
  } // end loadItems

  
  // ***********************************************
  
  //  Basic way to load in Items
  
  public void loadItems() 
  {
	itemsArray.add(new Items("Reese's", "Candy", 1));
	itemsArray.add(new Items("Hershey", "Candy", 1));
	itemsArray.add(new Items("Skittles", "Candy", 1));
	itemsArray.add(new Items("Bud-Light", "Beer", 10));
	itemsArray.add(new Items("Natural Light", "Beer", 7));
	itemsArray.add(new Items("Boulevard",  "Beer", 12));
  } // end loadItems
  
  public void printItemsInfo()
  {
	for(int i=0; i<itemsArray.size(); i++)
	{
	  System.out.println(itemsArray.get(i).printInfo());
	}
  }  // end printItemsInfo
} // end Items