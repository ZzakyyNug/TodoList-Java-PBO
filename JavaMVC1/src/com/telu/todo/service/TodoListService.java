/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.telu.todo.service;

import com.telu.todo.model.TodoList;
import java.util.List;

/**
 *
 * @author dany
 */
public interface TodoListService {
    
    public void addTodo(TodoList todoList);
    
    public void removeTodo(Integer id);
    
    public void updateTodo(TodoList todoList);
    
    public List<TodoList> getTodo();
      
}