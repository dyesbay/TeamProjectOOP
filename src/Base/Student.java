package Base;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements Drive {

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
        if ( !course.students.contains(this) && (course.yearOfStudy == null || course.yearOfStudy==this.yearOfStudy) ) {
            course.students.add(this);
            courses.add(course);
            course.numOfStudents++;
        }
        else System.out.println("You are not allowed in this course");
    }
    public static Student get (int id){
        return Storage.students.get(id);
    }

    public static boolean login (){
        while (true){

            System.out.println("Enter user ID: \n");
            int id = Driver.reader.nextInt();
            System.out.println("Enter password: \n");
            String password = Driver.reader.next();
            if (Storage.students.get(id)!=null){
                System.out.println("not null");
                if (password.equals((Storage.students.get(id)).password))
                    return Storage.students.get(id).drive();
            }
            System.out.println("Incorrect login or password. \n 1) Try again \n 2)Return back \n 3) Exit");
            String s = Driver.reader.next();
            if (s.equals("2")) {
                return false;
            }
            else if (s.equals("3"))
                return true;
        }
    }

    @Override
    public boolean drive() {
        return false;
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
