package com.res.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.res.Connector.ConnectorFactory;
import com.res.DAO.RestaurantDAO;
import com.res.DTO.Restaurant;

public class RestaurantDAOImp implements RestaurantDAO {

	private static final String GetAllRestaurants = "SELECT * FROM restaurant";
	private static final String GETRESTAURANT = "SELECT * FROM restaurant WHERE restaurant_id=?";
	private static final String ADDRESTAURANT = "INSERT INTO restaurant (restaurant_name, restaurant_description, restaurant_address, restaurant_rating, restaurant_cuisine, restaurant_delivery_time, restaurant_isactive, restaurant_imageurl, restaurant_admin_userid) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String UPDATERESTAURANT = "UPDATE restaurant SET restaurant_name = ?, restaurant_description = ?, restaurant_address = ?, restaurant_rating = ?, restaurant_cuisine = ?, restaurant_deliver_time = ?,restaurant_isactive = ?,restaurant_imageurl = ?,restaurant_admin_userid = ? WHERE restaurant_id = ?";
	private static final String DELETERESTAURANT = "DELETE from restaurant where restaurant_id = ?";

	@Override
	public List<Restaurant> getallRestaurants(Restaurant restaurant) {

		List<Restaurant> list = new ArrayList<>();

		try (Connection con = ConnectorFactory.requestConnection();
				PreparedStatement pstmt = con.prepareStatement(GetAllRestaurants);) {

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int id = res.getInt("restaurant_Id");
				String name = res.getString("restaurant_name");
				String description = res.getString("restaurant_description");
				String address = res.getString("restaurant_address");
				int rating = res.getInt("restaurant_rating");
				String cuisine = res.getString("restaurant_cuisine");
				String delivery_time = res.getString("restaurant_delivery_time");
				String isactive = res.getString("restaurant_isactive");
				String imgurl = res.getString("restaurant_imageurl");
				int admin_userid = res.getInt("restaurant_admin_userid");

				Restaurant restau = new Restaurant(id, name, description, address, rating, cuisine, delivery_time,
						isactive, imgurl, admin_userid);

				list.add(restau);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Restaurant getRestaurant(int id) {
		Restaurant restau = null;
		try (Connection con = ConnectorFactory.requestConnection();
				PreparedStatement pstmt = con.prepareStatement(GETRESTAURANT);) {
			
			pstmt.setInt(1, id);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int id1 = res.getInt("restaurant_Id");
				String name = res.getString("restaurant_name");
				String description = res.getString("restaurant_description");
				String address = res.getString("restaurant_address");
				int rating = res.getInt("restaurant_rating");
				String cuisine = res.getString("restaurant_cuisine");
				String delivery_time = res.getString("restaurant_delivery_time");
				String isactive = res.getString("restaurant_isactive");
				String imgurl = res.getString("restaurant_imageurl");
				int admin_userid = res.getInt("restaurant_admin_userid");

				restau = new Restaurant(id1, name, description, address, rating, cuisine, delivery_time, isactive,
						imgurl, admin_userid);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return restau;
	}

	@Override
	public void addRestauranr(Restaurant restaurant) {
		try (Connection con = ConnectorFactory.requestConnection();
				PreparedStatement pstmt = con.prepareStatement(ADDRESTAURANT);) {

			pstmt.setString(1, restaurant.getRestaurant_name());
			pstmt.setString(2, restaurant.getRestaurant_description());
			pstmt.setString(3, restaurant.getRestaurant_address());
			pstmt.setInt(4, restaurant.getRestaurant_rating());
			pstmt.setString(5, restaurant.getRestaurant_cuisine());
			pstmt.setString(6, restaurant.getRestaurant_delivery_time());
			pstmt.setString(7, restaurant.getRestaurant_isactive());
			pstmt.setString(8, restaurant.getRestaurant_imageurl());
			pstmt.setInt(9, restaurant.getRestaurant_admin_userid());
			int res = pstmt.executeUpdate();
			System.out.println(res);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		try (Connection con = ConnectorFactory.requestConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATERESTAURANT);) {

			pstmt.setString(1, restaurant.getRestaurant_name());
			pstmt.setString(2, restaurant.getRestaurant_description());
			pstmt.setString(3, restaurant.getRestaurant_address());
			pstmt.setInt(4, restaurant.getRestaurant_rating());
			pstmt.setString(5, restaurant.getRestaurant_cuisine());
			pstmt.setString(6, restaurant.getRestaurant_delivery_time());
			pstmt.setString(7, restaurant.getRestaurant_isactive());
			pstmt.setString(8, restaurant.getRestaurant_imageurl());
			pstmt.setInt(9, restaurant.getRestaurant_admin_userid());
			pstmt.setInt(10, restaurant.getRestaurant_id());

			int res = pstmt.executeUpdate();
			System.out.println(res);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteRestaurant(int id) {
		try {
			Connection con = ConnectorFactory.requestConnection();
			PreparedStatement pstmt = con.prepareStatement(DELETERESTAURANT);
			pstmt.setInt(1, id);

			int res = pstmt.executeUpdate();
			System.out.println(res);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
