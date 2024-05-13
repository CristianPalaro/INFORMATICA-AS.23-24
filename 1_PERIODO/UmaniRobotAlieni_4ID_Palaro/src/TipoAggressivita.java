public enum TipoAggressivita {
    NULLA(0),
    BASSA(1),
    MEDIA(2),
    ALTA(3);
    private int livello;
    public int getLivello(){
      return livello;  
    }
    private TipoAggressivita(int livello){
        this.livello = livello;
    }
    
    public void setLivello(int lvl){
        this.livello = lvl;
    }
}

/*
    Viene definito un tipo enumerato ...
    Il tipo enumerato può essere pensato come un modo per definire variabili 
    che assumano solo un set finito di valori costanti, come ad esempio:
        i semi di una carta da gioco che possono assumere solo 4 possibili valori (CUORI, QUADRI, FIORI e PICCHE)
        i giorni di una settimana che possono assumere solo 7 possibili valori (LUN, MAR, MER, ...)
        i mese dell'anno (GEN, FEB, MAR, ...)


    In questo caso specifico viene definito un tipo enumerato TipoAggressivita 
    che può assumere solo i valori NULLA, BASSA, MEDIA e ALTA 
    quantificabile, rispettivamente, da un livello intero 0, 1, 2 e 3
    
    Una variabile del tipo enumerato descritto sopra può essere 
    definita e impostata come segue:
        
        TipoAggressivita aggressivita;
        aggressivita = TipoAggressivita.ALTA
        System.out.println("Aggressivita = " + aggressivita )   STAMPA -> "Aggressivita = ALTA"
        System.out.println("Livello aggressivita = " + aggressivita.getLivello() )   STAMPA -> "Livello aggressivita = 3"
*/
