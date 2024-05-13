/* COGNOME e NOME:
   CLASSE:
   DATA:
*/
/* DI QUESTA CLASSE CONOSCI SOLO IL NOME! 
   DEVI COMPLETARLA SULLA BASE DEL DIAGRAMMA UML FORNITO*/
public class ProdottoAlimentare extends Prodotto implements Scontabile{
    private int giorniAllaScadenza;



   public ProdottoAlimentare(String descrizione, int prezzo, int giorniAllaScadenza) {
      
      super(descrizione, prezzo);
      this.giorniAllaScadenza = giorniAllaScadenza;

   }



    @Override
    public String toString() {

        // TODO Auto-generated method stub
        return super.toString() + "giorni alla scadenza: " + giorniAllaScadenza;

    }



   @Override
   public void applicaSconto(int percentuale) throws ScontoNonApplicabileException {
     
      if(inScadenza()) setPrezzo(getPrezzo()/100 * percentuale);
         else throw new ScontoNonApplicabileException("lo sconto non è applicabile perché il prodotto non è in scadenza");
      
         
      if(scaduto()) throw new ScontoNonApplicabileException("lo sconto non è applicabile perché il prodotto è scaduto");
   
   }



   @Override
   public boolean inScadenza() {

      return giorniAllaScadenza <= 5;

   }



   @Override
   public boolean scaduto() {

      return giorniAllaScadenza == 0;

   }



   @Override
   public int hashCode() {

      final int prime = 31;
      int result = 1;

      result = prime * result + giorniAllaScadenza;

      return result;

   }


   
   @Override
   public boolean equals(Object obj) {

      if (this == obj)
         return true;

      if (obj == null)
         return false;

      if (getClass() != obj.getClass())
         return false;

      ProdottoAlimentare other = (ProdottoAlimentare) obj;
      if (giorniAllaScadenza != other.giorniAllaScadenza)
         return false;

      return true;
   }



   @Override
   protected Object clone() throws CloneNotSupportedException {

      // TODO Auto-generated method stub
      return super.clone();

   }

   
}
