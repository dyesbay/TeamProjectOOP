package Base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class NonStaticStorage implements Serializable {
     protected int currID = 1;
     protected int currCourseID = 1;
     protected int currOrderID = 1;
     protected SortedMap<Integer,Student> students = new TreeMap<>();
     protected SortedMap<Integer,Teacher> teachers = new TreeMap<>();
     protected SortedMap<Integer,Executor> executors = new TreeMap<>();
     protected SortedMap<Integer,Admin> admins = new TreeMap<>();
     protected SortedMap<Integer,Manager> managers = new TreeMap<>();
     protected SortedMap<Integer,Course> activeCourses = new TreeMap<>();
     protected SortedMap<Integer,Course> pendingCourses = new TreeMap<>();
     protected ArrayList<Order> pendingOrders = new ArrayList<>();
     protected ArrayList<Order> doneOrders = new ArrayList<>();
     public NonStaticStorage (){
         currID = Storage.currID;
         currCourseID =  Storage.currCourseID;
         currOrderID =  Storage.currOrderID;
         students = Storage.students;
         teachers = Storage.teachers;
         executors = Storage.executors;
         admins = Storage.admins;
         managers = Storage.managers;
         activeCourses = Storage.activeCourses;
         pendingCourses = Storage.pendingCourses;
         pendingOrders = Storage.pendingOrders;
         doneOrders = Storage.doneOrders;
     }
}
