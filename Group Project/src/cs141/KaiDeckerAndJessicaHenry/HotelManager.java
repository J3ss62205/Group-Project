package cs141.KaiDeckerAndJessicaHenry;
import java.util.*;

import cs141.jlhenry2.Employee;

public class HotelManager {
	
	ArrayList<RegularRoom> regular = new ArrayList<RegularRoom>();
	ArrayList<LuxuryRoom> luxury = new ArrayList<LuxuryRoom>();
	
	int num;
	int num1;
	
	public HotelManager() {
		
	}
	
	public void RegBook(String newName, int people) {
		regular.get(num).createBooking(newName, people);
		num++;
	}
	
	public void LuxBook(String newName, int people) {
		luxury.get(num1).createBooking(newName, people);
		num1++;
	}
	
	public void removeRegBook(int i) {
		regular.get(i).removeBooking();
		num--;
	}
	
	public void removeLuxBook(int i) {
		luxury.get(i).removeBooking();
		num1--;
	}
	
	public void updateRegRoom(int i) {
		regular.get(i).updateRoom();
	}
	
	public void updateLuxRoom(int i) {
		luxury.get(i).updateRoom();
	}
	
	public void findSomeoneInReg(int i) {
		regular.get(i).HHHHHHHHhh();
	}
	
	public void findSomeoneInLux(int i) {
		luxury.get(i).HHHHHHHHhh();
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
