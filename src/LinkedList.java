import java.util.Objects;
public class LinkedList<T> {

    private Link<T> head; // first node
    private Link<T> tail; // last node
    private int size;     // number of nodes

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertFirst(T newItem) {
        Link<T> link = new Link<>(newItem);
        link.next = head;
        head = link;
        if (tail == null) {
            tail = link;
        }
        size++;
    }

    public void insertLast(T newItem) {
        Link<T> link = new Link<>(newItem);
        if (tail == null) {
            head = link;
        } else {
            tail.next = link;
        }
        tail = link;
        size++;
    }

    public void insertAt(int index, T newItem) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            insertFirst(newItem);
            return;
        }
        if (index == size) {
            insertLast(newItem);
            return;
        }

        Link<T> previous = nodeAt(index - 1);
        Link<T> link = new Link<>(newItem);
        link.next = previous.next;
        previous.next = link;
        size++;
    }

    public boolean deleteFirst() {
        if (head == null) {
            return false;
        }
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
        return true;
    }

    public boolean deleteLast() {
        if (tail == null) {
            return false;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return true;
        }

        Link<T> newTail = nodeAt(size - 2);
        newTail.next = null;
        tail = newTail;
        size--;
        return true;
    }

     public boolean deleteKey(T key) {
        if (head == null) {
            return false;
        }
        if (Objects.equals(head.data, key)) {
            return deleteFirst();
        }

        Link<T> previous = head;
        while (previous.next != null) {
            if (Objects.equals(previous.next.data, key)) {
                if (previous.next == tail) {
                    return deleteLast();
                }
                previous.next = previous.next.next;
                size--;
                return true;
            }
            previous = previous.next;
        }
        return false;
    }

    public int find(T key) {
        Link<T> current = head;
        int index = 0;
        while (current != null) {
            if (Objects.equals(current.data, key)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Link<T> current = head;
        while (current != null) {
            result.append(current.data);
            current = current.next;
            if (current != null) {
                result.append(", ");
            }
        }
        return result.append(']').toString();
    }

    public void display() {
        System.out.println(this);
    }

    private Link<T> nodeAt(int index) {
        Link<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}

