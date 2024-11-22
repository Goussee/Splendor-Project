
import javax.swing.JPanel;

public class ParentPanel extends JPanel{
    private SplendorFrame frame;

    public ParentPanel(){

    }//end of constructor

    public void setFrame(SplendorFrame f){
        frame = f;
    }//end of setFrame

    public SplendorFrame getFrame(){
        return frame;
    }
}//end of class