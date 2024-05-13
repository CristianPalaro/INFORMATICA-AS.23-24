import java.util.InputMismatchException;
import java.util.Scanner;

public class Gas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int km;
        int liters; 
        float res;

        boolean isOk= false;

        do{
            //try sequence
            try{
                km = sc.nextInt();

                System.out.println();

                liters = sc.nextInt();

                System.out.println();

                res = km/liters;

                isOk = true;
            }

            //catch sequence
            catch(InputMismatchException i){
                System.out.println("NUMBER IS NOT AN INTEGER");
            }
            catch(ArithmeticException a){
                System.out.println("LITERS CAN'T BE 0");
            }

            //finally sequence
            finally{
                sc.nextLine();
            }
        }
        while(!isOk);
    }
}