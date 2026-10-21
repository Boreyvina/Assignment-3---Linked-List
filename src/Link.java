public class Link<T> {

    public T data;
    public Link<T> next;

    // O(1): stores the data and starts with no next node
    public Link(T data) {
        this.data = data;
        this.next = null;
    }
}