import javax.swing.*;
import java.awt.*;

public class GraphicTris extends JFrame{

    int WIDTH = 1000;
    int HEIGHT = 1000;

    //button matrix
    JButton[][] btnMatrix;

    //JTextField matrix
    JTextField[][] txtMatrix;




    public GraphicTris(String titol){

        super(titol);




        initWindow(WIDTH, HEIGHT);
        initListener();

    }




    private void initListener() {
        
    }




    private void initWindow(int WIDTH, int HEIGHT) {

        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        JPanel mainPnl = new JPanel(new GridLayout(3,3));

        btnMatrix = new JButton[3][3];
        txtMatrix = new JTextField[3][3];

        for (JButton[] jButtons : btnMatrix) {
            mainPnl.add(jButtons);
        }

        this.getContentPane().add(mainPnl, BorderLayout.CENTER);


        this.setVisible(true);
    }




    public static void main(String[] args) {
        GraphicTris trisGame = new GraphicTris("TRIS!");
    }
}
