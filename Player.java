import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player {
    
    /*
    Attributes
    */

    /** coordinate of player */
    int x, y; 
    /** speed of the player */
    int speed;
    /** the amount of points the player owns */
    int point;
    /** the food the player is making */
    Food making;
    

    public BufferedImage back1, back2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    GamePanel gp;
    KeyHandler keyH;

    /*
    Constructor
    */
    
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        getPlayerImage();
        setDefultValues();

    }

    public Player(GamePanel gp, KeyHandler keyH, int point){
        this.gp = gp;
        this.keyH = keyH;
        getPlayerImage();
        setDefultValues();
        this.addPoint(point);

    }

    /*
    Accessors
    */

    /**
    gets the speed of the player
    @return the speed of the player
    */
    public int getSpeed(){
        return this.speed;
    }
    /**
    gets the number points owned by the player
    @return the number points owned by the player
    */
    public int getPoint(){
        return this.point;
    }
    /**
    gets the food the player is making
    @return the food the player is making
    */
    public Food getMaking(){
        return this.making;
    }
    

    /*
    Mutators
    */

    /**
    changes the number points owned by the player
    @param newPoint the new amount of points owned by the player
    */
    public void setPoint(int newPoint)
    {
        this.point = newPoint;
    }
    /**
    changes the food the player is making
    @param newPoint the food the player is making
    */
    public void setMake(Food newFood)
    {
        this.making = newFood;
    }

    /*
    Methods
    */

    /**
    completing an order
    @param order the food order
    */
    public void complete(Food order)
    {
        if(making.compare(order)){
            point =+ order.getPoint();
            making = null;
            order = null;
        }
        else{
            if(point > 10){
                point = point-10;
            }
            else{
                point = 0;
            }
            making = null;
            order = null;
        }
    }
    /**
    unlocks a topping
    @param upgrade the topping to be unlocked
    */
    public void unlock(Topping upgrade) {
        if(upgrade.getLock()){
            if(this.getPoint() >= upgrade.getCost()){
                upgrade.setLock(false);
                this.point = point - upgrade.getCost();
                upgrade.setCost(0);
            }
        }
    }
    /**
    increase the number points owned by the player
    @param add amount of points to increase by
    */
    public void addPoint(int add)
    {
        this.point =+ add;
    }





    /**
    sets the defult values of player
    */
    public void setDefultValues()
    {
        x = 100;
        y = 100;
        speed = 5;
        point = 0;
        making = null;
        direction = "down";
    }
    /**
    gets the player sprites
    */
    public void getPlayerImage()
    {
        try{

            back1 = ImageIO.read(getClass().getResourceAsStream("/player/back1.png"));
            back2 = ImageIO.read(getClass().getResourceAsStream("/player/back2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
    allows the player to move
    */
    public void update()
    {
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed == true){
                direction = "back";
                if (y - speed > 0)
                {
                   y -= speed;
                }
                else if(y - speed < 0){
                   y = 0;
                }
             }
            else if(keyH.downPressed == true){
                direction = "down";
                if (y + speed < gp.getScreenHeight()-gp.tileSize)
                {
                   y += speed;
                }
                else if(y + speed > gp.getScreenHeight()-gp.tileSize){
                   y = gp.getScreenHeight()-gp.tileSize;
                }
             }
            else if(keyH.leftPressed == true){
                direction = "right";
                if (x + speed < gp.getScreenWidth()-2*gp.tileSize){
                   x += speed;
                }
                else if(x + speed > gp.getScreenWidth()-2*gp.tileSize){
                   x = gp.getScreenWidth()-2*gp.tileSize;
                }
                
             }
            else if(keyH.rightPressed == true){
                direction = "left";
                if (x - speed > 0){
                   x -= speed;
                }
                if (x - speed < gp.tileSize){
                   x = gp.tileSize;
                }
             }

             
             spriteCounter++;
             if(spriteCounter > 10){
                 if(spriteNum == 1){
                     spriteNum = 2;
                 }
                 else if(spriteNum == 2){
                     spriteNum = 1;
                }
                spriteCounter = 0;
             }
        }

        if(keyH.spacePressed == true){
                 
            if(x >= 6*gp.tileSize && x < 9*gp.tileSize && y <= gp.tileSize){
                if(this.making != null){
                   this.complete(gp.order); 
                   gp.order = new Food();
                }
                
            }
            if(x > 2*gp.tileSize && x < 3*gp.tileSize && y < gp.tileSize){
                this.making = gp.pizza = new Food(1); 
            }
            if(x > 3*gp.tileSize && x < 4*gp.tileSize && y < gp.tileSize){
                this.making = gp.pizza = new Food(2); 
            }
            if(x > 4*gp.tileSize && x < 5*gp.tileSize && y < gp.tileSize){
                this.making = gp.pizza = new Food(3); 
            }
            if(x > 2*gp.tileSize && x < 3*gp.tileSize && y > 2*gp.tileSize && y < 3*gp.tileSize){
                if(this.making != null){
                    this.making.add(gp.cheese);
                }
            }
            if(x > 3*gp.tileSize && x < 4*gp.tileSize && y > 2*gp.tileSize && y < 3*gp.tileSize){
                if(this.making != null){
                    this.making.add(gp.pepperoni);
                }
            }
            if(x > 4*gp.tileSize && x < 5*gp.tileSize && y > 2*gp.tileSize && y < 3*gp.tileSize){
                if(!gp.sausage.getLock()){
                    if(this.making != null){
                        this.making.add(gp.sausage);
                    }
                }
                if(gp.sausage.getLock()){
                    this.unlock(gp.sausage);
                }
            }
            if(x > 2*gp.tileSize && x < 3*gp.tileSize && y > 4*gp.tileSize && y < 5*gp.tileSize){
                if(!gp.mushroom.getLock()){
                    if(this.making != null){
                        this.making.add(gp.mushroom);
                    }
                }
                if(gp.mushroom.getLock()){
                    this.unlock(gp.mushroom);
                }
            }
            if(x > 3*gp.tileSize && x < 4*gp.tileSize && y > 4*gp.tileSize && y < 5*gp.tileSize){
                if(!gp.bacon.getLock()){
                    if(this.making != null){
                        this.making.add(gp.bacon);
                    }
                }
                if(gp.bacon.getLock()){
                    this.unlock(gp.bacon);
                }
            }
            if(x > 4*gp.tileSize && x < 5*gp.tileSize && y > 4*gp.tileSize && y < 5*gp.tileSize){
                if(!gp.onion.getLock()){
                    if(this.making != null){
                        this.making.add(gp.onion);
                    }
                }
                if(gp.onion.getLock()){
                    this.unlock(gp.onion);
                }
            }
            if(x > 6*gp.tileSize && x < 7*gp.tileSize && y > 2*gp.tileSize && y < 3*gp.tileSize){
                if(!gp.eggplant.getLock()){
                    if(this.making != null){
                        this.making.add(gp.eggplant);
                    }
                }
                if(gp.eggplant.getLock()){
                    this.unlock(gp.eggplant);
                }
            }
            if(x > 7*gp.tileSize && x < 8*gp.tileSize && y > 2*gp.tileSize && y < 3*gp.tileSize){
                if(!gp.pepper.getLock()){
                    if(this.making != null){
                        this.making.add(gp.pepper);
                    }
                }
                if(gp.pepper.getLock()){
                    this.unlock(gp.pepper);
                }
            }
            if(x > 6*gp.tileSize && x < 7*gp.tileSize && y > 4*gp.tileSize && y < 5*gp.tileSize){
                if(!gp.olives.getLock()){
                    if(this.making != null){
                        this.making.add(gp.olives);
                    }
                }
                if(gp.olives.getLock()){
                    this.unlock(gp.olives);
                }
            }
            if(x > 7*gp.tileSize && x < 8*gp.tileSize && y > 4*gp.tileSize && y < 5*gp.tileSize){
                if(!gp.pineapple.getLock()){
                    if(this.making != null){
                        this.making.add(gp.pineapple);
                    }
                }
                if(gp.pineapple.getLock()){
                    this.unlock(gp.pineapple);
                }
            }

         }

        
    }
    /**
    display the player on the screen
    */
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch (direction){
            case "back":
            if(spriteNum == 1){
                image = back1;    
            }
            if(spriteNum == 2){
                image = back2;    
            }
            break;
            case "down":
            if(spriteNum == 1){
                image = down1;    
            }
            if(spriteNum == 2){
                image = down2;    
            }
            break;
            case "left":
            if(spriteNum == 1){
                image = left1;    
            }
            if(spriteNum == 2){
                image = left2;    
            }
            break;
            case "right":
            if(spriteNum == 1){
                image = right1;    
            }
            if(spriteNum == 2){
                image = right2;    
            }
            break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

        g2.setColor(Color.WHITE);
        g2.fillRect(x, y, 10, 10);
    }

}