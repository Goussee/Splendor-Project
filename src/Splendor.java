import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
public class Splendor{
    private HashMap<String, Integer> gems;
    private Player[] players;
    private int currentPlayer, lastPlayer;
    private Stack<Card> deck1, deck2, deck3;
    private Card[] seen1, seen2, seen3;
    private Patron[] patrons;
    private String gameState;
    private boolean isEnding;
    public Splendor(int n) throws Exception{
        gems = new HashMap<>();
        deck1 = new Stack<>();
        deck2 = new Stack<>();
        deck3 = new Stack<>();
        int numPlayers = (n < 2) ? 2 : (n > 4) ? 4 : n;
        int numTokens = (numPlayers == 4) ? 7 : (numPlayers == 3) ? 5 : 4;
        players = new Player[numPlayers];
        for(int i = 1; i <= players.length; i++){
            players[i-1] = new Player("Player " + i);
        }
        currentPlayer = 0;
        lastPlayer = 0;
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
            else if(c.getLevel() == 3)
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
    }

    boolean canDraw3(String gem1, String gem2, String gem3){
        return gems.get(gem1) > 0 && gems.get(gem2) > 0 && gems.get(gem3) > 0;
    }

    boolean canDraw2(String gem){
        return gems.get(gem) >= 4;
    }

    //vvv not working yet
    public void draw2(String gem){

    }
    
    public void draw3(String gem1, String gem2, String gem3){

    }

    public void endTurn(){
        while(players[currentPlayer].getGemSum() > 10){
            gameState = "removeTokens";
        }
        if(isEnding()){
            int nextPlayer = currentPlayer == players.length - 1 ? 0 : currentPlayer + 1;
            if(nextPlayer == lastPlayer){
                endGame();
                return;
            }
        }
        isEnding = players[currentPlayer].getPoints() >= 15;
        currentPlayer = currentPlayer == players.length - 1 ? 0 : currentPlayer + 1;
    }

    public boolean isEnding(){
        return false;
    }

    public void endGame(){

    }

    public void fillCard(){

    }

    public Player getWinner(){
        return new Player("");
    }
}