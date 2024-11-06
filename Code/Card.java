import java.util.HashMap;

public class Card{
    public final HashMap<String, Integer> cost; //order is w, r, g, b, k
    public final int value, level;
    public final String color;
    public final String code;
    public Card(){
        cost = new HashMap<>();
        level = 1;
        value = 1;
	    color = "";
        code = "";
    }
    public Card(String code){
        this.code = code;
        level = Integer.valueOf(code.charAt(0));
        value = Integer.valueOf(code.charAt(1));
        color = "" + code.charAt(2);
        cost = new HashMap<>();
        try{
            cost.put("w", Integer.valueOf(code.charAt(3)));
            cost.put("r", Integer.valueOf(code.charAt(4)));
            cost.put("g", Integer.valueOf(code.charAt(5)));
            cost.put("b", Integer.valueOf(code.charAt(6)));
            cost.put("k", Integer.valueOf(code.charAt(7)));
        }catch(Exception e){
            System.out.printf("card %s is not working.", code);
        }
    }

    public HashMap<String, Integer> getCost(){
        return this.cost;
    }
    public int getLevel() {
        return this.level;
    }
    public int getValue(){
        return this.value;
    }
    public String getColor(){
        return this.color;
    }
    public String getCode(){
        return this.code;
    }
}
