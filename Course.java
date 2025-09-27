public class Course {
    private String courseID;
    private String Title;
    private String credits;
    private String FacultyName;
    public Course(String code, String Title, String credits, String FacultyName) {
        this.courseID = code;
        this.Title = Title;
        this.credits = credits; // no parsing
        this.FacultyName = FacultyName;
    }
    public String getCourseID() {
        return courseID;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;

    }
    public String getCredits() {
        return credits;
    }
    public void setCredits(String credits) {
        this.credits = credits;
    }
    public String getFacultyName() {
        return FacultyName;
    }
    public void setFacultyName(String FacultyName) {
        this.FacultyName = FacultyName;
    }
    @Override
    public String toString() {
        return courseID +","+Title+","+credits+","+FacultyName;

    }
}
