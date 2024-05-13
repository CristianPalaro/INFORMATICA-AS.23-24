package Multimedia;
public class Footage extends MultimediaElements implements Reproducable, Luminosity,Comparable{
    int length;
    private int volume; //referred in minutes
    private int luminosity;

    public Footage(String titol, int length, int volume, int luminosity) {
        super(titol);
        this.length = length;
        this.volume = volume;
        this.luminosity=luminosity;
    }

    
    public void play() {
        String a = "";
        for(int i =0; i<volume; i++) a+="*";
        System.out.println(getTitol() +" Volume:" +a);

        show();
    }

    
    public void show() {
        String a = "";
        for(int i =0; i<luminosity; i++) a+="*";
        System.out.println(getTitol() +" Luminosity:" +a);
    }

    
    public void louder() {
        volume++;
    }

   
    public void weaker() {
        volume--;
    }

    
    public void brighter() {
        luminosity++;
    }

    
    public void darker() {
        luminosity--;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Luminosity || o instanceof Reproducable){
            Footage f = (Footage) o;
            return this.luminosity-f.luminosity;
        }
        throw new IllegalArgumentException("Cannot compare them because they're not the same type of file");
    }
}
