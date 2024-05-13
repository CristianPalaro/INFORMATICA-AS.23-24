public class Hero extends Fighter{
    public Hero(String name, int stress){
        super(name, stress);
    }

    boolean isAlive(){
        return getStress()<100;
    }

    void transform() {
        //Gli eroi non hanno potere di transformarsi
    }

    @Override
    void attack(Fighter other) {
        if(isAlive()){
            if(this.getClass()==other.getClass()){
                System.out.println("non posso attacare altri eroi");
            }
            else{
                other.defend();
            }
        }
        else System.out.println("sono morto");
    }

    void rest(){
        if(isAlive()) super.addStress(-getStress());;
    }

    @Override
    public String toString() {
        return "Fighter: "+getName()+" "+"Stress points: "+getStress();
    }
}
