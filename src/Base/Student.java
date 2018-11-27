package Base;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class Student extends User implements Info {

    private YearOfStudy yearOfStudy;
    private Faculty faculty;
    protected ArrayList<Course> courses = new ArrayList<Course>();
    public Student(String name, String surname, String password, YearOfStudy yearOfStudy, Faculty faculty){
        this.name = name;
        this.surname = surname;
        this.yearOfStudy=yearOfStudy;
        this.faculty=faculty;
        id = Storage.currID++;
        Storage.students.put(id,this);
    }
    public void enroll (Course course){
        if ( !course.students.contains(this) && (course.yeadOfStudy == null || course.yeadOfStudy==this.yearOfStudy) ) {
            course.students.add(this);
            courses.add(course);
            course.numOfStudents++;
        }
        else System.out.println("You are not allowed in this course");
    }
    public static Student get (int id){
        return Storage.students.get(id);
    }

    @Override
    public void showInfo() {

    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setYearOfStudy(YearOfStudy yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public YearOfStudy getYearOfStudy() {
        return yearOfStudy;
    }
}
