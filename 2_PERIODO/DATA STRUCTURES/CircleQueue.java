import java.util.ArrayList;

public class CircleQueue<E> {
    private ArrayList<E> circleQueue;
    private int start,end,logicalSize;

    /*
     * Constructor
     * @param dim: Dimension of the queue
     */
    public CircleQueue(int dim){
        circleQueue = new ArrayList<>(dim);
        start = 0;
        end = -1;
        logicalSize = 0;
    }



    /*
     * Get the start index of the queue
     * @return start index
     */
    public int getStart() {
        return start;
    }



    /*
     * Get the end index of the queue
     * @return end index
     */
    public int getEnd() {
        return end;
    }



    /*
     * Check if the queue is empty
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return circleQueue.isEmpty();
    }



    /*
     * Get the size of the queue
     * @return size of the queue
     */
    public int size(){
        return logicalSize;
    }



    /*
     * Add an element to the queue
     * @param elem: Element to add
     */
    public void enqueue(E elem){
        if(logicalSize == circleQueue.size()) throw new IllegalArgumentException("Queue is full");
        end = (end+1)%circleQueue.size();
        circleQueue.add(end, elem);
        logicalSize++;
    }



    /*
     * Remove an element from the queue
     * @return the element removed
     */
    public E dequeue(){
        if(logicalSize == 0) throw new IllegalArgumentException("Queue is empty");
        

        E elem = circleQueue.get(start);
        logicalSize--;
        return circleQueue.remove(start);
    }



    /*
     * Get the first element of the queue
     * @return the first element of the queue
     */
    public E getFront(){
        if(logicalSize == 0) throw new IllegalArgumentException("Queue is empty");   
        return circleQueue.get(start);
    }

   
    @Override
    /*
     * Convert the queue to a string
     * @return the string representation of the queue
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < circleQueue.size(); i++) {
            int index = (start+i)%circleQueue.size();

            sb.append(circleQueue.get(index));
        }
        sb.append("]");

        return sb.toString();
    }
    
    /*
     * Main method
     * @param args: Command line arguments
     */
    public static void main(String[] args) {
        try {
            CircleQueue<String> c = new CircleQueue(10);

            System.out.println("start: " + c.getStart());
            System.out.println("end: " + c.getEnd());
            
            for (int i = 0; i < c.size(); i++) {
                c.enqueue("Hello-" + i);
            }


            System.out.println(c.toString());

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getCause());
        }
    }
}
