package Base;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Driver {
    public static Scanner reader = new Scanner(System.in);

    protected static String defaultPassword = "12345";
    public static void startPage (){

        boolean end = false;
        while (!end) {
            System.out.println("Welcome to intranet. \n Login as: \n 1)Admin \n 2)Manager\n 3)Teacher  \n 4)Executor  \n 5) Student ");
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
        User user = new Admin("dias", "yesbay", "asd");
        startPage();
    }
}
