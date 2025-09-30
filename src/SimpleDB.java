import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class SimpleDB {
    static String STUDENTS = "students.txt";
    static String INSTRUCTORS = "instructors.txt";
    static String COURSES = "courses.txt";
    static String ENROLLS = "enrollments.txt";
    static void CreateFile() {
        try {
            new File(STUDENTS).createNewFile();
            new File(INSTRUCTORS).createNewFile();
            new File(COURSES).createNewFile();
            new File(ENROLLS).createNewFile();
        }catch(IOException e) {
            System.out.println("File ERROR! TRY AGAIN..");

        }
    }
    static ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(STUDENTS));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                if(data.length>=3) students.add(new Student(data[0],data[1],data[2]));
            }
            sc.close();
        }catch(FileNotFoundException e) {

        }
        return students;
    }
    static void SaveStudents(ArrayList<Student> students) {
        try{
            FileWriter fw = new FileWriter(STUDENTS);
            for(Student student : students) {
                fw.write(student.getId() + "," + student.getName() + "," + student.getDept()+"\n");
            }
            fw.close();
        }catch(IOException e) {
            System.out.println("Couldn't Save Students");
        }

    }
    static ArrayList<Instructor> loadInstructors() {
        ArrayList<Instructor> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(INSTRUCTORS));
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(",");
                if (p.length >= 3) list.add(new Instructor(p[0], p[1], p[2]));
            }
            sc.close();
        } catch (Exception e) {}
        return list;
    }

    static void SaveInstructors(ArrayList<Instructor> instructors) {
        try {
            FileWriter fw= new FileWriter(INSTRUCTORS);
            for(Instructor instructor : instructors) {
                fw.write(instructor.getId()+","+instructor.getName()+","+instructor.getDept()+"\n");
            }
            fw.close();
        }catch(IOException e) {
            System.out.println("Couldn't Save Instructors");
        }
    }
    static void SaveCourses(ArrayList<Course> courses) {
        ArrayList<Course> courses1 = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(COURSES));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                   if(data.length>=4) {
                       courses1.add(new Course(data[0], data[1], data[2], data[3]));

                   }
                   sc.close();
            }
        }catch (Exception e) {
            System.out.println("Couldn't Save Courses");
        }
    }
    static ArrayList<Course> loadCourses(){
        ArrayList<Course> list=new ArrayList<>();
        try{ Scanner sc=new Scanner(new File(COURSES));
            while(sc.hasNextLine()){
                String[] p=sc.nextLine().split(",");
                if(p.length>=4) list.add(new Course(p[0],p[1],p[2],p[3]));
            } sc.close(); }
        catch(Exception e){
            System.out.println("Couldn't Load Courses");
        } return list; }
     static void saveCourses(ArrayList<Course> list){
        try{
            FileWriter fw=new FileWriter(COURSES);
         for(Course c:list) fw.write(c.getCourseID()+","+c.getTitle()+","+c.getCredits()+","+c.getFacultyName()+"\n"); fw.close();
     }catch(Exception e)
     { System.out.println("saveCourses error"); }
    }
    static ArrayList<Enrollment> loadEnrolls() {
        ArrayList<Enrollment> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(ENROLLS));
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(",");
                if (p.length >= 3) list.add(new Enrollment(p[0], p[1], p[2]));
            }
            sc.close();
        } catch (Exception e) {}
        return list;
    }

    static void saveEnrolls(ArrayList<Enrollment> list) {
        try {
            FileWriter fw = new FileWriter(ENROLLS);
            for (Enrollment e : list) {
                String g = (e.getGrades() == null ? "" : e.getGrades());
                fw.write(e.getStudentID() + "," + e.getCourseID() + "," + g + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("saveEnrolls error");
        }
    }


}