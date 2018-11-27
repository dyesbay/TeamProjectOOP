package Base;

import java.util.Scanner;

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
        return false;
    }
}
