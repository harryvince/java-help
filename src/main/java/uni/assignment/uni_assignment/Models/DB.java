/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.assignment.uni_assignment.Models;

import com.dieselpoint.norm.Database;
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
}