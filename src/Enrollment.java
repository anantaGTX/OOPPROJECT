public class Enrollment {
    public String StudentID;
    public String courseID;
    public String grades;
    Enrollment(String studentID, String courseID, String grades) {
        this.StudentID = studentID;
        this.courseID = courseID;
        this.grades = grades;
    }
    public String getStudentID() {
        return StudentID;
    }
    public String getCourseID() {
        return courseID;
    }
    public String getGrades() {
        return grades;
    }
    public void setStudentID(String studentID) {
        StudentID = studentID;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public void setGrades(String grades) {
        this.grades = grades;
    }
}
