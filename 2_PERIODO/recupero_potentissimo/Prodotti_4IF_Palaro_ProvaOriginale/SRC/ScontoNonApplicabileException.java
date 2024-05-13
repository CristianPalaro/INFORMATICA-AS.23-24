/* COGNOME e NOME:
   CLASSE:
   DATA:
*/
/* DI QUESTA CLASSE CONOSCI SOLO IL NOME! 
   DEVI COMPLETARLA SAPENDO CHE POTRA' ISTANZIARE UNA ECCEZIONE PERSONALIZZATA CHE GIUSTIFICA IL MOTIVO PER CUI 
   NON SARA' POSSIBILE APPLICARE LO SCONTO SU UN PRODOTTO SCONTABILE
*/
public class ScontoNonApplicabileException extends Throwable{

   public ScontoNonApplicabileException() {
      getMessage();
   }



   public ScontoNonApplicabileException(String message) {
      super(message);
   }

   

   public String getMessage(){
      return "Impossibile applicare lo sconto";
   }
    
}
