package cs141.KaiDeckerAndJessicaHenry;
import java.util.*;
// Name: Jessica Henry
// Class: HotelManager
//
//Description: This will call methods from both the regular room and luxury room classes 
// and on top of that it can find someone and find the index of someone

public class HotelManager {

	Scanner scnr = new Scanner(System.in);

	ArrayList<RegularRoom> regular;
	ArrayList<LuxuryRoom> luxury;
	//These are our arrays
	
	int num;
	int num1;
	int regRoom;
	int luxRoom;
	int length;
	boolean found = false;
	//Variables yayyyyyyyyyy
	
	
	public HotelManager() {
		System.out.println("NAMES: JESSICA HENRY AND KAI DECKER");
		System.out.println("------------ Welcome to the Hotel Management System ------------ ");
		
		System.out.println("How many Regular Rooms does your hotel have?");
		regRoom = scnr.nextInt();
		//This gets the number of regular rooms at their hotel
		
		System.out.println("How many Luxury Rooms does your hotel have?");
		luxRoom = scnr.nextInt();
		//This gets the number of luxury rooms at their hotel
		
		length = regRoom + luxRoom;	
		
		regular = new ArrayList<RegularRoom>(regRoom);
		//regular.ensureCapacity(10);
		for(int i = 0; i < regRoom; i++)
		{
			regular.add(new RegularRoom());
		}
		luxury = new ArrayList<LuxuryRoom>(luxRoom);
		
		for(int i = 0; i < luxRoom; i++)
		{
			luxury.add(new LuxuryRoom());
		}//This will make it so the regular and luxury rooms get added in the array lists
	
	}
	
	public void RegBook(String newName, int people) {
		if(!(num >= regular.size())) {
			regular.get(num).createBooking(newName, people);
			num++;
			regRoom--;
		}
		else {
			System.out.println("The rooms are full and you can not make a booking");
			System.out.println();
		}
		
	}//This makes it so we can book regular rooms if there is enough rooms
	
	public void LuxBook(String newName, int people) {
		if(!(num1 >= luxury.size())) {
			luxury.get(num1).createBooking(newName, people);
			num1++;
			luxRoom--;
		}
		else {
			System.out.println("The rooms are full and you can not make a booking");
			System.out.println();
		}
	}//This makes it so we can book luxury rooms if there is enough rooms
	
	public void removeRegBook(int i) {
		regular.get(i).removeBooking();
		num--;
		regRoom++;
	}//This makes it so we can remove bookings of regular rooms
	
	public void removeLuxBook(int i) {
		luxury.get(i).removeBooking();
		num1--;
		luxRoom++;
	}//This makes it so we can remove bookings of luxury rooms
	
	public void updateRegRoom(int i) {
		regular.get(i).updateRoom();
	}//This makes it so we can update regular rooms information
	
	public void updateLuxRoom(int i) {
		luxury.get(i).updateRoom();
	}//This makes it so we can update luxury rooms information 
	
	public void findSomeone(String newName) {
		for (RegularRoom i : regular) {
			if (i.getName().equals(newName)){
				System.out.println("");
				System.out.println("This person is section REGULAR");
				System.out.println("");
				//If they are found within the first array then it will tell you the persons 
				//section and set found to true
				found = true;
			}
		}
		for (LuxuryRoom i : luxury) {
			if (i.getName().equals(newName)){
				System.out.println("");
				System.out.println("This person is section LUXURY");
				System.out.println("");
				//If they are found within the second array then it will tell you the persons 
				//section and set found to true
				found = true;
			}
		}
		if (found == false) {
			System.out.println();
			System.out.println("This person is not staying at our hotel");
			System.out.println();
			//If they are not found it will tell you that they aren't staying here
		}
		found = false;
		//after all of that we set found to false again
	}
	
	public void checkAvailbity() {
		System.out.println("*************************************************");
		System.out.println("There are " + regRoom + " available regular rooms");
		System.out.println("There are " + luxRoom + " available luxury rooms");
		System.out.println("*************************************************");
		//This will tell you the avaiable rooms
	}
	
	public void removeRegRoom() {
		regular.remove(regRoom);
		RegularRoom.removeRoom();
		regRoom--;
	}//This will remove a room for the regular array list
	
	public void removeLuxRoom() {
		luxury.remove(luxRoom);
		LuxuryRoom.removeRoom();
		luxRoom--;
	}//This will remove a room for the luxury array list
	
	public void addRegRoom() {
		regular.add(new RegularRoom());
		regRoom++;
	}//This will add a regular room to the array list
	
	public void addLuxRoom() {
		luxury.add(new LuxuryRoom());
		luxRoom++;
	}//This will add a luxury room to the array list
	
	public void printOpen() {
		System.out.println("");
		System.out.println("The Following Are Open Regular Rooms: ");
		for (RegularRoom i : regular) { //the loop makes it so that it goes though the whole list
			i.printOpen();
			//This calls the print open method from the regular room 
		}
		System.out.println("");
		System.out.println("The Following Are Open Luxury Rooms: ");
		for (LuxuryRoom i : luxury) { //the loop makes it so that it goes though the whole list
			i.printOpen();
			//this calls the print open method from the luxury room
		}
	}
	
	public void printAll() {
		System.out.println("");
		System.out.println("The Following Are Regular Rooms: ");
		for (RegularRoom i : regular) { //the loop makes it so that it goes though the whole list
			i.print();
		}
		System.out.println("");
		System.out.println("The Following Are Luxury Rooms: ");
		for (LuxuryRoom i : luxury) { //the loop makes it so that it goes though the whole list
			i.print();
		}
		//This will call the print methods for both types of rooms and print them!
	}
	
	public int getRegIndex(String newName) { 
		for (RegularRoom i : regular) {
			if (i.getName().equals(newName)){
				return regular.indexOf(i);
			}
		}
		//This gets the index of a person for a regular room
		return 0;
	}
	
	public int getLuxIndex(String newName) { 
		for (LuxuryRoom i : luxury) {
			if (i.getName().equals(newName)){
				return luxury.indexOf(i);
			}
		}
		//This gets the index of a person for a luxury room
		return 0;
	}
}
