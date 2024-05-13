/* NOME E COGNOME
   CLASSE
   DATA
*/

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/* NOTA: Prendi visione di come e' stata implementata questa classe che "specializza" una JLabel "standard". 
    E' specializzata a contenere e visualizzare uno specifico valoreIMC e la sua classificazione
    Per ssempio: 
        "IMC: 15 SOTTOPESO"
            oppure
        "IMC: 21 NORMOPESO"
            oppure
        "IMC: 35 OBESO"
            eccetera
*/

public class LabelImc extends JLabel{
    
    private double valoreIMC;
    
    public LabelImc (double valore){
        this.valoreIMC = valore;
        this.setFont(new Font("SansSerif",Font.BOLD,20));
        this.setForeground(Color.RED); /* imposta il colore del testo */
        mostra();
    }
    
    public void setValoreIMC(double valore){
        this.valoreIMC = valore;
        mostra();   
    }

    private String classificazione(){
        String classificazione="SOTTOPESO";
        if (valoreIMC>35.0) classificazione = "OBESITA' GRAVE";
        else if (valoreIMC>30) classificazione ="OBESITA'";
        else if (valoreIMC>25.0) classificazione = "SOVRAPPESO";
        else if (valoreIMC>18.0) classificazione = "NORMOPESO";
        return classificazione;
        
    }
 
    private void mostra(){
        if ( valoreIMC == 0.0)
            this.setText("IMC: "+String.valueOf(valoreIMC));
        else
            this.setText("IMC: "+String.valueOf(valoreIMC)+" "+classificazione());
    }
}
