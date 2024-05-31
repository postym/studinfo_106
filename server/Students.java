import java.rmi.RemoteException;

public class Students extends DatabaseConnect implements StudentInterface {
    private int id;
    private String name;
    private int age;
    private String address;
    private String contact_number;

    public void addStudentInfo(int id, String name, int age, String address, String contact_number) throws RemoteException {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.contact_number = contact_number;
    }

    public void insertStudent() throws RemoteException {
        String sql = "INSERT INTO students (id, name, age, address, contact_number) VALUES (?, ?, ?, ?, ?)";
        insertStudent(sql, id, name, age, address, contact_number);
    }

    public void displayStudentInfo() throws RemoteException {
        System.out.println();
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contact_number);
    }
}