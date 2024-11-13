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
        setVisible(true);
        panel = new StartPanel();
        //panel.setFrame(this);
        add(panel);
    }
    public void changePanel(String s){
        if(s.contains("game"))
            panel = new GamePanel();
        else if(s.contains("end"))
            panel = new EndPanel();
        add(panel);
    }
}