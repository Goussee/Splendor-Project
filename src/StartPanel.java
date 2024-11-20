import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.*;
public class StartPanel extends ParentPanel implements MouseListener{
    private JFrame frame;
    private boolean showRules;
    private boolean showNumPlayers;
    private Image startImg, rulesImg, chooseImg;

    public StartPanel(){
        System.out.println();
        showRules = false;
        showNumPlayers = false;
        startImg = null;
        chooseImg = null;
        rulesImg = null;
        try{
            startImg = ImageIO.read(getClass().getResource("StartScreenBackground.PNG"));
            chooseImg = ImageIO.read(getClass().getResource("onyx.PNG"));

        }catch(Exception e){
            System.out.println(e);
        }
        addMouseListener(this);
    }//end of constructor

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        g.drawImage(startImg, 0, 0, getWidth(), getHeight(), null);
        if(!(showRules || showNumPlayers)){
            g.drawImage(startImg, 0, 0, getWidth(), getHeight(), null);
            System.out.println("start");
        } else if(showRules){
            g.drawImage(rulesImg, 0, 0, getWidth(), getHeight(), null);
            System.out.println("rules");
        } else if(showNumPlayers){
            g.drawImage(chooseImg, 0, 0, getWidth(), getHeight(), null);
            System.out.println("players");
        }

    }//end of paint
    
    //vvv might not be working properly
    public void mouseClicked(MouseEvent e) {
        int x = e.getX(), y = e.getY();
        System.out.printf("rules: %b, players: %b%n", showRules, showNumPlayers);//testing things
        if(!(showRules||showNumPlayers)){
            if(x>getWidth()-110&&x<getWidth()+110&&y>getHeight()+45&&y<getHeight()+135)
                showNumPlayers = true;
            else if(x>getWidth()-135&&x<getWidth()+270&&y>getHeight()+180&&y<getHeight()+270)
                showRules = true;
        } else if(showRules){
            showRules = false;
        } else if(showNumPlayers){

        }
        System.out.printf("rules: %b, players: %b%n", showRules, showNumPlayers);//testing things
        repaint();
    }//end of mouseClicked

    public void mousePressed(MouseEvent e) {
        
    }//end of mousePressed

    public void mouseReleased(MouseEvent e) {

    }//end of mouseReleased

    public void mouseEntered(MouseEvent e) {
        
    }//end of mouseEntered

    public void mouseExited(MouseEvent e) {
        
    }//end of mouseExited
}//end of class