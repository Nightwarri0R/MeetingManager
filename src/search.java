import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeDiary {

	public EmployeeDiary() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		String name = "X";
		String start = "23/03/2018";
		String end = "28/06/2018";
		
		EmployeeDiary newDiary = new EmployeeDiary();
		newDiary.searchEmployeeMeetings(name, start, end);
		
	}
	
	public void searchEmployeeMeetings(String searchName, String searchStartDate, String searchEndDate)
	{
		MeetingManager manager = new MeetingManager();
		Date startDate = parseDate(searchStartDate);
		Date endDate = parseDate(searchEndDate);
		
		System.out.println("Start date: " + startDate);
		System.out.println("End date: " + endDate);
		System.out.println("For employee: " + searchName);
		//Employee = object
		//Diary = linked list node
		boolean validDate = startDate.before(endDate);
		if(validDate==true)
		{
			Employee employee = manager.search(searchName); //use search function in binary tree to look for employee
			if (employee == null) 
			{
				System.out.println("Error: Employee not found");
			}
			else
			{
				System.out.println("Showing available meetings for employee: " + employee.getName());
				System.out.println("Meeting \tDate \tTime \tDuration");
				Diary marker;
		    	marker = getTop();
		    	int counter=0;
		    	while (marker!=null)
		    	{
		    		if ((marker.getDate()).after(startDate)&&(marker.getDate()).before(endDate));//if the current diary date is in the correct range
		    		{
		    			System.out.println(marker.getMeeting() + "\t " + marker.getDate() + "\t " + marker.getTime + "\t " + marker.getDuration());
		    			counter++;
		    		}

		    		marker = marker.getNext();
		    	}
		    	if(counter==0)
		    	{
		    		System.out.println("No available meetings in entered date");
		    	}
			}
		}
		else
		{
			System.out.println("Error: inputted end date must be after start date");
		}
	}
	
	/**
	 * parses the dates from a string to a Date object
	 * 
	 * @param searchDate the date being parsed
	 * @return the parsed date
	 */
	public Date parseDate(String searchDate)
	{
		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.print(searchDate + " Parses as ");
		Date date = null;
		try {
			date = ft.parse(searchDate);
			System.out.println(date);
		}
		catch(Exception e)
		{
			System.out.println("Error: " + e);
		}
		return date;
	}

}
