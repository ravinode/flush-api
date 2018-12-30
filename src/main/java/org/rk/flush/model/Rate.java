package org.rk.flush.model;

public class Rate {

	private String id;
	private String rating;
	private String s_rating;
	private String c_rating;
	private String count;
	
	
	
	
	public Rate(String id, String rating, String s_rating, String c_rating, String count) {
		super();
		this.id = id;
		this.rating = rating;
		this.s_rating = s_rating;
		this.c_rating = c_rating;
		this.count = count;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getS_rating() {
		return s_rating;
	}
	public void setS_rating(String s_rating) {
		this.s_rating = s_rating;
	}
	public String getC_rating() {
		return c_rating;
	}
	public void setC_rating(String c_rating) {
		this.c_rating = c_rating;
	}
	
	
}
