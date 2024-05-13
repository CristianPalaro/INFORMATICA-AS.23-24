import java.util.ArrayList;
import java.util.Arrays;

public class queue<E> {
    private ArrayList<E> queue;


    public queue(int dim){
        queue = new ArrayList<>(dim);
    }


    public int size(){
        return queue.size();
    }

    public void enqueue(E elem){
        queue.add(elem);
    }


    public E dequeue(){
        return queue.remove(queue.size()-1);
    }


    public E getFirst(){
        return queue.get(queue.size()-1);
    }

    @Override
    public String toString(){
        return Arrays.toString(queue.toArray());
    }

    public static void main(String[] args) {
        queue<Integer> x = new queue(100);


        for (int i = 0; i < x.size(); i++) {
            x.enqueue(i);
        }

        System.out.println(x.toString());


        // for (int i = 0; i < x.size(); i++) {
        //     x.dequeue();
        // }

        // System.out.println(x.toString());

    }
}
