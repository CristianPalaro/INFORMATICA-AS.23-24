import javax.swing.JTextField;

public class GraphicCounter extends JTextField{
    private int counter;

    public GraphicCounter() {
        counter = 0;
    }

    public void increase(){
        counter++;
        setText(counter);
    }

    public void decrease(){
        counter--;
        setText(counter);
    }

    public void reset(){
        counter = 0;
        setText(counter);
    }

    @Override
    public String toString() {
        return ""+counter;
    }

    public void setText(int value){
        setText(String.valueOf(value));
    }
}   