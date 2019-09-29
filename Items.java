import java.util.ArrayList;

public class Items
{
  private final String catagory;
  private final String name;
  private final double buyPrice;
  private double sellPrice;
  private final String[] itemsCatagory = new String[] {"Beer", "Candy", "Food", "Drinks", "Snacks"};
	private ArrayList<Items> Items = new ArrayList<Items>();  
  
  // ***********************************************
  
  //  Constructor sets all the base Item information
  
  public Items(String catagory, String name, double buyPrice)
  {
  	this.catagory = catagory;
  	this.name = name;
  	this.buyPrice = buyPrice;
  } // end constructor
  
  public void loadItems()
  {
		//	employee[i] =  new Employee
		 //      (String name, int age, double wage,String rating,String strengths,String weaknesses);
		Items.add(new Items("Snickers", "Candy", 3.5));
		Items.add(new Items("Pizza", "Food", 3));
		Items.add(new Items("Bud Light", "Beer", 15));
  }
  
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
} // end Items

