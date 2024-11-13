import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class StartPanel extends ParentPanel implements MouseListener{
    private JFrame frame;
    private boolean showRules;
    private boolean showNumPlayers;
    private BufferedImage temp;
    public StartPanel(){
        System.out.println();
        showRules = true;
        showNumPlayers = false;
        addMouseListener(this);
        
    }
    public void paint(Graphics g){
        super.paint(g);
        System.out.println("\n\n\nok fine vitor");
        if(showRules){
            BufferedImage test = null;
            try {
                test = ImageIO.read(getClass().getResource("onyx.png"));
            } catch (IOException ex) {
    
            }
            g.drawImage(test, getWidth()/2-250, getHeight()/2,500,500,null);
        }
        g.setColor(showRules ? Color.CYAN : Color.YELLOW);
        g.fillOval(getWidth()/2-250, getHeight()/2-500,500,500); 
    }
    public void setFrame(SplendorFrame f){
        frame = f;
        //JButton b = new JButton("I'm a Button!");
        //b.setBounds(getWidth()/2-100, getHeight()/2-500,200,200);
        //b.setFont(new Font("Consolas", 0, 20));
        //frame.add(b);
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