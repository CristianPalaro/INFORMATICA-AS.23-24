import java.util.ArrayDeque;

public class CodaDoppiaArrayDeque<E>{
    private ArrayDeque<E> deque;


    public CodaDoppiaArrayDeque(){
        deque = new ArrayDeque<E>();
    }

    public void addFirst(E elem){
        deque.addFirst(elem);
    }

    public void addLast(E elem){
        deque.addLast(elem);
    }

    public E removeFirst(){
        return deque.removeFirst();
    }


    public E removeLast(){
        return deque.removeLast();
    }

    public E getFirst(){
        return deque.getFirst();
    }

    public E getLast(){
        return deque.getLast();
    }

    public boolean isEmpty(){
        return deque.isEmpty();
    }

    public int size(){
        return deque.size();
    }

    public boolean isPalindrome(){
        

        while(!deque.isEmpty()){
            if(deque.removeFirst().equals(deque.removeLast())){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CodaDoppiaArrayDeque<Integer> coda = new CodaDoppiaArrayDeque<>();

        int i = 0;
        while(i < 10){
            coda.addFirst(i);
            coda.addLast(i);
            i++;
        }

        System.out.println(coda.isPalindrome());
    }

}
