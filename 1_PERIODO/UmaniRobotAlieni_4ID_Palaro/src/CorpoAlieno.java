/* COGNOME e NOME: Palaro Cristian 
 * CLASSE: 4ID
 * DATA: 23/10/2023
 */

/* QUESTA CLASSE NON PUO' ESSERE MODIFICATA */
import java.util.Random;

/**
 * La classe CorpoAlieno gestisce l'integrita corporea di un Alieno.
 * Nell'ipotesi che il corpo di un alieno sia composto da 12 parti distinte,
 * la classe lo rappresenta per mezzo di un array di caratteri che potranno contenere
 * il carattere 'I' (parte del corpo INTEGRA) o 'N' (parte del corpo NON INTEGRA).
 * 
 * All'atto dell'istanziazione tutto il corpo è integro (l'array conterrà 12 'I')
 */

public class CorpoAlieno {
    
    private char[] corpo = new char[12];

    /**
     *Costruttore: permette di inizializzare un corpo composto da 12 parti totalmente integro
     */
    public CorpoAlieno(){
        for (int i=0;i<12;i++)
            corpo[i]='I'; // imposta l'integrita 'I' in ogni parte del corpo alieno
    }

    /**
     * Restituisce il conteggio delle parti integre del corpo,
     * un corpo completamente non integro decreta la morte dell'alieno.
     * @return il conteggio delle parti ancora integre del corpo 
     */
    public int quantificaIntegrita(){
        int conteggio = 0;
        for (char c:corpo)
            if (c == 'I')
                conteggio++;
        return conteggio;
    }

    /**
     * Il metodo permette di infliggere un danno al corpo alieno 
     * (il corpo non sarà più totalmente integro).
     * Delle 12 parti del corpo (rappresentato dall'array di 12 caratteri)
     * viene scelta una parte in modo randomico e impostata al valore 'N' (NON INTEGRO)
     * Potrebbe accadere che la parte del corpo scelta in modo randomico sia già non integra; 
     * in questo caso l'integrità resta immutata. 
     */
    public void infliggiDanno(){
        int parteRandomicaCorpo = new Random().nextInt(12);
        corpo[parteRandomicaCorpo] = 'N';
    }

    /**
     * Restituisce l'integrità corporea dell'alieno in formato sringa riportando
     * anche il numero di parti ancora integre;
     * Esempio 1:   IINIINNNIINI (7)  Un alieno con sole 7 parti del corpo integre
     * Esempio 2:   IIIIIIIIIIII (12) Un alieno in salute! Tutte le parti del corpo sono integre!
     * Esempio 3:   NNNNNNNNNNNN (0)  Un alieno defunto!
     * @return una stringa che rappresenta lo stato di this
     */
    @Override
    public String toString() {
        return new String(corpo) + "("+quantificaIntegrita()+")";
    }
}
