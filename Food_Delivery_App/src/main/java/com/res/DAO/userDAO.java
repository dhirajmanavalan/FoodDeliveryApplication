package com.res.DAO;

import java.util.List;

import com.res.DTO.User;

public interface userDAO {

	List<User> getAllUser();

	User getUser(int user_Id);

	void addUser(User user);

	void updateuser(User user);

	void deleteuser(int user_id);
}
