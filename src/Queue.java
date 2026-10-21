public class Queue<T> {

    private LinkedList<T> list;

    // O(1): Creates an empty queue
    public Queue() {
        list = new LinkedList<>();
    }

    // O(1): Keeps compatibility with the array-based version
    public Queue(int arraySize) {
        this();
    }

    // O(1): Adds an item to the rear of the queue
    public void insert(T newItem) {
        list.insertLast(newItem);
    }

    // O(1): Removes and returns the front item
    // Returns null if the queue is empty
    public T remove() {
        T item = list.getFirst();

        if (item != null) {
            list.deleteFirst();
        }

        return item;
    }

    // O(1): Returns the front item without removing it
    // Returns null if the queue is empty
    public T peekFront() {
        return list.getFirst();
    }

    // O(1): Returns the rear item without removing it
    // Returns null if the queue is empty
    public T peekRear() {
        return list.getLast();
    }

    // O(n): Returns the queue as a string (front to rear)
    @Override
    public String toString() {
        return list.toString();
    }

    // O(n): Displays the queue
    public void display() {
        System.out.println(toString());
    }
}