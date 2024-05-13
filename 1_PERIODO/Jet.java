public class Jet extends Aeromotore{
    private int mountedMotors;

    public Jet(String ID, int CV, int mountedMotors) {
        super(ID, CV);
        this.mountedMotors = mountedMotors;
    }
    
    public int getMountedMotors(){
        return mountedMotors;
    }

    public boolean morePowerful(Aeromobile x){
    if(x.getClass()!=getClass()) throw new IllegalArgumentException("Can't compare this to a JET'");
        Aeromotore a = (Aeromotore) x;
        return getCV()==a.getCV();
    }

    @Override
    public String toString() {
        return super.toString() + getMountedMotors() + " mounted motors";
    }
}
