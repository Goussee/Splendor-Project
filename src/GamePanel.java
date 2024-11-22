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
    public GamePanel(){
        try{
            gameBG = ImageIO.read(new File(SplendorMockUIBG.png));


        }
        catch(Exception e){
            System.out.println("Exception error.");
            return;

        }
        
    }
    public void paint(Graphics g){

    }
    public void setFrame(SplendorFrame f){
        frame = f;
    }

    public void mousePressed(MouseEvent e){

    }

    public void mouseReleased(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){
        
    }

    public void mouseClicked(MouseEvent e){
        
    }

    public boolean gameOver(){
        return false;
    }

}
