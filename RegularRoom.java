////
//	Name: Kai Decker
//	Class name: RegularRoom.
//
//	Description: The RegularRoom defines the class of regular room used in the project.
//	The class uses inheritance and error handling to provide a class that can be used in
//	the algorithm.
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

	// Enumeration so that these can be used to allow a more readable menu in the update method.
	enum menu {
		name, occupant, all;
	}

	// Variables for use in project.
	
	String roomName; // ClientsName for the room.
	final String roomType = "regular";
	int occupants = 0; // Number of people in room.
	boolean booked = false; // Store whether the room is booked or not.
	static int numRooms = 0; // Store the amount of rooms created.
	int roomNumber = 0; // Store the room number for the room.
	

	// Constructor
	
	public RegularRoom()
	{
	// assign values to the room upon creation
		
		roomName = "None"; // None means that there is no person in the room. 
		occupants = 0;		
		numRooms++;
		roomNumber = numRooms;
	}

	// Methods
	
	public void createBooking(String name, int occ)
	{
		// Set values for variables.
		
		roomName = name;
		occupants = occ;
		booked = true;
	}

	public void removeBooking()
	{
		// Set values for variables to empty.
		booked = false;
		roomName = "None";
		occupants = 0;
	}

	public void updateRoom()
	{
		// Menu for updating
		System.out.println("Action Menu");
		System.out.println("Enter 1 to update the room's name.");
		System.out.println("Enter 2 to update the room's number of occupants.");
		System.out.println("Enter 3 to update all of the room's information");
		
		// Take in the choice to be used in menu.
		int choice = scnr.nextInt();
		scnr.nextLine();
		
		if (choice == menu.name.ordinal()+ 1)
		{
			try {
				System.out.print("Enter the new name for the room: ");
			roomName = scnr.nextLine();
			System.out.println("");
			}
			catch (Exception e)
			{
				System.out.println("\nThe name entered has incorrect values.\n");
			}
		}
		else if (choice == menu.occupant.ordinal() + 1)
		{ 
				
			try {
				occupants = scnr.nextInt();
				scnr.nextLine();
				while(occupants < 0)
				{
					// While the number of occupants in the room is incorrect then get the data again.
					System.out.println("Reenter the number of occupants you would wish to assign the room.");
					System.out.print("The room number must be positive: ");
					occupants = scnr.nextInt();
					scnr.nextLine();
				}
			}
			catch(Exception e)
			{
				// If the input is incorrect tell the User.
				System.out.println("\nThe value entered for the room number was incorrect.\n");
			}
		}
		else if (choice == menu.all.ordinal() + 1)
		{
			// Try to set the new name of the room.
			try {
				occupants = scnr.nextInt();
				scnr.nextLine();
				while(occupants < 0)
				{
					// While the number of occupants in the room is incorrect then get the data again.
					System.out.println("Reenter the number of occupants you would wish to assign the room.");
					System.out.print("The room number must be positive: ");
					occupants = scnr.nextInt();
					scnr.nextLine();
				}
			}
			catch(Exception e)
			{
				// If the input is incorrect tell the User.
				System.out.println("\nThe value entered for the room number was incorrect.\n");
			}
			
			// Try to set the number of occupants in the room.
			try {
				occupants = scnr.nextInt();
				scnr.nextLine();
				System.out.println("");
				}
			catch (Exception e)
			{
				// If there is an error caught output 
				System.out.println("The number of occupants input has incorrect values.");
			}
		}
		
		
	}
	// Print the room's information.
	public void print()
	{
		// Display information about the room.
		System.out.println("\n***********************************");
		System.out.println("The name of the room is: " + roomName + '.');
		System.out.println("The section of the hotel is: " + roomType);
		System.out.println("The room number is: " + roomNumber + '.');
		System.out.println("The number of occupants in the room is: " + occupants + '.');
		System.out.println("\n***********************************");
	}
	// Print the room's information only if the name is "None" which signifies an open room. 
	public void printOpen()
	{
		if(this.booked == false)
		{
			this.print();
		}
	}

	// Setter/Getters
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
			// If the input is incorrect then tell the user.
			System.out.println("\nThe value entered is incorrect.\n");
		}
	}
	
	public void setOccupants(int occ)
	{
		try {
			while(occ < 0)
			{
				// While the number of occupants in the room is incorrect then get the data again.
				System.out.println("Reenter the number of occupants you would wish to assign the room.");
				System.out.print("The room number must be positive: ");
				occ = scnr.nextInt();
				scnr.nextLine();
			}
			occupants = occ;
		}
		catch(Exception e)
		{
			// If the input is incorrect tell the User.
			System.out.println("\nThe value entered for the room number was incorrect.\n");
		}
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
		// If a room number needs to be manually set try.
		try {
			// While the number given is negative have the user re-enter it.
		while(num < 0)
		{
			System.out.println("Re-enter the room number you would wish to assign the room.");
			System.out.print("The room number must be positive: ");
			num = scnr.nextInt();
			scnr.nextLine();
		}
		roomNumber = num;
		}
		catch(Exception e)
		{
			// If the input is incorrect tell the User.
			System.out.println("\nThe value entered for the room number was incorrect.\n");
		}
	
	}
	
	public String getRoomName()
	{
		return roomName;
	}
	
	public int getRoomNumber()
	{
		return roomNumber;
	} 
	
	public static void removeRoom() 
	{
		// Remove 1 from the total amount of rooms of this class available.
		numRooms--;
	}
	
}
