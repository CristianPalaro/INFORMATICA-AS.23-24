/* COGNOME e NOME:
   CLASSE:
   DATA:
*/
/* DI QUESTA CLASSE CONOSCI SOLO IL NOME! 
   DEVI COMPLETARLA SULLA BASE DEL DIAGRAMMA UML FORNITO*/
public class ProdottoNonAlimentare extends Prodotto{
   private String ingombro;

   public ProdottoNonAlimentare(String descrizione, double prezzo, String ingombro) {
     
      super(descrizione, prezzo);
      this.ingombro = ingombro;

   }



   @Override
   public String toString() {
       // TODO Auto-generated method stub
       return super.toString() + "ingombro: " + ingombro;
   }



   @Override
   public int hashCode() {

      final int prime = 31;
      int result = 1;

      result = prime * result + ((ingombro == null) ? 0 : ingombro.hashCode());
      
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

      ProdottoNonAlimentare other = (ProdottoNonAlimentare) obj;
      if (ingombro == null) {

         if (other.ingombro != null)
            return false;

      } 
      
      else if (!ingombro.equals(other.ingombro))
         return false;

      return true;
      
   }



   @Override
   protected Object clone() throws CloneNotSupportedException {


      // TODO Auto-generated method stub
      return super.clone();


   }

   
}
