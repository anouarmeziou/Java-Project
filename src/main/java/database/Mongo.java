package database;

import java.util.List;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.model.Filters;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import org.bson.Document;
import com.google.gson.Gson;

import main.java.employee.Employee;

import main.java.facility.Room;
import main.java.customer.Customer;



public class Mongo {

	private static MongoClient mongoClient;
	private static MongoDatabase database;
	private static MongoCollection<Document> empl;
	private static MongoCollection<Document> room;
	private static MongoCollection<Document> client;

	final Gson gson = new Gson();


	/**
	 * opens the connection for local mongoDB.
	 */
	public void mongoSetUp() {

		MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
		MongoClientOptions options = builder.connectionsPerHost(20).build();
		mongoClient = new MongoClient(new ServerAddress("localhost", 27017), options);
		database = mongoClient.getDatabase("HotelDB");
		empl = database.getCollection("Employee");
		room = database.getCollection("Room");
		client = database.getCollection("Client");
	}


	/**
	 * closes the connection for local mongoDB.
	 */
	public void closeConnection() {
		mongoClient.close();
	}

	/**
	 * Stores a single item in db
	 * @param obj object
	 */
	public void storeItem(Object obj) {
		if (obj != null) {
			String className = obj.getClass().getSimpleName();
			if (className.equals("Employee")) {
				empl.insertOne(Document.parse(gson.toJson(obj)));
			} else if (className.equals("Room")) {
				room.insertOne(Document.parse(gson.toJson(obj)));
			} else if (className.equals("Customer")) {
				client.insertOne(Document.parse(gson.toJson(obj)));
			}
		}
	}
	/**
	 * stores a list of objects
	 * @param list of objects
	 */
	public void storeList(List<Object> list) {
		if (list.size() > 0) {
			String className;
			for (var obj: list) {
				storeItem(obj);
			}
		}
	}
	/**
	 * prints out all data for a specific type
	 * @param type {employye, room, customer}
	 */
	public void getList(String type) {
		if (type.equals("Employee")) {
			printList(empl.find(), type);
		} else if (type.equals("Room")) {
			printList(room.find(), type);
		} else if (type.equals("Customer")) {
			printList(client.find(), type);
		}
	}

	/**
	 * prints out all data for a specific type
	 * @param type  {employye, room, customer}
	 * @param query one of the fields to be compared
	 * @param value comparable value of type String
	 */
	public void getList(String type, String query, String value) {
		if (type.equals("Employee")) {
			printList(empl.find(Filters.eq(query, value)), type);
		} else if (type.equals("Room")) {
			printList(room.find(Filters.eq(query, value)), type);
		} else if (type.equals("Customer")) {
			printList(client.find(Filters.eq(query, value)), type);
		}
	}


	/**
	 * prints out all data for a specific type
	 * @param type  {employye, room, customer}
	 * @param query one of the fields to be compared
	 * @param value comparable value of type int
	 */
	public void getList(String type, String query, int value) {
		if (type.equals("Employee")) {
			printList(empl.find(Filters.eq(query, value)), type);
		} else if (type.equals("Room")) {
			printList(room.find(Filters.eq(query, value)), type);
		} else if (type.equals("Customer")) {
			printList(client.find(Filters.eq(query, value)), type);
		}
	}


	/**
	 * calls toString for each object
	 * @param docs list of docs
	 * @param type {employye, room, customer}
	 */
	private void printList(FindIterable<Document> docs, String type) {
		for (Document doc: docs) {
			if (type.equals("Employee")) {
				Employee obj = gson.fromJson(doc.toJson(), Employee.class);
				obj.toString();
				System.out.println(obj.toString());
			} else if (type.equals("Room")) {
				Room obj = gson.fromJson(doc.toJson(), Room.class);
				obj.toString();
				System.out.println(obj.toString());
			} else if (type.equals("Customer")) {
				Customer obj = gson.fromJson(doc.toJson(), Customer.class);
				System.out.println(obj.toString());
			}
		}
	}
}
