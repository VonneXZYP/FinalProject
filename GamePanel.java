import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel  extends JPanel implements Runnable{
   
   //game panel is a subclass of Jpanel 
   //SCREEN SETTINGS

   public static final int tileSize = 40;
   //we are using tiles that are 16*  16
   final int screenWidth = 16 * 40 ;
   final int screenHeight = 16 * 20;

   //FPS
   int FPS = 60;

   Thread gameThread;
   KeyHandler keyH = new KeyHandler();
   Player player1 = new Player(this, keyH);

   //player default position    
   int playerX = screenWidth/2;
   int playerY = screenHeight/2;
 
   

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
      player1.draw(g2);
      g2.dispose();
   }


}