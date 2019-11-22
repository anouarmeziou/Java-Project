package main.java.database;

import java.util.List;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.MongoClient;

import org.bson.Document;
import com.google.gson.Gson;

import main.java.employee.Employee;
import facility.Room;
import main.java.facility.Customer;


public class Mongo {

	private static MongoClient mongoClient;
	private static MongoDatabase database;
	private static MongoCollection<Document> empl;
	private static MongoCollection<Document> room;
	private static MongoCollection<Document> client;

	final Gson gson = new Gson();


	public void mongoSetUp() {

		mongoClient = new MongoClient();
		database = mongoClient.getDatabase("HotelDB");
		empl = database.getCollection("Employee");
		room = database.getCollection("Room");
		client = database.getCollection("Client");
	}

	public void storeList(List<Object> list) {
		String className = list.get(0).getClass().getSimpleName();
		for (var obj: list) {
			if (className == "Employee") {
				empl.insertOne(Document.parse(gson.toJson(obj)));
			} else if (className == "Room") {
				empl.insertOne(Document.parse(gson.toJson(obj)));
			} else if (className == "Customer") {
				empl.insertOne(Document.parse(gson.toJson(obj)));
			}
		}
	}

	public void storeItem(Object obj) {
		String className = obj.getClass().getSimpleName();
		if (className == "Employee") {
			empl.insertOne(Document.parse(gson.toJson(obj)));
		} else if (className == "Room") {
			empl.insertOne(Document.parse(gson.toJson(obj)));
		} else if (className == "Customer") {
			empl.insertOne(Document.parse(gson.toJson(obj)));
		}
	}

	public void getList(String type) {
		if (type == "Employee") {
			printList(empl.find(), type);
		} else if (type == "Room") {
			printList(room.find(), type);
		} else if (type == "Customer") {
			printList(client.find(), type);
		}
	}

	// public void getList(String type, Integer id) {
	// 	if (type == "Employee") {
	// 		printList(empl.find(id), type);
	// 	} else if (type == "Room") {
	// 		printList(room.find(id), type);
	// 	} else if (type == "Customer") {
	// 		printList(client.find(id), type);
	// 	}
	// }

	public void getList(String type, String query, String value) {
		if (type == "Employee") {
			printList(empl.find(Filters.eq(query, value)), type);
		} else if (type == "Room") {
			printList(room.find(Filters.eq(query, value)), type);
		} else if (type == "Customer") {
			printList(client.find(Filters.eq(query, value)), type);
		}
	}

	public void getList(String type, String query, Integer value) {
		if (type == "Employee") {
			printList(empl.find(Filters.eq(query, value)), type);
		} else if (type == "Room") {
			printList(room.find(Filters.eq(query, value)), type);
		} else if (type == "Customer") {
			printList(client.find(Filters.eq(query, value)), type);
		}
	}


	private void printList(FindIterable<Document> docs, String type) {
		for (Document doc: docs) {
			if (type == "Employee") {
				Employee obj = gson.fromJson(doc.toJson(), Employee.class);
				obj.toString();
			} else if (type == "Room") {
				Room obj = gson.fromJson(doc.toJson(), Room.class);
				obj.toString();
			} else if (type == "Customer") {
				Customer obj = gson.fromJson(doc.toJson(), Customer.class);
				obj.toString();
			}
		}
	}
}
