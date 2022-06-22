import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class TileManager {
    
    GamePanel gp;
    Tiles[] tile;

    public TileManager(GamePanel gp){

        this.gp = gp;
        tile = new Tiles[30];

        getTileImage();
    }

    public void getTileImage(){

        try{

            tile[0] = new Tiles();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Pizza S.png"));
            tile[1] = new Tiles();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Pizza M.png"));
            tile[2] = new Tiles();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Pizza L.png"));

            tile[3] = new Tiles();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/order1.png"));
            tile[4] = new Tiles();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/order2.png"));
            tile[5] = new Tiles();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/order3.png"));
            tile[6] = new Tiles();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/making.png"));

            tile[7] = new Tiles();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/cheese.png"));
            tile[8] = new Tiles();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pepperoni.png"));
            tile[9] = new Tiles();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sausage.png"));
            tile[10] = new Tiles();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mushroom.png"));
            tile[11] = new Tiles();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bacon.png"));
            tile[12] = new Tiles();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/onion.png"));
            tile[13] = new Tiles();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/eggplant.png"));
            tile[14] = new Tiles();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pepper.png"));
            tile[15] = new Tiles();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/olives.png"));
            tile[16] = new Tiles();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pineapple.png"));



        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public void draw(Graphics2D g2){

        //order
        g2.drawImage(tile[3].image, 0, 0, gp.tileSize, gp.tileSize, null);        
        g2.drawImage(tile[4].image, 0, gp.tileSize, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 0, 2*gp.tileSize, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 0, 3*gp.tileSize, gp.tileSize, gp.tileSize, null);        
        g2.drawImage(tile[4].image, 0, 4*gp.tileSize, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 0, 5*gp.tileSize, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 0, 6*gp.tileSize, gp.tileSize, gp.tileSize, null);

        //making
        g2.drawImage(tile[6].image, gp.getScreenWidth()-gp.tileSize, 0, gp.tileSize, gp.tileSize, null);        
        g2.drawImage(tile[4].image, gp.getScreenWidth()-gp.tileSize, gp.tileSize, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, gp.getScreenWidth()-gp.tileSize, 2*gp.tileSize, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, gp.getScreenWidth()-gp.tileSize, 3*gp.tileSize, gp.tileSize, gp.tileSize, null);        
        g2.drawImage(tile[4].image, gp.getScreenWidth()-gp.tileSize, 4*gp.tileSize, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, gp.getScreenWidth()-gp.tileSize, 5*gp.tileSize, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, gp.getScreenWidth()-gp.tileSize, 6*gp.tileSize, gp.tileSize, gp.tileSize, null);

    }

}