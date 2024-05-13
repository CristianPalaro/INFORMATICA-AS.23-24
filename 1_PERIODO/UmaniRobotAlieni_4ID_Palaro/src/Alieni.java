/* COGNOME e NOME: Palaro Cristian 
 * CLASSE: 4ID
 * DATA: 23/10/2023
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author palaro11339
 */
public class Alieni extends Personaggio implements actions{
    private String name;
    TipoAggressivita aggressivita;
    CorpoAlieno c = new CorpoAlieno();

    
    /**
     * costruttore parametrico completo
     * @param name nome del personaggio
     */
    public Alieni(String name) {
        super(name);
        this.aggressivita = TipoAggressivita.ALTA;
    }
    
    

    @Override
    public boolean isVivo() {
        if(c.quantificaIntegrita() == 0) return false;
        return true;
    }

    @Override
    public void difenditi(int potenzaColpo) {
        if(potenzaColpo < 15){
            c.infliggiDanno();
            
        }
        else{
            c.infliggiDanno();c.infliggiDanno();
        }
    }

    /**
     * metodo che permette ad un personaggio di attaccare un'altro personaggio
     * controllo anche che il personaggio attaccato non sia un alleato
     * @param other personaggio da attaccare
     */
    @Override
    public void attack(Personaggio other) {
        if(other instanceof Umani ||other instanceof Robot) throw new IllegalArgumentException("UN ROBOT NON PUO' ATTACCARE I SUOI ALLEATI ");
        other.difenditi(aggressivita.getLivello()*10);
    }

    @Override
    public void flyattack(Personaggio other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * metodo che stampa le informazioni di un personaggio
     * @return informazioni del personaggio
     */
    @Override
    public String toString() {
        c.quantificaIntegrita();
        return super.toString() + ") " + "aggressivita = "+ aggressivita + " (" +" Livello aggressivita = " + aggressivita.getLivello()+" )";
    }
}

/**
    TipoAggressivita aggressivita;
    aggressivita = TipoAggressivita.ALTA
    System.out.println("Aggressivita = " + aggressivita )   STAMPA -> "Aggressivita = ALTA"
    System.out.println("Livello aggressivita = " + aggressivita.getLivello() )   STAMPA -> "Livello aggressivita = 3"
*/
    