package Base;

public class Admin extends Employee {
    public Admin (String name, String surname, String password, int id){
        super(name, surname, password);
//        id=Storage.currID++;
        this.id=id;
        Storage.admins.put(id,this);
    }
//    public static void addUser ()
}
