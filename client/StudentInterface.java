import java.rmi.Remote;
import java.rmi.RemoteException;
//import java.util.List;

public interface StudentInterface extends Remote {
    public void addStudentInfo(int student_id, String name, int age, String address, String contact)
            throws RemoteException;

    public void displayStudentInfo() throws RemoteException;

    public void insertStudent() throws RemoteException;
}