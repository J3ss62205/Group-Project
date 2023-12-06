package cs141.KaiDeckerAndJessicaHenry;
import java.util.*;

public class HotelManager {

	Scanner scnr = new Scanner(System.in);

	ArrayList<RegularRoom> regular = new ArrayList<RegularRoom>();
	ArrayList<LuxuryRoom> luxury = new ArrayList<LuxuryRoom>();
	
	int num;
	int num1;
	int regRoom;
	int luxRoom;
	int length;
	
	
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
		getRegIndex(newName);
		getLuxIndex(newName);
	}//THIS NEEDS TO BE DONE
	
	public void checkAvailbity() {
		System.out.println("There are " + regRoom + " available regular rooms");
		System.out.println("There are " + luxRoom + " available luxury rooms");
	}
	
	public void removeRegRoom(int x) {
		regular.remove(x);
	}
	
	public void removeLuxRoom(int x) {
		luxury.remove(x);
	}
	
	public void addRegRoom() {
		regular.add(new RegularRoom());
		regRoom++;
	}
	
	public void addLuxRoom() {
		luxury.add(new LuxuryRoom());
		luxRoom++;
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
