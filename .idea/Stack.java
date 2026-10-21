public class Stack<T> {

    private LinkedList<T> list;

    // O(1): Creates an empty stack
    public Stack() {
        list = new LinkedList<>();
    }

    // O(1): Keeps compatibility with the array-based version
    public Stack(int arraySize) {
        this();
    }

    // O(1): Adds an item to the top of the stack
    public void push(T newItem) {
        list.insertFirst(newItem);
    }

    // O(1): Removes and returns the top item
    // Returns null if the stack is empty
    public T pop() {
        T item = list.getFirst();

        if (item != null) {
            list.deleteFirst();
        }

        return item;
    }

    // O(1): Returns the top item without removing it
    // Returns null if the stack is empty
    public T peek() {
        return list.getFirst();
    }

    // O(n): Returns the stack as a string (top to bottom)
    @Override
    public String toString() {
        return list.toString();
    }

    // O(n): Displays the stack
    public void display() {
        System.out.println(toString());
    }
}