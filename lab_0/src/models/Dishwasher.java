package models;

public class Dishwasher extends Appliance {
	private String feature;
	private String soundRating;

    public Dishwasher(int itemNumber, String brand, int quantity, int wattage, String color, double price, String feature, String soundRating) {
        super(itemNumber, brand, quantity, wattage, color,  price);
        this.feature = feature;
        this.soundRating = soundRating;
    }
    
    public String getSoundRating() { return soundRating; }  
    public void setSoundRating(String soundRating) { this.soundRating = soundRating; }

    
    @Override
    public String toString() {
        return "ItemNumber: " + super.getItemNumber() + "\n" +
               "Brand: " + super.getBrand() + "\n" +
               "Quantity: " + super.getQuantity() + "\n" +
               "Wattage: " + super.getWattage() + "\n" +
               "Color: " + super.getColor() + "\n" +
               "Price: " + super.getPrice() + "\n" +
               "Feature: " + feature + "\n" +
               "SoundRating: " + 
               (soundRating.equals("Qt") ? "Quietest" : 
               (soundRating.equals("Qr") ? "Quieter" : 
               (soundRating.equals("Qu") ? "Quiet" : "Moderate"))) + "\n";
    }


    @Override
    public String formatForFile() {
        return super.toString() + ";" + feature + ";" + soundRating;
    }
}
