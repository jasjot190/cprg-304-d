package models;

//import java.util.Scanner;

public abstract class Appliance {
	private int itemNumber;
	private String brand;
	private int quantity;
	private int wattage;
    private String color;
    private double price;
//    private Scanner keyboard;
		
    public Appliance(int itemNumber, String brand, int quantity, int wattage, String color, double price) {
    	super();
    	this.itemNumber = itemNumber;
        this.brand = brand;
        this.quantity = quantity;
        this.wattage = wattage;
        this.color = color;
        this.price = price;
    }

    public int getItemNumber() { return itemNumber; }
    public String getBrand() { return brand; }
    public int getQuantity() { return quantity; }
    public int getWattage() { return wattage; }
    public String getColor() { return color; }
    public double getPrice() { return price; }
    
    public String checkout() {
    	String output = null;
    	if (quantity>0) {
    		this.quantity = quantity -1;
    		output = "\nAppliance "+ itemNumber +" has been checked out.";
    	}
    	else if(quantity == 0) {
    		output = "\nThe appliance is not available to be checked out.";
    	}
    	return output;
    	}
    		

    public abstract String formatForFile();
    
    @Override
    public String toString() {
        return itemNumber + ";" + brand + ";" + quantity + ";" + wattage + ";" + color + ";" + price;
    }
		
	

}
