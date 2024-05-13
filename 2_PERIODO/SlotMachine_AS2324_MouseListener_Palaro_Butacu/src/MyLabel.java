

import java.awt.Font;
import javax.swing.JLabel;

/* QUESTA CLASSE NON E' MODIFICABILE */
public class MyLabel extends JLabel {
    
    private String etichetta;
    private int valore;
    
    public MyLabel(String etichetta,int valore){
        this.etichetta = etichetta+" ";
        this.valore = valore;
        setFont(new Font("sans-serif", Font.PLAIN, 20));
        setText(this.etichetta + valore);       
    }
    
    public void setValore(int valore){
        this.valore = valore;
        setText(etichetta + valore);
    }
    
    public int getValore(){
        return valore;
    }
    
    public void incrementa(){
        valore++;
        setText(etichetta + valore);
    }
    
    public void decrementa(){
        valore--;
        setText(etichetta + valore);
    }
    
    public void aggiungi(int valore){
        this.valore += valore;
        setText(etichetta + this.valore);
    }
    
}
