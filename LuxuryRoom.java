////
//	Name: Kai Decker
//	Class name: LuxuryRoom.
//
//	Description: The RegularRoom defines the class of luxury room used in the project.
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
public class LuxuryRoom {
	
Scanner scnr = new Scanner(System.in);

enum menu {
	name, occupant, all;
}

// Variables for use in project.
String Roomname; // name for the room
final String roomType = "Luxury"; // 
int occupants;
boolean booked = false;
int roomNum = 0;
static int numberOfRooms = 0;

public LuxuryRoom()
{
	numberOfRooms++;
}

public void createBooking(String name, int occ)
{
	// Set values for variables.
	this.Roomname = name;
	this.occupants = occ;
	booked = true;
}

public void removeBooking()
{
	// Set values for variables to empty.
	booked = false;
	Roomname = "";
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
	
	if (i == menu.name.ordinal())
	{
	 System.out.print("Enter the new name for the room: ");
	 this.Roomname = scnr.next();
	}
	else if (i == menu.occupant.ordinal())
	{
		System.out.print("Enter the new amount of occupants for the room: ");
		this.occupants = scnr.nextInt();
	}
	else if (i == menu.all.ordinal())
	{
		System.out.print("Enter the new amount of occupants for the room: ");
		this.occupants = scnr.nextInt();
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
public static void addRoom()
{
	numberOfRooms++;
}
public static void removeRoom()
{
	numberOfRooms--;
}
public static int getNumOfLuxuryRooms()
{
	return numberOfRooms;
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
	Roomname = name;
}
public void setOccupants(int occ)
{
	occupants = occ;
}
public String getName()
{
	return Roomname;
}
public int getOccupants()
{
	return occupants;
}
public void setRoomNumber(int num)
{
	roomNum = num;
}
public int getRoomNumber()
{
	return roomNum;
}
}
