import java.util.HashMap;

public class Card{
    private final HashMap<String, Integer> cost;
    private final int value;
    private final int points;
    private final int tier;
    private final String type;
    private final String color;
    public Card(){
        //order is r,g,b,w,o
        cost = new HashMap<String, Integer>();
        tier = 1;
        value = 1;
        points = 0;
		type = "";
        color = "uninstantiated";
    }
    public Card( HashMap<String, Integer> cost, int tier, int value, int points, String type,String color){
        this.cost = cost;
        this.tier = tier;
        this.value = value;
        this.points = points;
		this.type = type;
        this.color = color;
    }
    public HashMap<String, Integer> getCost(){
        return cost;
    }
    public int getTier() {
        return tier;
    }
    public int getValue(){
        return value;
    }
    public int getPoints(){
        return points;
    }
    public String getColor(){
        return color;
    }
}
