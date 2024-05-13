package Multimedia;
public class Audio extends MultimediaElements implements Reproducable,Comparable{
    private int length;
    private int volume;

    public Audio(String titol, int length, int volume) {
        super(titol);
        this.length = length;
        this.volume=volume;
    }

    @Override
    public void play(){
        String a = "";
        for(int i =0; i<volume; i++) a+="*";
        System.out.println(getTitol() +" Volume:" +a);
    }

    @Override
    public void louder(){
        volume++;
    }

    @Override
    public void weaker(){
        volume--;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Reproducable){
            Audio f = (Audio) o;
            return this.length-f.length;
        }
        throw new IllegalArgumentException("Cannot compare them because they're not the same type of file");
    }
}
