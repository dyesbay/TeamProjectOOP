package Base;

import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements Serializable {
    protected String name;
    protected String surname;
    protected int id;
    protected String password;

    public void changePassword(){
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your password:");
            String password = reader.next();
            if (this.password.equals(password)){
                System.out.println("Enter your password:");
                String newPassword = reader.next();
                this.password=newPassword;
                System.out.println("Password successfully changed!");
                break;
            }
            System.out.println("Wrong password! \n1) Try again \n2) Back");
            int n = reader.nextInt();
            if (n==2)
                break;

        }
    }
    public String getName(){
        return name;
    }
    public void setName (String name){
        this.name=name;
    }
    public java.lang.String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
