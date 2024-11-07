import java.util.HashMap;

public class Sponsor{
    public final HashMap<String, Integer> cost;
 
    public final String code;
    public final int value;
    public Sponsor(){
        //order is r-g-b-w-o
        cost = new HashMap<>();
        value = 0;
        code = "";
    }
    public Sponsor(String code){
        cost = new HashMap<>();
        value = Integer.valueOf(code.charAt(0));
        this.code = code;
        try{
            cost.put("w", Integer.valueOf(code.charAt(2)));
            cost.put("r", Integer.valueOf(code.charAt(3)));
            cost.put("g", Integer.valueOf(code.charAt(4)));
            cost.put("b", Integer.valueOf(code.charAt(5)));
            cost.put("k", Integer.valueOf(code.charAt(6)));
        }catch(Exception e){
            System.out.printf("patron %s is not working.", code);
        }
        
    }
    public HashMap<String, Integer> getCost(){
        return cost;
    }
    public int getValue(){
        return value;
    }
}

//testing dhruv