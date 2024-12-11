
public class Testing{
    public static void main(String[] args) throws Exception {
        Splendor game = new Splendor(2);
        for(int i = 1; i <=3; i++){
            for(Card c : game.getTierCards(i))
                System.out.print(c + " ");
            System.out.println();
        }
        game.takeCard(1, 1);
        System.out.println();
        for(int i = 1; i <=3; i++){
            for(Card c : game.getTierCards(i))
                System.out.print(c + " ");
            System.out.println();
        }
    }
}//iuh