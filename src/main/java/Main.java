package main.java;

import java.io.IOException;
import java.net.ServerSocket;

import main.java.database.Mongo;
import main.java.employee.Employee;
import main.java.employee.Admin;
import main.java.facility.Room;
import main.java.customer.Customer;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static final int PORT = 8008;

    public final static Mongo mongo = new Mongo();
    public final static Random random = new Random();



    public static void main(String[] args) {

        mongo.mongoSetUp();

        List<Object> list = new ArrayList<>();
        for (int i=0; i<5; i++) {
            list.add(new Room());
            list.add(new Employee("Bob_"+i, "Ross_"+i, "Receptionist"));
            list.add(new Customer(random.nextInt(Integer.MAX_VALUE), "Bill_"+i, "12345_"+i));
        }


        
        mongo.storeList(list);
        mongo.getList("Room");
        mongo.getList("Customer");
        mongo.getList("Employee");
        mongo.getList("Room", "numOfBeds", 2);

        mongo.closeConnection();
        
    


    }
}

