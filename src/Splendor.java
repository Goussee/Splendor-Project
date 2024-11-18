import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
public class Splendor{
    private HashMap<String, Integer> tokens;
    private Player[] players;
    private Player currentPlayer;
    private Stack<Card> deck1, deck2, deck3;
    private Card[] seen1, seen2, seen3;
    private Patron[] patrons;
    public Splendor(int n) throws Exception{
        tokens = new HashMap<>();
        deck1 = new Stack<>();
        deck2 = new Stack<>();
        deck3 = new Stack<>();
        int numPlayers = (n < 2) ? 2 : (n > 4) ? 4 : n;
        int numTokens = (numPlayers == 4) ? 7 : (numPlayers == 3) ? 5 : 4;
        players = new Player[numPlayers];
        patrons = new Patron[numPlayers + 1];
        tokens.put("white", numTokens);
        tokens.put("red", numTokens);
        tokens.put("green", numTokens);
        tokens.put("blue", numTokens);
        tokens.put("black", numTokens);
        tokens.put("gold", 5);
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
        
    }
}