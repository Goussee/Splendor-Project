import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GamePanel extends ParentPanel implements MouseListener{

    private JFrame frame;
    private Image gameBG;
    private Splendor game;
    private int[] bigCardsX = {756, 900, 1044, 1188}, bigCardsY = {0, 334, 530, 726};

    public GamePanel(int numPlayers){
        repaint();
        try {
            game = new Splendor(numPlayers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addMouseListener(this);

        switch (numPlayers) {
            case 2:
            gameBG = ImageLoader.get("/Assets/Splendor2PlayersBG.png").getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
                break;
            case 3:
            gameBG = ImageLoader.get("/Assets/Splendor3PlayersBG.png").getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
                break;
            case 4:
            gameBG = ImageLoader.get("/Assets/Splendor4PlayersBG.png").getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
                break;
            default:
                gameBG = ImageLoader.get("/Assets/GamePanelHelp.png").getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
                break;
        }
        //to test use this vvv
        gameBG = ImageLoader.get("/Assets/GamePanelHelp.png").getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);

    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        g.drawImage(gameBG, 0, 0, null);
        for(int tier = 1; tier < 4; tier++){
            Card[] cards = game.getTierCards(tier);
            for(int i = 0; i < cards.length; i++)
                g.drawImage(cards[i].getImage(), bigCardsX[i], bigCardsY[tier], 120, 166, null);
        }

        Patron[] patrons = game.getPatrons();
        int xpos = 618;
        for(int i = 0; i < patrons.length; i++){
            g.drawImage(patrons[i].getImage(), xpos, 922, 124, 124, null);
            xpos += 144;
        }

        //this is testing --> g.drawRect(559, 22, 174, 57);
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
        int x = e.getX(), y = e.getY();
        
        //System.out.println("player " + game.getCurrent().getName());
        //width of buttons: 174, height of buttons : 57

        if(x >= 559 && x <= 731 && y >= 22 &&  y <= 79){ //draw a wild card
            game.draw("gold");
            //needs to get the card of this position
            //game.getCard(y, x);

            System.out.println("drawing a wildcard");
        } else if(x >= 768 && x <= 942 && y >= 22 &&  y <= 79){//draw 2 gems
            
            //get the gems needed

            System.out.println("drawing 2 of the same gem");

        }else if(x >= 978 && x <= 1152 && y >= 22 &&  y <= 79){//draw 3 gems
            //get the gems needed

            System.out.println("drawing 3 different gems");

        }else if(x >= 1188 && x <= 1362 && y >= 22 &&  y <= 79){//buy card
            System.out.println("buying a card");

        }
        
        game.setState("endTurn");
        
        if(game.getState().equals("endTurn")) game.endTurn();
        repaint();
    }//mouseClicked

    public void endGame(){
        this.getFrame().endScreen(game.getPlayers());
    }

    
    //end of gameOver

}//end of class
