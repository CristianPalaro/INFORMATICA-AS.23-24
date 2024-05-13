import java.util.ArrayList;

public class pila<E> {
    private ArrayList<E> pila;

    public pila(int dim){
        pila = new ArrayList<>(dim);
    }

    public E top(){
        return pila.get(pila.size()-1);
    }


    public void push(E elem){
        pila.add(elem);
    }


    public E pop(){
        return pila.remove(pila.size()-1);
    }


    public int size(){
        return pila.size();
    }


    public boolean isEmpty(){
        return pila.isEmpty();
    }


    public String arrayListToString() {
       return pila.toString();
    }


    public static void main(String[] args) {
        pila<Integer> pila = new pila<>(100);

        for (int i = 0; i < pila.size(); i++) {
            pila.push(i);
        }

        System.out.println(pila.arrayListToString());
    }
}