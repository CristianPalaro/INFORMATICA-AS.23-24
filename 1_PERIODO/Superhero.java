public class Superhero extends Hero{
    private Boolean Superpower;

    public Superhero(String name, int stress){
        super(name, stress);
        Superpower=false;
    }

    @Override
    void transform(){
        Superpower=true;
    }

    @Override
    void attack(Fighter other) {
        if(isAlive()){
            if(other.getClass()!=this.getClass()){
                if(!Superpower) super.attack(other);
                else other.addStress(100);
            }
                else System.out.println("Non posso attaccare un'altro eroe");
        }
            else System.out.println("Sono morto");
    }

    void defend(){
        if(isAlive()){
            if(!Superpower) super.defend();
        }
        else System.out.println("Sono morto");
    }

    @Override
    public String toString() {
        return "Fighter: "+getName()+" "+"Stress points: "+getStress();
    }
}
