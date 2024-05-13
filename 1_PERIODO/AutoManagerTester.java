import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class AutoManagerTester{
    public static void main(String[] args){
        AutoManager20 manager = new AutoManager20();

        try{
            manager.readFromFile();
        }
        catch(FileNotFoundException e){
            e.getMessage();
        }
        catch(NoSuchElementException e1){
            e1.getMessage();
        }
        catch(IllegalStateException e2){
            e2.getMessage();
        }

        System.out.println(manager.toString());
    }
}
