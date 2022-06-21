import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class TileManager {
    
    GamePanel gp;
    Tiles[] tile;

    public TileManager(GamePanel gp){

        this.gp = gp;
        tile = new Tiles[20];

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

        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public void draw(Graphics2D g2){

        g2.drawImage(tile[1].image, 0, 0, gp.tileSize, gp.tileSize, null);
    }

}
