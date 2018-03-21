import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	public void structureOfMenu()
	{
		EmployeeDiary newDiary = new EmployeeDiary();
		displayOptions();
		menu(newDiary);
	}
	
	/**
	 * prints out the menu choices
	 */
	public void displayOptions()
	{
		System.out.println();
		System.out.println("Please select one of the options below");
		System.out.println("1. Add entry");
		System.out.println("2. Delete entry");
		System.out.println("3. Entry entry");
		System.out.println("4. Delete last Entry");
		System.out.println("5. Print all employee entries");
		System.out.println("6. Save diary entries");
		System.out.println("7. Load diary entries from disk");
		System.out.println("8. Search for employee meetings");
		System.out.println("0. Exit");
	}
	
	
	
	/**
	 * This method asks the user for a choice and calls methods depending on their choice
	 * 
	 * @param newDiary instance of the employeeDiary class which is used to call the menu methods
	 */
	public void menu(EmployeeDiary newDiary)
	{
		boolean exit = false;
		

		do
		{
			try
			{
				System.out.println();
				
		
				Scanner s1 = new Scanner(System.in);
				System.out.println("Please enter a number: ");
				int choice = s1.nextInt();
				System.out.println();
				if (choice == 1)
				{
					System.out.println("ID of employee to add: ");
					int id = s1.nextInt();
					System.out.println("Name of employee to add: ");
					String name = s1.nextLine();
					
					newDiary.addEntry(id,name);
				}
				else if (choice == 2)
				{
					System.out.println("ID of employee to delete: ");
					int id = s1.nextInt();
					newDiary.deleteEntry(id);
				}
				else if (choice == 3)
				{
					newDiary.editAnEntry();
				}
				else if (choice == 4)
				{
					newDiary.deleteLastEntry();
				}
				else if (choice == 5)
				{
					newDiary.printAllEmployeeEntries();
				}
				else if (choice == 6)
				{
					newDiary.saveDiaryEntries();
				}
				else if (choice == 7)
				{
					newDiary.openFromDisk();
				}
				else if (choice == 8)
				{
					try
					{
						System.out.println("Enter employee name: ");
						String searchName = s1.nextLine();
						
						System.out.println("Enter a start date: (e.g. 15/03/2018)");
						String searchStartDate = s1.nextLine();
						
						System.out.println("Enter an end date: (e.g. 30/06/2018)");
						String searchEndDate = s1.nextLine();
						
						newDiary.searchEmployeeMeetings(searchName,searchStartDate,searchEndDate);
					}
					catch(Exception e)
					{
						System.out.println();
						System.out.println("Error: " + e);
					}
				}
				else if(choice==0)
				{
					System.exit(0);
				}
				else
				{
					System.out.print("Error, enter a number from 1 to 7");
				}
			}
			catch(Exception e)
			{
				System.out.println("Error: "+e);
				continue;
			}
		}
		while (exit == false);
	}

}
