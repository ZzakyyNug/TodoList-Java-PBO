/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telu.todo.model;

/**
 *
 * @author Lenovo
 */
public class User {
    // buat model
    // dari tabel user
    
    private Integer id;
    private String username;
    private String password;
    
    
    public User() {
    }

    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }


    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
