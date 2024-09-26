public class Card{
    private int[] cost;
    private int value;
    private String type;
    public Card(){
        cost = new int[]{0, 0, 0, 0, 0};
        value = 1;
        type = "uninstantiated";
    }
    public Card(int[] cost, int value, String type){
        this.cost = cost;
        this.value = value;
        this.type = type;
    }
    public int[] getCost(){
        return cost;
    }
    public int getValue(){
        return value;
    }
    public String getType(){
        return type;
    }
}
