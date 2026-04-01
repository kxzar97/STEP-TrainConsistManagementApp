import java.util.ArrayList;

abstract class Bogie {
    String id;

    public Bogie(String id) {
        this.id = id;
    }

    public abstract void displayDetails();
}

class PassengerBogie extends Bogie {
    String type;
    int capacity;

    public PassengerBogie(String id, String type, int capacity) {
        super(id);
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public void displayDetails() {
        System.out.println("Passenger Bogie [ID: " + id + ", Type: " + type + ", Capacity: " + capacity + "]");
    }
}

class GoodsBogie extends Bogie {
    String shape;
    String cargoType;
    boolean isSafe;

    public GoodsBogie(String id, String shape, String cargoType, boolean isSafe) {
        super(id);
        this.shape = shape;
        this.cargoType = cargoType;
        this.isSafe = isSafe;
    }

    @Override
    public void displayDetails() {
        System.out.println("Goods Bogie [ID: " + id + ", Shape: " + shape +
                ", Cargo: " + cargoType + ", Safe: " + isSafe + "]");
    }
}

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("====================================");

        // Initialize ArrayList
        ArrayList<Bogie> train = new ArrayList<>();

        System.out.println("\nTrain initialized successfully...");
        System.out.println("Initial Bogie Count: " + train.size());
        System.out.println("Current Train Consist: " + train);

        // Adding Passenger Bogies
        train.add(new PassengerBogie("P1", "Sleeper", 72));
        train.add(new PassengerBogie("P2", "AC Chair", 50));
        train.add(new PassengerBogie("P3", "First Class", 30));

        // Adding Goods Bogies
        train.add(new GoodsBogie("G1", "Rectangular", "Coal", true));
        train.add(new GoodsBogie("G2", "Cylindrical", "Oil", false));

        System.out.println("\nBogies added successfully...");
        System.out.println("Updated Bogie Count: " + train.size());

        // Display Train Consist
        System.out.println("\n--- Train Consist Details ---");
        for (Bogie b : train) {
            b.displayDetails();
        }

        // Summary
        int totalCapacity = 0;
        System.out.println("\n--- Summary ---");

        for (Bogie b : train) {
            if (b instanceof PassengerBogie) {
                totalCapacity += ((PassengerBogie) b).capacity;
            }
        }

        System.out.println("Total Passenger Capacity: " + totalCapacity);

        System.out.println("\nSystem ready for operations...");
    }
}