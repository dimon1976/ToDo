package repository;

import entity.Task;

import java.sql.*;

import static java.lang.Class.forName;

public class RepoTask extends ConfigConnection {

    public void addTask(Task task, String status, int userId) {
        RepoCategory category = new RepoCategory();
        int id = category.checkCategory(userId);
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String query = "INSERT INTO tasks (name, description, status, usersID,categoryID) values (?, ?, ?, ?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, task.getName());
                preparedStatement.setString(2, task.getDesc());
                preparedStatement.setString(3, status);
                preparedStatement.setInt(4, userId);
                preparedStatement.setInt(5, id);
                preparedStatement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeTask(int id) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String query = "DELETE FROM TASKS WHERE id = " + id;
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.execute();
                System.out.println("ToDo id = " + id + " удалена");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editTask(int id, String name, String desc) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String update = "UPDATE tasks SET name = ?,description = ? where id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(update);
                preparedStatement.setInt(3, id);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, desc);
                preparedStatement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editTaskStatus(int id, String status) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String update = "UPDATE tasks SET status = ? where id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(update);
                preparedStatement.setInt(2, id);
                preparedStatement.setString(1, status);
                preparedStatement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTask(int userId) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM tasks WHERE usersID = " + userId);
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String desc = resultSet.getString(3);
                    String status = resultSet.getString(4);
                    System.out.println("ID:" + id + " " + name + " " + desc + " " + status);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTaskId(int id) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM TASKS WHERE id = " + id);
                whileResult(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTaskStatus(String status, int userId) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM TASKS WHERE status = " + "'" + status + "'" + "and usersID =" + userId);
                whileResult(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void whileResult(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int i = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String desc = resultSet.getString(3);
            String st = resultSet.getString(4);
            System.out.println(st + " " + i + " " + name + " " + desc);
        }
        System.out.println();
    }
}
