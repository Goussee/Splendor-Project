import java.awt.Color;
import java.awt.Font;
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
    private Image background = ImageLoader.get("/Assets/Endscreen_Backgound.png");
    private Player[] players;

    public EndPanel(){

    }

    public EndPanel(Player[] p){
        players = p;
    }//end of constructor

    public void paint(Graphics g){
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        g.setColor(new Color(255,255,255,50));
        g.fillRect(20, 20, getWidth()-800, getHeight()-50);
        g.setColor(new Color(255, 60, 79) );
        g.setFont(new Font("Consolas", 0, 70));
        g.drawString("Player "+ " is the winner!", 60, 100);
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
}