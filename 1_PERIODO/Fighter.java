public abstract class Fighter {
    private String name;
    private int stress;

    public Fighter(String name, int stress) {
        this.name = name;
        this.stress = stress;
    }

    public String getName() {
        return name;
    }

    public int getStress() {
        return stress;
    }

    boolean isAlive(){
        return stress<100;
    }

    void attack(Fighter other){
        if(stress<100){
            this.stress+=5;
            other.defend();
        }
    }

    public void addStress(int stress){
        this.stress+=stress;
    }

    void defend(){
        if(stress<100) stress+=10;
    }

    void rest(){
        if(isAlive()) stress=0;
    }

    abstract void transform();

    @Override
    public String toString() {
        return "Fighter: "+getName()+" "+"Stress points: "+getStress();
    }
}
