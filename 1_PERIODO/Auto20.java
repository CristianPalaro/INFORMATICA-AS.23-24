import java.util.InputMismatchException;

public class Auto20 {
    private String name; 
    private int km; 
    private int liters;

    /**
     * @param name
     * @param km
     * @param liters
     */
    public Auto20(String name, int km, int liters) {
        this.name = name;
        this.km = km;
        this.liters = liters;
    }

    public double getresa(){
        double res = 0;

            //try sequence
            try{
                res = km/liters;
                if(res < 0) throw new IllegalArgumentException("EFFICIENCY CAN'T NEGATIVE");
            }

            //catch sequence
            catch(InputMismatchException i){
                System.out.println("NUMBER IS NOT AN INTEGER");
            }
            catch(ArithmeticException a){
                System.out.println("PROVA 0");
                return 0;
            }

        return res;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the liters
     */
    public int getLiters() {
        return liters;
    }
}
