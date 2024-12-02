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

    //Start panel constructor
    public StartPanel(){
        System.out.println();
        showRules = false;
        showNumPlayers = false;
        startImg = null;
        chooseImg = null;
        rulesImg = null;
        try{
            startImg = ImageIO.read(getClass().getResource("StartScreenBackground.PNG"));
            chooseImg = ImageIO.read(getClass().getResource("StartScreenPlayers.PNG"));
            rulesImg = ImageIO.read(getClass().getResource("Rules.png"));

        }catch(Exception e){
            System.out.println(e);
        }
        addMouseListener(this);
    }

    //Start Panel Paint
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        g.drawImage(chooseImg, 0, 0, getWidth(), getHeight(), null);
        
        if(!(showRules || showNumPlayers)){
            g.drawImage(startImg, 0, 0, getWidth(), getHeight(), null);
            //System.out.println("start");
        } else if(showRules){
            g.drawImage(rulesImg, 0, 0, getWidth(), getHeight(), null);
            //System.out.println("rules");
        } else if(showNumPlayers){
            g.drawImage(chooseImg, 0, 0, getWidth(), getHeight(), null);
            g.drawRect(getWidth()/2-50, getHeight()/2+45, 100, 120); //3
            g.drawRect(getWidth()/2-350, getHeight()/2+45, 100, 120);
            g.drawRect(getWidth()/2+250, getHeight()/2+45, 100, 120);
            //System.out.println("players");
        }

    }
    
    public void mousePressed(MouseEvent e) 
    {
        int x = e.getX(), y = e.getY();
        //System.out.printf("rules: %b, players: %b%n", showRules, showNumPlayers);

        if(!(showRules||showNumPlayers))
        {
            if(x>810 && x<1085 && y>560 && y<655)
                showNumPlayers = true;
            else if(x>790&& x<1100 && y>675 && y<750)
               showRules = true;
        } else if(showRules){
            showRules = false;
        } else if(showNumPlayers){
            if(getHeight()/2+45<y&&y<getHeight()/2+165){
                int numPlayers = 0;
                if(getWidth()/2-350<x&&x<getWidth()/2-250)
                    numPlayers = 2;
                else if(getWidth()/2-50<x&&x<getWidth()/2+50)
                    numPlayers = 3;
                else if(getWidth()/2+250<x&&x<getWidth()/2+350)
                    numPlayers = 4;
                if(numPlayers != 0){
                    try {
                        System.out.println("num players: " + numPlayers);
                        super.getFrame().startGame(numPlayers);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        //System.out.printf("rules: %b, players: %b%n", showRules, showNumPlayers);//testing things
        repaint();
    }


    public void mouseClicked(MouseEvent e) {
        
    }//end of mousePressed

    public void mouseReleased(MouseEvent e) {

    }//end of mouseReleased

    public void mouseEntered(MouseEvent e) {
        
    }//end of mouseEntered

    public void mouseExited(MouseEvent e) {
        
    }//end of mouseExited
}//end of class