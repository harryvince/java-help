/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.assignment.uni_assignment.Models;

import com.dieselpoint.norm.Database;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author harryvince
 */
public final class DB extends Database {
    @Override
    protected DataSource getDataSource() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.sqlite.JDBC");
        config.setJdbcUrl("jdbc:sqlite:file.db");
        config.setConnectionTestQuery("SELECT 1");
        config.setMaximumPoolSize(100);

        return new HikariDataSource(config);
    }
    
    public void Setup() {
        // Models migration
        DB db = new DB();
        db.getConnection();
        // Add each model here
        migrate_model(db, User.class);
        db.close();
    }
    
    public void newSetup() throws Exception {
        String databaseURL = "jdbc:sqlite:file.db";
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseURL);
        Dao<User, String> userDao = DaoManager.createDao(connectionSource, User.class);
        TableUtils.createTable(connectionSource, User.class);
        
        // Create a user
        User user = new User();
        user.setUsername("harry");
        user.setPassword("SuperSecurePassword");
        userDao.create(user);
        
        // Retrieve the user
        User user2 = userDao.queryForId("0");
        System.out.println("User: " + user2.getUsername());
        connectionSource.close();
    }
    
    private void migrate_model(DB client, Class<?> model) {
        try {
            client.createTable(model);
        } catch (Exception error) {
            System.out.println("This Model might have already been migrated"
                    + "please find the error attached: " + error);
        }
    }
}