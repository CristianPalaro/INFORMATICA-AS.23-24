public class Data implements Measurer, Filter{
    public static double average(Object[] objects, Measurer meas, Filter filt){
        double sum = 0;
        double counter = 0;
        for(int i = 0; i<objects.length; i++){
            if(filt.accept(objects[i]) == true){
                sum += meas.measure(objects[i]);
                counter++;
            }

            if(objects.length > 0) return sum/counter;
        }
        return -1;
    }
    @Override
    public double measure(Object o) {
        if(o instanceof Auto20){
            Auto20 a = (Auto20) o;
            return a.getresa();
        }

        return -1;
    }

    @Override
    public boolean accept(Object o) {
        if(o instanceof Auto20){
            Auto20 a = (Auto20) o;
            return a.getLiters()>0;
        }
        return false;
    }
}
