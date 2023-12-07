////
//	Name: Kai Decker
//	Class name: RegularRoom.
//
//	Description: The RegularRoom defines the class of regular room used in the project.
//
////
/**
 * 
 */
package cs141.KaiDeckerAndJessicaHenry;
import java.util.Scanner;

/**
 * 
 */
public class RegularRoom extends Room
{
	Scanner scnr = new Scanner(System.in);

	enum menu {
		name, occupant, all;
	}

	// Variables for use in project.
	String roomName; // name for the room
	final String roomType = "luxury"; // 
	int occupants = 0;
	boolean booked = false;
	static int numRooms = 0;
	boolean error = false;
	int roomNumber = 0;
	

	public RegularRoom()
	{
		roomName = "";
		occupants = 0;		
		numRooms++;
		roomNumber = numRooms;
	}

	public void createBooking(String name, int occ)
	{
		// Set values for variables.
		
		roomName = name;
		occupants = occ;
		error = false;
		booked = true;
	}

	public void removeBooking()
	{
		// Set values for variables to empty.
		booked = false;
		roomName = "";
		occupants = 0;
	}

	public void updateRoom()
	{
		// Menu for updating
		System.out.println("Action Menu");
		System.out.println("Enter 1 to update the room's name.");
		System.out.println("Enter 2 to update the room's number of occupants.");
		System.out.println("Enter 3 to update all of the room's information");
		
		int i = scnr.nextInt();
		
		if (i == menu.name.ordinal()+ 1)
		{
			try {
				System.out.print("Enter the new name for the room: ");
			roomName = scnr.next();
				error = false;
			}
			catch (Exception e)
			{
				error = true;
				System.out.println("\nThe name entered has incorrect values.\n");					
			}
		}
		else if (i == menu.occupant.ordinal() + 1)
		{ 
				
			try {
				System.out.print("Enter the new amount of occupants for the room: ");
				occupants = scnr.nextInt();
				error = false;
			}
			catch (Exception e)
			{
				error = true;
				System.out.println("\nThe number of occupants entered has incorrect values.\n");
			}
		}
		else if (i == menu.all.ordinal() + 1)
		{
			try {
				System.out.print("Enter the new name for the room: ");
				roomName = scnr.nextLine();
				error = false;
			}
			catch (Exception e)
			{
			error = true;
			System.out.println("\nThe name entered has incorrect values.\n");
			}
				
			
							
			try {
				occupants = scnr.nextInt();
				error = false;
				}
			catch (Exception e)
			{
				error = true;
				System.out.println("The number of occupants input has incorrect values.");
			}
		}
		
		
	}
	public boolean paid()
	{
		 System.out.print("Did the client pay: (Y/N)");
		 String pay = scnr.next();
		 while(!pay.equalsIgnoreCase("y") || !pay.equalsIgnoreCase("n"))
		 {
			 System.out.print("User input is not acceptable.\nRe-enter(Y/N): ");
			 pay = scnr.next();
		 }
		 try {
			 if (pay.equalsIgnoreCase("y"))
			 {
				 return true;
			 }
			 else if (pay.equalsIgnoreCase("n"))
			 {
				 return false;
			 }
			 else
			 {
				 System.out.println("The value input was incorrect.");
				 return false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println("Error. Incorrect data entered");
			 return false;
		 }
	}
	
	
	public void setAvailability(boolean bool)
	{
		booked = bool;
	}
	public boolean getAvailability()
	{
		return booked;
	}
	public void setName(String name)
	{
		try {
			roomName = name;
		}
		catch(Exception e)
		{
			System.out.println("\nThe value entered is incorrect.\n");
		}
	}
	public void setOccupants(int occ)
	{
		while(occ < 0)
		{
			System.out.println("Reenter the number of occupants you would wish to assign the room.");
			System.out.print("The room number must be positive: ");
			occ = scnr.nextInt();
		}
		occupants = occ;
	}
	public String getName()
	{
		return roomName;
	}
	public int getOccupants()
	{
		return occupants;
	}
	public void setRoomNumber(int num)
	{
		try {
			
		while(num < 0)
		{
			System.out.println("Re-enter the room number you would wish to assign the room.");
			System.out.print("The room number must be positive: ");
			num = scnr.nextInt();
		}
		roomNumber = num;
		}
		catch(Exception e)
		{
			System.out.println("\nThe value entered for the room number was incorrect.\n");
		}
	}
	public int getRoomNumber()
	{
		return roomNumber;
	} 
	public void print()
	{
		System.out.println("The name of the room is: " + roomName + '.');
		System.out.println("The room number is: " + roomNumber + '.');
		System.out.println("The number of occupants in the room is: " + occupants + '.');
	}
	
	public static void removeRoom() 
	{
		numRooms--;
	}
	public void printOpen()
	{
		if(roomName.equals(""))
		{
			System.out.println("\n***********************************");
			this.print();
			System.out.println("\n***********************************");
		}
	}
}
