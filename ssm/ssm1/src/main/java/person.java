import Annotation.hi;
import Annotation.he;

public class person {

    public String getName() {
        return name;
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public person() {
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
   @hi
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    private String name;
    public int age;

    @hi("zhang")
    @hi("ni")
    String a = "33";



}
