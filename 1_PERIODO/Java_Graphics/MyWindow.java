import java.awt.*;
import javax.swing.*;

public class MyWindow extends JFrame{
    private final int WIDTH = 400;
    private final int HEIGHT = 300;

    public MyWindow(String windowTitol, int width, int height) {
        super(windowTitol);
        initializeWindow(width, height);
    }

    public MyWindow(String windowTitol){
        super(windowTitol);
        initializeWindow(WIDTH, HEIGHT);
    }

    public void initializeWindow(int WIDTH, int HEIGHT){
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container windowContainer = this.getContentPane();

        /*

        //NORTH PANEL
        JPanel northPanel = new JPanel();
            northPanel.setOpaque(true);
            northPanel.setPreferredSize(new Dimension(150,150));
        //NORTH LABEL
        JLabel northLabel = new JLabel("This is the north Label");
        northLabel.setBackground(Color.BLACK);

        northPanel.add(northLabel);

        //CENTER PANEL
        JPanel centerPanel = new JPanel();
            centerPanel.setOpaque(true);         
            centerPanel.setPreferredSize(new Dimension(150,150));                                 
        //CENTER LABEL
        JLabel centerLabel = new JLabel("This is the center Label");
        centerLabel.setBackground(Color.BLACK);

        centerPanel.add(centerLabel);

        //WEST PANEL
        JPanel westPanel = new JPanel();    
            westPanel.setOpaque(true);
            westPanel.setPreferredSize(new Dimension(150,150));
        //WEST LABEL
        JLabel westLabel = new JLabel("This is the west Label");
        westLabel.setBackground(Color.BLACK);

        westPanel.add(westLabel);

        //EAST PANEL
        JPanel eastPanel = new JPanel();
            eastPanel.setOpaque(true);
            eastPanel.setPreferredSize(new Dimension(150,150));
        //EAST LABEL
        JLabel eastLabel = new JLabel("This is the east Label");
        eastLabel.setBackground(Color.BLACK);
        

        eastPanel.add(eastLabel);

        //SOUTH PANEL
        JPanel southPanel = new JPanel();
            southPanel.setOpaque(true);
            southPanel.setPreferredSize(new Dimension(150,150));
        //SOUTH LABEL
        JLabel southLabel = new JLabel("This is the south Label");
        southLabel.setBackground(Color.BLACK);

        southPanel.add(southLabel);


        windowContainer.add(northPanel,BorderLayout.NORTH);
        windowContainer.add(centerPanel,BorderLayout.CENTER);
        windowContainer.add(westPanel,BorderLayout.WEST);
        windowContainer.add(eastPanel,BorderLayout.EAST);
        windowContainer.add(southPanel,BorderLayout.SOUTH);

        */
        
        JPanel mainPan = new JPanel(new GridLayout(1, 2));
        JPanel UIPan = new JPanel(new GridLayout(5,1));
        JPanel drawPan = new JPanel();
        

        


        windowContainer.add(mainPan);
        pack();
        this.setVisible(true);
  
 }

    public static void main(String[] args) {
        new MyWindow("this is a test window");
    }
}
