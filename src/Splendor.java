import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
public class Splendor{
    private HashMap<String, Integer> gems;
    private Player[] players;
    private Player currentPlayer;
    private Stack<Card> deck1, deck2, deck3;
    private Card[] seen1, seen2, seen3;
    private Patron[] patrons;
    private Player winner;

    public Splendor(int n) throws Exception{
        gems = new HashMap<>();
        deck1 = new Stack<>();
        deck2 = new Stack<>();
        deck3 = new Stack<>();
        int numPlayers = (n < 2) ? 2 : (n > 4) ? 4 : n;
        int numTokens = (numPlayers == 4) ? 7 : (numPlayers == 3) ? 5 : 4;
        winner = null;
        players = new Player[numPlayers];

        for(int i = 1; i <= players.length; i++){
            players[i-1] = new Player("Player " + i);
        }

        patrons = new Patron[numPlayers + 1];
        gems.put("white", numTokens);
        gems.put("red", numTokens);
        gems.put("green", numTokens);
        gems.put("blue", numTokens);
        gems.put("black", numTokens);
        gems.put("gold", 5);
        Scanner scan = new Scanner(new File("cardData.txt"));

        while(scan.hasNext()){
            Card c = new Card(scan.next());
            if(c.getLevel() == 1)
                deck1.add(c);
            else if(c.getLevel() == 2)
                deck2.add(c);
            else
                deck3.add(c);
        }

        scan.close();
        Collections.shuffle(deck1);
        Collections.shuffle(deck2);
        Collections.shuffle(deck3);
        scan = new Scanner(new File("patronData.txt"));
        for(int i = 0; i < patrons.length; i++)
            patrons[i] = new Patron(scan.next());
        scan.close();
    }//end constructor

    boolean canDraw3(String gem1, String gem2, String gem3){
        return gems.get(gem1) > 0 && gems.get(gem2) > 0 && gems.get(gem3) > 0;
    }//end canDraw3

    boolean canDraw2(String gem){
        return gems.get(gem) >= 4;
    }//end canDraw2

    public void draw2(String gem){
        currentPlayer.addGems(gem, 2);
        gems.put(gem, gems.get(gem) - 2);
    }//end draw2
    
    public void draw3(String gem1, String gem2, String gem3){
        //give the gems to the player
        currentPlayer.addGems(gem1, 1);
        currentPlayer.addGems(gem2, 1);
        currentPlayer.addGems(gem3, 1);
        //remove the gems from the community gems
        gems.put(gem2, gems.get(gem2) - 1);
        gems.put(gem1, gems.get(gem1) - 1);
        gems.put(gem3, gems.get(gem3) - 1);
    }//end draw3

    public void endTurn(){

    }//end endTurn

    public boolean isEnding(){

    }//end isEnding

    public void endGame(){

    }//end endGame

    public void fillCard(){

    }//end fillCard

    public Player getWinner(){
        if(winner != null){
            return winner;
        }
        return null;
    }//end getWinner
}