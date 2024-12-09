import java.util.*;

public class Player implements Comparable<Player>{
    private String name;
    private HashMap<String, HashSet<Card>> cards;
    private HashMap<String, Integer> gems;
    private HashSet<Patron> patrons;
    private Card[] reservedCards;
    private int points;

    public Player(String n){
        this.name = n;
        cards = new HashMap<String, HashSet<Card>>();
        cards.put("white", new HashSet<Card>());
        cards.put("red", new HashSet<Card>());
        cards.put("green", new HashSet<Card>());
        cards.put("blue", new HashSet<Card>());
        cards.put("black", new HashSet<Card>());
        gems = new HashMap<String, Integer>();
        gems.put("white", 0);
        gems.put("red", 0);
        gems.put("green", 0);
        gems.put("blue", 0);
        gems.put("black", 0);
        gems.put("gold", 0);
        patrons = new HashSet<Patron>();
        reservedCards = new Card[3];
        points = 0;
    }

    public int getPoints(){
        return this.points;
    }

    public void addPoints(int p){
        this.points += p;
    }

    public void addGems(String gem, int x){
        for(String t : gems.keySet()){
            if(gem.equals(t)){
                gems.put(t, gems.get(t) + x);
                break;
            }
        }
    }

    public int getGemSum(){
        int sum = 0;
        for(String key : gems.keySet())
            sum += gems.get(key);
        return sum;
    }

    public int getCardSum(){
        int sum = 0;
        for(String key : cards.keySet())
            sum += cards.get(key).size();
        return sum;
    }

    public void removeGems(String gem, int x){
        for(String t : gems.keySet()){
            if(gem.equals(t) && gems.get(t) > 0){
                gems.put(t, gems.get(t) - x);
                break;
            }
        } 
    }

    public int getDiscount(String gem){ //previously pointsOfType
        try{
            return cards.get(gem).size();
        }catch(Exception e){
            return 0;
        }
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
            if(getDiscount(gem) >= cost.get(gem))
                cost.put(gem, 0);
            else if(gems.get(gem) + getDiscount(gem) >= cost.get(gem))
                cost.put(gem, cost.get(gem) - getDiscount(gem));
        }
        cost.put("gold", coinsNeeded);
        cards.get(c.getColor()).add(c);

        for(String s : cost.keySet())
            gems.put(s, gems.get(s) - cost.get(s));
        //returns the gems given back to the game
        return cost;
    }

    public void buy(Patron p){
        patrons.add(p);
    }

    public String getName(){
        return name;
    }

    //getters vvv
    public HashMap<String, HashSet<Card>> getCards(){
        return cards;
    }

    public Card[] getReservedCards(){
        return reservedCards;
    }

    public boolean hasReservedCards(){
        return reservedCards[0] != null;
    }

    @Override
    public int compareTo(Player o) {
        int diff = this.getPoints() - o.getPoints();
        return diff == 0 ? this.getCardSum() - o.getCardSum() : diff;
    }

    public String toString(){
        String output = "";
        output += "Name: " + name + "\n\n";
        output += "Inventory: " + gems + "\n";
        for(String s : cards.keySet()){
            output += cards.get(s) + "\n";
        }
        output += patrons + "\n";
        if(this.hasReservedCards()){
            output += reservedCards[0] + "\n" + reservedCards[1] + "\n" + reservedCards[2] + "\n";
        }
        output += "\nPoints: " + points + "\n";
        return output;
    }
}//end of class