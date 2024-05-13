/* COGNOME e NOME:
   CLASSE:
   DATA:
*/
/* DI QUESTA CLASSE CONOSCI SOLO IL NOME! 
   DEVI COMPLETARLA SULLA BASE DEL DIAGRAMMA UML FORNITO*/
public class ProdottoDaBanco extends ProdottoAlimentare{

   public ProdottoDaBanco(String descrizione,int prezzo, int giorniAllaScadenza) {
      super(descrizione, prezzo, giorniAllaScadenza);
   }



   public boolean scadenzaImminente(){
      return false;
   }
    


   @Override
   public void applicaSconto(int percentuale) throws ScontoNonApplicabileException {
       // TODO Auto-generated method stub
       if(inScadenza()) super.applicaSconto(percentuale + 50);
       super.applicaSconto(percentuale);
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


   
   @Override
   public String toString() {
       // TODO Auto-generated method stub
       return super.toString();
   }
}
