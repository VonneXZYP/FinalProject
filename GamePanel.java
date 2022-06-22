import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel  extends JPanel implements Runnable{
   
   
   //game panel is a subclass of Jpanel 
   //SCREEN SETTINGS

   public final int tileSize = 100;
   //we are using tiles that are 16*  16
   final int screenWidth = 20 * 60 ;
   final int screenHeight = 20 * 40;

   //FPS
   int FPS = 60;
   TileManager tileM = new TileManager(this);
   Thread gameThread;
   KeyHandler keyH = new KeyHandler();
   Player player1 = new Player(this, keyH, 1500);
   

   Topping cheese = new Topping("cheese", 10, 7);
   Topping pepperoni = new Topping("pepperoni", 10, 8);
   Topping sausage = new Topping("sausage", 15, 50, 9);
   Topping mushroom = new Topping("mushroom", 15, 80, 10);
   Topping bacon = new Topping("bacon", 15, 90, 11);
   Topping onion = new Topping("onion", 20, 100, 12);
   Topping eggplant = new Topping("eggplant", 20, 150, 13);
   Topping pepper = new Topping("pepper", 20, 180, 14);
   Topping olives = new Topping("olives", 25, 200, 15);
   Topping pineapple = new Topping("pineapple", 30, 300, 16);
   
   Food order = new Food();
   Food pizza = null;

   


   public GamePanel() {
   
      this.setPreferredSize(new Dimension(screenWidth,screenHeight));
      this.setBackground(Color.darkGray);
      this.setDoubleBuffered(true); //make game run better 
      this.addKeyListener(keyH);
      this.setFocusable(true); //12:45 Game loop and key input 
   }

   
   @Override
   public void run() {
   
      double drawInterval = 1000000000/FPS; //0.01666 seconds
      double nextDrawTime = System.nanoTime() + drawInterval;
   
      while(gameThread != null){
         
         update();
      
         repaint();
      
         try {
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime/1000000;
         
            if(remainingTime < 0) {
               remainingTime = 0;
            }
         
            Thread.sleep((long) remainingTime);
         
            nextDrawTime += drawInterval; 
         
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         
      }
      
   }

   /**
    gets screen height
    @return the screen height
    */
   public int getScreenHeight(){
      return this.screenHeight;
   }
   /**
    gets screen width
    @return the screen width
    */
   public int getScreenWidth(){
      return this.screenWidth;
   }

   public void startGamePanel() {
      gameThread = new Thread(this);
      gameThread.start(); //this calls the run method 
   
   }

   public void update() {
      player1.update();
      
   }

   public void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;

      tileM.draw(g2);
      player1.draw(g2);

      g2.dispose();
   }


}