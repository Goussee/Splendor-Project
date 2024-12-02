public class Testing{
    public static void main(String[] args) throws Exception {
        Player p = new Player("Joe");
        System.out.println(p);
        p.addGems("white", 100);
        p.addGems("red", 100);
        p.addGems("green", 100);
        p.addGems("blue", 100);
        p.addGems("black", 100);
        System.out.println(p);
        Card c = new Card("21r22003");
        if(p.canAfford(c))
            p.buy(c);
        System.out.println(p);

        
    }
}