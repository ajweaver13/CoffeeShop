import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        ArrayList<MenuItem> menu = new ArrayList();
        menu.add(new MenuItem("Espresso", Type.DRINK, 2.00));
        menu.add(new MenuItem("Latte", Type.DRINK, 3.00));
        menu.add(new MenuItem("Tea", Type.DRINK, 3.50));
        menu.add(new MenuItem("Iced Coffee", Type.DRINK, 2.50));
        menu.add(new MenuItem("Juice", Type.DRINK, 4.00));
        menu.add(new MenuItem("Smoothie", Type.DRINK, 8.00));
        menu.add(new MenuItem("Bagel", Type.FOOD, 5.00));
        menu.add(new MenuItem("Donut", Type.FOOD, 3.50));
        menu.add(new MenuItem("Croissant", Type.FOOD, 7.50));
        menu.add(new MenuItem("Breakfast Sandwich", Type.FOOD, 10.00));

        CoffeeShop coffeeShop = new CoffeeShop("Bright Morning", menu);
        App(coffeeShop);
    }

    public static void App(CoffeeShop coffeeShop) {
        CoffeeShop shop = coffeeShop;
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.println("\n\tWelcome to "+coffeeShop.getName()+"!\n");
        System.out.println("======================================");
        System.out.println("||\t\t\tToday's Menu\t\t\t||");
        System.out.println("======================================");
        System.out.println("|\t\t\t\tDrinks\t\t\t\t |");
        System.out.println("--------------------------------------");
        List<MenuItem> drinks = shop.drinksOnly();


        for (MenuItem drink : drinks) {
            String price = money.format(drink.getPrice());
            System.out.printf("|\t%-20s%11s\t |\n", drink.getItem(), price);
        }
        System.out.println("--------------------------------------");
        System.out.println("|\t\t\t\tFoods\t\t\t\t |");
        System.out.println("--------------------------------------");
        List<MenuItem> foods = shop.foodOnly();

        for (MenuItem food : foods) {
            String price = money.format(food.getPrice());
            System.out.printf("|\t%-20s%11s\t |\n", food.getItem(), price);
        }
        System.out.println("--------------------------------------\n");

        System.out.println("Today's Cheapest Item is the "+coffeeShop.cheapestItem()+"!\n");
        String[] items = {"Latte", "Tea", "Bagel", "Cookie", "Donut"};
        for (String item : items) {
            String result = coffeeShop.addOrder(item);
            if (result == null) {
                System.out.println(item+" has been ordered.");
            } else {
                System.out.println(result);
            }
        }

        System.out.println("\nThe total amount is "+money.format(coffeeShop.dueAmount()));
        System.out.println("The full order:");
        MenuItem[] list = coffeeShop.listOrders();
        for (MenuItem l : list) {
            System.out.println("\t"+l);
        }
        System.out.println();
        for (int x = 0; x < 5; x++) {
            System.out.println(coffeeShop.fulfillOrder());
        }

        System.out.println("\nThank you and come back again!");
    }
}