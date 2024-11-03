//Vehicle (Base Class)
public abstract class Vehicle {
    protected String brand;
    protected Engine engine;
 
    public Vehicle(String brand, Engine engine) {
       this.brand = brand;
       this.engine = engine;
    }
 
    public abstract void displayInfo();  
 
    public void startEngine() {
       System.out.println(brand + " engine starting: " + engine.getType());
    }
 }
 
 //Car (Derived Class)
 public class Car extends Vehicle {
    private int numDoors;
 
    public Car(String brand, Engine engine, int numDoors) {
       super(brand, engine);
       this.numDoors = numDoors;
    }
 
    @Override
    public void displayInfo() {
       System.out.println("Car: " + brand + ", Doors: " + numDoors);
    }
 }

 //Bike (Derived Class)
 public class Bike extends Vehicle {
    private boolean hasCarrier;
 
    public Bike(String brand, Engine engine, boolean hasCarrier) {
       super(brand, engine);
       this.hasCarrier = hasCarrier;
    }
 
    @Override
    public void displayInfo() {
       System.out.println("Bike: " + brand + ", Carrier: " + (hasCarrier ? "Yes" : "No"));
    }
 }

 //Engine (Composition Class)
 public class Engine {
    private String type;
 
    public Engine(String type) {
       this.type = type;
    }
 
    public String getType() {
       return type;
    }
 }

 //VehicleManagement (Main Class)
 import java.util.ArrayList;

public class VehicleManagement {
   public static void main(String[] args) {
      
      Engine petrolEngine = new Engine("Petrol");
      Engine electricEngine = new Engine("Electric");

      
      Car car1 = new Car("Tesla", electricEngine, 4);
      Car car2 = new Car("Toyota", petrolEngine, 5);
      Bike bike1 = new Bike("Yamaha", petrolEngine, false);
      Bike bike2 = new Bike("Harley", petrolEngine, true);

      
      ArrayList<Vehicle> vehicles = new ArrayList<>();
      vehicles.add(car1);
      vehicles.add(car2);
      vehicles.add(bike1);
      vehicles.add(bike2);

     
      for (Vehicle vehicle : vehicles) {
         vehicle.displayInfo();   
         vehicle.startEngine();   
         System.out.println();
      }
   }
}
