package Base;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Teacher extends Employee implements Info{
    private Title title;
    private ArrayList<Course> courses= new ArrayList<Course>();

    public Teacher (String name, String surname, String password, Title title){
        super(name, surname, password);
        this.title= title;
        id=Storage.currID++;
        Storage.teachers.put(id,this);
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
        return Storage.teachers.get(id);
    }


    @Override
    public void showInfo() {

    }

    public void setTitle(Title title){
        this.title=title;
    }
    public Title getTitle (){
        return title;
    }
}
