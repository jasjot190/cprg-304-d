package models;

public class Refrigerator extends Appliance {
    private int doors;
    private double height;
    private double width;

    public Refrigerator(int itemNumber, String brand, int quantity, int wattage, String color, double price,int doors, double height, double width) {
    	super(itemNumber, brand, quantity, wattage, color,  price);
        this.doors = doors;
        this.height = height;
        this.width = width;
    }
    
    public int getDoors() { return doors; } public void setDoors(int doors) { this.doors = doors; }
    public double getHeight() { return height; } public void setHeight(double height) { this.height = height; }
    public double getWidth() { return width; } public void setWidth(double width) { this.width = width; }

    
    @Override
    public String toString() {
        return "ItemNumber: " + super.getItemNumber() + "\n" +
               "Brand: " + super.getBrand() + "\n" +
               "Quantity: " + super.getQuantity() + "\n" +
               "Wattage: " + super.getWattage() + "\n" +
               "Color: " + super.getColor() + "\n" +
               "Price: " + super.getPrice() + "\n" +
               "Doors: " + doors + "\n" +
               "Height: " + height + "\n" +
               "Width: " + width + "\n";
    }

    @Override
    public String formatForFile() {
        return super.toString() + ";" + doors + ";" + height + ";" + width;
    }
}
