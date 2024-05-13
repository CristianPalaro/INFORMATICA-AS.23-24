public class Aeromotore extends Aeromobile implements Aeromodello{
    private int CV;

    public Aeromotore(String ID, int CV) {
        super(ID);
        this.CV = CV;
    }

    public int getCV() {
        return CV;
    }

    @Override
    public String getType() {
        return "type: " + this.getClass();
    }

    @Override
    public boolean morePowerful(Aeromobile x) {
        if(x.getClass()!=getClass()) return false;
        Aeromotore a = (Aeromotore) x;
        return getCV()==a.getCV();
    }

	@Override
	public String getID() {
		return toString();
	}

    @Override
    public String toString() {
        return super.toString()+ getCV() + " CV";
    }
}
