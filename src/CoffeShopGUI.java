import javax.swing.*;

public class CoffeShopGUI extends JPanel{
    private CoffeeShop coffeeShop;
    private JPanel panel;

    public  CoffeShopGUI(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    public JPanel getter(){
        return this.panel;
    }
}
