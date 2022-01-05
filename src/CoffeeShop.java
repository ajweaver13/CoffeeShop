import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class CoffeeShop {
    private String name;
    private ArrayList<MenuItem> menu;
    private Queue<MenuItem> orders;

    public CoffeeShop (String name, ArrayList<MenuItem> menu) {
        this.name = name;
        this.menu = menu;
        orders = new LinkedBlockingQueue<>();
    }

    /**
     * adds the name of the item to the end of the orders array if it exists on the menu.
     * Otherwise, return "This item is currently unavailable!"
     */
    public String addOrder(MenuItem order) {
        for (MenuItem item : menu) {
            if (item.getItem() == order.getItem()) {
                orders.add(item);
                return null;
            }
        }
        return "This item is currently unavailable!";
    }

    /**
     * if the orders array is not empty, return "The {item} is ready!".
     * If the orders array is empty, return "All orders have been fulfilled!"
     */
    public String fulfillOrder() {
        if (orders.isEmpty()) {
            return "All orders have been fulfilled!";
        }
        MenuItem item = orders.remove();
        return "The "+item.getItem()+" is ready!";
    }

    /**
     * returns the list of orders taken, otherwise, an empty array.
     */
    public MenuItem[] listOrders() {
        return (MenuItem[]) orders.toArray();
    }

    /**
     * returns the total amount due for the orders taken.
     */
    public Double dueAmount() {
        double total = 0;
        for (MenuItem item : orders) {
            total = total + item.getPrice();
        }
        return total;
    }

    /**
     * returns the name of the cheapest item on the menu.
     */
    public String cheapestItem() {
        MenuItem temp = null;
        for (MenuItem item : menu) {
            if (temp == null) {
                temp = item;
            } else {
                if (temp.getPrice() > item.getPrice()) {
                    temp = item;
                }
            }
        }
        return temp.getItem();
    }

    /**
     * returns only the item names of type drink from the menu.
     * @return
     */
    public List<MenuItem> drinksOnly() {
        return menu.stream().filter(i -> i.getType() == Type.DRINK).collect(Collectors.toList());
    }

    /**
     * returns only the item names of type food from the menu.
     */
    public List<MenuItem> foodOnly(){
        return menu.stream().filter(i -> i.getType() == Type.FOOD).collect(Collectors.toList());
    }
}
