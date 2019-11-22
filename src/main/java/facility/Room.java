package main.java.facility;

public class Room {


	/**
	 * Made it for testing DB
	 */
		
	public Integer _id;
	public Integer numOfBeds;

	public Room(int id, Integer n) {
		this._id = id;
		this.numOfBeds = n;
	}

    @Override
    public String toString() {
        return "Room [id=" + _id + ", numOfBeds=" + numOfBeds+ "]";
    }

}
