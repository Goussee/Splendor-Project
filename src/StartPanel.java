import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.*;
public class StartPanel extends ParentPanel implements MouseListener{
    private JFrame frame;
    private boolean showRules;
    private boolean showNumPlayers;
    private Image startImg, rulesImg, chooseImage;
    public StartPanel(){
        System.out.println();
        showRules = true;
        showNumPlayers = false;
        startImg = null;
        try{
            startImg = ImageIO.read(getClass().getResource("StartScreenBackground.PNG"));
            chooseImg = ImageIO.read(getClass().getResource("StartScreenPlayers.PNG"));
        }catch(Exception e){
            System.out.println(e);
        }
        addMouseListener(this);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);

        if(!(showRules || showNumPlayers)){
            g.drawImage(startImg, 0, 0, getWidth(), getHeight(), null);
            g.drawRect(getWidth()/2-110, getHeight()/2+45, 220, 90);
            g.drawRect(getWidth()/2-135, getHeight()/2+180, 270, 90);
        } else if(showRules){
            g.drawImage(rulesImg, 0, 0, getWidth(), getHeight(), null);
        }

    }
    
    public void mouseClicked(MouseEvent e) {
        int x = e.getX(), y = e.getY();
        if(!(showRules||showNumPlayers)){
            showNumPlayers = x>getWidth()-110&&x<getWidth()+110&&y>getHeight()+45&&y<getHeight()+135;
            showRules = x>getWidth()-135&&x<getWidth()+270&&y>getHeight()+180&&y<getHeight()+270;
        } else if(showRules){
            showRules = false;
        } else if(showNumPlayers){

        }
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