import javax.swing.JOptionPane;

/* QUESTA CLASSE NON E' MODIFICABILE */
public class SlotMachineGo {
    public static void main(String[] args) {

        int nCaselle = 0;
        do{
            String strNumCaselleSlot = JOptionPane.showInputDialog(null,"Numero di Caselle linea singola (2..10)","Dialog di inserimento",JOptionPane.QUESTION_MESSAGE);
            nCaselle = 0;
            if (strNumCaselleSlot!=null && !strNumCaselleSlot.equals(""))
                nCaselle = Integer.parseInt( strNumCaselleSlot );                
        }while( !(nCaselle>=2 && nCaselle<=10) );
        
        new SlotMachine(nCaselle);
        
    }
}
