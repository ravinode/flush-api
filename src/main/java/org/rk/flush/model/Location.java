package org.rk.flush.model;

public class Location {

	private String id;
	private String name;
	private String description;
	private String rating;
	private String latitude;
	private String longitude;
	private String distance;
	
	
	
	public Location(String id, String name, String description, String rating, String latitude, String longitude,
			String distance) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distance = distance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	
}
