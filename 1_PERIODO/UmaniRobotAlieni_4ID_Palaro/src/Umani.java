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
public class Umani extends Personaggio{
    private String name;
    private int stress;

    /**
     * costruttore parametrico completo
     * @param name nome del personaggio
     */
    public Umani(String name) {
        super(name);
        this.stress = 0;
    }
    
    /**
     * verifica attraverso lo stress se il personagggio è vivo o morto
     * se stress è uguale a 100 il personaggio è morto
     * @return vero se il personaggio è vivo,false se è morto
     */
    @Override
    public boolean isVivo() {
        return stress < 100;
    }

    /**
     * metod o che permette ad un personaggio di difendersi da un attacco
     * @param potenzaColpo colpo inflitto 
     */
    @Override
    public void difenditi(int potenzaColpo) {
        if(!isVivo()) throw new IllegalArgumentException("IL PERSONAGGIO E' MORTO");
        stress += potenzaColpo;
    }
    
    /**
     * metodo che permette ad un personaggio di riposare quindi resettando lo stress la carica o l'integrita
     */
    public void rest(){
        stress = 0;
    }
    
    /**
     * metodo che stampa le informazioni di un personaggio
     * @return informazioni del personaggio
     */
    @Override
    public String toString(){
        return super.toString() + ") " + "stress massimo: 100" + "stress accumulato: "+ stress;
    }
    
}
