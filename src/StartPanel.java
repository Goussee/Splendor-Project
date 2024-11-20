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
            rulesImg = ImageIO.read(getClass().getResource("onyx.PNG"));

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
            System.out.println("rules");
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

    }
    /*showNumPlayers = true;
        if(x>590 && y>565 && x<680 && y<685)
        {
            System.out.println("Number 2");
        }
        else if(x>900 && y>565 && x<990 && y<685)
        {
            System.out.println("Number 3");
        }
        else if(x>1810 && y>565 && x<1890 && y<685)
        {
            System.out.println("Number 4");
        }*/
    

    //Mouse clicked
    public void mouseClicked(MouseEvent e) 
    {
        int x = e.getX(), y = e.getY();
        System.out.printf("rules: %b, players: %b%n", showRules, showNumPlayers);

        if(!(showRules||showNumPlayers))
        {
            if(x>810 && x<1085 && y>560 && y<655)
                showNumPlayers = true;
            //else if(x>getWidth()-135&&x<getWidth()+270&&y>getHeight()+180&&y<getHeight()+270)
            //    showRules = true;
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