
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Questa classe specializza una JLabel al fine di visualizzare una stringa di giudizio legata ad un voto
 * 
 * 
 * @author Cassandro Tiziano
 */
public class EtichettaGiudizio extends JLabel {
    
        /**
         * Inizializza una etichetta inserendo "" (stringa vuota)
         */ 
        public EtichettaGiudizio(){
            super("");
            setHorizontalAlignment(JLabel.CENTER);
            setFont(new Font("SANS-SERIF", Font.PLAIN, 15));
        }
        
        /**
         * Restituisce una stringa di giudizio rappresentativa del voto inserito
         * @param voto il voto del quale si vuole ottenere il relativo giudizio
         * @return la stringa del giudizio 
         */
        public void setGiudizio(int voto){
            String giudizio = "";
            switch(voto){
                case 1:
                case 2:
                case 3:    
                case 4:  giudizio = "Grav. insuff."; break;
                case 5:  giudizio = "Insufficiente"; break;
                case 6:  giudizio = "Sufficiente"; break;
                case 7:  giudizio = "Discreto"; break;
                case 8:  giudizio = "Buono"; break;   
                case 9:  giudizio = "Ottimo"; break;
                case 10: giudizio = "Eccellente"; break;
                default: giudizio = "";
            }
            setText(giudizio);
        }


        
   
}
