package cs141.KaiDeckerAndJessicaHenry;
import java.util.*;
// Name: Jessica Henry
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
		}
	
	}
	
	public void RegBook(String newName, int people) {
		regular.get(num).createBooking(newName, people);
		num++;
		regRoom--;
	}
	
	public void LuxBook(String newName, int people) {
		luxury.get(num1).createBooking(newName, people);
		num1++;
		luxRoom--;
	}
	
	public void removeRegBook(int i) {
		regular.get(i).removeBooking();
		num--;
		regRoom++;
	}
	
	public void removeLuxBook(int i) {
		luxury.get(i).removeBooking();
		num1--;
		luxRoom++;
	}
	
	public void updateRegRoom(int i) {
		regular.get(i).updateRoom();
	}
	
	public void updateLuxRoom(int i) {
		luxury.get(i).updateRoom();
	}
	
	public void findSomeone(String newName) {
		for (RegularRoom i : regular) {
			if (i.getName().equals(newName)){
				System.out.println();
				System.out.println(newName + " is section REGULAR and in the room number " + i);
				System.out.println();
				found = true;
			}
		}
		for (LuxuryRoom i : luxury) {
			if (i.getName().equals(newName)){
				System.out.println();
				System.out.println(newName +" is section LUXURY and in the room number " + i);
				System.out.println();
				found = true;
			}
		}
		if (found == false) {
			System.out.println();
			System.out.println("This person is not staying at our hotel");
			System.out.println();
		}
		found = false;
	}
	
	public void checkAvailbity() {
		System.out.println("There are " + regRoom + " available regular rooms");
		System.out.println("There are " + luxRoom + " available luxury rooms");
	}
	
	public void removeRegRoom(int x) {
		regular.remove(x);
		regular.removeRoom();
	}
	
	public void removeLuxRoom(int x) {
		luxury.remove(x);
		luxury.removeRoom();
	}
	
	public void addRegRoom() {
		regular.add(new RegularRoom());
		regRoom++;
	}
	
	public void addLuxRoom() {
		luxury.add(new LuxuryRoom());
		luxRoom++;
	}
	
	public void printOpen() {
		System.out.println("");
		System.out.println("The Following Are Open Regular Rooms: ");
		for (RegularRoom i : regular) {
			regular.printOpen();
		}
		System.out.println("");
		System.out.println("The Following Are Open Luxury Rooms: ");
		for (LuxuryRoom i : luxury) {
			luxury.printOpen();
		}
	}
	
	public void printAll() {
		System.out.println("");
		System.out.println("The Following Are Regular Rooms: ");
		for (RegularRoom i : regular) {
			regular.print();
		}
		System.out.println("");
		System.out.println("The Following Are Luxury Rooms: ");
		for (LuxuryRoom i : luxury) {
			luxury.print();
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
