import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class GamePanel extends JPanel{


    private JFrame frame;
    private BufferedImage gameBG;

    public GamePanel(int numplayers){
        try{
            //gameBG = ImageIO.read(new File(SplendorMockUIBG.png));


        }
        catch(Exception e){
            System.out.println("Exception error.");
            return;

        }
        
    }

    public void paint(Graphics g){

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
