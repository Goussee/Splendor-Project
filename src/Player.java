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
        int  goldNeeded = 0;
        HashMap<String, Integer> cost = c.getCost();

        for(String gem : cost.keySet()){
            goldNeeded += gems.get(gem) + this.getDiscount(gem) >= cost.get(gem) ? 0 : cost.get(gem) - (gems.get(gem) - getDiscount(gem));
            if(goldNeeded > gems.get("gold"))
                return false;
        }
        return true;
    }

    boolean canAfford(Patron p){
        int cardsNeeded = 0;
        HashMap<String, Integer> cost = p.getCost();

        for(String gem : cost.keySet()){
            cardsNeeded += cards.get(gem).size() >= cost.get(gem) ? 0 : cost.get(gem) - gems.get(gem);
            if(cardsNeeded > 1)
                return false;
        }
        return true;
    }

    //not yet implemented vvvv
    public HashMap<String, Integer> buy(Card c){
        HashMap<String, Integer> cost = c.getCost(); 
        int coinsNeeded = 0;
        for(String gem : cost.keySet()){
            if(getDiscount(gem)>= cost.get(gem))
                cost.put(gem, 0);
            else if(gems.get(gem) + getDiscount(gem) >= cost.get(gem))
                cost.put(gem, gems.get(gem)-(cost.get(gem) - getDiscount(gem)));
            else 
                coinsNeeded += cost.get(gem) - (getDiscount(gem) + gems.get(gem));
        }
        cost.put("gold", coinsNeeded);
        return cost;
    }

    public void buy(Patron p){
        HashMap<String, Integer> cost = p.getCost();
       
    }

    //getters vvv
    public HashMap<String, HashSet<Card>> getCards(){
        return cards;
    }

    public Card[] getReservedCards(){
        return reservedCards;
    }

    public boolean hasReservedCards(){
        for(Card c : reservedCards){
            if(c != null)
                return true;
        }
        return false;
    }
}//end of class