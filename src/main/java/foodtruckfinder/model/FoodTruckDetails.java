package foodtruckfinder.model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import foodtruckfinder.json.LocalTimeDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodTruckDetails {

	private String name;
	private String location;
	private LocalTime startTime;
	private LocalTime endTime;
	private int dayOfWeek;
	
	// Getters and setters
	@JsonProperty("applicant")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@JsonProperty("start24")
	@JsonDeserialize(using = LocalTimeDeserializer.class) 
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	@JsonProperty("end24")
	@JsonDeserialize(using = LocalTimeDeserializer.class) 
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	@JsonProperty("dayorder")
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
		
	
}
