import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.*;


public class EndPanel extends ParentPanel implements KeyListener{
    //variables go here vvv
    private JFrame frame;
    private Image background = ImageLoader.get("Endscreen_Backgound.png");
    public void paint(Graphics g){

    }//end of paint

    public void keyTyped(KeyEvent e) {
        //when 'R' is pressed, restart the game
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
