import java.util.*;

public class Employee 
{
	double wage;
	String name;
	int age;
	String strengths;
	String weaknesses;
	
	// **********************************************************
	
	// Prints out all the information about the Employee
	
	public void getInfo() 
	{
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
		System.out.println("Wage: " + this.wage);
		System.out.println("Strengths: " + this.strengths);
		System.out.println("Weaknesses: " + this.weaknesses);
	}  // end getInfo
	
	public double getWage()
	{
		return this.wage;
	}
	
	
	
	public String getName()
	{
		return this.name;
	}
	
	public int age()
	{
		return this.age;
	}
	
	public String getStrengths()
	{
		return this.strengths;
	}
	
	public String getWeaknesses()

	{
		return this.weaknesses;
	}

	

}
