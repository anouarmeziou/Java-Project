package main.java.facility;


import java.util.Random;


/**
 * Room allows the receptionist to create a room.
 * He can check its availability, check-in and check-out a customer.
 */
public class Room {

	Random random = new Random();


	/**
	 * Made it for testing DB
	 */
		
	public Integer _id;
	public Integer numOfBeds;

	public Room(int id, Integer n) {
		this._id = id;
		this.numOfBeds = n;
	}

	public Integer beds;
	public boolean available = true;
	public Integer customerId;


	/**
	 * A constractor that creates a room with a random Id and random number of beds.
	 */
	public Room() {
		this._id = random.nextInt(Integer.MAX_VALUE);
		this.beds = random.nextInt(4) + 1;
	}

	/**
	 * @return a string that contains room's id and the number of beds
	 */
    @Override
    public String toString() {
        return "Room [id=" + _id + ", numOfBeds=" + numOfBeds+ "]";
    }


	/**
	 * @return the availability of the room
	 */
	public boolean availability() {
		 return available;
	}


	/**
	 * Check-in a client to a room and set the availability of the room to false
	 * @param customerId is usefull to save the customerId in the database
	 * @return the availability of the room to false
	 */
	public boolean checkIn(Integer customerId) {
		this.customerId = customerId;
		return available = false;
	}


	/**
	 * Check-in a client from the room and set the availability to true
	 * @return
	 */
	public boolean checkOut() {
		this.customerId = null;
		return available = true;
	}

}
