import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.*;
public class StartPanel extends ParentPanel implements MouseListener{
    private JFrame frame;
    private boolean showRules;
    private boolean showNumPlayers;
    private Image bg;
    public StartPanel(){
        System.out.println();
        showRules = true;
        showNumPlayers = false;
        bg = null;
        try{
            bg = ImageIO.read(getClass().getResource("Startscreen_Background.PNG"));
        }catch(Exception e){
            System.out.println(e);
        }
        addMouseListener(this);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
        if(!(showRules || showNumPlayers)){
            //show "play" and "rules"
        }
        if(showRules){
            
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        showRules = !showRules;
        repaint();
    }
    public void mousePressed(MouseEvent e) {
        
    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {
        
    }
    public void mouseExited(MouseEvent e) {
        
    }
}