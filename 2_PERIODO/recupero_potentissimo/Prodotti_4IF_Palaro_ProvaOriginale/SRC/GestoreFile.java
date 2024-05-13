import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/* COGNOME e NOME:
   CLASSE:
   DATA:
*/
/* QUESTA CLASSE DEVE ESSERE COMPLETATA SOLO NELLE PARTI IN CUI APPARE LA STRINGA "CANCELLAMI E COMPLETA"
   LE PARTI GIA' SCRITTE NON POSSONO ESSERE MODIFICATE!!
   I COMMENTI CONTRASSEGNATI DA "NOTA" SONO INDICAZIONI O INTEGRAZIONI DI CONSEGNA
*/

/*
 * NOTA: La seguente classe ha il compito di leggere un file di testo strutturato 
 * a colonne come segue:
 * 
 * COLONNA 1        COLONNA 2   COLONNA 3                   COLONNA 4
 * DESCRIZIONE      PREZZO      GGSCADENZA/INGOMBRO         DA BANCO
 * (String)         (double)    (int / String)              (boolean)       
 * -------------------------------------------------------------------
 * Burro            10,0            20                      TRUE
 * Latte            10,0            3                       FALSE
 * Detersivo        10,0            MEDIO                   FALSE
 * Pasta            10,0            9                       FALSE
 * 
 * Crea una ArrayList di Prodotti (ALIMENTARI (ANCHE DA BAMCO) e NON ALIMENTARI) che potrà essere restituito. 
 * 
 */
public class GestoreFile {

    private ArrayList<Prodotto> listaProdotti;

    public GestoreFile(String nomeFile){
        listaProdotti = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(nomeFile))) {



            while(sc.hasNextLine()){



                if(sc.nextLine().contains("True")){
             
                    Prodotto p = new ProdottoDaBanco(sc.next(), sc.nextInt(), sc.nextInt());
                    listaProdotti.add(p);

                }



                else{

                    Prodotto p = new ProdottoNonAlimentare(sc.next(), sc.nextDouble(), sc.next());
                    listaProdotti.add(p);

                }

            }

        } 



        catch (FileNotFoundException e) {
            System.out.println("File name " + "'" + nomeFile + "'" + " couldn't be found");
        }
        


        finally{
            System.out.println("\n");
        }
        
    }
    
    public ArrayList<Prodotto> getListaProdotti(){
        return listaProdotti;
    }  
}
