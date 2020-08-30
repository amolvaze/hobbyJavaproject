package foodtruckfinder.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import foodtruckfinder.model.FoodTruckDetails;

public class FoodTruckServiceImpl implements FoodTruckService {

	@Override
	public List<FoodTruckDetails> getCurrentFoodTrucks() {
		List<FoodTruckDetails> allData = getAllFoodTruckDetails();
		List<FoodTruckDetails> todaysData = new ArrayList<>();
		LocalTime now = LocalTime.now();
		todaysData = allData.stream()
		   .filter(f -> f.getDayOfWeek() == getDayOfWeek())
		   .filter(f -> (
				   (now.equals(f.getStartTime()) || now.isAfter(f.getStartTime()))
				   && (now.equals(f.getEndTime()) || now.isBefore(f.getEndTime()))))
		   .sorted(Comparator.comparing(FoodTruckDetails::getName))
		   .collect(Collectors.toList());
		return todaysData;
	}
	
	private int getDayOfWeek() {
		int dayOfWeek = LocalDate.now().getDayOfWeek().getValue();
		// Java DayOfWeek value ranges from 1 for Monday to 7 for Sunday
		// whereas, in the data, it ranges from 0 for Sunday to 6 for Saturday
		if (dayOfWeek == 7) {
			dayOfWeek = 0;
		}
		return dayOfWeek;
	}
	
	private List<FoodTruckDetails> getAllFoodTruckDetails() {
		Client client = ClientBuilder.newClient();
		List<FoodTruckDetails> allData = client.target("http://data.sfgov.org/resource/bbb8-hzi6.json")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<FoodTruckDetails>>() {});
		return allData;
	}
       
}
