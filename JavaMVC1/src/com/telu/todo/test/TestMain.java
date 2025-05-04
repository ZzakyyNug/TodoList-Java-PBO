/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telu.todo.test;

import com.telu.todo.model.TodoList;
import com.telu.todo.service.TodoListService;
import com.telu.todo.service.impl.TodoListServiceImpl;
import com.telu.todo.utilities.DatabaseUtilities;
import java.util.List;

/**
 *
 * @author dany
 */
public class TestMain {
    
    public static void main(String[] args) {
        
        
        
        TodoListService service=new TodoListServiceImpl(DatabaseUtilities.getConnection());
        List<TodoList>list=service.getTodo();
        for (TodoList todoList : list) {
            System.out.println(todoList.getId()+" "+todoList.getTodo());
        }
        
    }
    
}
