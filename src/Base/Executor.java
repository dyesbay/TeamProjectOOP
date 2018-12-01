package Base;

import java.io.Serializable;
import java.util.Scanner;

public class Executor extends Employee implements  Serializable {
    public Executor(String name, String surname, String password){
        super(name, surname, password);
        id=Storage.currID++;
        Storage.executors.put(id,this);
    }

}
