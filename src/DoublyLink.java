public class DoublyLink<T> {
    public T data;
    public DoublyLink<T> next;
    public DoublyLink<T> previous;


    public DoublyLink(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }


    @Override
    public String toString() {
        return String.valueOf(data);
    }
}