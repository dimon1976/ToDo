package repository;

import entity.Category;
import entity.User;

import java.sql.*;

import static java.lang.Class.forName;

public class RepoCategory extends ConfigConnection {


    public int checkCategory(int userId) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CATEGORY where CategoryName = 'Без категории' and UserId = " + userId);
                ResultSet rs = preparedStatement.executeQuery();
                {
                    if (rs.next()) {
                        System.out.println("есть такая категория");
                        return rs.getInt(1);
                    } else {
                        String query = "INSERT INTO category (CategoryName,UserId) values(?,?)";
                        PreparedStatement ps = connection.prepareStatement(query);
                        ps.setString(1, "Без категории");
                        ps.setInt(2, userId);
                        ps.execute();
                        Statement statement2 = connection.createStatement();
                        ResultSet resultSet = statement2.executeQuery("SELECT * FROM CATEGORY where CategoryName = 'Без категории' and UserId = " + userId);
                        while (resultSet.next()) {
                            return resultSet.getInt(1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addCategory(Category category, int userId) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String query = "INSERT INTO category (CategoryName,userId) values(?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, category.getNameCategory());
                preparedStatement.setInt(2, userId);
                preparedStatement.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeCategory(int id) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * FROM CATEGORY WHERE categoryID = " + id);
                String name = "";
                while (resultSet.next()) {
                    name = resultSet.getString(2);
                }
                String query = "DELETE FROM CATEGORY WHERE categoryID = " + id;
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.execute();
                System.out.println("Категория " + name + " удалена");


            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editCategory(int id, String name) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String query = "UPDATE category Set CategoryName = ? where Categoryid = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(2, id);
                preparedStatement.setString(1, name);
                preparedStatement.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTaskInCategory(int id) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance(); //Указали путь к драйверу, вызвали конструктор и создали объект для работы с базой
            try (Connection connection = DriverManager.getConnection(url, username, password)) {  // Передаем данные для соединения
                Statement statement = connection.createStatement();
                String select = ("SELECT * FROM TASKS WHERE categoryID = " + id);
                ResultSet resultSet = statement.executeQuery(select);
                RepoTask.whileResult(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printAllCategory(int userId) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM category WHERE userId =" + userId);
                while (resultSet.next()) {
//                    if (resultSet.next()) {
//                        System.out.println("категорий не создано");
//                        break;
//                    }
                    int a = resultSet.getInt("CategoryId");
                    String b = resultSet.getString("CategoryName");
                    System.out.println("ID:" + a + " " + b);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCategoryTask(int a, int b) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance(); //Указали путь к драйверу, вызвали конструктор и создали объект для работы с базой
            try (Connection connection = DriverManager.getConnection(url, username, password)) {  // Передаем данные для соединения
                String update = "UPDATE tasks SET categoryID = ? where id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(update);
                preparedStatement.setInt(2, a);
                preparedStatement.setInt(1, b);
                preparedStatement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean printCheckCategory(int userId) {
        try {
            forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM category WHERE userId =" + userId);
                if (!resultSet.next()) {
                    System.out.println("категорий не создано");
                    return false;
                }
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
