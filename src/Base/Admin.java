package Base;

import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Admin extends Employee implements Serializable {
    public Admin (String name, String surname, String password){
        super(name, surname, password);
//        id=Storage.currID++;
        this.id=Storage.currID++;
        Storage.admins.put(id,this);
    }




}
