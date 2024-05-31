import java.rmi.RemoteException;

public class Courses extends DatabaseConnect implements CourseInterface {
    private int course_id;
    private int student_id;
    private String course_title;
    private String course_description;

    // Method to add new information
    public void addCourseInfo(int course_id, int student_id, String course_title, String course_description)
            throws RemoteException {
        this.course_id = course_id;
        this.student_id = student_id;
        this.course_title = course_title;
        this.course_description = course_description;
    }

    public void insertCourse() throws RemoteException {
        String sql = "INSERT INTO courses (course_id, student_id, course_title, course_description) VALUES (?, ?, ?, ?)";
        insertCourse(sql, course_id, student_id, course_title, course_description);
    }

    // Display method to print all information
    public void displayCourseInfo() throws RemoteException {
        System.out.println();
        System.out.println("Course ID: " + course_id);
        System.out.println("Student ID: " + student_id);
        System.out.println("Course Title: " + course_title);
        System.out.println("Course Description: " + course_description);
    }

}