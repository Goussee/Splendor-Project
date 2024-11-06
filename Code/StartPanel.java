import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
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