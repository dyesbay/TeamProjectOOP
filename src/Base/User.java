package Base;

public abstract class User {
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
