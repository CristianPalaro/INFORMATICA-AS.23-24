/* QUESTA CLASSE NON DEVE ESSERE MODIFICATA */
public class Prodotto {
    private String descrizione;
    private double prezzo;

    public Prodotto(String descrizione, double prezzo) {
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }



    public String getDescrizione() {
        return descrizione;
    }



    public double getPrezzo() {
        return prezzo;
    }



    public void setPrezzo(double nuovoPrezzo) {
        prezzo = nuovoPrezzo;
    }


    
    @Override
    public String toString() {
        return "Prodotto "+this.getClass().getName()+"\n\tDescrizione: " + descrizione + "\n\tPrezzo: " + prezzo + " euro";
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }



    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }



    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }  

    
    
}
