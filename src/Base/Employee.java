package Base;

public class Employee extends User{
    protected int salary;
    public Employee(String name, String surname, String password){
        this.name=name;
        this.surname=surname;
        this.password=password;
    }

}
