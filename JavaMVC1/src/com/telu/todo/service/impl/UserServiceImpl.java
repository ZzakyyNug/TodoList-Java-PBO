package com.telu.todo.service.impl;

import com.telu.todo.model.User;
import com.telu.todo.service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {

    private final Connection connection;

    public UserServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getUser() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
}
