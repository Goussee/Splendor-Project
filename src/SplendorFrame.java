import javax.swing.*;
public class SplendorFrame extends JFrame{
    private JPanel panel;
    public SplendorFrame(){
        super("Splendor Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920,1080);
		setLocationRelativeTo(null);
		setResizable(false);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        setVisible(true);
        panel = new StartPanel();
        add(panel);
        panel.repaint();
    }
    public void changePanel(String s){
        if(s.contains("game"))
            panel = new GamePanel();
        else if(s.contains("end"))
            panel = new EndPanel();
        add(panel);
    }
}