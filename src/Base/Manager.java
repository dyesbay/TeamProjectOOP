package Base;

import java.io.Serializable;
import java.util.*;

public class Manager extends Employee implements Serializable {
    public Manager (String name, String surname, String password){
        super(name, surname, password);
        id=Storage.currID++;
        Storage.managers.put(id,this);
    }
}
