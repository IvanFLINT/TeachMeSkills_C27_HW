package spring;

import connectDB.DriverDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class UserService {

    @Autowired
    private DriverDB driverDB;

    public boolean createUser(String login, String password) {
        try (Connection connection = driverDB.initializeDatabase()) {
            String query = "INSERT INTO users (login, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changeUserLogin(int id, String newLogin) {
        try (Connection connection = driverDB.initializeDatabase()) {
            String query = "UPDATE users SET login=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newLogin);
            statement.setInt(2, id);
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User getUser(int id) {
        try (Connection connection = driverDB.initializeDatabase()) {
            String query = "SELECT * FROM users WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteUser(int id) {
        try (Connection connection = driverDB.initializeDatabase()) {
            String query = "DELETE FROM users WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}