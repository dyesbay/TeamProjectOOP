package Base;

import java.io.Serializable;
import java.util.Scanner;

public abstract class User  implements Serializable {
    protected String name;
    protected String surname;
    protected int id;
    protected String password;


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
