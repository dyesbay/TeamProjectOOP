package Base;

import java.util.*;

public class Manager extends Employee implements Drive {
    public Manager (String name, String surname, String password){
        super(name, surname, password);
    }
    public static boolean login (){
        Scanner reader = new Scanner(System.in);
        while (true){

            System.out.println("Enter user ID: \n");
            int id = reader.nextInt();
            System.out.println("Enter password: \n");
            String password = reader.next();
            if (Storage.managers.get(id)!=null){
                System.out.println("not null");
                if (password.equals((Storage.managers.get(id)).password))
                    return Storage.managers.get(id).drive();
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
    public boolean drive() {
        while(true){
            System.out.println("Hello, " + name + ". You are logged in as manager. \n 1) Add course for registration \n 2) Remove user  \n 3) Change password \n 4) Logout \n 5) Exit ");


            Scanner reader = new Scanner(System.in);
            int n = reader.nextInt();
            if (n==1)
                addCourse();
            if (n==3)
                changePassword();
            if (n==4)
                return false;
            if (n==5)
                return true;
        }
    }
    public void addCourse(){
        ArrayList<Map.Entry<Integer,Course>> arl = new ArrayList<>();
        arl.addAll(Storage.pendingCourses.entrySet());
        for (int j = 0; j < arl.size(); j++) {
            System.out.println((j + 1) + ") " + arl.get(j).getValue().getName());
        }
        System.out.println((arl.size() + 1) + ") Back");
        int n = Driver.reader.nextInt();
        if (n <= arl.size()) {
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
}
