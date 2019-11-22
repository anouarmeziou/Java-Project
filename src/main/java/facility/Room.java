package facility;


import java.util.Random;

public class Room {

	Random random = new Random();


	/**
	 * Made it for testing DB
	 */
		
	public Integer _id;
	public Integer beds;
	public boolean available = true;
	public Integer customerId;

	public Room() {
		this._id = random.nextInt(Integer.MAX_VALUE);
		this.beds = random.nextInt(4) + 1;
	}

    @Override
    public String toString() {
        return "Room [id=" + _id + ", numOfBeds=" + beds+ "]";
    }


	public boolean availability() {
		 return available;
	}

	public boolean checkIn(main.java.facility.Customer customer) {
		customerId = customer.getId();
		return available = false;
	}

	public boolean checkOut() {
		return available = true;
	}
}
