import java.util.ArrayList;
import java.util.Random;

public class Race{
    private String name; 
    boolean inCourse;
    ArrayList<Pilot> pilots;

    public Race(String name) {
        this.name = name;
        inCourse = true;
        this.pilots = new ArrayList<>();
    }

    public void addPilot(int pos, Pilot pilot){
        pilots.add(pos, pilot);
    }

    public void raceGrid(){
        Random gen = new Random();
        
        for(int i = 0; i<pilots.size(); i++){
            int rnd = gen.nextInt(60);
            this.pilots.add(new Pilot(pilots.get(i).getName(), pilots.get(i).getScuderia(), rnd));
        }
    }

    public void startRace(){
        inCourse = !inCourse;
    }
    
    private int currentPos(String pilotName){
        for(int i = 0; i<pilots.size(); i++){
            if(pilotName.equals(pilots.get(i).getName())) return i;
        }
        
        return -1;
    }

    public String ranking(){
        return pilots.toString();
    }

    public void outofRace(String pilotName){
        pilots.remove(pilotName);
    }

    public void overTake(String pilotName){
        int pos = currentPos(pilotName);
        if(pos>0){
            pilots.add(pos-1, pilots.get(pos));
            pilots.remove(pos+1);
        }
    }

    public void pitStop(String pilotName){
        int pos = currentPos(pilotName);
    if(pos<=pilots.size()-4){
        pilots.add(pos+3, pilots.get(pos));
    }
    else{
        pilots.add(pilots.get(pos));
    }

    pilots.add(pilots.get(pos));
    }

    public void stop(){
        inCourse = false;
        String s = "";

        s+="WINNER: " + pilots.get(0).getName();
    }


    public static void main(String[] args) {
        Pilot s = new Pilot("gesu", "null", 9013);
        Pilot s1 = new Pilot("ahh", "africa", 9013);
        Pilot s2 = new Pilot("gesu", "lamapotente", 9013);

        Race r = new Race("grand priz");
        System.out.println(r.ranking());
    }
}
