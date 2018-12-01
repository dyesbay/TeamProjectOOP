package Base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Teacher extends Employee implements  Serializable {
    protected Title title;
    protected ArrayList<Course> courses= new ArrayList<Course>();

    public Teacher (String name, String surname, String password, Title title){
        super(name, surname, password);
        this.title= title;
        id=Storage.currID++;
        Storage.teachers.put(id,this);
    }

    public static Teacher get(String id){
        return Storage.teachers.get(id);
    }




    @Override
    public String toString() {
        return (title+super.toString());
    }

    public void setTitle(Title title){
        this.title=title;
    }
    public Title getTitle (){
        return title;
    }
}
