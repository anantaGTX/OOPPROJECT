abstract class Person{
    private String id;
    private String name;
    private String dept;
    Person(String id, String name, String dept){
        this.id = id;
        this.name = name;
        this.dept = dept;
    }
    public String getId(){
        return id;

    }
    public String getName(){
        return name;
    }
    public String getDept(){
        return dept;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDept(String dept){
        this.dept = dept;

    }
    public abstract String role();
    @Override
    public String toString(){
        return "Person{" + "id=" + id + ", name=" + name + ", dept=" + dept + '}';
    }

}