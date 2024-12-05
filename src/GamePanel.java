import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GamePanel extends ParentPanel implements MouseListener{

    private JFrame frame;
    private Image gameBG;
    private Splendor game;
    private Player currentPlayer;

    public GamePanel(int numPlayers){
        repaint();
        try {
            game = new Splendor(numPlayers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addMouseListener(this);
        gameBG = ImageLoader.get("/Assets/GamePanelHelp.png").getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
    }

    public void paint(Graphics g){
        super.paint(g);
        currentPlayer = game.getCurrent();
        g.drawImage(gameBG, 0, 0, null);
        System.out.println("currentPlayer = "+game.getCurrentNum());
    }//end of paint

    public Player[] getPlayers(){
        return game.getPlayers();
    }

    public void mousePressed(MouseEvent e){
        int x = e.getX(), y = e.getY();

        game.endTurn();

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
        this.getFrame().endScreen(game.getPlayers());
    }

    
    //end of gameOver

}//end of class
