package Base;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Teacher extends Employee implements Info{
    private Title title;
    private String id;
    private ArrayList<Course> courses= new ArrayList<Course>();
    static private int currID;
    static protected TreeMap<String,Teacher> teachersList = new TreeMap<>();

    public Teacher (String name, String surname, Title title){
        super(name, surname);
        this.title= title;
        id="tchr"+currID;
        currID++;
    }
    public void addCourse(String courseName, Faculty faculty){
        courses.add(new Course(courseName,faculty,this));
    }
    public void addCourseFile (Course course, CourseFile courseFile){
        if (courses.contains(course))
            course.courseFiles.add(courseFile);
        else System.out.println("You have no access to this course.");
    }
    public static Teacher get(String id){
        return teachersList.get(id);
    }


    @Override
    public void showInfo() {

    }
}
