package Base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Student extends User implements Serializable {

    protected YearOfStudy yearOfStudy;
    protected Faculty faculty;
    protected ArrayList<Course> courses = new ArrayList<Course>();
    public Student(String name, String surname, String password, YearOfStudy yearOfStudy, Faculty faculty){
        this.name = name;
        this.surname = surname;
        this.yearOfStudy=yearOfStudy;
        this.faculty=faculty;
        this.password=password;
        id = Storage.currID++;
        Storage.students.put(id,this);
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
