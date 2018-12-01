package Base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class Storage   {
    static protected int currID = 1;
    static protected int currCourseID = 1;
    static protected int currOrderID = 1;
    static protected SortedMap<Integer,Student> students = new TreeMap<>();
    static protected SortedMap<Integer,Teacher> teachers = new TreeMap<>();
    static protected SortedMap<Integer,Executor> executors = new TreeMap<>();
    static protected SortedMap<Integer,Admin> admins = new TreeMap<>();
    static protected SortedMap<Integer,Manager> managers = new TreeMap<>();
    static protected SortedMap<Integer,Course> activeCourses = new TreeMap<>();
    static protected SortedMap<Integer,Course> pendingCourses = new TreeMap<>();
    static protected ArrayList<Order> pendingOrders = new ArrayList<>();
    static protected ArrayList<Order> doneOrders = new ArrayList<>();

}
