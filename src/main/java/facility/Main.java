package facility;

import main.java.database.Mongo;

import java.util.Random;

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
//        mongo.mongoSetUp();
//
//        List<Room> rooms = new ArrayList<>();
//        List<Employee> empls = new ArrayList<>();
//        List<Customer> clients = new ArrayList<>();
//        for (int i=0; i<5; i++) {
//            rooms.add(new Room(random.nextInt(Integer.MAX_VALUE), i+1));
//            //empls.add(new Employee(random.nextInt(Integer.MAX_VALUE), "Bob_"+i, "Ross_"+i, "Receptionist", i+1*100));
//            clients.add(new Customer(random.nextInt(Integer.MAX_VALUE), "Bill_"+i, "12345_"+i));
//        }

    }
}

