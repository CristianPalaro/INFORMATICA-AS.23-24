public abstract class Aeromobile {
    private String ID;

    public Aeromobile(String ID){
        this.ID = ID;
    }

    public abstract String getID();

    @Override
    public String toString() {
        return ID;
    }
}
