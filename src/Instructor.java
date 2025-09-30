public class Instructor extends Person {
    Instructor(String id,String name,String dept) {
        super(id,name,dept);

    }
    @Override
    public String role() {
        return "Instructor";
    }

}