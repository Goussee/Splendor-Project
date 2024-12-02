import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class GamePanel extends ParentPanel{
    private JFrame frame;
    private BufferedImage gameBG;
 

    public GamePanel(int numPlayers) throws Exception{
        Splendor game = new Splendor(numPlayers);
    }

    public void paint(Graphics g){

        g.drawImage(gameBG, 0, 0, getWidth(), getHeight(), null);
    }//end of paint

    
    public void mousePressed(MouseEvent e){


    }//end of mousePressed



    public void mouseReleased(MouseEvent e){

    }//end of mouseReleased

    public void mouseEntered(MouseEvent e){

    }//end of mouseEntered

    public void mouseExited(MouseEvent e){
        
    }//end of mouseExited

    public void mouseClicked(MouseEvent e){
        
    }//mouseClicked

    public boolean gameOver(){
        return false;
    }//end of gameOver

}//end of class
