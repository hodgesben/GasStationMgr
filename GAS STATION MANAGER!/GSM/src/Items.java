import java.io.File;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

public class Items
{
  private final String catagory;
  private final String name;
  private int count;
  private final double buyPrice;
  private double sellPrice;
  private final String[] itemsCatagory = new String[] {"Beer", "Candy", "Food", "Drinks", "Snacks"};
  private ArrayList<Items> Items = new ArrayList<Items>();  
	
  // ***********************************************
  
  //  Constructor sets all the base Item information
  
  public Items(String name, String catagory, double buyPrice)
  {
  	this.catagory = catagory;
  	this.name = name;
  	this.buyPrice = buyPrice;
  } // end constructor
	
  public Items()
  {
	catagory = "";
	name = "";
	buyPrice = 0;
	sellPrice = 0;
  } // end defualt constructor
  
  public ArrayList<Items> getItemsArry()
  {
	return Items;
  } // end getItemsArry
  
  public String printInfo() 
  {
	return "Name: " + this.name + "\nCatagory: " + this.catagory 
	  + "\nBuy Price: $" + this.buyPrice + "\nSell Price: $" + this.sellPrice + "\n";
  }  // end getInfo
	
  public String getCatagory()
  {
	return this.catagory;
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
	  Items[] myPojo = mapper.readValue(new File("C:/Users/Ben/git/GasStationMgr/GAS STATION MANAGER!/GSM/Items.json"), Items[].class);
	  for(int i=0; i < myPojo.length; i++)
	  {
	  	Items.add(new Items(myPojo[i].getName(), myPojo[i].getCatagory(), myPojo[i].getBuyPrice()));
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
  } // end loadItems
  
  public void printItemsInfo(ArrayList<Items> arrayList)
  {
	for(int i=0; i<arrayList.size(); i++)
	{
	  System.out.println(arrayList.get(i).printInfo());
	}
  }  // end printItemsInfo
} // end Items

