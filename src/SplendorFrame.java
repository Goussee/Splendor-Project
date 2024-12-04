import javax.swing.*;
public class SplendorFrame extends JFrame{
    private ParentPanel panel;

    public SplendorFrame(){
        super("Splendor Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920,1080);
		setLocationRelativeTo(null);
		setResizable(false);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //setUndecorated(true);
        //Player[] testing = {new Player("Player 5"), new Player("player 9")};

        panel = new StartPanel();
        panel.setFrame(this);
        add(panel);
        setVisible(true);
    }//end of constructor

    public void endGame(Player[] ps){
        panel = new EndPanel(ps);
    }//end of changePanel

    public void startGame(int numPlayers) throws Exception{
        panel = new GamePanel(numPlayers);
    }

}//end of class