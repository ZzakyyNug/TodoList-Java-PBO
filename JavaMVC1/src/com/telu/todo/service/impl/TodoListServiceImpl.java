/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telu.todo.service.impl;

import com.telu.todo.model.TodoList;
import com.telu.todo.service.TodoListService;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dany
 */
public class TodoListServiceImpl implements TodoListService {

    private final Connection connection;

    public TodoListServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addTodo(TodoList todoList) {
        String sql = "INSERT INTO todolist (todo) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, todoList.getTodo());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TodoListServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeTodo(Integer id) {
        String sql = "DELETE FROM todolist WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TodoListServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void updateTodo(TodoList todoList) {
        String sql = "UPDATE todolist SET todo = ? WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, todoList.getTodo());
            statement.setInt(2, todoList.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TodoListServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<TodoList> getTodo() {
        List<TodoList> list = new ArrayList<>();
        String sql = "SELECT * FROM todolist";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                TodoList todoList = new TodoList();
                todoList.setId(resultSet.getInt("id"));
                todoList.setTodo(resultSet.getString("todo"));
                list.add(todoList);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TodoListServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}