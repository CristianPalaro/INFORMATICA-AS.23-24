import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AutoManager{
    private ArrayList<Auto2> a;
    /*
     * passato nome file
     * associo scanner leggo contenuto (nome auto, km , e litri)
     * arraylist di stringe
     */
    /**
     * @param a
     * @param fileName
     */
    public AutoManager() {
        this.a = new ArrayList<>();
    }
        
    public void readFromFile() throws FileNotFoundException{
        File f = new File("datiAuto.txt");
        Scanner sc  = new Scanner(f);

        while (sc.hasNext()) {
            Auto2 b = new Auto2(sc.next(), sc.nextInt(), sc.nextInt());
            a.add(b);
            sc.nextLine();
        }

        sc.close();
    }

    @Override
    public String toString() {
        String line = "";
       for(int i = 0; i<a.size(); i++){
            line+=" "+ a.get(i).getName()+ " " + a.get(i).getresa();
       }
       return line;
    }
}
