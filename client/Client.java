import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Client {

        public static void main(String[] args) {
                try {
                        // Locate the registry and lookup the remote objects
                        Registry remoteRegistry = LocateRegistry.getRegistry("127.0.0.1", 9103);
                        StudentInterface studentRemote = (StudentInterface) remoteRegistry.lookup("student");
                        CourseInterface courseRemote = (CourseInterface) remoteRegistry.lookup("course");

                        // Parse the Student XML file
                        DocumentBuilderFactory studentDocumentFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder studentDocumentBuilder = studentDocumentFactory.newDocumentBuilder();
                        Document studentXmlDocument = studentDocumentBuilder.parse("Student.xml");
                        studentXmlDocument.getDocumentElement().normalize();
                        NodeList studentNodes = studentXmlDocument.getElementsByTagName("student");

                        // Iterate through student nodes and add to the server
                        for (int i = 0; i < studentNodes.getLength(); i++) {
                                Node studentNode = studentNodes.item(i);
                                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element studentElement = (Element) studentNode;

                                        int studentId = Integer.parseInt(studentElement.getElementsByTagName("id")
                                                        .item(0).getTextContent());
                                        String studentName = studentElement.getElementsByTagName("name").item(0)
                                                        .getTextContent();
                                        int studentAge = Integer.parseInt(studentElement.getElementsByTagName("age")
                                                        .item(0).getTextContent());
                                        String studentAddress = studentElement.getElementsByTagName("address").item(0)
                                                        .getTextContent();
                                        String studentContactNumber = studentElement
                                                        .getElementsByTagName("contact_number").item(0)
                                                        .getTextContent();

                                        studentRemote.addStudentInfo(studentId, studentName, studentAge, studentAddress,
                                                        studentContactNumber);
                                        studentRemote.insertStudent();
                                }
                        }

                        System.out.println("Successfully Passed The Student Data to Server.");

                        // Parse the Course XML file
                        DocumentBuilderFactory courseDocumentFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder courseDocumentBuilder = courseDocumentFactory.newDocumentBuilder();
                        Document courseXmlDocument = courseDocumentBuilder.parse("Course.xml");
                        courseXmlDocument.getDocumentElement().normalize();
                        NodeList courseNodes = courseXmlDocument.getElementsByTagName("courses");

                        // Iterate through course nodes and add to the server
                        for (int i = 0; i < courseNodes.getLength(); i++) {
                                Node courseNode = courseNodes.item(i);
                                if (courseNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element courseElement = (Element) courseNode;

                                        int courseId = Integer
                                                        .parseInt(courseElement.getElementsByTagName("course_id")
                                                                        .item(0).getTextContent());
                                        int courseStudentId = Integer.parseInt(courseElement
                                                        .getElementsByTagName("student_id").item(0).getTextContent());
                                        String courseTitle = courseElement.getElementsByTagName("course_title").item(0)
                                                        .getTextContent();
                                        String courseDescription = courseElement
                                                        .getElementsByTagName("course_description").item(0)
                                                        .getTextContent();

                                        courseRemote.addCourseInfo(courseId, courseStudentId, courseTitle,
                                                        courseDescription);
                                        courseRemote.insertCourse();
                                }
                        }

                        System.out.println("Successfully Passed the Course Data To Server.");

                } catch (Exception e) {
                        System.out.println("Error (Client): " + e);
                }
        }
}
