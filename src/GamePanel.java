import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends ParentPanel implements MouseListener{

    private JFrame frame;
    private Image gameBG;
    private Splendor game;

    public GamePanel(int numPlayers){
        repaint();
        try {
            game = new Splendor(numPlayers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addMouseListener(this);

        switch(numPlayers){
            case 2 : 
                gameBG = ImageLoader.get("/Assets/GamePanelHelp.png").getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
                break;
            case 3: 
                gameBG = ImageLoader.get("/Assets/GamePanelHelp.png").getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
                break;
            case 4: 
                gameBG = ImageLoader.get("/Assets/GamePanelHelp.png").getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
                break;
        }

        gameBG = ImageLoader.get("/Assets/GamePanelHelp.png").getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        System.out.println("hi");
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(gameBG, 0, 0, null);
    }//end of paint

    public Player[] getPlayers(){
        return game.getPlayers();
    }

    public void mousePressed(MouseEvent e){

 

    }//end of mousePressed

    public void mouseReleased(MouseEvent e){

    }//end of mouseReleased

    public void mouseEntered(MouseEvent e){

    }//end of mouseEntered

    public void mouseExited(MouseEvent e){
        
    }//end of mouseExited

    public void mouseClicked(MouseEvent e){
        
    }//mouseClicked

    public void endGame(){
        //this.getFrame().endGame(game.getPlayers());
    }

    
    //end of gameOver

}//end of class
