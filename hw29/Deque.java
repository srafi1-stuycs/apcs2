public interface Deque<T> {

    public void addFront(T obj);

    public T removeFront();

    public T peekFront();
    
    public void addLast(T obj);

    public T removeLast();

    public T peekLast();
    
    public boolean isEmpty();

    public int size();
    
}
