package foodtruckfinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import foodtruckfinder.model.FoodTruckDetails;
import foodtruckfinder.service.FoodTruckService;
import foodtruckfinder.service.FoodTruckServiceImpl;

public class FoodTruckFinder {

	public static void main(String[] args) {
		System.out.println("Loading available foodtrucks...!!");
		List<FoodTruckDetails> data = new ArrayList<>();
		try {
			FoodTruckService service = new FoodTruckServiceImpl();
			data = service.getCurrentFoodTrucks();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error fetching foodtrucks...please try again.");
			System.exit(1);
		}
		System.out.println("Loading completed..!! ");
		displayResults(data);
		System.out.println("Program terminated.");
	}
	
	private static void displayResults(List<FoodTruckDetails> data) {
		if (data.size() == 0) {
			System.out.println("No food trucks available now.");
			return;
		}
		System.out.printf("%-60s\t%s\n", "Name", "Address");
		
		int i = 0;
		Scanner sc = new Scanner(System.in); 
		while (i < data.size()) {
			FoodTruckDetails details = data.get(i++);
			System.out.printf("%-60s\t%s\n", details.getName(), details.getLocation());
			if (i % 10 == 0 && i < data.size()) {
				System.out.println("Press Enter key to view more foodtrucks...!!");
				sc.nextLine();
			}
		}
		sc.close();
	}

}
