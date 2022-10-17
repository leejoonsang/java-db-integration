package com.dbexercise;

import com.dbexercise.domain.User;

import java.sql.*;

import java.util.Map;

public class UserDao {
    public User select(String id) throws SQLException, ClassNotFoundException{
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);

        // INSERT 문
//        PreparedStatement ps = conn.prepareStatement(
//                "INSERT INTO users(id, name, password) values (?, ?, ?)"
//                );
//        ps.setString(1, "1");
//        ps.setString(2, "sangjoon");
//        ps.setString(3, "1234");

        // SELECT 문
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM users where id = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User(rs.getString("id"), rs.getString("name"),
                rs.getString("password"));
        rs.close();
        ps.close();
        conn.close();
        return user;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        User user = userDao.select("1");
        System.out.println(user.getName());
    }

}
