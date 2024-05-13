import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class e11_2 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("1° PERIODO/FileTest.txt");
        Scanner sc = new Scanner(f);
        PrintWriter p = new PrintWriter("1° PERIODO/FileTest.txt");
        int i = 1;
        while (sc.hasNextLine()) {
            p.println("/*" + i + "*/" + sc.nextLine());
            i++;       
        }

        sc.close();
        p.close();
    }
}
