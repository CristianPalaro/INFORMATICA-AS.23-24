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
public class Robot extends Personaggio implements actions{
    private String name; 
    private int charge;

    /**
     * costruttore parametrico completo
     * @param name nome del personaggio
     */
    public Robot(String name) {
        super(name);
        this.charge = 100;
    }

    /**
     * verifica attraverso lo stress se il personagggio è vivo o morto
     * se charge è uguale a 0 il personaggio è morto
     * @return vero se il personaggio è vivo,false se è morto
     */
    @Override
    public boolean isVivo() {
       return charge < 100;
    }

    /**
     * metod o che permette ad un personaggio di difendersi da un attacco
     * @param potenzaColpo colpo inflitto 
     */
    @Override
    public void difenditi(int potenzaColpo) {
        if(!isVivo()) throw new IllegalArgumentException("IL PERSONAGGIO E' MORTO");
        charge -= 1;
    }

    /**
     * metodo che permette ad un personaggio di attaccare un'altro personaggio
     * controllo anche che il personaggio attaccato non sia un alleato
     * @param other personaggio da attaccare
     */
    @Override
    public void attack(Personaggio other) {
        if(other instanceof Umani ||other instanceof Robot) throw new IllegalArgumentException("UN ROBOT NON PUO' ATTACCARE I SUOI ALLEATI ");
        this.charge-=2;
        other.difenditi(charge);
    }

    @Override
    public void flyattack(Personaggio other) {
        throw new UnsupportedOperationException("Character doesn't have the power to fly");
    }
    
    /**
     * metodo che permette ad un personaggio di riposare quindi resettando lo stress la carica o l'integrita
     */
    public void recharge(){
        charge = 100;
    }
    
    /**
     * metodo che stampa le informazioni di un personaggio
     * @return informazioni del personaggio
     */
    @Override
    public String toString(){
        return super.toString() + ") " + "carica batteria = "+ charge + " tacche";
    }
}
