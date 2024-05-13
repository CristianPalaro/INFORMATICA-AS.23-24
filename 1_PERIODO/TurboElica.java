public class TurboElica extends Aeromotore{
    private int RPM;

	public TurboElica(String ID, int CV, int RPM) {
		super(ID, CV);
        this.RPM=RPM;
	}

	public int getRPM() {
		return RPM;
	}

    public boolean morePowerful(Aeromobile x){
    if(x.getClass()!=getClass()) return false;
        Aeromotore a = (Aeromotore) x;
        return getCV()==a.getCV();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString()+" "+getRPM()+" RPM";
    }
}
