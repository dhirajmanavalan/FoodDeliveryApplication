package com.res.DTO;

public class Restaurant {

	private int restaurant_id;
	private String restaurant_name;
	private String restaurant_description;
	private String restaurant_address;
	private int restaurant_rating;
	private String restaurant_cuisine;
	private String restaurant_delivery_time;
	private String restaurant_isactive;
	private String restaurant_imageurl;
	private int restaurant_admin_userid; 

	public Restaurant() {
		super();
	}

	public Restaurant(String restaurant_name, String restaurant_description, String restaurant_address,
			int restaurant_rating, String restaurant_cuisine, String restaurant_delivery_time,
			String restaurant_isactive, String restaurant_imageurl, int restaurant_admin_userid) {
		this.restaurant_name = restaurant_name;
		this.restaurant_description = restaurant_description;
		this.restaurant_address = restaurant_address;
		this.restaurant_rating = restaurant_rating;
		this.restaurant_cuisine = restaurant_cuisine;
		this.restaurant_delivery_time = restaurant_delivery_time;
		this.restaurant_isactive = restaurant_isactive;
		this.restaurant_imageurl = restaurant_imageurl;
		this.restaurant_admin_userid = restaurant_admin_userid;
	}

	public Restaurant(int restaurant_id, String restaurant_name, String restaurant_description,
			String restaurant_address, int restaurant_rating, String restaurant_cuisine,
			String restaurant_delivery_time, String restaurant_isactive, String restaurant_imageurl,
			int restaurant_admin_userid) {
		super();
		this.restaurant_id = restaurant_id;
		this.restaurant_name = restaurant_name;
		this.restaurant_description = restaurant_description;
		this.restaurant_address = restaurant_address;
		this.restaurant_rating = restaurant_rating;
		this.restaurant_cuisine = restaurant_cuisine;
		this.restaurant_delivery_time = restaurant_delivery_time;
		this.restaurant_isactive = restaurant_isactive;
		this.restaurant_imageurl = restaurant_imageurl;
		this.restaurant_admin_userid = restaurant_admin_userid;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getRestaurant_description() {
		return restaurant_description;
	}

	public void setRestaurant_description(String restaurant_description) {
		this.restaurant_description = restaurant_description;
	}

	public String getRestaurant_address() {
		return restaurant_address;
	}

	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}

	public int getRestaurant_rating() {
		return restaurant_rating;
	}

	public void setRestaurant_rating(int restaurant_rating) {
		this.restaurant_rating = restaurant_rating;
	}

	public String getRestaurant_cuisine() {
		return restaurant_cuisine;
	}

	public void setRestaurant_cuisine(String restaurant_cuisine) {
		this.restaurant_cuisine = restaurant_cuisine;
	}

	public String getRestaurant_delivery_time() {
		return restaurant_delivery_time;
	}

	public void setRestaurant_delivery_time(String restaurant_delivery_time) {
		this.restaurant_delivery_time = restaurant_delivery_time;
	}

	public String getRestaurant_isactive() {
		return restaurant_isactive;
	}

	public void setRestaurant_isactive(String restaurant_isactive) {
		this.restaurant_isactive = restaurant_isactive;
	}

	public String getRestaurant_imageurl() {
		return restaurant_imageurl;
	}

	public void setRestaurant_imageurl(String restaurant_imageurl) {
		this.restaurant_imageurl = restaurant_imageurl;
	}

	public int getRestaurant_admin_userid() {
		return restaurant_admin_userid;
	}

	public void setRestaurant_admin_userid(int restaurant_admin_userid) {
		this.restaurant_admin_userid = restaurant_admin_userid;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurant_id=" + restaurant_id + ", restaurant_name=" + restaurant_name
				+ ", restaurant_description=" + restaurant_description + ", restaurant_address=" + restaurant_address
				+ ", restaurant_rating=" + restaurant_rating + ", restaurant_cuisine=" + restaurant_cuisine
				+ ", restaurant_delivery_time=" + restaurant_delivery_time + ", restaurant_isactive="
				+ restaurant_isactive + ", restaurant_imageurl=" + restaurant_imageurl + ", restaurant_admin_userid="
				+ restaurant_admin_userid + "]";
	}
	

}
