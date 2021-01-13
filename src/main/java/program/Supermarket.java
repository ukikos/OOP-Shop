package program;

import com.google.gson.annotations.SerializedName;
import program.events.EventType;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Supermarket {

    private Storage stock = new Storage();
    private Storage shop = new Storage();

    @SerializedName("customers queue")
    private List<Customer> customers = new LinkedList<>();

    @SerializedName("planned events")
    private Queue<EventType> events = new LinkedList<>();

    public Supermarket() {
    }

    public Storage getStock() {
        return stock;
    }

    public Storage getShop() {
        return shop;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Queue<EventType> getEvents() {
        return events;
    }
}