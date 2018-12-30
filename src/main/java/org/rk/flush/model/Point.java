package org.rk.flush.model;

public class Point {

	private String userID;
	private String points;
	private String pointStatus;
	
	
	
	
	public Point(String userID, String points, String pointStatus) {
		super();
		this.userID = userID;
		this.points = points;
		this.pointStatus = pointStatus;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public String getPointStatus() {
		return pointStatus;
	}
	public void setPointStatus(String pointStatus) {
		this.pointStatus = pointStatus;
	}
	
	
}
