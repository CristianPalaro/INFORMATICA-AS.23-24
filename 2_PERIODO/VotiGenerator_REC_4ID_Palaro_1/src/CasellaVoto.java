/* ATTENZIONE NON MODIFICARE */
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
/**
 * Questa classe specializza una JTextField al fine di memorizzare un valore numerico intero che 
 * rappresenta un voto (range 1..10)
 * Le caratteristiche di questa particolare JTextField sono:
 *      - non editabile (non sarà possibile impostarne un valore tramite tastiera)
 *      - può essere VUOTA (casella GIALLA in assenza di testo )
 *      - può contenere un voto valido 
 *              - sarà ROSSA se il voto è negativo ( minore di 6 )
 *              - sarà VERDE se il voto è positivo ( maggiore o uguale a 6 )
 *      - consente di generare un voto randomico valido
 *      
 * 
 * @author Cassandro Tiziano
 */
public class CasellaVoto extends JTextField{
        
        private int voto;
    
        /**
         * Inizializza una casella su sfondo GIALLO, non editabile, inserendo "" (stringa vuota)
         */ 
        public CasellaVoto(){
            super("");
            setFont(new Font("SANS-SERIF", Font.PLAIN, 30));
            setHorizontalAlignment(JTextField.CENTER);
            setEditable(false);
            setBackground(Color.YELLOW);
            voto = 0;
            
        }
        
        /**
         * Restituisce il valore del voto memorizzato in this
         * @return il valore del voto 
         */
        public int getVoto(){
            return voto;
        }
        
        /**
         * Resetta la casella impostando "" (stringa vuota) su sfondo GIALLO e voto = 0 (non valido)
         */
        public void resetVoto(){
            voto=0;
            setText("");
            setBackground(Color.YELLOW);
        }
        
        /**
         * Genera un voto casuale (un voto valido è entro il range 1..10)
         * Imposta e visualizza il voto generato su this
         */
        public void generaVotoCasuale(){
            voto = (int) (Math.random() * 10)+1;  
            if (voto<6) 
                setBackground(Color.RED);
            else 
                setBackground(Color.GREEN);
            setText(String.valueOf(voto));
        }
 
}
