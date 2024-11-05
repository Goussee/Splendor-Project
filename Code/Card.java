import java.util.HashMap;

public class Card{
    public final HashMap<String, Integer> cost;
    public final int value, points, level;
    public final String type;
    public final String code;
    public Card(){
        //order is r,g,b,w,o
        cost = new HashMap<String, Integer>();
        level = 1;
        value = 1;
        points = 0;
	type = "";
        code = "";
    }
    public Card( HashMap<String, Integer> cost, int level, int value, int points, String type,String color){
        this.cost = cost;
        this.tier = tier;
        this.value = value;
        this.points = points;
		this.type = type;
        this.code = code;
    }
    /*public HashMap<String, Integer> getCost(){
        return cost;
    }
    public int getLevel() {
        return level;
    }
    public int getValue(){
        return value;
    }
    public int getPoints(){
        return points;
    }
    public String getCode(){
        return code;
    }*/
}
