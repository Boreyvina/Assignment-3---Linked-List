public class DoublyLinkedList<T> {
    private DoublyLink<T> head;
    private DoublyLink<T> tail;

    // Time Complexity: O(1)
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Time Complexity: O(1)
    public boolean isEmpty() {
        return head == null;
    }

    // Time Complexity: O(1)
    public void insertFirst(T newItem) {
        DoublyLink<T> newLink = new DoublyLink<>(newItem);

        if (isEmpty()) {
            tail = newLink;
        } else {
            head.previous = newLink;
            newLink.next = head;
        }
        head = newLink;
    }

    // Time Complexity: O(1)
    public void insertLast(T newItem) {
        DoublyLink<T> newLink = new DoublyLink<>(newItem);

        if (isEmpty()) {
            head = newLink;
        } else {
            tail.next = newLink;
            newLink.previous = tail;
        }
        tail = newLink;
    }

    // Time Complexity: O(n)
    public void insertAt(int index, T newItem) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            insertFirst(newItem);
            return;
        }

        DoublyLink<T> current = head;
        int position = 0;

        while (current != null && position < index) {
            current = current.next;
            position++;
        }

        if (position != index) {
            throw new IndexOutOfBoundsException();
        }

        if (current == null) {
            insertLast(newItem);
            return;
        }

        DoublyLink<T> newNode = new DoublyLink<>(newItem);
        DoublyLink<T> before = current.previous;

        newNode.previous = before;
        newNode.next = current;
        before.next = newNode;
        current.previous = newNode;
    }

    // Time Complexity: O(1)
    public boolean deleteFirst() {
        if (isEmpty()) {
            return false;
        }

        unlink(head);
        return true;
    }

    // Time Complexity: O(1)
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        unlink(tail);
        return true;
    }

    // Time Complexity: O(n)
    public boolean deleteAt(int index) {
        if (index < 0) {
            return false;
        }

        DoublyLink<T> current = head;
        int position = 0;

        while (current != null && position < index) {
            current = current.next;
            position++;
        }

        if (current == null) {
            return false;
        }

        unlink(current);
        return true;
    }

    // Time Complexity: O(n)
    public boolean deleteKey(T key) {
        DoublyLink<T> current = head;

        while (current != null) {
            if (java.util.Objects.equals(current.data, key)) {
                unlink(current);
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Time Complexity: O(n)
    public int find(T key) {
        DoublyLink<T> current = head;
        int index = 0;

        while (current != null) {
            if (java.util.Objects.equals(current.data, key)) {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }

    // Time Complexity: O(n)
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        DoublyLink<T> current = head;

        while (current != null) {
            result.append(current.data);

            if (current.next != null) {
                result.append(", ");
            }

            current = current.next;
        }

        result.append("]");
        return result.toString();
    }

    // Time Complexity: O(n)
    public void displayForward() {
        System.out.println(toString());
    }

    // Time Complexity: O(n)
    public void displayBackward() {
        StringBuilder result = new StringBuilder("[");
        DoublyLink<T> current = tail;

        while (current != null) {
            result.append(current.data);

            if (current.previous != null) {
                result.append(", ");
            }

            current = current.previous;
        }

        result.append("]");
        System.out.println(result);
    }

    // Helper method to remove a node
    // Time Complexity: O(1)
    private void unlink(DoublyLink<T> node) {
        if (node.previous == null) {
            head = node.next;
        } else {
            node.previous.next = node.next;
        }

        if (node.next == null) {
            tail = node.previous;
        } else {
            node.next.previous = node.previous;
        }

        node.next = null;
        node.previous = null;
    }
}