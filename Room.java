/**
 * 
 */
package cs141.KaiDeckerAndJessicaHenry;

/**
 * 
 */
public abstract class Room {
	
	abstract void createBooking(String name, int occ);
	abstract void removeBooking();
	abstract void updateRoom();
	abstract void print();
	abstract void printOpen();
	abstract boolean paid();
	abstract void removeRoom();

	
}
