import java.util.ArrayList;
import java.util.Scanner;

/* COGNOME e NOME:
   CLASSE:
   DATA:
*/
/* QUESTA CLASSE DEVE ESSERE COMPLETATA NELLE PARTI IN CUI APPARE LA STRINGA "CANCELLAMI E COMPLETA"
   LE PARTI GIA' SCRITTE NON POSSONO ESSERE MODIFICATE!! */

public class ProdottiTester {
    public static void main(String[] args){
        ArrayList <Prodotto> prodottiInVendita = new ArrayList<>();
        GestoreFile gestore = new GestoreFile("sex.txt");

        prodottiInVendita = gestore.getListaProdotti();

        Scanner sc = new Scanner(System.in);

        for (Prodotto p:prodottiInVendita){

            if(p.getClass().equals("ProdottoAlimentare")){
                System.out.println("input discount amount: ");
                int perc = sc.nextInt();
                p.setPrezzo(p.getPrezzo()/100 * perc);
            }
            System.out.println(p.toString());
            
            System.out.println("\n");

        }
        
    }
}
