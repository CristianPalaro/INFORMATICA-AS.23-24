import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AutoManager20{
    private ArrayList<Auto20> a;
    /*
     * passato nome file
     * associo scanner leggo contenuto (nome auto, km , e litri)
     * arraylist di stringe
     */
    /**
     * @param a
     * @param fileName
     */
    public AutoManager20() {
        this.a = new ArrayList<>();
    }
        
    public void readFromFile() throws FileNotFoundException{
        File f = new File("datiAuto.txt");
        Scanner sc  = new Scanner(f);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            /**
             *   String[] s = line.split("[ ]+", 0);
             *   Auto20 b = new Auto20(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]));
             * */
            Scanner in = new Scanner(line);
            Auto20 b = new Auto20(in.next(), in.nextInt(), in.nextInt());
            a.add(b);
        }

        sc.close();
    }

    @Override
    public String toString() {
        String line = "";
       for(int i = 0; i<a.size(); i++){
            line+= " "+ a.get(i).getName()+ " " + a.get(i).getresa();
       }
       return line;
    }
}
