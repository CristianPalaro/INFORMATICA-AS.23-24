import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class mainFrame extends JFrame{
    private GraphicCounter counter;
    private ExternalListener listener;

    private JLabel lblCont;
    private JTextField txtCont;

    private JRadioButton rbInc;
    private JRadioButton rbDec;
    private JRadioButton rbRes;

    private JButton btnGo1;

    private JCheckBox cbInc;
    private JCheckBox cbDec;
    private JCheckBox cbRes;

    private JButton btnInc;
    private JButton btnDec;
    private JButton btnRes;

    private ButtonGroup btnGroup;

    private JButton btnGo2;

    private JComboBox combo;

    private JButton btnGo3;

    private String[] elements = {"increase", "decrease", "reset"};

    public mainFrame(String name){
        super(name);
        counter = new GraphicCounter();
        init(WIDTH, HEIGHT);
        listener = new ExternalListener(counter, lblCont, txtCont, cbInc, cbDec, btnGo2);
    }

    private void init(int width, int height) {
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container windowContainer = this.getContentPane();
        JPanel mainPanel = new JPanel(new GridLayout(6,2));

        windowContainer.add(mainPanel);
        //FIRST PANEL
        

        JPanel pnlYellowSx = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pnlYellowSx.setBackground(Color.YELLOW);

        JPanel pnlYellowDx = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            pnlYellowDx.setBackground(Color.YELLOW);    

        pnlYellowSx.add(new JLabel("valore su contatore"));
        lblCont = new JLabel(counter.toString());
        pnlYellowDx.add(lblCont);

        //SECOND PANEL
        

        JPanel pnlOrangeSx = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pnlOrangeSx.setBackground(Color.ORANGE);

        JPanel pnlOrangeDx = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            pnlOrangeDx.setBackground(Color.ORANGE);

        pnlOrangeSx.add(new JLabel("Conteggio su JTextField"));
        txtCont = new JTextField("0");
        txtCont.setPreferredSize(new Dimension(100, 15));
        pnlOrangeDx.add(txtCont);


        //THIRD PANEL
        

        JPanel pnlGreenSx = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pnlGreenSx.setBackground(Color.GREEN);

        JPanel pnlGreenDx = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            pnlGreenDx.setBackground(Color.GREEN);

        rbInc = new JRadioButton("increase");
        rbDec = new JRadioButton("decrease");
        rbRes = new JRadioButton("reset");
        btnGo1 = new JButton("GO!");

        btnGroup = new ButtonGroup();
        btnGroup.add(rbInc);
        btnGroup.add(rbDec);
        btnGroup.add(rbRes);

        pnlGreenSx.add(rbInc);
        pnlGreenSx.add(rbDec);
        pnlGreenSx.add(rbRes);
        pnlGreenDx.add(btnGo1);


        
        //FOURTH PANEL
        

        JPanel pnlBlueSx = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pnlBlueSx.setBackground(Color.BLUE);

        JPanel pnlBlueDx = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            pnlBlueDx.setBackground(Color.BLUE);

        cbInc = new JCheckBox("increase");
        cbDec = new JCheckBox("decrease");
        btnGo2 = new JButton("GO!");

        pnlBlueSx.add(cbInc);
        pnlBlueSx.add(cbDec);
        pnlBlueDx.add(btnGo2);



        //FIFTH PANEL
        

        JPanel pnlRedSx = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pnlRedSx.setBackground(Color.RED);

        JPanel pnlRedDx = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            pnlRedDx.setBackground(Color.RED);

        combo = new JComboBox(elements);
        btnGo3 = new JButton("GO!");

        pnlRedSx.add(combo);
        pnlRedDx.add(btnGo3);


        //SIXTH PANEL
        

        JPanel pnlMagentaSx = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pnlMagentaSx.setBackground(Color.MAGENTA);

        JPanel pnlMagentaDx = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            pnlMagentaDx.setBackground(Color.MAGENTA);

        btnInc = new JButton("INCREASE");
        btnDec = new JButton("DECREASE");
        btnRes = new JButton("RESET");
        JButton btnClose = new JButton("CHIUDI IL PROGRAMMA");

        pnlMagentaSx.add(btnInc);
        pnlMagentaSx.add(btnDec);
        pnlMagentaSx.add(btnRes);

        pnlMagentaDx.add(btnClose);

        mainPanel.add(pnlYellowSx);
        mainPanel.add(pnlYellowDx);

        mainPanel.add(pnlOrangeSx);
        mainPanel.add(pnlOrangeDx);

        mainPanel.add(pnlGreenSx);
        mainPanel.add(pnlGreenDx);

        mainPanel.add(pnlBlueSx);
        mainPanel.add(pnlBlueDx);

        mainPanel.add(pnlRedSx);
        mainPanel.add(pnlRedDx);

        mainPanel.add(pnlMagentaSx);
        mainPanel.add(pnlMagentaDx);

        btnGo1.addActionListener(new InternalListener()); //classe interna
        btnGo2.addActionListener(listener); //classe esterna

        //classe anonima
        btnGo3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(combo.getSelectedItem().equals("increase")){
                    counter.increase();
                }
                if(combo.getSelectedItem().equals("decrease")){
                    counter.decrease();
                }
                if(combo.getSelectedItem().equals("reset")){
                    counter.reset();
                }
        
                counter.setText(counter);
            }
            
        }); 

        

        btnClose.addActionListener(new InternalListener());
        pack();
        this.setVisible(true);
    }

    public class InternalListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (((JButton)e.getSource()).getActionCommand()) {

                case "GO!":

                    switch (getRadioSelected()) {
                        case "INCREASE":
                            counter.increase();

                        case "DECREASE":
                            counter.decrease();

                        case "RESET":
                            counter.reset();
                    }
                break;
                case "CHIUDI IL PROGRAMMA":
                    dispose();
                break;

                default:
                    break;
            }
            
        }

        private String getRadioSelected() {
            if(rbInc.isSelected()) return "increase";
            if(rbDec.isSelected()) return "decrease";
            if(rbRes.isSelected()) return "reset";

            return "";
        }
    }

    public static void main(String[] args) {
        mainFrame frame = new mainFrame("Graphic Counter");
    }
}