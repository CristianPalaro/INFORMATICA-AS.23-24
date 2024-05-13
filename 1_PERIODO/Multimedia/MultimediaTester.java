package Multimedia;
public class MultimediaTester {
    public static void main(String[] args) {
        Audio m = new Audio("Pierri's Lesson", 4, 10);
        Image i = new Image("Santoro's Test Screenshot", 5);
        Footage f = new Footage("SCP Foundation: Found Footage", 10, 7, 20);

        m.play();
        i.show();
        f.play();

        System.out.println(m.compareTo(f));
    }
}
