/**
 * 
 */
package com.lexelpro.dao;

import com.lexelpro.entity.User;

import java.util.List;

/**
 * @author Lexel PRO
 * @version 1.0
 */
public interface UserDAO {
	public long createUser(User user);
    public User updateUser(User user);
    public void deleteUser(long id);
    public List<User> getAllUsers();
    public User getUser(long id);

}
