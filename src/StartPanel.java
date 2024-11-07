import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class StartPanel extends JPanel implements MouseListener{
    private JFrame frame;
    private boolean showRules;
    private boolean showNumPlayers;
    private BufferedImage temp;
    public StartPanel(){
        System.out.println();
        showRules = false;
        showNumPlayers = false;
        addMouseListener(this);
    }
    public void paint(Graphics g){
        /*
        BufferedImage test = new BufferedImage(getWidth(), getHeight(), TYPE_INT_RGB);
        for(int i = 0; i < getWidth(); i++)
            for(int j = 0; j < getHeight(); j++)
                test.setRGB(i, j, (int)(Math.random()*16777216));
        */
        Image test = null;
        try {
            test = ImageIO.read(getClass().getResource("onyx.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        g.drawImage(test, getWidth()/2-250, getHeight()/2-250,500,500,null);
        g.setColor(showRules ? Color.RED : Color.BLACK);
        g.fillOval(getWidth()/2-100, getHeight()/2-100, 200, 200);
        
    }
    public void setFrame(SplendorFrame f){
        frame = f;
    }
    
    public void mouseClicked(MouseEvent e) {
        
    }
    public void mousePressed(MouseEvent e) {
        showRules = !showRules;
        repaint();
    }
    public void mouseReleased(MouseEvent e) {
        showRules = !showRules;
        repaint();
    }
    public void mouseEntered(MouseEvent e) {
        
    }
    public void mouseExited(MouseEvent e) {
        
    }
}