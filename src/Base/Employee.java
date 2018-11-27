package Base;

import java.io.Serializable;

public class Employee extends User implements Serializable {
    protected int salary;
    public Employee(String name, String surname, String password){
        this.name=name;
        this.surname=surname;
        this.password=password;
    }

}
