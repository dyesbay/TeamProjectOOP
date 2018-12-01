package Base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Course implements Serializable {
    private String name;
    private String description;
    private int id;
    protected int numOfStudents=0;
    private Faculty faculty;
    protected YearOfStudy yearOfStudy;
    private Teacher teacher;
    protected ArrayList<Student> students = new ArrayList<Student>();
    protected ArrayList<CourseFile> courseFiles = new ArrayList<>();
    protected ArrayList<Mark> marks;

    public Course(String name, String description, Teacher teacher){
        this.name=name;
        this.description=description;
        this.faculty=Faculty.NOT_SET;
        this.yearOfStudy=YearOfStudy.NOT_SET;
        this.teacher=teacher;
        marks=new ArrayList<>();
        id = Storage.currCourseID++;
        Storage.pendingCourses.put(id,this);
    }
    public void manage (){
        boolean end = false;
        while (!end) {
            System.out.println(name + ". \n 1) Information about course \n 2) Add course file \n 3) Delete course file \n 4) Put mark \n  5) Back");
            int n = Driver.reader.nextInt();
            switch (n) {
                case 1: {
                    System.out.println(this + "\n 1) Back");
                    int k = Driver.reader.nextInt();
                    break;
                }
                case 2:
                    addCourseFile();
                    break;
                case 3:
                    deleteCourseFile();
                    break;
                case 4:
                    putMark();
                    break;
                case 5:
                    end = true;
                    break;

            }
        }
    }
    public boolean addCourseFile (){
        System.out.println("Set a name for a course:");
        String name = Driver.reader.next();
        for (int i = 0; i< courseFiles.size(); i++){
            if (courseFiles.get(i).getName().equals(name)){
                System.out.println("File with such name already exists!");
                return false;
            }
        }
        courseFiles.add(new CourseFile(name));
        System.out.println("File successfully added");
        return true;

    }
    public void deleteCourseFile (){
        System.out.println("Select file for deletion: ");
        for (int j = 0; j < courseFiles.size(); j++) {
            System.out.println((j + 1) + ") " + courseFiles.get(j).getName());
        }
        System.out.println((courseFiles.size() + 1) + ") Back");
        int n = Driver.reader.nextInt();
        if (n <= courseFiles.size()) {
            courseFiles.remove(n-1);
            System.out.println("File deleted");
        }

    }
    public void putMark (){
        System.out.println("Select student : ");
        for (int j = 0; j < students.size(); j++) {
            System.out.println((j + 1) + ") " + students.get(j).getName());
        }
        System.out.println((students.size() + 1) + ") Back");
        int n = Driver.reader.nextInt();
        n--;
        if (n < students.size()) {
            System.out.println("Enter the mark: ");
            double value = Driver.reader.nextDouble();
            marks.add(new Mark(value,students.get(n), this));
        }
    }
    public void showStudents (){

    }
    @Override
    public String toString (){
        return " Course name: " + name + "\n Teacher: " + teacher.getName() + " " + teacher.getSurname() + ". \n Number of students: " + numOfStudents + ".\n Course description: " + description ;

    }

    public boolean equals(Course course) {
        return (this.name.equals(course.getName()) && this.yearOfStudy==course.getYearOfStudy() && this.faculty == course.getFaculty());
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public YearOfStudy getYearOfStudy() {
        return yearOfStudy;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public void setYearOfStudy(YearOfStudy yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

}
