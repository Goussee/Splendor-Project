import java.util.Arrays;
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
    private Player winner;

    public Splendor(int n) throws Exception{
        gems = new HashMap<>();
        deck1 = new Stack<>();
        deck2 = new Stack<>();
        deck3 = new Stack<>();
        seen1 = new Card[4];
        seen2 = new Card[4];
        seen3 = new Card[4];
        int numPlayers = (n < 2) ? 2 : (n > 4) ? 4 : n;
        int numTokens = (numPlayers == 4) ? 7 : (numPlayers == 3) ? 5 : 4;
        winner = null;
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
        Scanner scan = new Scanner(System.in);
        try{
            scan = new Scanner(getClass().getResourceAsStream("cardData.txt"));
            
            while(scan.hasNext()){
                Card c = new Card(scan.next());
                if(c.getLevel() == 1)
                    deck1.add(c);
                else if(c.getLevel() == 2)
                    deck2.add(c);
                else if(c.getLevel() == 3)
                    deck3.add(c);
            }
            for(int i = 0; i < 4; i++){
                seen1[i] = deck1.pop();
                seen2[i] = deck2.pop();
                seen3[i] = deck3.pop();
            }

            scan.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("tried cardData");
        Collections.shuffle(deck1);
        Collections.shuffle(deck2);
        Collections.shuffle(deck3);
        try{
            scan = new Scanner(getClass().getResourceAsStream("patronData.txt"));
            for(int i = 0; i < patrons.length; i++)
                patrons[i] = new Patron(scan.next());
            scan.close();
        }catch(Exception e){
            System.out.println("patronData not working...");
        }
        System.out.println("tried patronData");
    }//end of constructor

    boolean canDraw3(String gem1, String gem2, String gem3){
        return gems.get(gem1) > 0 && gems.get(gem2) > 0 && gems.get(gem3) > 0;
    }//end of canDraw3

    boolean canDraw2(String gem){
        return gems.get(gem) >= 4;
    }//end of canDraw2

    public void draw(String gem){
        //draws a single gem, gives it to the player, and removes it from 
        //the community gems
        players[currentPlayer].addGems(gem, 1);
        gems.put(gem, gems.get(gem) - 1);
    }//end of draw

    public void draw2(String gem){
        //draws 2 gems of the same type, gives them to the player, and 
        //removes them for the community gems
        players[currentPlayer].addGems(gem, 2);
        gems.put(gem, gems.get(gem) - 2);
    }//end of draw2
    
    public void draw3(String gem1, String gem2, String gem3){
        //adds the drawn gems to the player's inventory
        players[currentPlayer].addGems(gem1, 1);
        players[currentPlayer].addGems(gem2, 1);
        players[currentPlayer].addGems(gem3, 1);

        //removes the gems drawn fromt he community gems
        gems.put(gem1, gems.get(gem1) - 1);
        gems.put(gem2, gems.get(gem2) - 1);
        gems.put(gem3, gems.get(gem3) - 1);
    }//end of draw3
    
    public void endTurn(){
        while(players[currentPlayer].getGemSum() > 10){
            gameState = "removeTokens";
        } if(isEnding()) {
            int nextPlayer = currentPlayer == players.length - 1 ? 0 : currentPlayer + 1;
            if(nextPlayer == lastPlayer){
                endGame();
                return;
            }
        } else {
            isEnding = players[currentPlayer].getPoints() >= 15;
        }
        currentPlayer = currentPlayer == players.length - 1 ? 0 : currentPlayer + 1;
        
    }//end of endTurn

    public boolean isEnding(){
        return isEnding;
    }//end of isEnding

    public void endGame(){
        winner = getWinner();
    }//end of endGame

    public void fillCard(){
        for(int i = 0; i < 4; i++){
            if(seen1[i] == null){
                seen1[i] = deck1.pop();
                return;
            } else if(seen2[i] == null){
                seen2[i] = deck1.pop();
                return;
            } else if(seen3[i] == null){
                seen3[i] = deck1.pop();
                return;
            }
        }
    }//end of fillCard

    public Card getCard(int level, int index){
        Card taken = null;
        if(index <= 0 || index >= 4)
            switch(level){
                case 1: return deck1.pop();
                case 2: return deck2.pop();
                case 3: return deck3.pop();
            }
        else
            switch(level){
                case 1:
                    taken = seen1[index-1];
                    seen1[index-1] = null;
                    break;
                case 2:
                    taken = seen2[index-1];
                    seen2[index-1] = null;
                    break;
                case 3:
                    taken = seen3[index-1];
                    seen3[index-1] = null;
                    break;
            }
        return taken;
    }

    public Player[] getPlayers(){
        return players;
    }

    public Player getWinner(){
        //returns the player that has been determined as the winner
        if (winner == null){
            Arrays.sort(players);
            return players[0];
        } else 
            return winner;
    }//end of getWinner
}