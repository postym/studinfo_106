import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server has been started...");
            Registry rmiRegistry = LocateRegistry.createRegistry(9103);

            Students studentService = new Students();
            Courses courseService = new Courses();

            StudentInterface studentStub = (StudentInterface) UnicastRemoteObject.exportObject(studentService, 0);
            CourseInterface courseStub = (CourseInterface) UnicastRemoteObject.exportObject(courseService, 0);

            rmiRegistry.rebind("student", studentStub);
            rmiRegistry.rebind("course", courseStub);

            System.out.println("Server is running......");
        } catch (Exception e) {
            System.out.println("Error (Server): " + e);
        }
    }
}
