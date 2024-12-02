import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class GamePanel extends ParentPanel implements MouseListener{

    private JFrame frame;
    private BufferedImage gameBG;

    public GamePanel(int numPlayers) throws Exception{
        repaint();
        Splendor game = new Splendor(numPlayers);
        addMouseListener(this);
        System.out.println("hi");
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(0, 0, 500, 500);
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

    public void endGame(){
        this.getFrame().endGame(game.getPlayers);
    }
    //end of gameOver


}//end of class
