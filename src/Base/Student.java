package Base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Student extends User implements Drive, Serializable {

    private YearOfStudy yearOfStudy;
    private Faculty faculty;
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
    public void register (){
        System.out.println("Select subject: ");
        ArrayList<Course> courseArrayList = new ArrayList<>();
        for (Map.Entry<Integer,Course> entry : Storage.activeCourses.entrySet()){
            if (this.faculty==entry.getValue().getFaculty() && this.yearOfStudy==entry.getValue().getYearOfStudy())
                courseArrayList.add(entry.getValue());
        }
        while (true) {
            for (int j = 0; j < courseArrayList.size(); j++) {
                System.out.println((j + 1) + ") " + courseArrayList.get(j).getName());
            }
            System.out.println((courseArrayList.size() + 1) + ") Back");
            int n = Driver.reader.nextInt();
            n--;
            if (n < courseArrayList.size()) {
                System.out.println(courseArrayList.get(n) + "\n1) Register for course \n2)Back");
                int k = Driver.reader.nextInt();
                if (k==1) {
                    courses.add(courseArrayList.get(n));
                    courseArrayList.get(n).students.add(this);
                    courseArrayList.get(n).numOfStudents++;
                    break;
                }


            }
            else break;
        }
    }
    public void viewMarks(){
        while (true) {
            for (int j = 0; j < courses.size(); j++) {
                System.out.println((j + 1) + ") " + courses.get(j).getName());
            }
            System.out.println((courses.size() + 1) + ") Back");
            int n = Driver.reader.nextInt();
            n--;
            if (n < courses.size()) {
                Course course = courses.get(n);
                System.out.println("Your marks for subject " + course.getName() + " are:");
                for (Mark m : course.marks) {
                    if (this == m.getStudent()) {
                        System.out.println(m.getValue());
                    }
                }
                System.out.println("1) Back");
                int k = Driver.reader.nextInt();
            }
            else break;
        }
    }
    public void viewFiles(){
        while (true) {
            for (int j = 0; j < courses.size(); j++) {
                System.out.println((j + 1) + ") " + courses.get(j).getName());
            }
            System.out.println((courses.size() + 1) + ") Back");
            int n = Driver.reader.nextInt();
            n--;
            if (n < courses.size()) {
                Course course = courses.get(n);
                System.out.println("Course files:");
                for (int j = 0; j < course.courseFiles.size(); j++) {
                    System.out.println((j + 1) + ") " + course.courseFiles.get(j).getName());
                }
                System.out.println("1) Back");
                int k = Driver.reader.nextInt();
                k--;
                if(k<course.courseFiles.size()){
                    course.courseFiles.get(k);
                }
            }
            else break;
        }
    }
    public void viewTeacher(){
        while (true) {
            for (int j = 0; j < courses.size(); j++) {
                System.out.println((j + 1) + ") " + courses.get(j).getName());
            }
            System.out.println((courses.size() + 1) + ") Back");
            int n = Driver.reader.nextInt();
            n--;
            if (n < courses.size()) {
                Course course = courses.get(n);
                System.out.println(course.getTeacher());
                System.out.println("1) Back");
                int k = Driver.reader.nextInt();
            }
            else break;
        }
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
        while (true) {
            System.out.println("Hello, " + this.name + "! You are logged in as student. \n 1) Register for course \n 2) View marks \n 3) View files \n 4) View Teacher \n  5) Change password \n 6) Logout \n 7) Exit ");
            int n = Driver.reader.nextInt();
            switch (n) {
                case 1:
                    register();
                    break;
                case 2:
                    viewMarks();
                    break;
                case 3:
                    viewFiles();
                    break;
                case 4:
                    viewTeacher();
                    break;
                case 5:
                    changePassword();
                    break;
                case 6:
                    return false;
                case 7:
                    return true;

            }
        }
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
