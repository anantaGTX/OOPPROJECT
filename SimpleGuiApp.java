import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class SimpleGuiApp extends JFrame {
    private final ArrayList<Student> students;
    private final ArrayList<Instructor> instructors;
    private final ArrayList<Course> courses;
    private final ArrayList<Enrollment> enrolls;

    SimpleGuiApp(ArrayList<Student> students,
                 ArrayList<Instructor> instructors,
                 ArrayList<Course> courses,
                 ArrayList<Enrollment> enrolls) {
        super("Simple Student Manager (GUI)");
        this.students = students;
        this.instructors = instructors;
        this.courses = courses;
        this.enrolls = enrolls;

        setSize(420, 360);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        buildUI();
    }

    private void buildUI() {
        JPanel panel = new JPanel(new GridLayout(8, 1, 6, 6));
        JButton addStu   = new JButton("Add Student");
        JButton addIns   = new JButton("Add Instructor");
        JButton addCrs   = new JButton("Add Course");
        JButton enrollBt = new JButton("Enroll Student");
        JButton gradeBt  = new JButton("Assign Grade");
        JButton listBt   = new JButton("List All");
        JButton cgpaBt   = new JButton("Compute CGPA");
        JButton saveBt   = new JButton("Save Files");

        panel.add(addStu);
        panel.add(addIns);
        panel.add(addCrs);
        panel.add(enrollBt);
        panel.add(gradeBt);
        panel.add(listBt);
        panel.add(cgpaBt);
        panel.add(saveBt);
        add(panel);
        addStu.addActionListener(e -> {
            String id = JOptionPane.showInputDialog(this, "Student ID:");
            if (id == null) return;
            String nm = JOptionPane.showInputDialog(this, "Name:");
            if (nm == null) return;
            String dp = JOptionPane.showInputDialog(this, "Dept:");
            if (dp == null) return;
            students.add(new Student(id, nm, dp));
            msg("Student added");
        });
        addIns.addActionListener(e -> {
            String id = JOptionPane.showInputDialog(this, "Instructor ID:");
            if (id == null) return;
            String nm = JOptionPane.showInputDialog(this, "Name:");
            if (nm == null) return;
            String dp = JOptionPane.showInputDialog(this, "Dept:");
            if (dp == null) return;
            instructors.add(new Instructor(id, nm, dp));
            msg("Instructor added");
        });

        // --- Add Course ---
        addCrs.addActionListener(e -> {
            String code = JOptionPane.showInputDialog(this, "Course code:");
            if (code == null) return;
            String title = JOptionPane.showInputDialog(this, "Title:");
            if (title == null) return;
            String credits = JOptionPane.showInputDialog(this, "Credits (as text):");
            if (credits == null) return;
            String insId = JOptionPane.showInputDialog(this, "Instructor ID:");
            if (insId == null) return;

            courses.add(new Course(code, title, credits, insId));
            msg("Course added");
        });
        enrollBt.addActionListener(e -> {
            String sid = JOptionPane.showInputDialog(this, "Student ID:");
            if (sid == null) return;
            String code = JOptionPane.showInputDialog(this, "Course code:");
            if (code == null) return;

            enrolls.add(new Enrollment(sid, code, ""));
            msg("Enrolled");
        });

        // --- Assign Grade ---
        gradeBt.addActionListener(e -> {
            String sid = JOptionPane.showInputDialog(this, "Student ID:");
            if (sid == null) return;
            String code = JOptionPane.showInputDialog(this, "Course code:");
            if (code == null) return;
            String g = JOptionPane.showInputDialog(this, "Grade (A, A-, B+, ...):");
            if (g == null) return;

            for (Enrollment en : enrolls) {
                if (sid.equals(en.getStudentID()) && code.equals(en.getCourseID())) {
                    en.setGrades(g.trim().toUpperCase());
                }
            }
            msg("Grade set");
        });
        listBt.addActionListener(e -> {
            String sb = "Students\n";
            for (Student s : students) sb += " - " + s + "\n";
            sb += "\nInstructors\n";
            for (Instructor i : instructors) sb += " - " + i + "\n";
            sb += "\nCourses\n";
            for (Course c : courses) sb += " - " + c + "\n";
            sb += "\nEnrollments\n";
            for (Enrollment en : enrolls) {
                sb += " - " + en.getStudentID() + " -> " + en.getCourseID()  + " [" + (en.getGrades() == null ? "" : en.getGrades()) + "]\n";
            }
            msg(sb);
        });

        cgpaBt.addActionListener(e -> {
            String sid = JOptionPane.showInputDialog(this, "Student ID:");
            if (sid == null) return;
            double g = GPA.cgpaEqualWeight(sid, enrolls);
            msg("CGPA: " + String.format("%.2f", g));
        });

        saveBt.addActionListener(e -> {
            SimpleDB.SaveStudents(students);
            SimpleDB.SaveInstructors(instructors);
            SimpleDB.saveCourses(courses);
            SimpleDB.saveEnrolls(enrolls);
            msg("Saved to files");
        });
    }

    private void msg(String m) {
        JOptionPane.showMessageDialog(this, m);
    }
}
