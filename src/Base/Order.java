package Base;

import java.io.Serializable;

public class Order implements Serializable {
    protected Teacher source;
    protected String subject;
    protected String text;
    public Order (Teacher source, String subject, String text){
        this.source=source;
        this.subject=subject;
        this.text=text;
        Storage.pendingOrders.add(this);
    }

    @Override
    public String toString() {
        String toString = "Subject: " + subject + ". \n";
        toString+= "From: " + source.getTitle() + " " + source.getName() + " " + source.getSurname() + ". \n";
        toString+= "Text: " + subject + ". ";

        return toString;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public Teacher getSource() {
        return source;
    }
}
