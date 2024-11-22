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
    }//end of constructor

    @SuppressWarnings("UnnecessaryTemporaryOnConversionFromString")
    public Card(String code){
        this.code = code;
        level = Integer.parseInt("" + code.charAt(0));
        value = Integer.parseInt("" + code.charAt(1));
        switch(code.charAt(2)){
            case 'r':
                color = "red";
                break;
            case 'w':
                color = "white";
                break;
            case 'g':
                color = "green";
                break;
            case 'b':
                color = "blue";
                break;
            case 'k':
                color = "black";
                break;
            default:
                color = "hmm";

        }
        cost = new HashMap<>();
        //places the necessary amount of gems to buy the card into the card cost
        cost.put("white", Integer.parseInt(code.substring(3,4)));
        cost.put("red", Integer.parseInt(code.substring(4,5)));
        cost.put("green", Integer.parseInt(code.substring(5,6)));
        cost.put("blue", Integer.parseInt(code.substring(6,7)));
        cost.put("black", Integer.parseInt(code.substring(7,8)));
    }//end of constructor

    public HashMap<String, Integer> getCost(){
        return this.cost;
    }//end of getCost
    public int getLevel() {
        return this.level;
    }//end of getLevel
    public int getValue(){
        return this.value;
    }//end og getValue
    public String getColor(){
        return this.color;
    }//end of getColor
    public String getCode(){
        return this.code;
    }
    public String toString(){
        return this.code;
    }
}
