/* COGNOME e NOME: Palaro Cristian
 * CLASSE:  4ID
 * DATA: 23/10/2023
 */

/* QUESTA CLASSE NON PUO' ESSERE MODIFICATA */
public abstract class Personaggio {    
    private String nome;

    public Personaggio(String unNome){
        nome = unNome;
    }
    public String getNome(){
        return nome;
    }
    
    public abstract boolean isVivo();    
    public abstract void difenditi(int potenzaColpo);

    @Override
    public String toString(){
        return nome + " (" + getClass().getName() + ") ";
    }    
}
