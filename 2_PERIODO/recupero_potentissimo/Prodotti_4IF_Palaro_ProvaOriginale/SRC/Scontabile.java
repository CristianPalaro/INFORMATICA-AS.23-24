/* QUESTA INTERFACCIA NON DEVE ESSERE MODIFICATA */
public interface Scontabile {

    void applicaSconto(int percentuale) throws ScontoNonApplicabileException;


    
    boolean inScadenza();



    boolean scaduto();

}