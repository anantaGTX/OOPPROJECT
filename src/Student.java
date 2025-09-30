public class Student extends Person {
    Student(String id,String name,String dept) {
        super(id,name,dept);

    }
    @Override
    public String role() {
        return "Student";
    }

}
