/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telu.todo.run;

import com.telu.todo.service.TodoListService;
import com.telu.todo.service.impl.TodoListServiceImpl;
import com.telu.todo.utilities.DatabaseUtilities;
import com.telu.todo.view.TodoListView;

/**
 *
 * @author dany
 */
public class Main {
    
    public static void main(String[] args) {
        
        TodoListService service=new TodoListServiceImpl(DatabaseUtilities.getConnection());
        TodoListView view=new TodoListView(service);
        view.viewShowTodoList();
        
    }
    
}
