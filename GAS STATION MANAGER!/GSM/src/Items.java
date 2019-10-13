import java.io.File;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

public class Items
{
  private final String category;
  private final String name;
  private int count;
  private final double buyPrice;
  private double sellPrice;
  public final String[] itemsCategory = new String[] {"Beer", "Candy", "Food", "Drinks", "Snacks"};
  private ArrayList<Items> Items = new ArrayList<Items>();  
	
  // ***********************************************
  
  //  Constructor sets all the base Item information
  
  public Items(String name, String category, double buyPrice)
  {
  	this.category = category;
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
	return Items;
  } // end getItemsArry
  
  public String printInfo() 
  {
	String info = "Name: " + this.name + "\nCategory: " + this.category 
			  + "\nBuy Price: $" + this.buyPrice + "\nSell Price: $" + this.sellPrice + "\n";
	return info;
  }  // end getInfo
	
  public String getCategory()
  {
	return this.category;
  } // end getCategory
	
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
	  Items[] myPojo = mapper.readValue(new File("C:/Users/Ben/git/GasStationMgr/GAS STATION MANAGER!/GSM/Items.json"), Items[].class);
	  for(int i=0; i < myPojo.length; i++)
	  {
	  	Items.add(new Items(myPojo[i].getName(), myPojo[i].getCategory(), myPojo[i].getBuyPrice()));
	  }
	}
	catch(Exception e)
	{
	  System.out.println("ERROR");
	}
  } // end loadItems

  
  // ***********************************************
  
  //  Default way to load in Items
  
  public void loadItems() 
  {
	Items.add(new Items("Reese's", "Candy", 1));
	Items.add(new Items("Hershey", "Candy", 1));
	Items.add(new Items("Skittles", "Candy", 1));
	Items.add(new Items("Bud-Light", "Beer", 10));
	Items.add(new Items("Natural Light", "Beer", 7));
	Items.add(new Items("Boulevard",  "Beer", 12));
	System.out.println("Items Loaded");
  } // end loadItems
  
  public void printItemsInfo(ArrayList<Items> arrayList)
  {
	for(int i=0; i<arrayList.size(); i++)
	{
	  System.out.println(arrayList.get(i).printInfo());
	}
  }  // end printItemsInfo
  
  public void printCategories()
  {
	  for(int i=0; i<itemsCategory.length; i++)
	  {
		  System.out.println( (i+1) + ". " + itemsCategory[i] + " Items");
	  }
	  System.out.println("6. Main Menu");
  }
  
  public void searchItems(int userPick)
  {
	int j=1;
	  
	for(int i=0; i<Items.size(); i++)
	{
      if(Items.get(i).getCategory().equals(itemsCategory[userPick-1]))
	  {
	    System.out.println(j + ". " + Items.get(i).printInfo());
	    j++;
      }
	}
	System.out.println("Select a new category or return to main menu.");
  } // end SearchItems  
} // end Items

