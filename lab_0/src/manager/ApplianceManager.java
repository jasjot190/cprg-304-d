/*
 Author : Jasjot Singh and Jinsun yu
*/


package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import models.Appliance;
import models.Refrigerator;
import models.Dishwasher;
import models.Microwave;
import models.Vacuum;

public class ApplianceManager {
	private ArrayList<Appliance> list;
	private Scanner keyboard;
	public ApplianceManager() {
		list = new ArrayList<>();
		loadStudentsFromFile();
		Boolean run = true;
		while (run) {
			String uIpt = displayMenu();
			switch(uIpt) {
			case "1":
				checkOutAppliance();
				break;
			case "2":
				findApplianceByBrand();
				break;
			case "3":
				displayAppliancesByType();
				break;
			case "4":
				randomApplianceList();
				break;
			case "5":{
				saveAppliancesToFile();
				System.out.println("\n-----Thanks!-----\n");
				run=false;}
			}			
		}
	}

	private void randomApplianceList() {
		System.out.print("\nEnter number of appliances: ");
		int numberOfAppliances = keyboard.nextInt();
		System.out.println("\nRandom appliance list:\n");

		Random random = new Random();
		for (int i = 0; i < numberOfAppliances; i++) {
		    int randomIndex = random.nextInt(list.size()); 
		    Appliance randomAppliance = list.get(randomIndex);
		    System.out.println(randomAppliance);
		}

		
	}

	private void displayAppliancesByType() {
		String[] options = {"1", "2", "3", "4"};
		ArrayList<Appliance> filteredAppliances = new ArrayList<>();
		keyboard = new Scanner(System.in);
		System.out.println("\nAppliance Types" +
							"\n1 - Refrigerators" +
							"\n2 - Vacuums" +
							"\n3 - Microwaves" +
							"\n4 - Dishwashers\n"
							+ "\nEnter type of appliance: "
							);
		
		String typeInput = keyboard.nextLine();
		while (!Arrays.asList(options).contains(typeInput)) {
			System.out.println("\n*****INVALID INPUT*****\n");
			System.out.print("Enter option: ");
			typeInput = keyboard.nextLine();			
		}
		
		
		for (Appliance A : list) {
		    String itemNumber = Integer.toString(A.getItemNumber());                
		    String firstDigit = String.valueOf(itemNumber.charAt(0));

		    if (typeInput.equals("4")) {
		        if (firstDigit.equals("4") || firstDigit.equals("5")) {
		            filteredAppliances.add(A);
		        }
		    } else {
		        if (typeInput.equals(firstDigit)) {
		            filteredAppliances.add(A);
		        }
		    }
		}

		
		switch(typeInput) {
		case "1":
			System.out.print("\nEnter number of doors: 2 (double door), 3 (three doors) or 4 (four doors): ");
			int nDoors = keyboard.nextInt();
			System.out.println("\nMatching refrigerators:\n");
			for (Appliance A : filteredAppliances) {
			    if (A instanceof Refrigerator) {
			        Refrigerator fridge = (Refrigerator) A;
			        if (nDoors == fridge.getDoors()) {
			            System.out.println(fridge);
			        }
			    }
			}
			break;
			
		case "2":
			System.out.print("\nEnter battery voltage value. 18 V (low) or 24 V (high): ");
			int batteryVoltage = keyboard.nextInt();
			System.out.println("\nMatching vacuums:\n");

			for (Appliance A : filteredAppliances) {
			    if (A instanceof Vacuum) {
			        Vacuum vacuum = (Vacuum) A;
			        if (batteryVoltage == vacuum.getVoltage()) {
			            System.out.println(vacuum);
			        }
			    }
			}

			break;
			
			
			
		case "3":
			System.out.print("\nEnter room type where the microwave will be installed: K (kitchen) or W (work site): ");
			String roomType = keyboard.nextLine().toUpperCase();  // Ensure input is in uppercase
			System.out.println("\nMatching microwaves:\n");

			for (Appliance A : filteredAppliances) {
			    if (A instanceof Microwave) {
			        Microwave microwave = (Microwave) A;
			        if (roomType.equals(microwave.getRoomType())) {
			            System.out.println(microwave);
			        }
			    }
			}

			break;
			
		case "4":
			System.out.print("\nEnter the sound rating of the dishwasher: Qt (Quietest), Qr (Quieter), Qu (Quiet), or M (Moderate): ");
			String soundRating = keyboard.nextLine().toUpperCase();  // Ensure input is in uppercase
			System.out.println("\nMatching dishwashers:\n");

			for (Appliance A : filteredAppliances) {
			    if (A instanceof Dishwasher) {
			        Dishwasher dishwasher = (Dishwasher) A;
			        if (soundRating.equals(dishwasher.getSoundRating())) {
			            System.out.println(dishwasher);
			        }
			    }
			}
			break;
			
		}
		
		
	}

