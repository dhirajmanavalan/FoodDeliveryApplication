package com.res.DAO;

import java.util.List;

import com.res.DTO.Restaurant;

public interface RestaurantDAO {
	
	List<Restaurant> getallRestaurants(Restaurant restaurant);
	
	Restaurant getRestaurant(int id);
	
	void addRestauranr(Restaurant restaurant);
	
	void updateRestaurant(Restaurant restaurant);
	
	void deleteRestaurant(int id);
	
	

}
