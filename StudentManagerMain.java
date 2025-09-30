import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


public class StudentManagerMain {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       SimpleDB.CreateFile();
        ArrayList<Student> students = SimpleDB.getStudents();
        ArrayList<Instructor> instructors = SimpleDB.loadInstructors();
        ArrayList<Course> courses = SimpleDB.loadCourses();
        ArrayList<Enrollment> enrolls = SimpleDB.loadEnrolls();
        while (true) {
            System.out.println("********************************************************************\n");
            System.out.println(" PRESS 9 TO OPEN GUI. THIS IS AN APP SUITABLE FOR BOTH GUI AND CLI \n");
            System.out.println("********************************************************************\n\n");
            System.out.println("==MENU==");
            System.out.println("1. Add Student");
            System.out.println("2. Add Instructor");
            System.out.println("3. Add Course");
            System.out.println("4. Enroll Student");
            System.out.println("5. Assign Grade");
            System.out.println("6. List all");
            System.out.println("7. Compute CGPA");
            System.out.println("8. Exit");
            System.out.println("9. Open GUI");

            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("Enter Student ID");
                    String id = sc.nextLine();
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Department : ");
                    String department = sc.nextLine();
                    students.add(new Student(id, name, department));
                    System.out.println("Student added successfully");
               }
                    case "2" -> {
                        System.out.println("Enter Instructor ID : ");
                        String instructorID = sc.nextLine();
                        System.out.println("Enter Instructor Name : ");
                        String instructorName = sc.nextLine();
                        System.out.println("Enter Instructor Department : ");
                        String instructorDepartment = sc.nextLine();
                        instructors.add(new Instructor(instructorID, instructorName, instructorDepartment));
                        System.out.println("Instructor added successfully");
               }
                        case "3" -> {
                            System.out.println("Enter Course ID : ");
                            String courseID = sc.nextLine();
                            System.out.println("Enter Course Name : ");
                            String courseName = sc.nextLine();
                            System.out.println("Enter Course Credits : ");
                            String courseCredits = sc.nextLine();
                            System.out.println("Enter Instructor ID: ");
                            String instructorInstructorID = sc.nextLine();
                            courses.add(new Course(courseID,courseName,courseCredits,instructorInstructorID));
                            System.out.println("Course added successfully");
               }
                            case "4" -> {
                                System.out.println("Enter Student ID : ");
                                String studentID = sc.nextLine();
                                System.out.println("Enter Course ID : ");
                                String cc = sc.nextLine();
                                enrolls.add(new Enrollment(studentID,cc,""));
                                System.out.println("Enrollment added successfully");
               }
                                case "5" -> {
                                    System.out.println("STUDENT ID: ");
                                    String sid = sc.nextLine();
                                    System.out.println("Enter Course ID :");
                                    String cid = sc.nextLine();
                                    System.out.println("Enter GRADE : ");
                                    String grade = sc.nextLine();
                                    for(Enrollment e : enrolls) {
                                        if(e.getStudentID().equals(sid) && e.getCourseID().equals(cid)) {
                                            e.setGrades(grade.trim().toUpperCase());

                                        }
                                    }
                                    System.out.println("Grades SET");
               }
                                    case "6" -> {
                                        String out = "Students\n";
                                        for(Student s : students) {
                                            out+= "  -  " + s + "\n" ;
                                            out += "\nInstructors\n" ;

                                        }
                                        for(Instructor i : instructors) out += " - " + i + "\n";
                                        out += "\nCourses\n";
                                        for(Course c : courses) out += " - " + c + "\n";
                                        out += "\nEnrollments\n";
                                        for(Enrollment e : enrolls) out += " - " + e.getStudentID() + " -> " + e.getCourseID() + " [" + (e.getGrades()==null?"":e.getGrades()) + "]\n";
                                        System.out.println(out);
               }
                                        case "7" -> {
                                            System.out.println("Student ID : ");
                                            String st = sc.nextLine();
                                            double g =GPA.cgpaEqualWeight(st,enrolls);
                                            System.out.println("CGPA: " + String.format("%.2f", g));
               }
                                            case "8" -> {
                                                SimpleDB.SaveStudents(students);
                                                SimpleDB.SaveInstructors(instructors);
                                                SimpleDB.SaveCourses(courses);
                                                SimpleDB.saveEnrolls(enrolls);
                                                System.out.println("Saved..Bye!");
                                                System.exit(0);
               }
                                                case "9" -> SwingUtilities.invokeLater(()-> new SimpleGuiApp(students,instructors,courses,enrolls).setVisible(true));



            }
            sc.close();
        }
        
    }
}