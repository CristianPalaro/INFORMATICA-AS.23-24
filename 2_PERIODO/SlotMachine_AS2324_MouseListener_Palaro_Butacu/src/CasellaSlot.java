
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JTextField;

public class CasellaSlot extends JTextField{
        
    private boolean bloccata;
        
        public CasellaSlot(){
            bloccata = false;
            setFont(new Font("SANS-SERIF", Font.PLAIN, 40));
            setHorizontalAlignment(JTextField.CENTER);
            setEditable(false);
            setBackground(Color.YELLOW);
        }

        public void setValore(int valore){
            /* invoca il metodo della superclasse setText impostanto valore in formato stringa */
            setText(String.valueOf(valore));
        }
        public void setValoreCasuale(){
            
            /* imposta un valore casuale tra i primi 10 numeri naturali (0..9) */
           Random gen = new Random();
           setValore(gen.nextInt(10));

        }
        
        public int getValore(){
            /* invoca il metodo della superclasse getText (che si presenta in formato String) e restituisce il corrispondente valore intero */ 
            return Integer.parseInt(getText());
        }
        
        public void resetCasella(){
            /* il contenuto della casella è una stringa vuota
               non è bloccata
               il colore di sfondo è GIALLO
               il colore del testo è NERO
            */
            setText("");
            setBackground(Color.YELLOW);
            setForeground(Color.BLACK);
        }
        
        public boolean isBloccata(){
            return bloccata;
        }
        
        public void bloccaSblocca(){
            bloccata = !bloccata;
            /* imposta alternativamente nella casella lo stato di bloccata | Non Bloccata
            
                Se è bloccata appare su sfondo BLUE e testo BIANCO
                Se NON è bloccata appare su sfondo GIALLO e testo NERO
            */
            if(isBloccata()){ 
                setBackground(Color.BLUE);
                setCaretColor(Color.WHITE);
            }
            else{
                setBackground(Color.YELLOW);
                setCaretColor(Color.BLACK);
            }
        }


} 
