package Week5.src;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student implements Comparable<Student>{

    private final String name;
    private final int age;
    private final Gender gender;
    private final boolean active;
    private final List<Course> courses;

    public Student(String name, int age, Gender gender, boolean active, List<Course> courses) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.active = active;
        this.courses = courses;
    }

    public static Student of(String name, int age, Gender gender, boolean active,Course ... courses){

//        courses.length
        return new Student(name,age,gender,active, Arrays.asList(courses));
    }
//    public static Student of(String name, int age, Gender gender){
//
//        return new Student(name,age,gender,true, Collections.emptyList());
//    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isActive() {
        return active;
    }

    public List<Course> getCourse() {
        return new ArrayList<>(courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", active=" + active +
                ", courses=" + courses +
                '}';
    }

//    @Override
//    public int compareTo(Student o) {
//        return this.age>o.getAge()
//                ?1
//                :this.age<o.getAge()
//                ?-1
//                :0;
//    }    @Override
    public int compareTo(Student o) {
        return Integer.compare(age,o.getAge());
    }
}
