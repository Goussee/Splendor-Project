import java.util.HashMap;

public class Patron{
    private final HashMap<String, Integer> cost;
 
    public final String code;
    private final int value;
    public Patron(){
        //order is r-g-b-w-o
        cost = new HashMap<>();
        value = 0;
        code = "";
    }
    public Patron(String code){
        cost = new HashMap<>();
        value = Integer.valueOf(code.charAt(0));
        this.code = code;
        try{
            cost.put("white", Integer.valueOf(code.charAt(2)));
            cost.put("red", Integer.valueOf(code.charAt(3)));
            cost.put("green", Integer.valueOf(code.charAt(4)));
            cost.put("blue", Integer.valueOf(code.charAt(5)));
            cost.put("black", Integer.valueOf(code.charAt(6)));
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
    public String getCode(){
        return code;
    }
}

