import java.util.HashMap;

public class Card{
    private final HashMap<String, Integer> cost; //order is w, r, g, b, k
    private final int value, level;
    private final String color;
    private final String code;
    public Card(){
        cost = new HashMap<>();
        level = 1;
        value = 1;
	    color = "";
        code = "";
    }
    @SuppressWarnings("UnnecessaryTemporaryOnConversionFromString")
    public Card(String code){
        this.code = code;
        level = Integer.parseInt("" + code.charAt(0));
        value = Integer.parseInt("" + code.charAt(1));
        color = "" + code.charAt(2);
        cost = new HashMap<>();
        cost.put("white", Integer.parseInt(code.substring(3,4)));
        cost.put("red", Integer.parseInt(code.substring(4,5)));
        cost.put("green", Integer.parseInt(code.substring(5,6)));
        cost.put("blue", Integer.parseInt(code.substring(6,7)));
        cost.put("black", Integer.parseInt(code.substring(7,8)));
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
}//testing commit
