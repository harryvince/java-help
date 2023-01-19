/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package uni.assignment.uni_assignment;

import java.util.List;
import uni.assignment.uni_assignment.Models.*;
import uni.assignment.uni_assignment.Views.*;

/**
 *
 * @author harryvince
 * Entry point for program
 */
public class Uni_assignment {

    public static void main(String[] args) {
        DB db = new DB();
        db.getConnection();
        // Setup for Models
        try {
            db.createTable(User.class);
        } catch (Exception err) {
            System.out.println("Error has occured: " + err);
        }
        
        User harry = new User();
        harry.setUsername("test");
        harry.setPassword("test");
        db.insert(harry);
        List<User> users = db.where("password=?", "SuperSecurePassword").orderBy("password").results(User.class);
        dump("data=", users);
        System.out.println("Hello World!");
        TestScreen screen1 = new TestScreen();
        screen1.show();
    }
    
    public static void dump(String label, List<User> list) {
		System.out.println(label);
		for (User n : list) {
			System.out.println(n.getId());
		}
	}
}
