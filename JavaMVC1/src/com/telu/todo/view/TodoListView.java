/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telu.todo.view;

import com.telu.todo.model.TodoList;
import com.telu.todo.model.User;
import com.telu.todo.service.TodoListService;
import com.telu.todo.service.UserService;
import com.telu.todo.service.impl.UserServiceImpl;
import com.telu.todo.utilities.DatabaseUtilities;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dany
 */
public class TodoListView {
    
    private TodoListService todoListService;
    private UserService userService;
    
    private Scanner scanner = new Scanner(System.in);

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
        this.userService = new UserServiceImpl(DatabaseUtilities.getConnection());
    }
    
    public void viewShowTodoList(){
        
        while(true){
            System.out.println("==================");
            System.out.println("Todo List Saya");
            System.out.println("==================");
            
            // list pekerjaan
            List<TodoList> list = todoListService.getTodo();
            for (TodoList todoList : list) {
                System.out.println(todoList.getId() + ". " + todoList.getTodo());
            }
            
            System.out.println("-------------------");
            System.out.println("Menu:");
            System.out.println("-------------------");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Edit Todo");
            System.out.println("4. Tampilkan User");
            System.out.println("x. Keluar");
            
            // untuk menampung input dari user
            System.out.print("Pilih Menu: ");
            var input = scanner.nextLine();
            
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else if (input.equals("3")) {
                viewEditTodoList();
            } else if (input.equals("4")) {
                viewShowUserList();
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }
    
    public void viewAddTodoList(){
        System.out.println("Menambah TodoList (Tekan X untuk batal)");
        System.out.print("Masukan todo list : ");
        
        var todo = scanner.nextLine();
        
        if (todo.equals("x")) {
            // Do nothing, cancel operation
        } else {
            TodoList todoList = new TodoList(todo);
            todoListService.addTodo(todoList);
        }
    }
    
    public void viewRemoveTodoList(){
        System.out.println("Menghapus TodoList (Tekan X untuk batal)");
        System.out.print("Masukan Id : ");
        
        var todo = scanner.nextLine();
        
        if (todo.equals("x")) {
            // Do nothing, cancel operation
        } else {
            int id = Integer.parseInt(todo);
            todoListService.removeTodo(id);
        }
    }
    
    public void viewEditTodoList() {
        System.out.println("Edit TodoList (Tekan X untuk batal)");
        System.out.print("Masukan Id : ");
        
        var todoId = scanner.nextLine();
        
        if (todoId.equals("x")) {
            // Do nothing, cancel operation
        } else {
            int id = Integer.parseInt(todoId);
            
            // Find the todo by id
            List<TodoList> todos = todoListService.getTodo();
            TodoList todoToEdit = null;
            
            for (TodoList todo : todos) {
                if (todo.getId() == id) {
                    todoToEdit = todo;
                    break;
                }
            }
            
            if (todoToEdit == null) {
                System.out.println("Todo dengan Id " + id + " tidak ditemukan");
                return;
            }
            
            System.out.println("Todo saat ini: " + todoToEdit.getTodo());
            System.out.print("Masukan todo baru : ");
            String newTodo = scanner.nextLine();
            
            if (!newTodo.equals("x")) {
                todoToEdit.setTodo(newTodo);
                todoListService.updateTodo(todoToEdit);
                System.out.println("Todo berhasil diupdate!");
            }
        }
    }
    
    public void viewShowUserList(){
        System.out.println("Menampilkan User");
        
        List<User> list = userService.getUser();
      
        for (User user : list) {
            System.out.println("id : " + user.getId() + " Username : " + user.getUsername());   
        }
        
        System.out.println("Tekan Enter untuk kembali ke menu utama");
        scanner.nextLine();
    }
}