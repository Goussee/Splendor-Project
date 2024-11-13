import java.util.*;

public class Player {//implements Comparable<Player>
    private String name;
    private HashMap<String, HashSet<Card>> cards;
    private HashMap<String, Integer> gems;
    private HashSet<Patron> patrons;
    private Card[] reservedCards;
    private int points;

    public Player(String n){
        this.name = n;
        cards = new HashMap<String, HashSet<Card>>();
        gems = new HashMap<String, Integer>();
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
        for(String t : gems.keySet()){
            if(gem.equals(t)){
                gems.put(t, gems.get(t) + x);
                break;
            }
        }
    }

    public void removeGems(String gem, int x){
        for(String t : gems.keySet()){
            if(gem.equals(t) && gems.get(t) > 0){
                gems.put(t, gems.get(t) - x);
                break;
            }
        } 
    }

    public int getDiscount(String gem){//previously pointsOfType
        int discount = 0;        
        discount += cards.get(gem).size();
        return discount;
    }

    boolean canAfford(Card c){
        int  goldNeeded;
        HashMap<String, Integer> cost = c.getCost();

        for(String gem : cost.keySet()){
            goldNeeded += gems.get(gem) + this.getDiscount(gem) >= cost.get(gem) ? 0 : cost.get(gem) - (tokens.get(gem) - getDiscount(gem));
            if(goldNeeded > gems.get("gold"))
                return false;
        }
        return true;
    }
}//end of class
