public class Glider extends Aeromobile implements Aeromodello{
	private int efficiency;

	public Glider(String ID, int efficiency) {
		super(ID);
		this.efficiency=efficiency;
	}

	@Override
	public String getType() {
		return "type: " + this.getClass();
	}

	@Override
	public boolean morePowerful(Aeromobile x) {
		return false;
	}

	public int getEfficiency() {
		return efficiency;
	}

	@Override
	public String getID() {
		return getID();
	}

	@Override
	public String toString() {
		return super.toString() + getEfficiency();
	}
}
