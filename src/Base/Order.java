package Base;

public class Order {
    protected int id;
    protected String subject;
    protected String text;
    protected boolean accepted = false;
    public Order (String subject, String text){
        this.subject=subject;
        this.text=text;
        id=Storage.currOrderID++;
        Storage.pendingOrders.put(id,this);

    }
}
