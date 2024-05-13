
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
/*
            COME RISPONDE QUESTO ASCOLTATORE ...
            1) al click di rbMedia aggiorna lblInfo con la media dei voti calcolata sui voti effettivamente presenti nell'array txtsVoti (VEDI DEMO)
            2) al click di rbEsito aggiorna lblInfo con una delle seguenti stringhe: 
                "PROMOSSO" in presenza di tutti i voti e media >= 6 (VEDI DEMO) 
                "BOCCIATO" in presenza di tutti i voti e media <6   (VEDI DEMO)
                "VOTI INSUFFICIENTI" se non sono presenti tutti i voti (VEDI DEMO)
            SUGGERIMENTO: demanda a metodi privati il calcolo e la restituzione 
                          del conteggio dei voti, della media e dell'esito. Completa quindi i metodi :
                            - private int contaVoti()
                            - private double getMedia()
                            - private String getEsito()
            SUGGERIMENTO: SE VUOI FORMATTARE LA MEDIA CON 2 CIFRE DOPO LA VIRGOLA PUOI USARE COME SOLUZIONE QUELLA CHE SEGUE:
                                DecimalFormat df = new DecimalFormat("###.##");
                                double unaMedia = 123.2398765    
                                System.out.println("Media = " + df.format(unaMedia) ); -> visualizza "MEDIA = 123.24"
*/
public class RadioButtonListener implements ActionListener{
    VotiForm form;
    double media;

    public RadioButtonListener(VotiForm form) {
        this.form = form;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if(form.rbMedia.isSelected()){
            media = 0.0;
            int sum = 0;
            int votecounter = 0;

            for (int i = 0; i < form.txtsVoti.length; i++) {
                if(!form.txtsVoti[i].getText().equals("")){
                    votecounter++;
                    sum += form.txtsVoti[i].getVoto();
                }
            }

            //System.out.println(votecounter);

            media = sum/votecounter;

            form.lblInfo.setText("MEDIA: "+ media);
        }

        if(form.rbEsito.isSelected())
                form.lblInfo.setText(getEsito(media));
    }
    

        private String getEsito(double media){
            if(media >= 6.0) return "PROMOSSO";
            if(media < 6.0) return "BOCCIATO";

            int votecounter2 = 0;
            for (int i = 0; i < form.txtsVoti.length; i++) {

                if(form.txtsVoti[i].getText() == ""){
                    votecounter2++;
                }

            }

            if(votecounter2 != form.txtsVoti.length){

                return "VOTI INSUFFICIENTI";

            }

            return "";
        }
}
