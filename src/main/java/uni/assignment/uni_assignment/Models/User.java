/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.assignment.uni_assignment.Models;

import javax.persistence.*;

/**
 *
 * @author harryvince
 */
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private Integer Id;
    private String Username;
    private String Password;
    
    public User() {}
    
    public User(String username, String password) {
        this.Username = username;
        this.Password = password;
    }
    
    public void setId(Integer Id) {
        this.Id = Id;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Integer getId() {
        return Id;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
}
