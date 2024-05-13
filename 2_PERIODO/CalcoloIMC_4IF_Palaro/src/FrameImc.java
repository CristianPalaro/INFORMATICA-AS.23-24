/* NOME E COGNOME Palaro Cristian
   CLASSE 4ID
   DATA 19022024
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/* NOTA: Prendi visione di come e' stata implementata questa classe che "specializza" un JFrame e completa */

public class FrameImc extends JFrame implements ActionListener{
    
    private LabelImc lblImc; /* NON MODIFICARE */
    /* Inserisci qui le altre varibili di esemplare che ritieni necessarie */
    Container contentPane;
    JPanel northPanel;
    JPanel centerPanel;
    JPanel southPanel;
    JPanel unitMeasure;

    JTextField txtWeigh;
    JTextField txtHeight;

    JLabel heightLabel;
    LabelImc imcLabel;
    
    JRadioButton rbCent;
    JRadioButton rbMet;

    JButton enable = new JButton("ENABLE");
    JButton calculate = new JButton("CALCULATE");
    JButton cancel = new JButton("CANCEL");
    JButton exit = new JButton("EXIT");
    /* CANCELLAMI e COMPLETA */
    
    public FrameImc(){
        super("Calcolo dell' Indice di Massa Corporea (IMC)");
        setSize(300,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initPannelli();
        initComponenti();
        initAscoltatori();
        pack(); /* Minimizza le dimensioni del JFrame garantendo una buone visibilità a tutte le componenti */
        setVisible(true);
        
    } /* ---- FINE costruttore ---- */
    
    
    private void initComponenti(){
        /* Istanzia tutte le componenti necessarie cercando di mantenere una 
           sequenza logica e chiara. Scrivi dei commenti esplicativi se necessario !
        */

        //NORTH PANEL

        northPanel.add(new JLabel("Peso (KG)"));
        txtWeigh = new JTextField("0");
        txtWeigh.setHorizontalAlignment(JTextField.RIGHT);

        northPanel.add(txtWeigh);
        northPanel.add(new JLabel("unità di misura dell'altezza"));

        unitMeasure = new JPanel(new FlowLayout(FlowLayout.CENTER));

        rbCent = new JRadioButton("in Centimeters");
        rbMet = new JRadioButton("in Meters");
        unitMeasure.setBackground(Color.YELLOW);

        unitMeasure.add(rbCent);
        unitMeasure.add(rbMet);

        rbCent.setBackground(Color.YELLOW);
        rbCent.setSelected(true);
        rbMet.setBackground(Color.YELLOW);

        ButtonGroup radios = new ButtonGroup();
        radios.add(rbCent);
        radios.add(rbMet);

        heightLabel = new JLabel("ALTEZZA (CM)");
        txtHeight = new JTextField("0");
        txtHeight.setHorizontalAlignment(JTextField.RIGHT);

        northPanel.add(unitMeasure);
        northPanel.add(heightLabel);
        northPanel.add(txtHeight);




        //CENTER PANEL

        enable.setActionCommand("ENABLE");
        centerPanel.add(enable);

        calculate.setEnabled(false);
        calculate.setActionCommand("CALCULATE");
        centerPanel.add(calculate);

        cancel.setEnabled(false);
        cancel.setActionCommand("RESET");
        centerPanel.add(cancel);

        centerPanel.add(exit);




        //SOUTH PANEL
        
        imcLabel = new LabelImc(0.0);
        southPanel.add(imcLabel);
    } /* ---- FINE initComponenti() ---- */

    
    private void initPannelli(){
        /* Istanzia tutti i pannelli necessari cercando di mantenere una 
           sequenza logica e chiara. Scrivi dei commenti esplicativi se necessario !
        */
        /* 1) Pannello NORD (QUELLO di colore GIALLO) */



        northPanel = new JPanel(new GridLayout(3,2));
        northPanel.setBackground(Color.YELLOW);

        /* 2) Pannello CENTRO (QUELLO di colore VERDE) */



        centerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        centerPanel.setBackground(Color.GREEN);

        /* 3) Pannello SUD (QUELLO di colore ARANCIONE) */



        southPanel = new JPanel();
        southPanel.setBackground(Color.ORANGE);

        /* 4) Il ContentPane del JFrame */


        contentPane = this.getContentPane();
        contentPane.add(northPanel, BorderLayout.NORTH);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(southPanel, BorderLayout.SOUTH);

    } /* ---- FINE initPannelli() ---- */
    
    
    private void initAscoltatori(){
        /* Associa qui gli ascoltatori alle relative sorgenti riuspettando le consegne descritte nel PDF
           Scrivi dei commenti esplicativi se necessario !
        */
        
        rbCent.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    heightLabel.setText("ALTEZZA (CM)");
                    txtHeight.setText("0");
            }
            
        });

        rbMet.addActionListener(new ActionListener() {

           @Override
            public void actionPerformed(ActionEvent e) {
                    heightLabel.setText("ALTEZZA (MT)");
                    txtHeight.setText("0");
            }
            
        });

        enable.addActionListener(new InternalButtonListener());
        calculate.addActionListener(new InternalButtonListener());
        cancel.addActionListener(new InternalButtonListener());

        


    } /* ---- FINE initAscoltatori() ---- */
class InternalButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case value:
                
                break;
        
            default:
                break;
        }
    }    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
    

    
} /* ---- FINE classe FrameImc ---- */
