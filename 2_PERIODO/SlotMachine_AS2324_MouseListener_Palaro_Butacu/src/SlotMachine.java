
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;


public class SlotMachine extends JFrame{

    private JPanel pnlNord,pnlCentro,pnlSud,pnlSudUP,pnlSudDOWN;

    private ArrayList<CasellaSlot> txtCaselleSlot;

    private JButton btnCoin,btnRipristina,btnGioca;

    private JCheckBox cbConferma;

    private JComboBox comboCoin;

    private MyLabel lblJackpot, lblCoin;

    private int numCaselleSlot;

    private String[] puntate = {"ALL-IN", "20$", "10$", "5$", "2$"};   


    public SlotMachine(int numCaselle) {
        super("SlotMachine a Linea Singola ("+numCaselle+")");

        this.setSize(750, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        numCaselleSlot = numCaselle;
        txtCaselleSlot = new ArrayList<>();

        initComponenti();
        initPannelli();
        initAscoltatori();
        
        pack();
        setVisible(true);
        btnRipristina.doClick();
    }
    
    private void initComponenti(){
        btnCoin = new JButton("INSERT COIN");
        btnRipristina = new JButton("RIPRISTINA");
        btnGioca = new JButton("Game Over");
        cbConferma = new JCheckBox("Conferma Giocata");
        comboCoin = new JComboBox<>(puntate);
        lblJackpot = new MyLabel("JACKPOT", 100);
        lblCoin = new MyLabel("", 0);

        for (int i = 0; i < numCaselleSlot; i++) {
            txtCaselleSlot.add(new CasellaSlot());
        }
    } /*----------------  FINE initComponenti ----------------- */
    
    private void initPannelli(){
        /* INIT PANNELLO NORD (pnlNord): ETICHETTA JACKPOT */
        Container main = getContentPane();

        pnlNord = new JPanel();
        pnlNord.add(lblJackpot);

        main.add(pnlNord, BorderLayout.NORTH);

        /* INIT PANNELLO CENTRO (pnlCentro): LA LINEA DELLE CASELLE SLOT 
          Se volete creare un padding tra il pannello e 
          il bordo del frame, scrivete la seguente riga di istruzione:
        */

        pnlCentro = new JPanel(new GridLayout(1,numCaselleSlot,3,3));

        pnlCentro.setBackground(Color.YELLOW);

        pnlCentro.setBackground(Color.GRAY);

        for (int i = 0; i < txtCaselleSlot.size(); i++) {
            pnlCentro.add(txtCaselleSlot.get(i));
        }

        main.add(pnlCentro, BorderLayout.CENTER);
        
       
        /* INIT PANNELLO SUD (pnlSud): COMPOSTO DA 2 SOTTOPANNELLI 
            pnlSudUP è un GridLayout (2,3) Vedi DEMO
            pnlSudDown è un FlowLayout con allineamento a destra Vedi DEMO
        */
        
        pnlSud = new JPanel();
        pnlSudUP = new JPanel(new GridLayout(2,3));
        pnlSudUP.add(btnCoin);
        pnlSudUP.add(lblCoin);
        pnlSudUP.add(comboCoin);
        pnlSudUP.add(cbConferma);

        pnlSudDOWN = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlSudDOWN.add(btnGioca);
        pnlSudDOWN.add(btnRipristina);


        pnlSud.add(pnlSudUP);
        pnlSud.add(pnlSudDOWN);

        main.add(pnlSud, BorderLayout.SOUTH);

         
    }/*----------------  FINE initPannelli ----------------- */

    
    private void initAscoltatori(){
        
        /* ASCOLTATORE 1:
            Su btnCoin deve essere associato un ascoltatore ActionListener su classe ANONIMA
            l'Ascoltatore risponde come da DEMO del file JAR
        */

        btnCoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lblCoin.getValore()>=50) lblCoin.setValore(50);
                lblCoin.incrementa();
            }
        });
        
        /* ASCOLTATORE 2:
            Su ComboCoin deve essere associato un ascoltatore ActionListener su classe ANONIMA
            l'Ascoltatore risponde come da DEMO del file JAR
        */
        //{"ALL-IN", "20$", "10$", "5$", "2$"}; 
        comboCoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String)comboCoin.getSelectedItem()) {
                    case "ALL-IN":
                        lblCoin.setValore(50);
                        break;
                    case "20$": lblCoin.setValore(lblCoin.getValore()+20); break;
                    case "10$": lblCoin.setValore(lblCoin.getValore()+10); break;
                    case "5$": lblCoin.setValore(lblCoin.getValore()+5); break;
                    case "2$": lblCoin.setValore(lblCoin.getValore()+2); break;
                    default:
                        break;
                }

                if(lblCoin.getValore()>=50){
                    lblCoin.setValore(50);
                }
            }
            
        });
        
        /* ASCOLTATORE 3:
            Su cbConferma, btnGioca e btnRipristina deve essere associato un unico ascoltatore ActionListener su classe INTERNA
            Tale ascoltatore sarà in grado di risalire alla sorgente 
            che ha generato l'evento per mezzo del metodo getActionCommand()
            l'Ascoltatore risponde come da DEMO del file JAR
        */
        class myListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("Conferma Giocata")){
                    if(cbConferma.isSelected()){
                        btnCoin.setEnabled(false);
                        comboCoin.setEnabled(false);
                    }
                    else{
                        btnCoin.setEnabled(true);
                        comboCoin.setEnabled(true);
                    }


                    if(lblCoin.getValore()>0){
                        btnGioca.setEnabled(true);
                        btnGioca.setText("Play");
                    }
                }


                if(e.getActionCommand().equals("Play")){
                    for (int i = 0; i < numCaselleSlot; i++) {
                        txtCaselleSlot.get(i).setValoreCasuale();
                    }
                }

                

                if(e.getActionCommand().equals("RIPRISTINA")){
                    lblJackpot.setValore(lblJackpot.getValore() + lblCoin.getValore());
                    lblCoin.setValore(0);

                    cbConferma.setSelected(false);
                    btnCoin.setEnabled(true);
                    comboCoin.setEnabled(true);

                    btnGioca.setText("Game Over");
                    btnGioca.setEnabled(false);

                    for (CasellaSlot c : txtCaselleSlot) {
                        c.setText("");
                    }
                }
            }

        }

        myListener listener = new myListener();
        btnGioca.addActionListener(listener);
        btnRipristina.addActionListener(listener);
        cbConferma.addActionListener(listener);

        /* ASCOLTATORE 4 :
            Sull'array delle caselle Slot devi associate un ascoltatore che estende MouseAdapter su classe INTERNA
            L'evento da intercettare è: "il mouse entra in una casella slot ... "
            l'Ascoltatore risponde come da DEMO del file JAR
        */

        class myMouseListener extends MouseAdapter{
            @Override
            public void mouseEntered(MouseEvent e) {
                if(cbConferma.isSelected()){
                    ((CasellaSlot) e.getSource()).bloccaSblocca();
                }
            }
        }

        myMouseListener mouseListener = new myMouseListener();
        for (CasellaSlot c : txtCaselleSlot) {
            c.addMouseListener(mouseListener); 
        }

        /* ASCOLTATORE 5 (alternativo al numero 4):
            Sull'array delle caselle Slot devi associate un ascoltatore che implementa MouseListener su classe INTERNA
            L'evento da intercettare è: "è stato cliccato il bottone destro nel mouse in una casella slot ... "
            l'Ascoltatore risponde come da DEMO del file JAR
        */

        class myMouseListener2 implements MouseListener{

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                CasellaSlot src = (CasellaSlot) e.getSource();

                    if(e.getButton() == MouseEvent.BUTTON3 && cbConferma.isSelected() && lblCoin.getValore() > 0){
                        src.bloccaSblocca();
                    }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
            }
            
        }

        myMouseListener myMouseListener2 = new myMouseListener();
        for (CasellaSlot c : txtCaselleSlot) {
            c.addMouseListener(mouseListener); 
        }
        

    }/*----------------  FINE initAscoltatori ----------------- */
    

} /* ------------- FINE CLASSE SLOTMACHINE -----------------------*/
