package org.rk.flush.model;

public class Location {

	private String id;
	private String name;
	private String description;
	private String serviceType;
	private String rating;
	private String latitude;
	private String longitude;
	private String distance;
	private String status;
	private String addedBy;
	private String male;
	private String female;
	private String wheel;
	private String family;
	
	
	
	
	
	
	public Location(String id, String name, String description, String serviceType, String rating, String latitude,
			String longitude, String distance, String status, String addedBy, String male, String female, String wheel,
			String family) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.serviceType = serviceType;
		this.rating = rating;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distance = distance;
		this.status = status;
		this.addedBy = addedBy;
		this.male = male;
		this.female = female;
		this.wheel = wheel;
		this.family = family;
	}
	public String getMale() {
		return male;
	}
	public void setMale(String male) {
		this.male = male;
	}
	public String getFemale() {
		return female;
	}
	public void setFemale(String female) {
		this.female = female;
	}
	public String getWheel() {
		return wheel;
	}
	public void setWheel(String wheel) {
		this.wheel = wheel;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
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
	
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	
	
	
}
