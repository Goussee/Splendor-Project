import java.util.*;

public class Player implements Comparable<Player>{
    private String name;
    private HashMap<String, HashSet<Card>> cards;
    private HashMap<String, Integer> tokens;
    private HashSet<Patron> patrons;
    private Card[] reservedCards;
    private int points;

    public Player(String n){
        this.name = n;
        cards = new HashMap<String, HashSet<Card>>();
        tokens = new HashMap<String, Integer>();
        patrons = new HashSet<Patron>();
        reservedCards = new Card[3];
        
        points = 0;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int p){
        this.points = p;
    }

    public void addTokens(String gem, int x){
        for(String t : tokens.keySet()){
            if(gem.equals(t)){
                tokens.put(t, tokens.get(t) + x);
                break;
            }
        }
    }

    public void removeTokens(String gem, int x){
        for(String t : tokens.keySet()){
            if(gem.equals(t) && tokens.get(t) > 0){
                tokens.put(t, tokens.get(t) - x);
                break;
            }
        } 
    }
}//end of class
