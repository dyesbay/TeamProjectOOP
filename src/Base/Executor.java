package Base;

import java.io.Serializable;
import java.util.Scanner;

public class Executor extends Employee implements Drive, Serializable {
    public Executor(String name, String surname, String password){
        super(name, surname, password);
        id=Storage.currID++;
        Storage.executors.put(id,this);
    }
    public static boolean login (){
        Scanner reader = new Scanner(System.in);
        while (true){

            System.out.println("Enter user ID: \n");
            int id = reader.nextInt();
            System.out.println("Enter password: \n");
            String password = reader.next();
            if (Storage.executors.get(id)!=null){
                if (password.equals((Storage.executors.get(id)).password))
                    return Storage.executors.get(id).drive();
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

    public void viewOrders (){
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

    @Override
    public boolean drive() {
        while(true){
            System.out.println("Hello, " + name + ". You are logged in as executor. \n 1) View orders \n 2) Change password \n 3) Logout \n 4) Exit ");


            Scanner reader = new Scanner(System.in);
            int n = reader.nextInt();
            if (n==1)
                viewOrders();
            if (n==2)
                changePassword();
            if (n==3)
                return false;
            if (n==4)
                return true;
        }
    }
}
