package models;

public class Microwave extends Appliance {
    private double capacity;
    private String roomType;

    // Constructor to initialize microwave-specific properties
    public Microwave(int itemNumber, String brand, int quantity, int wattage, String color, double price, double capacity, String roomType) {
    	super(itemNumber, brand, quantity, wattage, color,  price);
        this.capacity = capacity;
        this.roomType = roomType;
    }
    
    public double getCapacity() { return capacity; } 
    public void setCapacity(double capacity) { this.capacity = capacity; }
    public String getRoomType() { return roomType; } 
    public void setRoomType(String roomType) { this.roomType = roomType; }
    
    @Override
    public String toString() {
        return "Item Number: " + super.getItemNumber() + "\n" +
               "Brand: " + super.getBrand() + "\n" +
               "Quantity: " + super.getQuantity() + "\n" +
               "Wattage: " + super.getWattage() + " W\n" +
               "Color: " + super.getColor() + "\n" +
               "Price: $" + super.getPrice() + "\n" +
               "Capacity (cu ft): " + capacity + "\n" +
               "RoomType: " + (roomType.equals("K") ? "Kitchen" : "Work Site") + "\n";
    }

    
    @Override
    public String formatForFile() {
        return super.toString() + ";" + capacity + ";" + roomType;
    }
}
