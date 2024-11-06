import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class StartPanel extends JPanel{
    private JFrame frame;
    private boolean showRules;
    private boolean showNumPlayers;
    public StartPanel(){
        System.out.println();
        showRules = false;
        showNumPlayers = false;
    }
    public void paint(Graphics g){
        try{
            BufferedImage temp = ImageIO.read(getClass().getResource("/Assets/Splendor-Front-Cover.png"));
            g.drawImage(temp, 0, 0, getWidth(), getHeight(), null);
        }catch(Exception e){
            System.out.println(e);
            g.fillOval(getWidth()/2-100, getHeight()/2-100, 200, 200);
        }
    }
    public void setFrame(SplendorFrame f){
        frame = f;
    }
}