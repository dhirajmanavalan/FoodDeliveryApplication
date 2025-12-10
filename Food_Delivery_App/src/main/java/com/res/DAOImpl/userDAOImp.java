package com.res.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.res.Connector.ConnectorFactory;
import com.res.DAO.userDAO;
import com.res.DTO.User;

public class userDAOImp implements userDAO {

	private static final String INSERT_USER = "INSERT into user (user_Name , user_Email, user_Password ,user_Address , user_Role, user_Created_Date, user_Last_Login_Date)"
			+ "Values(?,?,?,?,?,?,?)";

	private static final String UPDATE_USER = "UPDATE user SET user_Name = ? , user_Email = ? , user_Password = ? , user_Address = ? WHERE user_id=?";

	private static final String GETUSER = "SELECT * FROM user WHERE user_id = ?";

	private static final String GET_ALL_USERS = "SELECT * FROM user";

	private static final String DELETE_USER = "DELETE FROM user WHERE user_id=?";

	@Override
	public List<User> getAllUser() {
	    List<User> list = new ArrayList<>();

	    try (Connection con = ConnectorFactory.requestConnection();
	         PreparedStatement pstmt = con.prepareStatement(GET_ALL_USERS);
	         ResultSet res = pstmt.executeQuery()) {

	        while (res.next()) {

	            int id = res.getInt("user_id");
	            String name = res.getString("user_Name");
	            String email = res.getString("user_Email");
	            String password = res.getString("user_Password");
	            String address = res.getString("user_Address");
	            String role = res.getString("user_Role");
	            Timestamp created = res.getTimestamp("user_Created_Date");
	            Timestamp lastLogin = res.getTimestamp("user_Last_Login_Date");

	            User user = new User(id, name, email, password, address, role, created, lastLogin);
	            list.add(user);
	        }

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}


	@Override
	public User getUser(int user_Id) {
		User user = null;
		try {
			Connection con = ConnectorFactory.requestConnection();
			PreparedStatement pstmt = con.prepareStatement(GETUSER);
			pstmt.setInt(1, user_Id);
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int id = res.getInt("user_Id");
				String name = res.getString("user_Name");
				String email = res.getString("user_email");
				String password = res.getString("user_Password");
				String address = res.getString("user_Address");
				String role = res.getString("user_role");
				Timestamp createddate = res.getTimestamp("user_created_date");
				Timestamp lastlogin = res.getTimestamp("user_last_login_date");

				user = new User(id, name, email, password, address, role, createddate, lastlogin);

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void addUser(User user) {
		try (Connection con = ConnectorFactory.requestConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_USER);) {

			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setString(4, user.getUserAddress());
			pstmt.setString(5, user.getUserRole());
			pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

			int res = pstmt.executeUpdate();
			System.out.println(res);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateuser(User user) {
		try (Connection con = ConnectorFactory.requestConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_USER);) {

			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setString(4, user.getUserAddress());
			pstmt.setInt(5, user.getUserId());

			int res = pstmt.executeUpdate();
			System.out.println(res);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	 @Override
	    public void deleteuser(int user_id) {
	        try (Connection con = ConnectorFactory.requestConnection();
	             PreparedStatement pstmt = con.prepareStatement(DELETE_USER)) {

	            pstmt.setInt(1, user_id);
	            pstmt.executeUpdate();
	            System.out.println("User Deleted Successfully.");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	

}
