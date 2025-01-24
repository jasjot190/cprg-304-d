package models;

public class Vacuum extends Appliance {
	private String grade;
    private int batteryVoltage;

    public Vacuum(int itemNumber, String brand, int quantity, int wattage, String color, double price, String grade, int batteryVoltage) {
    	super(itemNumber, brand, quantity, wattage, color,  price);
    	this.grade = grade;
        this.batteryVoltage = batteryVoltage;
    }
    
    public int getVoltage() { return batteryVoltage; } public void setVoltage(int voltage) { this.batteryVoltage = voltage; }
    public String getGrade() { return grade; } public void setGrade(String grade) { this.grade = grade; }

    
    @Override
    public String toString() {
        return "ItemNumber: " + super.getItemNumber() + "\n" +
               "Brand: " + super.getBrand() + "\n" +
               "Quantity: " + super.getQuantity() + "\n" +
               "Wattage: " + super.getWattage() + "\n" +
               "Color: " + super.getColor() + "\n" +
               "Price: $" + super.getPrice() + "\n" +
               "Grade: " + grade + "\n" +
               "BatteryVoltage: " + (batteryVoltage == 18 ? "Low" : "High") + "\n";
    }


    @Override
    public String formatForFile() {
        return super.toString() + ";" + batteryVoltage + ";" + grade;
    }
}
