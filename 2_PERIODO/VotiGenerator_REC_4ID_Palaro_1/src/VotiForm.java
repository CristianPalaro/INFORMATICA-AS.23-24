
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;


import javax.swing.*;


/* COGNOME E NOME: 
   CLASSE: 
   DATA: 
*/
/* SUGGERIMENTO DEL PROF: Se sei accorto, nel provare la DEMO, noterai che ci sono dei momenti in cui potresti/dovresti invocare 
                          il metodo doClick() (ove opportuno naturalmente!). Come sai, demandare all'invocazione di tale metodo delle azioni 
                          gia scritte ti semplificherà notevolmente il lavoro. 

*/ 

public class VotiForm extends JFrame implements ActionListener{

    protected   String studente; /* Conterrà il tuo nome e cognome */
    protected   JLabel lblInfo;
    protected  JButton[] btnsVoti;
    protected   CasellaVoto[] txtsVoti;
    protected   EtichettaGiudizio[] lblsGiudizi;
    protected   JRadioButton rbMedia,rbEsito; 
    protected   JButton btnRipristina,btnGenera,btnExit;
    protected  ButtonGroup gruppo;

    public VotiForm(String nomeStudente, int numeroVoti) {
        super("VOTI di "+nomeStudente);
        studente    = nomeStudente;
        btnsVoti    = new JButton[numeroVoti];
        txtsVoti    = new CasellaVoto[numeroVoti];
        lblsGiudizi = new EtichettaGiudizio[numeroVoti];
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initComponenti();
        initPannelli();
        initAscoltatori();
        
        pack();
        setVisible(true);
    }
    
    private void initComponenti(){
        lblInfo = new JLabel(studente);
        lblInfo.setFont(new Font("SANS-SERIF", Font.PLAIN, 20));
        
        /* CONSEGNA 1 (0.25): CREAZIONE DI COMPONENTI
            Inizializza tutte le componenti dell'array btnsVoti impostando la stringa di testo "GET"
            Inizializza tutte le componenti dell'array txtsVoti 
            Inizializza tutte le componenti dell'array lblsGiudizi
        */


        /* CONSEGNA 1 */

        for(int i = 0; i<btnsVoti.length; i++){
            btnsVoti[i] = new JButton("GET");
        }

        for(int i = 0; i<txtsVoti.length; i++){
            txtsVoti[i] = new CasellaVoto();
        }

        for(int i = 0; i<lblsGiudizi.length; i++){
            lblsGiudizi[i] = new EtichettaGiudizio();
        }
        
        /* FINE CONSEGNA 1 */
        
        rbMedia = new JRadioButton("Media");
        rbEsito = new JRadioButton("Esito scrutinio");
        gruppo = new ButtonGroup(); 
        gruppo.add(rbMedia);
        gruppo.add(rbEsito);
        btnRipristina = new JButton("RIPRISTINA");
        btnGenera = new JButton("GENERA TUTTI");
        btnExit = new JButton("EXIT");
       
    } /* --------- FINE initComponenti --------------- */
    
