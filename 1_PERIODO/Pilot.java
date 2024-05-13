public class Pilot {
    private String name;
    private String scuderia;
    private int points;

    public Pilot(String name, String scuderia, int points) {
        this.name = name;
        this.scuderia = scuderia;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public String getScuderia() {
        return scuderia;
    }

    public int getPoints() {
        return points;
    } 
    
    @Override
    public String toString() {
        return name+" "+"("+points+")"+" "+scuderia;
    }
}