	private void findApplianceByBrand() {
		keyboard = new Scanner(System.in);
		System.out.print("\nFind appliances by brand: ");
		String brandInput = keyboard.nextLine();
		int found = 0;
		System.out.println("Matching Appliances:\n");
		for (Appliance A : list) {
			if (A.getBrand().equalsIgnoreCase(brandInput)) {
				found ++;
				System.out.println(A.toString());
			}
		}
		if (found==0){System.out.println("No appliances were found for this Brand : " + brandInput + "\n");}
		
		
	}

	private void checkOutAppliance() {
		keyboard = new Scanner(System.in);
    	System.out.print("\nEnter item number of an Appliance: ");
    	int user_input = keyboard.nextInt();
    	Boolean found = false;
    	for (Appliance A : list) {
    		if (user_input == A.getItemNumber()) {
    			System.out.println(A.checkout());
    			found = true;
    			break;
    			}
    		}
    	if (!found) {
    		System.out.println("\nNo appliances found with that item number.");
    	}
	}

	private String displayMenu() {
		keyboard = new Scanner(System.in);
		String[] options = {"1", "2", "3", "4", "5"};
		System.out.print("\n-----Welcome to Modern Appliances!-----\n\n"
				+ "How may we assist you? \r\n"
				+ "1 – Check out appliance \r\n"
				+ "2 – Find appliances by brand \r\n"
				+ "3 – Display appliances by type \r\n"
				+ "4 – Produce random appliance list \r\n"
				+ "5 – Save & exit \r\n\n"
				+ "Enter option: ");
		String user_ipt = keyboard.nextLine();
		while (!Arrays.asList(options).contains(user_ipt)) {
			System.out.println("\n*****INVALID INPUT*****\n");
			System.out.print("Enter option: ");
			user_ipt = keyboard.nextLine();
			
		}
		return user_ipt;
		
	}
	
	private void loadStudentsFromFile() {
		File file = new File("res/appliances.txt");
		try {
			Scanner input = new Scanner(file);
			while(input.hasNext()) {
				String line = input.nextLine();
				String[] fields = line.split(";");
				String itemNumber= fields[0];				
				char firstDigit = itemNumber.charAt(0);
				Appliance a = null;
				switch(firstDigit) {
				case '1':
					a = new Refrigerator(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), fields[4], Double.parseDouble(fields[5]), Integer.parseInt(fields[6]), Double.parseDouble(fields[7]), Double.parseDouble(fields[8]));
					break;
				case '2':
					a = new Vacuum(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), fields[4], Double.parseDouble(fields[5]), fields[6], Integer.parseInt(fields[7]));
					break;
				case '3':
					a = new Microwave(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), fields[4], Double.parseDouble(fields[5]), Double.parseDouble(fields[6]), fields[7]);
					break;
				case '4':
				case '5':
					a = new Dishwasher(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), fields[4], Double.parseDouble(fields[5]), fields[6], fields[7]);
					break;
				}
			list.add(a);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void saveAppliancesToFile() {
		File file = new File("res/appliances.txt"); 
        try (FileWriter writer = new FileWriter(file)) {
            for (Appliance appliance : list) {
               writer.write(appliance.formatForFile() + "\n");
            }
            System.out.println("Data has been saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
	}
}