    private void initPannelli(){
        /* INIT PANNELLO NORD (NON MODIFICARE)*/
        JPanel pnlNord = new JPanel();
        pnlNord.add(lblInfo);

        /* INIT PANNELLO CENTRO: LA GRIGLIA DI GESTIONE DEI VOTI*/
        /* CONSEGNA 2 (0.25):
            Crea pnlCentro con layoutManager GridLayout e sfondo ARANCIONE
            Imposta un bordo esterno invocanto il metodo -> pnlCentro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            Inserisci su pnlCentro:
                L'array btnsVoti (sulla DEMO è la colonna di bottoni con impostato "GET")
                L'array txtsVoti (sulla DEMO è la colonna di caselle GIALLE)
                L'array lblsGiudizi (sulle DEMO è la colonna di caselle SENZA COLORE)
            Ricorda di rispettare il naturale inserimento che richiede il LayoutManager GridLayout (da sx -> dx e dall'alto -> basso)
            Vedi demo
        */
        /* CONSEGNA 2 */
 
                JPanel pnlCentro = new JPanel(new GridLayout(btnsVoti.length, 3));
                pnlCentro.setBackground(Color.ORANGE);
                pnlCentro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

                for (int i = 0; i < btnsVoti.length; i++) {
                    pnlCentro.add(btnsVoti[i]);
                    pnlCentro.add(txtsVoti[i]);
                    pnlCentro.add(lblsGiudizi[i]);
                }
        
        /* FINE CONSEGNA 2 */
        
        /* INIT PANNELLO SUD (NON MODIFICARE)*/
        JPanel pnlSud = new JPanel(new GridLayout(3,2,5,5));
        pnlSud.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        pnlSud.add(rbMedia);      pnlSud.add(btnRipristina);    
        pnlSud.add(rbEsito);      pnlSud.add(btnGenera);     
        pnlSud.add(new JPanel()); pnlSud.add(btnExit);       
        /* INIT CONTENT PANE (NON MODIFICARE)*/
        this.getContentPane().add(pnlNord,BorderLayout.NORTH);
        this.getContentPane().add(pnlCentro,BorderLayout.CENTER);
        this.getContentPane().add(pnlSud,BorderLayout.SOUTH);
        
    }/* --------- FINE initPannelli --------------- */

    
    private void initAscoltatori(){

        /* CONSEGNA 3 (1.5):
            ASCOLTATORE A: Associa su ogni btnsVoti un ascoltatore ActionListener implementato su classe INTERNA
            La classe dovrà chiamarsi BtnVotiListener 
        
            COME RISPONDE QUESTO ASCOLTATORE ...
            1) al click di un qualsiasi button appartenente alla'array btnsVoti,
                - Genera e imposta un voto casuale nella corrispondente casella di txtsVoti
                - Imposta il corrispondente giudizio nella casella lblsGiudizi

                Aggiorna infine lblInfo con il valore coerente a quello preventivamente selezionato nel gruppo delle RadioButton  
                        
            Usa anche la demo per capire l'azione di risposta che deve fornire tale ascoltatore
        */
        /* CONSEGNA 3 */

                class BtnVotiListener implements ActionListener{
                    int i;
                    public BtnVotiListener(int i){
                        this.i = i;
                    }
                    @Override
                    public void actionPerformed(ActionEvent e) {
                                txtsVoti[i].generaVotoCasuale();
                                lblsGiudizi[i].setGiudizio(txtsVoti[i].getVoto());
                    }
                    
                }

                for (int i = 0; i < btnsVoti.length; i++) {
                    btnsVoti[i].addActionListener(new BtnVotiListener(i));    
                }
        
        /* FINE CONSEGNA 3 */
        
        
        /* CONSEGNA 4 (1.5):
            ASCOLTATORE B: Associa su ogni txtsVoti un ascoltatore del Mouse implementato su classe INTERNA
            La classe dovrà chiamarsi TxtVotiMListener che estende MouseAdapter 
        
            COME RISPONDE QUESTO ASCOLTATORE ...
            1) Solo col click sinistro del mouse su una qualsiasi casella appartenente alla'array txtsVoti,
                - Resetta la casella del voto 
                - Reimposta a stringa vuota la corrispondente etichetta del giudizio 

                Aggiorna infine lblInfo con il valore coerente a quello preventivamente selezionato nel gruppo delle RadioButton  
                        
            Usa anche la demo per capire l'azione di risposta che deve fornire tale ascoltatore
        */
        
        /* CONSEGNA 4 */

        class TxtVotiMListener extends MouseAdapter{
            int i;
            public TxtVotiMListener(int i){
                this.i = i;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                CasellaVoto casellaCurrent = (CasellaVoto) e.getSource();

                if(e.getButton() == MouseEvent.BUTTON1){
                    casellaCurrent.resetVoto();
                    rbMedia.doClick();
                    lblsGiudizi[i].setText("");
                }
            }
            
        }

        for (int index = 0; index < txtsVoti.length; index++) {
            txtsVoti[index].addMouseListener(new TxtVotiMListener(index));
        }
         
        /* FINE CONSEGNA 4 */
        
        
        /* CONSEGNA 5 (1.5):
            ASCOLTATORE C: Associa su 
                                - btnRipristina
                                - btnGenera 
                                un ascoltatore implementato sulla classe MEDESIMA
            L'ascoltatore deve capire quale componente ha scatenato l'evento per mezzo del metodo getActionCommand() 
            
            COME RISPONDE QUESTO ASCOLTATORE ...
            
            1) al click di btnRipristina,
                        - Tutte le caselle txtsVoti sono resettate
                        - Tutte le etichette lblsGiudizi sono reimpostate a stringa vuota 
            2) al click di btnGenera,
                        - rigenera completamente tutto il tabellone dei voti e i rispettivi giudizi (sovrascrivento eventuali voti già impostati)
            3) In qualsiasi caso
                        - Cancella tutte le selezioni presenti nel gruppo delle RadioButton. Invoca il metodo -> gruppo.clearSelection()
                        - Su lblInfo riappare il nome dello studente
        
        
            Usa anche la demo per capire l'azione di risposta che deve fornire tale ascoltatore
        */
        /* CONSEGNA 5 */

            btnRipristina.addActionListener(this);
            btnGenera.addActionListener(this);

        /* FINE CONSEGNA 5 */
        
        
        /* CONSEGNA 6 (0.25):
            ASCOLTATORE D: Associa su btnExit un ascoltatore implementato su classe ANONIMA
                - L'azione di risposta dell'ascoltatore è facilmente intuibile
        */
        /* CONSEGNA 6 */

                /* ---------- CANCELLAMI E COMPLETA -----------*/
                btnExit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                    }
                    
                });

        /* FINE CONSEGNA 6 */


        /* CONSEGNA 7 (2.75):
            ASCOLTATORE E: Associa su 
                                    - rbMedia
                                    - rbEsito 
                                    un unico ascoltatore implementato su classe ESTERNA
            La classe è nominata RadioButtonListener ed è gia disponibile; devi solo completarla 
            L'ascoltatore deve capire quale componente ha scatenato l'evento per mezzo del metodo getSource() 
            Attenzione ... Ricordo che un ascoltatore implementato su classe esterna richiede una particolare attenzione di gestione!!
            Per i dettagli di risposta di questo ascoltatore vedi i commenti riportati direttamente nella classe stessa

            Usa anche la demo per capire l'azione di risposta che deve fornire tale ascoltatore
        */
        /* CONSEGNA 7 */

                RadioButtonListener btnsListener = new RadioButtonListener(this);

                rbMedia.addActionListener(btnsListener);
                rbEsito.addActionListener(btnsListener);

        /* FINE CONSEGNA 7 */
                
    }/* --------------- FINE initAscoltatori ---------------------- */


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "RIPRISTINA":{
                for (int i = 0; i < lblsGiudizi.length; i++) {
                    txtsVoti[i].resetVoto();
                    lblsGiudizi[i].setText("");
                }
            }

                break;

            case "GENERA TUTTI": {
                for (int i = 0; i < btnsVoti.length; i++) {
                    btnsVoti[i].doClick();
                }
            }
                
                break;
        
            default:{
                gruppo.clearSelection();
                lblInfo.setText("PALARO CRISTIAN");
            }

                break;
        }
    }


} /* FINE classe VotiForm */
