
public class Card{
    private final int[] cost;
    private final int value;
    private final int points;
    private final int tier;
    private final String color;
    public Card(){
        //order is r,g,b,w,o
        //secret
        cost = new int[]{0, 0, 0, 0, 0};
        tier = 1;
        value = 1;
        points = 0;
        color = "uninstantiated";
    }
    public Card(int[] cost, int tier, int value, int points, String color){
        this.cost = cost;
        this.tier = tier;
        this.value = value;
        this.points = points;
        this.color = color;
    }
    public int[] getCost(){
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
