package main.java.facility;


import java.util.Random;

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

	public Room() {
		this._id = random.nextInt(Integer.MAX_VALUE);
		this.beds = random.nextInt(4) + 1;
	}

    @Override
    public String toString() {
        return "Room [id=" + _id + ", numOfBeds=" + numOfBeds+ "]";
    }

	public boolean availability() {
		 return available;
	}

	public boolean checkIn(Integer customerId) {
		this.customerId = customerId;
		return available = false;
	}

	public boolean checkOut() {
		return available = true;
	}

}
