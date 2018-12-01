package Base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Teacher extends Employee implements Drive, Serializable {
    private Title title;
    private ArrayList<Course> courses= new ArrayList<Course>();

    public Teacher (String name, String surname, String password, Title title){
        super(name, surname, password);
        this.title= title;
        id=Storage.currID++;
        Storage.teachers.put(id,this);
    }

    public static Teacher get(String id){
        return Storage.teachers.get(id);
    }


    public static boolean login (){
        while (true){

            System.out.println("Enter user ID: \n");
            int id = Driver.reader.nextInt();
            System.out.println("Enter password: \n");
            String password = Driver.reader.next();
            if (Storage.teachers.get(id)!=null){
                if (password.equals((Storage.teachers.get(id)).password))
                    return Storage.teachers.get(id).drive();
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
            System.out.println("Hello, " + this.name + "! You are logged in as teacher. \n 1) Add course \n 2) View courses \n 3) View students \n 4) Send order \n  5) Change password \n 6) Logout \n 7) Exit ");
            int n = Driver.reader.nextInt();
            switch (n) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    viewCourses();
                    break;
                case 3:
                    viewStudents();
                    break;
                case 4:
                    sendOrder();
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


    public void addCourse (){
        System.out.println("Set a name for a course:");
        String name = Driver.reader.next();
        System.out.println("Give a course description:");
        String description = Driver.reader.next();
        courses.add(new Course(name, description, this));
        System.out.println("Course added!");

    }
    public void viewCourses (){
        while (true) {
            System.out.println("Your courses: ");
            for (int j = 0; j < courses.size(); j++) {
                System.out.println((j + 1) + ") " + courses.get(j).getName());
            }
            System.out.println((courses.size() + 1) + ") Back");
            Scanner reader = new Scanner(System.in);
            int n = reader.nextInt();
            n--;
            if (n < courses.size()) {
                courses.get(n).manage();
            }
            else break;
        }
    }
    public void viewStudents () {
        while (true) {
            System.out.println("Choose a course: ");
            for (int j = 0; j < courses.size(); j++) {
                System.out.println((j + 1) + ") " + courses.get(j).getName());
            }
            System.out.println((courses.size() + 1) + ") Back");
            int n = Driver.reader.nextInt();
            if (n <= courses.size()) {
                courses.get(n-1).showStudents();
            }
            else break;
        }
    }
    public void sendOrder (){
        System.out.println("Give an order subject:");
        String subject = Driver.reader.next();
        System.out.println("Enter your order:");
        String text = Driver.reader.next();
        Storage.pendingOrders.add(new Order(this,subject, text));
        System.out.println("Order sent!");

    }

    @Override
    public String toString() {
        return (title+super.toString());
    }

    public void setTitle(Title title){
        this.title=title;
    }
    public Title getTitle (){
        return title;
    }
}
