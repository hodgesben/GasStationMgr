import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cal 
{
	  private static Calendar cal = new GregorianCalendar();
	  private static int weekOfYearNum;
	  private static DateFormat dateFormatter = DateFormat.getDateInstance();    // Date
	  private static DateFormat timeFormatter = DateFormat.getTimeInstance();    // Time
	  
	  public Cal()
	  {
	    cal.getTime();
	    weekOfYearNum = cal.get(Calendar.WEEK_OF_YEAR);
	  }

	public String getDate() 
	{
	   return getDayOfWeek() + " " + dateFormatter.format(cal.getTime());
	}

	public void addDay()
	{
	  cal.add(Calendar.DATE, 1);
	}

	public int getDayOfMonth() 
	{
		return cal.get(Calendar.DATE);
	}

	public int getMonth() 
	{
		return cal.get(Calendar.MONTH);
	}

	public boolean checkIfSunday() 
	{
	  System.out.println("Sunday Checked");
	  return weekOfYearNum != cal.get(Calendar.WEEK_OF_YEAR);
	}

	public void incrementCurWeekOfYear() 
	{
	  System.out.println("Week Incamented");
	  weekOfYearNum++;
	}

	public int getEmployeeMonth(String employeeDateString) 
	{
		int employeeDate;
		employeeDateString = employeeDateString.substring(0, employeeDateString.indexOf(' '));
		  
		switch(employeeDateString)
		{
		  case "Jan":
			  employeeDate = 0;
			  break;
		  case "Feb":
			  employeeDate = 1;
			  break;
		  case "Mar":
			  employeeDate = 2;
			  break;
		  case "Apr":
			  employeeDate = 3;
			  break;
		  case "May":
			  employeeDate = 4;
			  break;
		  case "Jun":
			  employeeDate = 5;
			  break;
		  case "Jul":
			  employeeDate = 6;
			  break;
		  case "Aug":
			  employeeDate = 7;
		  case "Sep":
			  employeeDate = 8;
			  break;
		  case "Oct":
			  employeeDate = 9;
			  break;
		  case "Nov":
			  employeeDate = 10;
			  break;
		  case "Dec":
			  employeeDate = 11;
			  break;
		  default:
			  employeeDate = -1;
		}
		return employeeDate;
	  } // end getDayOfMonth

	public int getEmployeeDayOfMonth(String employeeDateString) 
	{
	  int spaceIndex = employeeDateString.indexOf(' ');
	  employeeDateString = employeeDateString.substring(spaceIndex + 1);
	  spaceIndex = employeeDateString.indexOf(' ');
	  int camaIndex = employeeDateString.indexOf(',');
	  employeeDateString  = employeeDateString.substring(spaceIndex + 1, camaIndex);
	  return Integer.parseInt(employeeDateString);
	}
	
	private String getDayOfWeek()
	{
	  String dayOfWeek;
		
	  switch(cal.get(Calendar.DAY_OF_WEEK))
	  {
		case 1:
		 dayOfWeek = "Sunday";
		 break;
		case 2:
			 dayOfWeek = "Monday";
			 break;
		case 3:
			 dayOfWeek = "Tuesday";
			 break;
		case 4:
			 dayOfWeek = "Wednesday";
			 break;
		case 5:
			 dayOfWeek = "Thursday";
			 break;
		case 6:
			 dayOfWeek = "Friday";
			 break;
		case 7:
			 dayOfWeek = "Saturday";
		break;
			default:
			dayOfWeek = "";
	  }
	  return dayOfWeek;
    } // end getDayOfWeek
  }


