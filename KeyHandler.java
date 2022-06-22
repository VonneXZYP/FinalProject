import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, rightPressed, leftPressed, spacePressed = false;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    //this method runs **once** everytime key gets pressed
    @Override
    public void keyPressed(KeyEvent e) {
        //this converts keyevent e into numbered code corressponding to keys
        int keyCode = e.getKeyCode(); 


        if (keyCode == KeyEvent.VK_W){
            upPressed = true;
        }
        if (keyCode == KeyEvent.VK_A){
            rightPressed = true;
        }
        if (keyCode == KeyEvent.VK_S){
            downPressed = true;
        }
        if (keyCode == KeyEvent.VK_D){
            leftPressed = true;
        }
        if (keyCode == KeyEvent.VK_SPACE){
            spacePressed = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int keyCode = e.getKeyCode(); 

        if (keyCode == KeyEvent.VK_W){
            upPressed = false;
        }
        if (keyCode == KeyEvent.VK_A){
            rightPressed = false;
        }
        if (keyCode == KeyEvent.VK_S){
            downPressed = false;
        }
        if (keyCode == KeyEvent.VK_D){
            leftPressed = false;
        }
        if (keyCode == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
        
    }




}

