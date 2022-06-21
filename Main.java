import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        

        KeyHandler keyH = new KeyHandler();
        GamePanel gp = new GamePanel();


        Topping cheese = new Topping("cheese", 10);
        Topping pepperoni = new Topping("pepperoni", 10);
        Topping sausage = new Topping("sausage", 10, 50);
        Topping mushroom = new Topping("mushroom", 10, 80);
        Topping bacon = new Topping("bacon", 10, 80);
        Topping onion = new Topping("onion", 10, 80);
        Topping chicken = new Topping("chicken", 10, 80);
        Topping pepper = new Topping("pepper", 10, 150);
        Topping olives = new Topping("olives", 10, 100);
        Topping spinach = new Topping("spinach", 10, 150);
        Topping beef = new Topping("beef", 10, 80);
        Topping ham = new Topping("ham", 10, 100);
        Topping pineapple = new Topping("pineapple", 10, 200);
        Topping corn = new Topping("corn", 10, 200);
        Topping eggplant = new Topping("eggplant", 10, 200);

        //Testing
        Food order = new Food();
        Food pizza = new Food(1);
        Food pizza2 = new Food(1);
        System.out.println(pizza.getPoint());
        pizza.add(cheese);
        System.out.println(pizza.getPoint());

        pizza2.add(cheese);
        order.printToppings();
        System.out.println();
        pizza.printToppings();
        System.out.println();
        pizza2.printToppings();
        System.out.println(pizza.compare(pizza2));
        System.out.println(pizza.compare(order));
        
        Player player = new Player(gp,keyH);
        player.setMake(pizza);
        System.out.println();

        System.out.println(player.getPoint());
        System.out.println(player.getMaking());
        player.complete(pizza2);
        pizza = null;
        System.out.println(player.getPoint());
        System.out.println(player.getMaking());
        

        pizza = new Food(1);
        player.addPoint(50);
        player.setMake(pizza);
        player.unlock(sausage);
        pizza.add(sausage);
        pizza.printToppings();




        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.setResizable(false);
        window.setTitle("");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel); 
        
        window.pack();
        gamePanel.startGamePanel();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }


}
