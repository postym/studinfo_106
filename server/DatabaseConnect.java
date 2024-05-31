// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.Statement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

// public class DatabaseConnect {
//     // Predefined database connection details
//     protected String databaseURL = "jdbc:mysql://127.0.0.1:3306/laravel";
//     protected String databaseUsername = "root";
//     protected String databasePassword = "2675";

//     static {
//         try {
//             System.out.println("Loading MySQL driver..."); // Add this line for logging
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             System.out.println("MySQL driver loaded successfully."); // Add this line for logging
//         } catch (ClassNotFoundException e) {
//             System.out.println("Failed to load MySQL driver: " + e.getMessage());
//             e.printStackTrace();
//         }
//         // Establish database connection and execute query
//         try (Connection conn = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword)) {
//             System.out.println("Connected to the database successfully.");
//             String query = "SELECT 1";
//             try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
//                 if (rs.next()) {
//                     System.out.println("Query executed successfully, result: " + rs.getInt(1));
//                 }
//             }
//         } catch (SQLException e) {
//             System.out.println("Failed to connect to the database: " + e.getMessage());
//             e.printStackTrace();
//         }
//     }

//     // Method to insert student record into the database
//     protected void insertStudent(String insertStudentSQL, int studentId, String studentName, int studentAge,
//             String studentAddress, String studentContactNumber) {
//         try (Connection dbConnection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword)) {
//             // Check if the record already exists
//             if (isStudentRecordExists(dbConnection, "students", studentId)) {
//                 System.out.println("Student Already Exists: " + studentId);
//                 return; // Do not insert the record if it already exists
//             }

//             // Insert the record into the database
//             PreparedStatement preparedStatement = dbConnection.prepareStatement(insertStudentSQL);
//             preparedStatement.setInt(1, studentId);
//             preparedStatement.setString(2, studentName);
//             preparedStatement.setInt(3, studentAge);
//             preparedStatement.setString(4, studentAddress);
//             preparedStatement.setString(5, studentContactNumber);

//             int rowsInserted = preparedStatement.executeUpdate();
//             if (rowsInserted > 0) {
//                 System.out.println("Student Inserted Successfully.");
//             }
//         } catch (SQLException e) {
//             System.out.println("Error Occured: Cannot Insert Student Record.\n" + e.getMessage());
//         }
//     }

//     // Method to insert course record into the database
//     protected void insertCourse(String insertCourseSQL, int courseId, int studentId, String courseTitle,
//             String courseDescription) {
//         try (Connection dbConnection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword)) {
//             // Check if the record already exists
//             if (isCourseRecordExists(dbConnection, "courses", studentId, courseId)) {
//                 System.out.println("Course Already Exists: " + courseId);
//                 return; // Do not insert the record if it already exists
//             }

//             // Insert the record into the database
//             PreparedStatement preparedStatement = dbConnection.prepareStatement(insertCourseSQL);
//             preparedStatement.setInt(1, courseId);
//             preparedStatement.setInt(2, studentId);
//             preparedStatement.setString(3, courseTitle);
//             preparedStatement.setString(4, courseDescription);

//             int rowsInserted = preparedStatement.executeUpdate();
//             if (rowsInserted > 0) {
//                 System.out.println("Course Inserted Successfully.");
//             }
//         } catch (SQLException e) {
//             System.out.println("Error Occured: Cannot Insert Course Record.\n" + e.getMessage());
//         }
//     }

//     // Method to check if a student record already exists in the database
//     private boolean isStudentRecordExists(Connection dbConnection, String tableName, int studentId)
//             throws SQLException {
//         String checkStudentQuery = "SELECT COUNT(*) FROM " + tableName + " WHERE id = ?";
//         try (PreparedStatement preparedStatement = dbConnection.prepareStatement(checkStudentQuery)) {
//             preparedStatement.setInt(1, studentId);
//             try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                 if (resultSet.next()) {
//                     return resultSet.getInt(1) > 0;
//                 }
//             }
//         }
//         return false; // Default to false if an error occurs or no result is found
//     }

