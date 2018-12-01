package Base;

import java.util.*;
import java.io.*;

public class Driver {
    Storage storage = new Storage();
    public static Scanner reader = new Scanner(System.in);

    protected static String defaultPassword = "12345";

    public static void startPage (){

        boolean end = false;
        while (!end) {
            System.out.println("Welcome to intranet. \n Login as: \n 1) Admin \n 2) Manager\n 3) Teacher  \n 4) Executor  \n 5) Student ");
            String s = reader.next();
            switch (s) {
                case "1":
                    end=adminLogin();
                        break;
                case "2":
                    end =managerLogin();
                    break;
                case "3":
                    end=teacherLogin();
                    break;
                case "4":
                    end=executorLogin();
                    break;
                case "5":
                    end=studentLogin();
                    break;
                case "6":
                    end = true;
                    break;
            }
        }

    }

    //Admin functions
    public static boolean adminLogin (){
        Scanner reader = new Scanner(System.in);
        while (true){

            System.out.println("Enter user ID: \n");
            int id = reader.nextInt();
            System.out.println("Enter password: \n");
            String password = reader.next();
            if (Storage.admins.get(id)!=null){
                if (password.equals((Storage.admins.get(id)).password))
                    return adminDrive(id);
            }
            System.out.println("Incorrect login or password. \n 1) Try again \n 2)Return back \n 3) Exit");
            String s = reader.next();
            if (s.equals("2")) {
                return false;
            }
            else if (s.equals("3"))
                return true;
        }
    }
    public static boolean adminDrive(int id){

        while(true){
            System.out.println("You are logged in as admin. \n 1) Add user \n 2) Show users  \n 3) Change password \n 4) Logout \n 5) Exit  ");


            Scanner reader = new Scanner(System.in);
            int n = reader.nextInt();
            if (n==1)
                addUser();
            if (n==3)
                changePassword(Storage.admins.get(id));
            if (n==4)
                return false;
            if (n==5)
                return true;
            if (n==2){
                showUsers();
            }
        }
    }
    public static void showUsers(){
        System.out.println("Admins:");
        for (Map.Entry<Integer,Admin> entry: Storage.admins.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getSurname());
        }
        System.out.println("Managers:");
        for (Map.Entry<Integer,Manager> entry: Storage.managers.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getSurname());
        }
        System.out.println("Teachers:");
        for (Map.Entry<Integer,Teacher> entry: Storage.teachers.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getSurname());
        }
        System.out.println("Executors:");
        for (Map.Entry<Integer,Executor> entry: Storage.executors.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getSurname());
        }
        System.out.println("Students:");
        for (Map.Entry<Integer,Student> entry: Storage.students.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getSurname());
        }
    }
    public static void addUser (){
        Scanner reader = new Scanner(System.in);
        System.out.println("Who do you want to add? \n 1) Admin \n 2)Manager \n 3) Teacher \n 4) Executor \n 5) Student" );
        int k = reader.nextInt();
        System.out.println("Enter name");
        String name = reader.next();
        System.out.println("Enter surname");
        String surname = reader.next();
        if (k==1)
            new Admin(name,surname,Driver.defaultPassword);
        if (k==2)
            new Manager(name,surname,Driver.defaultPassword);

        if (k==3){
            System.out.println("Enter title: \n 1) Tutor \n 2) Lector \n 3) Senior Lector \n 4) Professor");
            int tit = reader.nextInt();
            Title title = Title.TUTOR ;
            if (tit==1)
                title= Title.TUTOR;
            if (tit==2)
                title= Title.LECTOR;
            if (tit==3)
                title= Title.SENIOR_LECTOR;
            if (tit==4)
                title= Title.PROFESSOR;
            new Teacher(name, surname, Driver.defaultPassword, title);
        }
        if (k==4)
            new Executor(name,surname,Driver.defaultPassword);

        if (k==5){
            System.out.println("Enter faculty: \n 1) FIT \n 2) BS \n 3) KMA \n 4) MCM");
            int fac = reader.nextInt();
            Faculty faculty = Faculty.FIT;
            if (fac == 1)
                faculty = Faculty.FIT;
            if (fac == 2)
                faculty = Faculty.BS;
            if (fac == 3)
                faculty = Faculty.KMA;
            if (fac == 4)
                faculty = Faculty.MCM;
            System.out.println("Enter year of study: \n 1) Bachelor 1st year \n 2) Bachelor 2nd year \n 3) Bachelor 3rd year \n 4) Bachelor 4th year \n 5) Master 1st year \n 6) Master 2nd year ");
            int yos = reader.nextInt();
            YearOfStudy yearOfStudy = YearOfStudy.BACHELOR_1;

            if (yos==1)
                yearOfStudy=YearOfStudy.BACHELOR_1;
            if (yos==2)
                yearOfStudy=YearOfStudy.BACHELOR_2;
            if (yos==3)
                yearOfStudy=YearOfStudy.BACHELOR_3;
            if (yos==4)
                yearOfStudy=YearOfStudy.BACHELOR_4;
            if (yos==5)
                yearOfStudy=YearOfStudy.MASTER_1;
            if (yos==6)
                yearOfStudy=YearOfStudy.MASTER_2;

            new Student(name, surname, Driver.defaultPassword, yearOfStudy, faculty);

        }
    }
    public static void changePassword(User user){
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your password:");
            String password = reader.next();
            if (user.password.equals(password)){
                System.out.println("Enter your password:");
                String newPassword = reader.next();
                user.password=newPassword;
                System.out.println("Password successfully changed!");
                break;
            }
            System.out.println("Wrong password! \n1) Try again \n2) Back");
            int n = reader.nextInt();
            if (n==2)
                break;
        }
    }

    //Student functions
    public static boolean studentLogin (){
        while (true){

            System.out.println("Enter user ID: \n");
            int id = Driver.reader.nextInt();
            System.out.println("Enter password: \n");
            String password = Driver.reader.next();
            if (Storage.students.get(id)!=null){
                if (password.equals((Storage.students.get(id)).password))
                    return studentDrive(id);
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
    public static boolean studentDrive (int id) {
        while (true) {
            Student student = Storage.students.get(id);
            System.out.println("Hello, " + student.name + "! You are logged in as student. \n 1) Register for course \n 2) View marks \n 3) View files \n 4) View Teacher \n  5) Change password \n 6) Logout \n 7) Exit ");
            int n = Driver.reader.nextInt();
            switch (n) {
                case 1:
                    register(student);
                    break;
                case 2:
                    viewMarks(student);
                    break;
                case 3:
                    viewFiles(student);
                    break;
                case 4:
                    viewTeacher(student);
                    break;
                case 5:
                    changePassword(student);
                    break;
                case 6:
                    return false;
                case 7:
                    return true;

            }
        }
    }
    public static void register (Student student){
        System.out.println("Select subject: ");
        ArrayList<Course> courseArrayList = new ArrayList<>();
        for (Map.Entry<Integer,Course> entry : Storage.activeCourses.entrySet()){
            if (student.faculty==entry.getValue().getFaculty() && student.yearOfStudy==entry.getValue().getYearOfStudy())
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
                    student.courses.add(courseArrayList.get(n));
                    courseArrayList.get(n).students.add(student);
                    courseArrayList.get(n).numOfStudents++;
                    break;
                }


            }
            else break;
        }
    }
    public static void viewMarks(Student student){
        while (true) {
            for (int j = 0; j < student.courses.size(); j++) {
                System.out.println((j + 1) + ") " + student.courses.get(j).getName());
            }
            System.out.println((student.courses.size() + 1) + ") Back");
            int n = Driver.reader.nextInt();
            n--;
            if (n < student.courses.size()) {
                Course course = student.courses.get(n);
                System.out.println("Your marks for subject " + course.getName() + " are:");
                for (Mark m : course.marks) {
                    if (student == m.getStudent()) {
                        System.out.println(m.getValue());
                    }
                }
                System.out.println("1) Back");
                int k = Driver.reader.nextInt();
            }
            else break;
        }
    }
    public static void viewFiles(Student student){
        while (true) {
            for (int j = 0; j < student.courses.size(); j++) {
                System.out.println((j + 1) + ") " +  student.courses.get(j).getName());
            }
            System.out.println((student.courses.size() + 1) + ") Back");
            int n = Driver.reader.nextInt();
            n--;
            if (n < student.courses.size()) {
                Course course = student.courses.get(n);
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
    public static void viewTeacher(Student student){
        while (true) {
            for (int j = 0; j < student.courses.size(); j++) {
                System.out.println((j + 1) + ") " + student.courses.get(j).getName());
            }
            System.out.println((student.courses.size() + 1) + ") Back");
            int n = Driver.reader.nextInt();
            n--;
            if (n < student.courses.size()) {
                Course course = student.courses.get(n);
                System.out.println(course.getTeacher());
                System.out.println("1) Back");
                int k = Driver.reader.nextInt();
            }
            else break;
        }
    }

    //Executor functions
    public static boolean executorLogin (){
        Scanner reader = new Scanner(System.in);
        while (true){

            System.out.println("Enter user ID: \n");
            int id = reader.nextInt();
            System.out.println("Enter password: \n");
            String password = reader.next();
            if (Storage.executors.get(id)!=null){
                if (password.equals((Storage.executors.get(id)).password))
                    return executorDrive(id);
            }
            System.out.println("Incorrect login or password. \n 1) Try again \n 2)Return back \n 3) Exit");
            String s = reader.next();
            if (s.equals("2")) {
                return false;
            }
            else if (s.equals("3"))
                return true;
        }
    }
    public static boolean executorDrive(int id) {
        while(true){
            Executor executor = Storage.executors.get(id);
            System.out.println("Hello, " + executor.name + ". You are logged in as executor. \n 1) View orders \n 2) Change password \n 3) Logout \n 4) Exit ");


            Scanner reader = new Scanner(System.in);
            int n = reader.nextInt();
            if (n==1)
                viewOrders();
            if (n==2)
                changePassword(executor);
            if (n==3)
                return false;
            if (n==4)
                return true;
        }
    }
    public static void viewOrders (){
        while(true) {
            for (int j = 0; j < Storage.pendingOrders.size(); j++) {
                System.out.println((j + 1) + ") " + Storage.pendingOrders.get(j).getSubject());
            }
            System.out.println((Storage.pendingOrders.size() + 1) + ") Back");
            int n = Driver.reader.nextInt();
            if (n==Storage.pendingOrders.size()+1)
                break;
            if (n <= Storage.pendingOrders.size()) {
                System.out.println(Storage.pendingOrders.get(n-1));
                System.out.println("1) Accept order \n 2)Back");
                int k = Driver.reader.nextInt();
                if (k == 1) {
                    Storage.doneOrders.add(Storage.pendingOrders.get(n-1));
                    Storage.pendingOrders.remove(n);
                    break;
                }


            }
        }
    }

    //Manager functions
    public static boolean managerLogin (){
        Scanner reader = new Scanner(System.in);
        while (true){

            System.out.println("Enter user ID: \n");
            int id = reader.nextInt();
            System.out.println("Enter password: \n");
            String password = reader.next();
            if (Storage.managers.get(id)!=null){
                if (password.equals((Storage.managers.get(id)).password))
                    return managerDrive(id);
            }
            System.out.println("Incorrect login or password. \n 1) Try again \n 2)Return back \n 3) Exit");
            String s = reader.next();
            if (s.equals("2")) {
                return false;
            }
            else if (s.equals("3"))
                return true;
        }
    }
    public static boolean managerDrive(int id) {
        Manager manager = Storage.managers.get(id);
        while(true){
            System.out.println("Hello, " + manager + ". You are logged in as manager. \n 1) Add course for registration \n   2) Change password \n 3) Logout \n 4) Exit ");


            Scanner reader = new Scanner(System.in);
            int n = reader.nextInt();
            if (n==1)
                addCourseForReg();
            if (n==2)
                changePassword(manager);
            if (n==3)
                return false;
            if (n==4)
                return true;
        }
    }
    public static void addCourseForReg(){
        ArrayList<Map.Entry<Integer,Course>> arl = new ArrayList<>();
        arl.addAll(Storage.pendingCourses.entrySet());
        for (int j = 0; j < arl.size(); j++) {
            System.out.println((j + 1) + ") " + arl.get(j).getValue().getName());
        }
        System.out.println((arl.size() + 1) + ") Back");
        int n = Driver.reader.nextInt();
        n--;
        if (n < arl.size()) {
            System.out.println("Enter faculty: \n 1) FIT \n 2) BS \n 3) KMA \n 4) MCM");
            int fac = Driver.reader.nextInt();
            Faculty faculty = Faculty.FIT;
            if (fac == 1)
                faculty = Faculty.FIT;
            if (fac == 2)
                faculty = Faculty.BS;
            if (fac == 3)
                faculty = Faculty.KMA;
            if (fac == 4)
                faculty = Faculty.MCM;
            System.out.println("Enter year of study: \n 1) Bachelor 1st year \n 2) Bachelor 2nd year \n 3) Bachelor 3rd year \n 4) Bachelor 4th year \n 5) Master 1st year \n 6) Master 2nd year ");
            int yos = Driver.reader.nextInt();
            YearOfStudy yearOfStudy = YearOfStudy.BACHELOR_1;

            if (yos==1)
                yearOfStudy=YearOfStudy.BACHELOR_1;
            if (yos==2)
                yearOfStudy=YearOfStudy.BACHELOR_2;
            if (yos==3)
                yearOfStudy=YearOfStudy.BACHELOR_3;
            if (yos==4)
                yearOfStudy=YearOfStudy.BACHELOR_4;
            if (yos==5)
                yearOfStudy=YearOfStudy.MASTER_1;
            if (yos==6)
                yearOfStudy=YearOfStudy.MASTER_2;
            arl.get(n).getValue().setFaculty(faculty);
            arl.get(n).getValue().setYearOfStudy(yearOfStudy);
            Storage.activeCourses.put(arl.get(n).getKey(),arl.get(n).getValue());
            Storage.pendingCourses.remove(arl.get(n).getKey());
        }

    }

    //Teacher functions
    public static boolean teacherLogin (){
        while (true){

            System.out.println("Enter user ID: \n");
            int id = Driver.reader.nextInt();
            System.out.println("Enter password: \n");
            String password = Driver.reader.next();
            if (Storage.teachers.get(id)!=null){
                if (password.equals((Storage.teachers.get(id)).password))
                    return teacherDrive(id);
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
    public static boolean teacherDrive(int id) {
        Teacher teacher = Storage.teachers.get(id);
        while (true) {

            System.out.println("Hello, " + teacher.name + "! You are logged in as teacher. \n 1) Add course \n 2) View courses \n 3) View students \n 4) Send order \n  5) Change password \n 6) Logout \n 7) Exit ");
            int n = Driver.reader.nextInt();
            switch (n) {
                case 1:
                    addCourse(teacher);
                    break;
                case 2:
                    viewCourses(teacher);
                    break;
                case 3:
                    viewStudents(teacher);
                    break;
                case 4:
                    sendOrder(teacher);
                    break;
                case 5:
                    changePassword(teacher);
                    break;
                case 6:
                    return false;
                case 7:
                    return true;

            }
        }

    }
    public static void addCourse (Teacher teacher){
        System.out.println("Set a name for a course:");
        String name = Driver.reader.next();
        System.out.println("Give a course description:");
        String description = Driver.reader.next();
        teacher.courses.add(new Course(name, description, teacher));
        System.out.println("Course added!");

    }
    public static void viewCourses (Teacher teacher){
        while (true) {
            System.out.println("Your courses: ");
            for (int j = 0; j < teacher.courses.size(); j++) {
                System.out.println((j + 1) + ") " + teacher.courses.get(j).getName());
            }
            System.out.println((teacher.courses.size() + 1) + ") Back");
            Scanner reader = new Scanner(System.in);
            int n = reader.nextInt();
            n--;
            if (n < teacher.courses.size()) {
                teacher.courses.get(n).manage();
            }
            else break;
        }
    }
    public static void viewStudents ( Teacher teacher) {
        while (true) {
            System.out.println("Choose a course: ");
            for (int j = 0; j < teacher.courses.size(); j++) {
                System.out.println((j + 1) + ") " + teacher.courses.get(j).getName());
            }
            System.out.println((teacher.courses.size() + 1) + ") Back");
            int n = Driver.reader.nextInt();
            if (n <= teacher.courses.size()) {
                teacher.courses.get(n-1).showStudents();
            }
            else break;
        }
    }
    public static void sendOrder (Teacher teacher){
        System.out.println("Give an order subject:");
        String subject = Driver.reader.next();
        System.out.println("Enter your order:");
        String text = Driver.reader.next();
        Storage.pendingOrders.add(new Order(teacher,subject, text));
        System.out.println("Order sent!");

    }


    public static void main (String[] args){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat")))
        {
            NonStaticStorage nonStaticStorage=(NonStaticStorage) ois.readObject();
            Storage.currID = nonStaticStorage.currID;
            Storage.currCourseID = nonStaticStorage.currCourseID;
            Storage.currOrderID = nonStaticStorage.currOrderID;
            Storage.students =  nonStaticStorage.students;
            Storage.teachers = nonStaticStorage.teachers;
            Storage.executors = nonStaticStorage.executors;
            Storage.admins = nonStaticStorage.admins;
            Storage.managers = nonStaticStorage.managers;
            Storage.activeCourses = nonStaticStorage.activeCourses;
            Storage.pendingCourses = nonStaticStorage.pendingCourses;
            Storage.pendingOrders = nonStaticStorage.pendingOrders;
            Storage.doneOrders = nonStaticStorage.doneOrders;

            ois.close();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        Admin user = new Admin("dias", "yesbay", "asd");
        showUsers();
        startPage();

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat")))
        {
            NonStaticStorage nonStaticStorage = new NonStaticStorage();
            oos.writeObject(nonStaticStorage);
            oos.flush();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
