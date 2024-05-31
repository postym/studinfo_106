import java.rmi.Remote;
import java.rmi.RemoteException;
//import java.util.List;

public interface CourseInterface extends Remote {
    public void addCourseInfo(int course_id, int student_id, String course_title, String course_description)
            throws RemoteException;

    public void displayCourseInfo() throws RemoteException;

    public void insertCourse() throws RemoteException;
}