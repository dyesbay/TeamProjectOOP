package Base;

import java.io.Serializable;

public class CourseFile implements Serializable {
    private String name;
    public CourseFile (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void download(){};

}