//     // Method to check if a course record already exists in the database
//     private boolean isCourseRecordExists(Connection dbConnection, String tableName, int studentId, int courseId)
//             throws SQLException {
//         String checkCourseQuery = "SELECT COUNT(*) FROM " + tableName + " WHERE student_id = ? AND course_id = ?";
//         try (PreparedStatement preparedStatement = dbConnection.prepareStatement(checkCourseQuery)) {
//             preparedStatement.setInt(1, studentId);
//             preparedStatement.setInt(2, courseId);
//             try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                 if (resultSet.next()) {
//                     return resultSet.getInt(1) > 0;
//                 }
//             }
//         }
//         return false; // Default to false if an error occurs or no result is found
//     }
// }

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnect {
    // Predefined database connection details
    protected static String databaseURL = "jdbc:mysql://127.0.0.1:3306/laravel";
    protected static String databaseUsername = "root";
    protected static String databasePassword = "2675";

    static {
        try {
            System.out.println("Loading MySQL driver..."); // Add this line for logging
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL driver loaded successfully."); // Add this line for logging
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load MySQL driver: " + e.getMessage());
            e.printStackTrace();
        }
        // Establish database connection and execute query
        try (Connection conn = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword)) {
            System.out.println("Connected to the database successfully.");
            String query = "SELECT 1";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                if (rs.next()) {
                    System.out.println("Query executed successfully, result: " + rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to insert student record into the database
    protected void insertStudent(String insertStudentSQL, int studentId, String studentName, int studentAge,
            String studentAddress, String studentContactNumber) {
        try (Connection dbConnection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword)) {
            // Check if the record already exists
            if (isStudentRecordExists(dbConnection, "students", studentId)) {
                System.out.println("Student Already Exists: " + studentId);
                return; // Do not insert the record if it already exists
            }

            // Insert the record into the database
            PreparedStatement preparedStatement = dbConnection.prepareStatement(insertStudentSQL);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setString(2, studentName);
            preparedStatement.setInt(3, studentAge);
            preparedStatement.setString(4, studentAddress);
            preparedStatement.setString(5, studentContactNumber);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student Inserted Successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error Occurred: Cannot Insert Student Record.\n" + e.getMessage());
        }
    }

    // Method to insert course record into the database
    protected void insertCourse(String insertCourseSQL, int courseId, int studentId, String courseTitle,
            String courseDescription) {
        try (Connection dbConnection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword)) {
            // Check if the record already exists
            if (isCourseRecordExists(dbConnection, "courses", studentId, courseId)) {
                System.out.println("Course Already Exists: " + courseId);
                return; // Do not insert the record if it already exists
            }

            // Insert the record into the database
            PreparedStatement preparedStatement = dbConnection.prepareStatement(insertCourseSQL);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, studentId);
            preparedStatement.setString(3, courseTitle);
            preparedStatement.setString(4, courseDescription);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Course Inserted Successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error Occurred: Cannot Insert Course Record.\n" + e.getMessage());
        }
    }

    // Method to check if a student record already exists in the database
    private boolean isStudentRecordExists(Connection dbConnection, String tableName, int studentId)
            throws SQLException {
        String checkStudentQuery = "SELECT COUNT(*) FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(checkStudentQuery)) {
            preparedStatement.setInt(1, studentId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false; // Default to false if an error occurs or no result is found
    }

    // Method to check if a course record already exists in the database
    private boolean isCourseRecordExists(Connection dbConnection, String tableName, int studentId, int courseId)
            throws SQLException {
        String checkCourseQuery = "SELECT COUNT(*) FROM " + tableName + " WHERE student_id = ? AND course_id = ?";
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(checkCourseQuery)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseId);
            preparedStatement.setInt(2, courseId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false; // Default to false if an error occurs or no result is found
    }
}
