public class Sponsor{
    private final int[] cost;
    private final int value;
    public Sponsor(){
        //order is r-g-b-w-o
        cost = new int[]{0, 0, 0, 0, 0};
        value = 0;
    }
    public Sponsor(int[] cost, int value, String type){
        this.cost = cost;
        this.value = value;
    }
    public int[] getCost(){
        return cost;
    }
    public int getValue(){
        return value;
    }
}

//testing dhruv