package Base;

public class Mark {
    private double value;
    private Student student;
    private Course course;
    public Mark ( double value, Student student, Course course){
        this.value=value;
        this.student=student;
        this.course = course;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }
}
