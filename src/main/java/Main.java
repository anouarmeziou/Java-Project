package main.java;

import java.io.IOException;
import java.net.ServerSocket;

import main.java.database.Mongo;
import main.java.employee.Employee;
import main.java.facility.Room;
import main.java.customer.Customer;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static final int PORT = 8008;


    final static Random random = new Random();
    final static Mongo mongo = new Mongo();

    public static void main(String[] args) {









        // try (ServerSocket s = new ServerSocket(PORT)) {
        //     System.out.println("Server started on port " + PORT);
        //     while (true) {

        //     }
        // } catch (IOException e) {
        //     System.out.println("Server failed on port " + PORT);
        // }   
        mongo.mongoSetUp();

        List<Object> list = new ArrayList<>();
        List<Object> empls = new ArrayList<>();
        List<Object> clients = new ArrayList<>();
        for (int i=0; i<5; i++) {
            list.add(new Room(random.nextInt(Integer.MAX_VALUE), i+1));
            //empls.add(new Employee(random.nextInt(Integer.MAX_VALUE), "Bob_"+i, "Ross_"+i, "Receptionist", i+1*100));
            list.add(new Customer(random.nextInt(Integer.MAX_VALUE), "Bill_"+i, "12345_"+i));
        }

        //mongo.storeList(list);
        //mongo.getList("Room");
        //mongo.getList("Customer");
        //mongo.getList("Room");
        mongo.getList("Room", "numOfBeds", 2);
        mongo.getList("Customer");

        mongo.closeConnection();
        
    


    }
}

