public class Employee 
{
	String name;
	int age;
	double wage;
	String rating;
	String strengths;
	String weaknesses;
	
	// **********************************************************
	
	// Constructor sets all the employee base information
	
	public Employee(String name, int age, double wage, String rating, String strengths, String weaknesses)
	{
		this.name = name;
		this.age = age;
		this.wage = wage;
		this.rating = rating;
		this.strengths = strengths;
		this.weaknesses = weaknesses;
	} // end constructor

	
	// **********************************************************
	
	// Returns a string of all the information about the Employee
	
	public String printInfo() 
	{

		return "Name: " + this.name + "\nAge: " + this.age 
				+ "\nWage: " + this.wage + "\nRating:  " + this.rating +
				"\nStrengths: " + this.strengths + "\nWeaknesses: " + 
				this.weaknesses + "\n";
	}  // end getInfo
	
	public double getWage()
	{
		return this.wage;
	} // end getWage
	
	public String getName()
	{
		return this.name;
	} // end getName
	
	public int getAge()
	{
		return this.age;
	} // end getAge
	
	public String getStrengths()
	{
		return this.strengths;
	} // end getStrengths
	
	public String getWeaknesses()
	{
		return this.weaknesses;
	} // end getWeaknesses
	
	public void setWage(double wage)
	{
		this.wage = wage;
	} // end setWage
}
