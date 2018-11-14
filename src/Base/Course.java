package Base;

import java.util.ArrayList;
import java.util.TreeMap;

public class Course {
    private String name;
    private int id;
    private int numOfStudents;
    private Faculty faculty;
    protected YearOfStudy yeadOfStudy;
    private Teacher teacher;
    protected ArrayList<Student> students = new ArrayList<Student>();
    static private int currID;
    static protected TreeMap<String,Course> courses = new TreeMap<>();
    protected ArrayList<CourseFile> courseFiles = new ArrayList<>();
    protected ArrayList<Mark> marks;
    public Course(String name, Faculty faculty, Teacher teacher){
        this.name=name;
        this.faculty=faculty;
        this.teacher=teacher;
        id = currID++;
    }
    public static Course get (String id){
        return courses.get(id);
    }

}
