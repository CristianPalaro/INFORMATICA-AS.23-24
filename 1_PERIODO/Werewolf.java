import java.util.Random;

public class Werewolf extends Fighter{
    private String Wolfname;
    private boolean Humanform;
    private boolean Fullmoon;
    Random rd = new Random();

    public Werewolf(String Humanname,int stress, String Wolfname, boolean Fullmoon) {
        super(Humanname, stress);
        this.Wolfname = Wolfname;
        Fullmoon=rd.nextBoolean();
    }

    @Override
    public String getName() {
        if(!Fullmoon) return super.getName();
        return Wolfname;
    }

    @Override
    public void transform(){
        Humanform=!Humanform;
    }

    @Override
    void defend(){
        if(getStress()<100&&Humanform) addStress(10);
        addStress(5);
    }

}
