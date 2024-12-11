import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GamePanel extends ParentPanel implements MouseListener{

    private JFrame frame;
    private Image gameBG;
    private Splendor game;
    private int[] bigCardsX = {756, 900, 1044, 1188}, bigCardsY = {0, 334, 530, 726};
    private int gemsDrawn;
    private String[] gemsWanted;

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

        gemsDrawn = 0;
        gemsWanted = new String[3];
        //to test use this vvv
        //gameBG = ImageLoader.get("/Assets/GamePanelHelp.png").getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);

    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        g.drawImage(gameBG, 0, 0, null);
        for(int tier = 1; tier < 4; tier++){
            Card[] cards = game.getTierCards(tier);
            for(int i = 0; i < cards.length; i++)
                try{
                    g.drawImage(cards[i].getImage(), bigCardsX[i], bigCardsY[tier], 120, 166, null);
                } catch(Exception e){
                    System.out.println(e);
                }
        }
        
        if(!game.deckIsEmpty(1))
            g.drawImage(ImageLoader.get("/Assets/tier-1-back.png"), 613, 334, 120, 166, null);
        if(!game.deckIsEmpty(2))
            g.drawImage(ImageLoader.get("/Assets/tier-2-back.png"), 613, 530, 120, 166, null);
        if(!game.deckIsEmpty(3))
            g.drawImage(ImageLoader.get("/Assets/tier-3-back.png"), 613, 725, 120, 166, null);
        
        
        Patron[] patrons = game.getPatrons();
        int xpos = 618;
        for(int i = 0; i < patrons.length; i++){
            g.drawImage(patrons[i].getImage(), xpos, 922, 124, 124, null);
            xpos += 144;
        }
        //gem numbers in the middle (community gems)
        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas", 0, 50));
        g.drawString("" + game.getGems().get("red"), 645, 200);
        g.drawString("" + game.getGems().get("green"), 765, 200);
        g.drawString("" + game.getGems().get("blue"), 885, 200);
        g.drawString("" + game.getGems().get("white"), 1005, 200);
        g.drawString("" + game.getGems().get("black"), 1125, 200);
        g.drawString("" + game.getGems().get("gold"), 1245, 200);
        //getting the number of player gems o load.

        //player 1 gems
        g.drawString("" + game.getPlayers()[0].getGems().get("red"), 40, 165);
        g.drawString("" + game.getPlayers()[0].getGems().get("green"), 135, 165);
        g.drawString("" + game.getPlayers()[0].getGems().get("blue"), 225, 165);
        g.drawString("" + game.getPlayers()[0].getGems().get("white"), 315, 165);
        g.drawString("" + game.getPlayers()[0].getGems().get("black"), 410, 165);
        g.drawString("" + game.getPlayers()[0].getGems().get("gold"), 500, 165);
        int[] xPositions = {11, 1363, 11, 1363};
        int[] yPositions = {251, 251, 761, 761};
        for(int i = 0; i < game.getPlayers().length; i++){
            int x = xPositions[i];
            for(String s : game.getPlayers()[i].getCards().keySet()){
                int y = yPositions[i];
                for(Card c : game.getPlayers()[i].getCards().get(s)){
                    g.drawImage(c.getImage(), x, y, 90, 126, null);
                    y += 29;
                }
                x += 90;
            }
        }
        //player 2 gems
        g.drawString("" + game.getPlayers()[1].getGems().get("red"), 1390, 165);
        g.drawString("" + game.getPlayers()[1].getGems().get("green"), 1485, 165);
        g.drawString("" + game.getPlayers()[1].getGems().get("blue"), 1575, 165);
        g.drawString("" + game.getPlayers()[1].getGems().get("white"), 1670, 165);
        g.drawString("" + game.getPlayers()[1].getGems().get("black"), 1760, 165);
        g.drawString("" + game.getPlayers()[1].getGems().get("gold"), 1850, 165);
        //player 3 gems
        if(game.getPlayers().length > 2){
            g.drawString("" + game.getPlayers()[2].getGems().get("red"), 40, 670);
            g.drawString("" + game.getPlayers()[2].getGems().get("green"), 135, 670);
            g.drawString("" + game.getPlayers()[2].getGems().get("blue"), 225, 670);
            g.drawString("" + game.getPlayers()[2].getGems().get("white"), 315, 670);
            g.drawString("" + game.getPlayers()[2].getGems().get("black"), 410, 670);
            g.drawString("" + game.getPlayers()[2].getGems().get("gold"), 500, 670);
        }
        //player 4 gems
        if(game.getPlayers().length > 3){
            g.drawString("" + game.getPlayers()[3].getGems().get("red"), 1390, 670);
            g.drawString("" + game.getPlayers()[3].getGems().get("green"), 1485, 670);
            g.drawString("" + game.getPlayers()[3].getGems().get("blue"), 1575, 670);
            g.drawString("" + game.getPlayers()[3].getGems().get("white"), 1670, 670);
            g.drawString("" + game.getPlayers()[3].getGems().get("black"), 1760, 670);
            g.drawString("" + game.getPlayers()[3].getGems().get("gold"), 1850, 670);
        }
        //this is testing --> g.drawRect(559, 22, 174, 57);
        g.setColor(new Color(255, 255, 170));
        switch(game.getCurrentNum()){
            case 0:
                g.drawRoundRect(118, 16, 319, 83, 20, 20);
                break;
            case 1:
                g.drawRoundRect(1468, 16, 319, 83, 20, 20);
                break;
            case 2:
                g.drawRoundRect(118, 525, 319, 83, 20, 20);
                break;
            case 3:
                g.drawRoundRect(1468, 525, 319, 83, 20, 20);
                break;
        }

        //testing --> g.drawRect(732, 149, 90, 150);

        if(game.getCurrent().hasReservedCards()){
            Image enderEye = ImageLoader.get("/Assets/enderEye.png").getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            switch(game.getCurrentNum()){
                case 0: g.drawImage(enderEye, 464, 31, 50, 50, null);
                    break;
                case 1: g.drawImage(enderEye, 1813, 31, 50, 50, null);
                    break;
                case 2: g.drawImage(enderEye, 464, 537, 50, 50, null);
                    break;
                case 3: g.drawImage(enderEye, 1813, 537, 50, 50, null);
                    break;    
            }
        }

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
        if(game.getState().equals("endTurn")){
            if(x >= 559 && x <= 731 && y >= 22 &&  y <= 79){ //draw a wild card
                if(game.canDraw1("gold") && game.getCurrent().canReserve()){
                    game.setState("getWildToken");
                    System.out.println("drawing a wildcard");
                }
            } else if(x >= 768 && x <= 942 && y >= 22 &&  y <= 79){//draw 2 gems
                game.setState("get2gems");
                System.out.println("drawing 2 of the same gem");
                return;
            }else if(x >= 978 && x <= 1152 && y >= 22 &&  y <= 79){//draw 3 gems
                game.setState("get3gems");
                System.out.println("drawing 3 different gems");
                return;
            }else if(x >= 1188 && x <= 1362 && y >= 22 &&  y <= 79){//buy card
                game.setState("buyCard");
                System.out.println("buying a card");
                return;
            }
        }
        // g.drawRect(732, 149, 90, 150);
        if(game.getState().equals("get2gems")){
             String wantedGem = "";
            if(gemsDrawn < 3){
                if(x >= 612 && x <= 702 && y >= 149 && y <= 299){
                    wantedGem = "red";
                }else if(x >= 732 && x <= 822 && y >= 149 && y <= 299){
                    wantedGem = "green";
                }else if(x >= 853 && x <= 943 && y >= 149 && y <= 299){
                    wantedGem = "blue";
                }else if(x >= 975 && x <= 1065 && y >= 149 && y <= 299){
                    wantedGem = "white";
                }else if(x >= 1096 && x <= 1186 && y >= 149 && y <= 299){
                    wantedGem = "black";
                }

                if(game.canDraw2(wantedGem)){
                    game.draw2(wantedGem);
                }
            }
        }

        if(game.getState().equals("get3gems")){
            boolean lastGem = false;
            if(gemsDrawn < 3){
                if(x >= 612 && x <= 702 && y >= 149 && y <= 299){
                    gemsWanted[gemsDrawn] = "red";
                    gemsDrawn++;
                }else if(x >= 732 && x <= 822 && y >= 149 && y <= 299){
                    gemsWanted[gemsDrawn] = "green";
                    gemsDrawn++;
                }else if(x >= 853 && x <= 943 && y >= 149 && y <= 299){
                    gemsWanted[gemsDrawn] = "blue";
                    gemsDrawn++;

                }else if(x >= 975 && x <= 1065 && y >= 149 && y <= 299){
                    gemsWanted[gemsDrawn] = "white";
                    gemsDrawn++;

                }else if(x >= 1096 && x <= 1186 && y >= 149 && y <= 299){
                    gemsWanted[gemsDrawn] = "black";
                    gemsDrawn++;

                }
                
            } else{

                if(game.canDraw3(gemsWanted[0], gemsWanted[1], gemsWanted[2])){
                    game.draw3(gemsWanted[0], gemsWanted[1], gemsWanted[2]);
                }

                gemsDrawn = 0;
                gemsWanted[0] = "";
                gemsWanted[1] = "";
                gemsWanted[2] = "";
            }
        }



        if(game.getState().equals("getWildToken")){
            game.draw("gold");
            game.setState("getWildCard");
        }

        if(game.getState().equals("getWildCard")){
            int tier = -1, pos = -1;
            if(x<756&&x<876)
                pos = 0;
            else if(x<900&&x<1020)
                pos = 1;
            else if(x<1044&&x<1164)
                pos = 2;
            else if(x<1184&&x<1304)
                pos = 3;

            if(y>334&&y<500)
                tier = 1;
            else if(y>530&&y<696)
                tier = 2;
            else if(y>726&&y<894)
                tier = 3;

            if(pos > -1 && tier > 0){
                game.reserveCard(tier, pos);
                game.endTurn();
            }
        }

        if(game.getState().equals("buyCard")){
            int tier = -1, pos = -1;
            if(x<756&&x<876)
                pos = 0;
            else if(x<900&&x<1020)
                pos = 1;
            else if(x<1044&&x<1164)
                pos = 2;
            else if(x<1184&&x<1304)
                pos = 3;

            if(y>334&&y<500)
                tier = 1;
            else if(y>530&&y<696)
                tier = 2;
            else if(y>726&&y<894)
                tier = 3;

            if(pos > -1 && tier > 0){
                Card temp = game.getCard(tier, pos);
                System.out.println(temp);
                if(game.getCurrent().canAfford(temp)){
                    temp = game.takeCard(tier, pos);
                    game.getCurrent().buy(temp);
                }
                game.endTurn();
            }
        }

        repaint();
    }//mouseClicked

    public void endGame(){
        this.getFrame().endScreen(game.getPlayers());
    }

    
    //end of gameOver

}//end of class
