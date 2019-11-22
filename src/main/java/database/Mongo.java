package main.java.database;

import java.net.UnknownHostException;
import java.util.List;
import java.util.ArrayList;

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


	public void mongoSetUp() {

		MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
		MongoClientOptions options = builder.connectionsPerHost(20).build();
		mongoClient = new MongoClient(new ServerAddress("localhost", 27017), options);
		database = mongoClient.getDatabase("HotelDB");
		empl = database.getCollection("Employee");
		room = database.getCollection("Room");
		client = database.getCollection("Client");
	}

	public void closeConnection() {
		mongoClient.close();
	}


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

	public void storeList(List<Object> list) {
		if (list.size() > 0) {
			String className;
			for (var obj: list) {
				storeItem(obj);
			}
		}
	}

	public void getList(String type) {
		if (type.equals("Employee")) {
			printList(empl.find(), type);
		} else if (type.equals("Room")) {
			printList(room.find(), type);
		} else if (type.equals("Customer")) {
			printList(client.find(), type);
		}
	}

	public void getList(String type, String query, String value) {
		if (type.equals("Employee")) {
			printList(empl.find(Filters.eq(query, value)), type);
		} else if (type.equals("Room")) {
			printList(room.find(Filters.eq(query, value)), type);
		} else if (type.equals("Customer")) {
			printList(client.find(Filters.eq(query, value)), type);
		}
	}

	public void getList(String type, String query, int value) {
		if (type.equals("Employee")) {
			printList(empl.find(Filters.eq(query, value)), type);
		} else if (type.equals("Room")) {
			printList(room.find(Filters.eq(query, value)), type);
		} else if (type.equals("Customer")) {
			printList(client.find(Filters.eq(query, value)), type);
		}
	}

	// public void getList(String type, String query_1, int value, String query_2, boolean b) {
	// 	if (type == "Employee") {
	// 		printList(empl.find(Filters.and(Filters.eq(query_1, value), Filters.eq(query_2, b)), type));
	// 	} else if (type == "Room") {
	// 		printList(room.find(Filters.and(Filters.eq(query_1, value), Filters.eq(query_2, b)), type));
	// 	} else if (type == "Customer") {
	// 		printList(client.find(Filters.and(Filters.eq(query_1, value), Filters.eq(query_2, b)), type));
	// 	}
	// }


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
