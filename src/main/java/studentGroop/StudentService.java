package studentGroop;

import connect.ConnectDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private ConnectDB connectDB;

    public boolean createStudent(String firstName, String lastName) {
        try (Connection connection = connectDB.initializeDatabase()) {
            String query = "INSERT INTO student (first_name, last_name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("Запись учащегося успешно создана.");
            } else {
                System.out.println("Студенческий список не был создан.");
            }
            return result > 0;
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            return false;
        }
    }
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = connectDB.initializeDatabase()) {
            String query = "SELECT id, first_name, last_name FROM student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    public boolean deleteStudent(Long id) {
        try (Connection connection = connectDB.initializeDatabase()) {
            String query = "DELETE FROM student WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            int result = statement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
