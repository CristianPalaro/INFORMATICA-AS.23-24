package Multimedia;
public class Image extends MultimediaElements implements Luminosity,Comparable{
    private int luminosity;

    public Image(String titol, int luminosity){
        super(titol);
        this.luminosity = luminosity;
    }

    public void show(){
        String a = "";
        for(int i =0; i<luminosity; i++) a+="*";
        System.out.println(super.getTitol() +" Luminosity:" +a);
    }

    @Override
    public void brighter() {
        luminosity++;
        
    }

    @Override
    public void darker() {
        luminosity--;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Luminosity){
            Image f = (Image) o;
            return this.luminosity-f.luminosity;
        }
        throw new IllegalArgumentException("Cannot compare them because they're not the same type of file");
    }
}
