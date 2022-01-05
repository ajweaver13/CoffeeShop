import javax.swing.*;
import java.util.ArrayList;

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

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame("CoffeShopGUI");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new CoffeShopGUI(coffeeShop).getter());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
