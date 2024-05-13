import java.util.InputMismatchException;
import java.util.Scanner;

public class NumeriValidi {
    static Scanner sc = new Scanner(System.in);

    //scrivere solo metodi statici
    public static int leggiIntero(String msg){
        int num=0;
        boolean isOk = false;
        System.out.println(msg); 
        do{
            try{
                System.out.print("input a string: ");
                num = Integer.parseInt(sc.nextLine());

                isOk = true;
            }

            catch(NumberFormatException n){
                System.out.println("NUMBER'S NOT AN INTEGER");
            }
            finally{
                sc.nextLine();
            }
        }while(!isOk);

        return num;
    }

    public static int leggiInteroNonNegativo(String msg){
        int num=0;
        boolean isOk = false;
        System.out.println(msg); 
        do{
            try{
                num = leggiIntero(msg);
                if (num < 0)
                    throw new InputMismatchException("Invalid number");
                isOk = true;
            }

            catch(InputMismatchException n){
                System.out.println(n.getMessage());
            }
        }while(!isOk);

        return num;
    }

    public static int leggiInteroPositivo(String msg){
        int num=0;
        boolean isOk = false;
        System.out.println(msg); 
        do{
            try{
                System.out.print("input a string: ");
                num = leggiInteroNonNegativo(msg);
            }

            catch(NumberFormatException n){
                System.out.println("NUMBER IS NEGATIVE");
            }
            finally{
                sc.nextLine();
            }
        }while(!isOk);

        return num;
    }

    public static void main(String[] args) {
        System.out.println(leggiInteroPositivo("-45"));
    }
}
