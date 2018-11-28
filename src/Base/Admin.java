package Base;

import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Admin extends Employee implements Drive, Serializable {
    public Admin (String name, String surname, String password){
        super(name, surname, password);
//        id=Storage.currID++;
        this.id=Storage.currID++;
        Storage.admins.put(id,this);
    }
    public void addUser (){
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
    public static boolean login (){
        Scanner reader = new Scanner(System.in);
        while (true){

            System.out.println("Enter user ID: \n");
            int id = reader.nextInt();
            System.out.println("Enter password: \n");
            String password = reader.next();
            if (Storage.admins.get(id)!=null){
                System.out.println("not null");
                if (password.equals((Storage.admins.get(id)).password))
                    return Storage.admins.get(id).drive();
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
    @Override
    public boolean drive(){

        while(true){
            System.out.println("You are logged in as admin. \n 1) Add user \n 2) Remove user  \n 3) Change password \n 4) Logout \n 5) Exit \n 6) Show users ");


            Scanner reader = new Scanner(System.in);
            int n = reader.nextInt();
            if (n==1)
                addUser();
            if (n==3)
                changePassword();
            if (n==4)
                return false;
            if (n==5)
                return true;
            if (n==6){
                showUsers();
            }
        }
    }
    public void showUsers(){
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

}
