package Base;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Driver {

    private static String defaultPassword = "12345";
    public static void startPage (){
        System.out.println("Welcome to intranet. \n Login as: \n 1)Admin \n 2)Manager\n 3)Teacher  \n 4)Executor  \n 5) Student ");
        Scanner reader = new Scanner(System.in);

            String s = reader.next();
            switch (s){
                case "1" : if (login(1))
                    adminInterface();
                break;
                case "2" : if (login(2))
                    managerInterface();
                break;
                case "3" : if (login(3))
                    teacherInterface();
                    break;
                case "4" : if (login(4))
                    execInterface();
                    break;
                case "5" : if (login(5))
                    studInterface();
                    break;
                case "6" : break;
            }

    }
    public static boolean login (int n){
        SortedMap map = new TreeMap();
        boolean logCorrect = false;
        switch (n){
            case 1: map =Storage.admins;
            case 2: map= Storage.managers;
            case 3: map= Storage.teachers;
            case 4: map= Storage.executors;
            case 5: map= Storage.students;
        }
        Scanner reader = new Scanner(System.in);
        while (true){

            System.out.println("Enter user ID: \n");
            int id = reader.nextInt();
            System.out.println("Enter password: \n");
            String password = reader.next();
            if (Storage.admins.get(id)!=null){
                System.out.println("not null");
                if (password.equals((Storage.admins.get(id)).password))
                    return true;
            }
            System.out.println("Incorrect login or password. \n 1) Try again \n 2)Return back \n 3) Exit");
            String s = reader.next();
            if (s.equals("2")) {
                startPage();
                return false;
            }
            else if (s.equals("3"))
                return false;
        }


    }
    public static void adminInterface(){
        System.out.println("You are logged in as admin. \n 1) Add user \n 2) Remove user  \n 3) Update info about user \n 4) Logout \n 5) Exit ");

        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        if (n==1){
            System.out.println("Who do you want to add? \n 1) Admin \n 2)Manager \n 3) Teacher \n 4) Executor \n 5) Student" );
            int k = reader.nextInt();
            System.out.println("Enter name");
            String name = reader.next();
            System.out.println("Enter surname");
            String surname = reader.next();

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
                Teacher teacher = new Teacher(name, surname, defaultPassword, title);
            }
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
                System.out.println("Enter year of study:");
                YearOfStudy yearOfStudy = YearOfStudy.BACHELOR_1;
                new Student(name, surname, defaultPassword, yearOfStudy, faculty);

            }
        }

    };
    public static void managerInterface(){

        System.out.println("You are logged in as admin.");
    };
    public static void teacherInterface(){

        System.out.println("You are logged in as admin.");
    };
    public static void execInterface(){

        System.out.println("You are logged in as admin.");
    };
    public static void studInterface(){

        System.out.println("You are logged in as student.");
    };
    public static void main (String[] args){
        User user = new Admin("dias", "yesbay", "asd", 2);
        System.out.println(Storage.admins.get(2).name);
        startPage();
    }
}
