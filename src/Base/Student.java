package Base;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class Student extends Person implements Info {
    private String id;
    private YearOfStudy yearOfStudy;
    private Faculty faculty;
    static SortedMap<Integer,Student> studentsList = new TreeMap<>();
    static private int currID=0;
    protected ArrayList<Course> courses = new ArrayList<Course>();
    public Student(String name, String surname, YearOfStudy yearOfStudy, Faculty faculty){
        this.name = name;
        this.surname = surname;
        this.yearOfStudy=yearOfStudy;
        this.faculty=faculty;
        id = "stud"+currID++;
    }
    public void enroll (Course course){
        if (course.yeadOfStudy == null || course.yeadOfStudy==this.yearOfStudy ) {
            course.students.add(this);
            courses.add(course);
        }
        else System.out.println("You are not allowed in this course");
    }
    public static Student get (String id){
        return studentsList.get(id);
    }

    @Override
    public void showInfo() {

    }
}
