import java.io.File;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

public class Items
{
  private final String catagory;
  private final String name;
  private final double buyPrice;
  private double sellPrice;
//  private final String[] itemsCatagory = new String[] {"Beer", "Candy", "Food", "Drinks", "Snacks"};
	private ArrayList<Items> Items = new ArrayList<Items>();  
	
  // ***********************************************
  
  //  Constructor sets all the base Item information
  
  public Items(String catagory, String name, double buyPrice)
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
	}
	
	public ArrayList<Items> getItemsArry()
	{
		return Items;
	}
  
	public String printInfo() 
	{
		return "Name: " + this.name + "\nCatagory: " + this.catagory 
				+ "\nBuy Price: $" + this.buyPrice + "\nSell Price:  $" + this.sellPrice + "\n";
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
	}
	
  // ***********************************************
  
  //  Loads All the Items In the JASON File
	
	public void loadItems()
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
	}

	public void printItemsInfo(ArrayList<Items> arrayList)
	{
		for(int i=0; i<arrayList.size(); i++)
		{
			System.out.println(arrayList.get(i).printInfo());
		}
	}
} // end Items

