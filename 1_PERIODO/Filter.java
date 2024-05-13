public interface Filter {
    boolean accept(Object o);
    default boolean reject(Object o) {
        if(o instanceof Auto20){
            return true;
        }
        return false;
    }
}
