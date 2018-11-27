package Base;

import java.util.ArrayList;
import java.util.TreeMap;

public class Course {
    private String name;
    private int id;
    protected int numOfStudents;
    private Faculty faculty;
    protected YearOfStudy yeadOfStudy;
    private Teacher teacher;
    protected ArrayList<Student> students = new ArrayList<Student>();
    protected ArrayList<CourseFile> courseFiles = new ArrayList<>();
    protected ArrayList<Mark> marks;
    public Course(String name, Faculty faculty, Teacher teacher){
        this.name=name;
        this.faculty=faculty;
        this.teacher=teacher;
        id = Storage.currCourseID++;
    }
    public static Course get (String id){
        return Storage.courses.get(id);
    }

}
