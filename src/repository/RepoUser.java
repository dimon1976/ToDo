package repository;

import java.sql.*;

import static java.lang.Class.forName;

public class RepoUser extends ConfigConnection{

    public boolean userLogin(String login, String pass) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement ps = connection.prepareStatement("select 1 from `users` where `UsersLogin` = ? and `UsersPass` = ?");
                ps.setString(1, login);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean userRegister(String login, String pass) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String query = "select 1 from `users` where `UsersLogin` = ? and `UsersPass` = ?";
                String addUser = "INSERT INTO `users` (UsersLogin,UsersPass) values(?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, login);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return false;
                } else {
                    ps = connection.prepareStatement(addUser);
                    ps.setString(1, login);
                    ps.setString(2, pass);
                    ps.execute();
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public int returnUserId(String login){
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String query = "select * from `users` where `UsersLogin` = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, login);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("UsersId");
                } else {
                    System.out.println("Такого логина не существует");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
