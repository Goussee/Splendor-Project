import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
public class SplendorFrame extends JFrame{
    private CardLayout cl;
    private JPanel mainP;
    private StartPanel startP;
    private GamePanel gameP;
    private EndPanel endP;

    public SplendorFrame(){
        super("Splendor Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // double width = screenSize.getWidth();
        // double height = screenSize.getHeight();
        
        //1920, 1080
		//setSize((int)width - 10,(int)height - 50);
        
        setSize(1920, 1080);
		setLocationRelativeTo(null);
		setResizable(false);
        cl = new CardLayout();
        mainP = new JPanel();
        mainP.setLayout(cl);
        startP = new StartPanel();
        startP.setFrame(this);
        mainP.add("START_PANEL", startP);
        startScreen();
        add(mainP);
        setVisible(true);
    }//end of constructor

    public void startScreen(){
        cl.show(mainP, "START_PANEL");
    }

    public void endScreen(Player[] ps){
        endP = new EndPanel(gameP.getPlayers());
        endP.setFrame(this);
        mainP.add("END_PANEL", endP);
        cl.show(mainP, "END_PANEL");
    }//end of changePanel

    public void gameScreen(int numPlayers) throws Exception{
        System.out.println("gamescreem");
        gameP = new GamePanel(startP.getNumPlayers());
        gameP.setFrame(this);
        mainP.add("GAME_PANEL", gameP);
        cl.show(mainP, "GAME_PANEL");
    }

}//end of class