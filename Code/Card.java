import java.util.HashMap;
public class Card{
   public final HashMap<String, Integer> cost;
   public final int value,level;
   public final String type;
   public final String code;
   public Card(){
       //order is r,g,b,w,o
       cost = new HashMap<String, Integer>();
       level = 1;
       value = 1;
       type = "";
       code = "";
   }
   public Card(String code){
     
       String[] splitCode = code.split("");
       cost = new  HashMap<String, Integer>();
       cost.put("w", Integer.parseInt(splitCode[3]));
       cost.put("r", Integer.parseInt(splitCode[4]));
       cost.put("g", Integer.parseInt(splitCode[5]));
       cost.put("b", Integer.parseInt(splitCode[6]));
       cost.put("k", Integer.parseInt(splitCode[7]));
       level = Integer.parseInt(splitCode[0]);
       value = Integer.parseInt(splitCode[1]);
       type = splitCode[2];
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

