package org.rk.flush.request;

public class FlushLocReq {

	private String latitude;
	private String longtitude;
	private String distance;
	private String kmOrMiles;
	
	
	public FlushLocReq(String latitude, String longtitude, String distance, String kmOrMiles) {
		super();
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.distance = distance;
		this.kmOrMiles = kmOrMiles;
	}
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getKmOrMiles() {
		return kmOrMiles;
	}
	public void setKmOrMiles(String kmOrMiles) {
		this.kmOrMiles = kmOrMiles;
	}
	
	
}
