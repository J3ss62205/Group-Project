package cs141.KaiDeckerAndJessicaHenry;
import java.util.*;

public class Main {
//	0: Create a Booking -----FIX ARRAY
//	1: Remove a Booking ---- FIX ARRAY
//	2: Update Rooms Information ---FIX ARRAY
//	3: Find Someone in the System ---- HELPPPPPPPPPPP
//	4: Check Availbity ----- DONE
//	5: Remove a Room -----FIX ARRAY
//	6: Add a Room ------- FIX ARRAY
//	7: Print Out All or Open Rooms ------------ NOT DONE
//	8: Quit ----------DONE

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int choice;
		int room;
		
		HotelManager hotel = new HotelManager();
		
		do {
			System.out.println("0: Create a Booking");
			System.out.println("1: Remove a Booking");
			System.out.println("2: Update Rooms Information");
			System.out.println("3: Find Someone in the System");
			System.out.println("4: Check Availbity");
			System.out.println("5: Remove a Room");
			System.out.println("6: Add a Room");
			System.out.println("7: Print Out All or Open Rooms");
			System.out.println("8: Quit");
			//This is the menu 
			
			choice = scnr.nextInt();
			
			switch(choice){
				case 0:
					System.out.println("Would you like a luxury or a regular room?");
					System.out.println("1: Regular");
					System.out.println("2: Luxury");
					room = scnr.nextInt();
					//The user will choose what room type they want 
					
					if (room == 1) {
						System.out.println("What is the name you'd like to book with: ");
						String name = scnr.nextLine();
						scnr.next();
						System.out.println("What is the number of people in your room: ");
						int people = scnr.nextInt();
						hotel.RegBook(name, people);
						//This calls the regular room method in the hotel manager 
					}
					else if (room == 2) {
						System.out.println("What is the name you'd like to book with: ");
						String name = scnr.nextLine();
						System.out.println("What is the number of people in your room: ");
						int people = scnr.nextInt();
						hotel.LuxBook(name, people);
						//This calls the luxury room method in the hotel manager 
					}
					break;
					
				case 1:
					System.out.println("Was your booking a luxury or a regular room?");
					System.out.println("1: Regular");
					System.out.println("2: Luxury");
					room = scnr.nextInt();
					//The user will choose what room type they booked with 
					
					if (room == 1) {
						System.out.println("What is the name you booked with: ");
						String name = scnr.nextLine();
						//This gets their name

						int index = hotel.getRegIndex(name);
						hotel.removeRegBook(index);
						//This calls the regular room method in the hotel manager and removes their booking
					}
					else if (room == 2) {
						System.out.println("What is the name you booked with: ");
						String name = scnr.nextLine();
						//This gets their name
						
						int index = hotel.getLuxIndex(name);
						hotel.removeLuxBook(index);
						//This calls the luxury room method in the hotel manager and removes their booking
					}
					break;
					
				case 2:
					System.out.println("Was your booking a luxury or a regular room?");
					System.out.println("1: Regular");
					System.out.println("2: Luxury");
					room = scnr.nextInt();
					
					if (room == 1) {
						System.out.println("What is the name you booked with: ");
						String name = scnr.nextLine();
						//This gets their name
						
						int index = hotel.getRegIndex(name);
						hotel.updateRegRoom(index);
					}
					else if (room == 2) {
						System.out.println("What is the name you booked with: ");
						String name = scnr.nextLine();
						//This gets their name
						
						int index = hotel.getLuxIndex(name);
						hotel.updateLuxRoom(index);
					}
					break;
					
				case 3:
					System.out.println("What is the name of the person you're looking for: ");
					String name = scnr.nextLine();
					
					hotel.findSomeone(name);
					
					break;
				case 4:
					hotel.checkAvailbity();
					//This prints out the available rooms
					break;
				case 5:
					System.out.println("Was your booking a luxury or a regular room?");
					System.out.println("1: Regular");
					System.out.println("2: Luxury");
					room = scnr.nextInt();
					
					if (room == 1) {
						System.out.println("What is the name under the booking: ");
						String name1 = scnr.nextLine();
						//This gets their name
						
						int index = hotel.getRegIndex(name1);
						hotel.removeRegRoom(index);
					}
					else if (room == 2) {
						System.out.println("What is the name under the booking: ");
						String name2 = scnr.nextLine();
						//This gets their name
						
						int index = hotel.getLuxIndex(name2);
						hotel.removeLuxRoom(index);
					}
					break;
					
				case 6:
					System.out.println("Would you like to add a luxury or a regular room?");
					System.out.println("1: Regular");
					System.out.println("2: Luxury");
					room = scnr.nextInt();
					
					if (room == 1) {						
						hotel.addRegRoom();
					}
					else if (room == 2) {
						hotel.addLuxRoom();
					}
					
					break;
				case 7:
					
					break;
			}
			
			
		} while (choice != 8);
	}

}
