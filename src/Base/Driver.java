package Base;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
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
                    end=Admin.login();
                        break;
                case "2":
                    end =Manager.login();
                    break;
                case "3":
                    end=Teacher.login();
                    break;
                case "4":
                    end=Executor.login();
                    break;
                case "5":
                    end=Student.login();
                    break;
                case "6":
                    end = true;
                    break;
            }
        }

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
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
//        User user = new Admin("dias", "yesbay", "asd");
        startPage();

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat")))
        {
            NonStaticStorage nonStaticStorage = new NonStaticStorage();
            oos.writeObject(nonStaticStorage);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
