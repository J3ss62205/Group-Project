/////
//	Name: Kai Decker
//	Class Name: Room
//
//	Description: This class is meant to use an abstract class to make a uniform model a room
//	that is meant to be expanded upon inside a subclass through the use of inheritance.
//
/////

/**
 * 
 */
package cs141.KaiDeckerAndJessicaHenry;

/**
 * 
 */
public abstract class Room {
	// Fill in room with information.
	abstract void createBooking(String name, int occ);
	// Fill in room with information stating it is empty.
	abstract void removeBooking();
	// Allow the room's information to be changed.
	abstract void updateRoom();
	// Output room information.
	abstract void print();
	// print information for open rooms only.
	abstract void printOpen();
}
