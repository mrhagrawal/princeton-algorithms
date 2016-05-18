import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * An implementation of a Deque (Double Ended Queue).
 *
 * @author Anand Dyavanapalli
 * @version 1.0
 */
public class Deque<Item> implements Iterable<Item> {

    /** The deque consists of doubly linked Node objects. */
    private class Node {

        private Item item;
        private Node next;
        private Node prev;

        public Node(Item item) {
            this.item = item;
        }

        private Item getItem() {
            return item;
        }

        private Node getNext() {
            return next;
        }

        private Node getPrev() {
            return prev;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    /** Keeps track of size of deque. */
    private int size;

    /** Pointer to header Node. */
    private Node header;

    /** Pointer to tail Node. */
    private Node tail;


    /**
     * Create an empty deque object.
     */
    public Deque() {
        header = null;
        tail = null;
    }

    /**
     * Check whether deque is empty.
     *
     * @return true if deque is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return size of deque.
     *
     * @return size of deque
     */
    public int size() {
        return size;
    }

    /**
     * Add item to front of deque.
     *
     * @param item added to front of deque
     */
    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException(
                    "Cannot add null item to front of deque.");
        Node node = new Node(item);
        if (isEmpty()) {
            header = node;
            tail = node;
        } else {
            header.setPrev(node);
            node.setNext(header);
            header = node;
        }
        // Increment size of deque.
        size++;
    }

    /**
     * Add item to end of deque.
     *
     * @param item added to end of deque
     */
    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException(
                    "Cannot add null item to end of deque.");
        Node node = new Node(item);
        if (isEmpty()) {
            header = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        // Increment size of deque.
        size++;
    }

    /**
     * Remove and return item from front of deque.
     *
     * @return item from front of deque
     */
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException(
                    "Cannot remove item from front of empty deque.");
        Item item = header.getItem();
        if (size == 1) {
            header = null;
            tail = null;
        }
        else {
            // Advance node.
            header = header.getNext();
            // Remove all links to first node.
            header.getPrev().setNext(null);
            header.setPrev(null);
        }
        size--;
        return item;
    }

    /**
     * Remove and return item from end of deque.
     *
     * @return item from end of deque
     */
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException(
                    "Cannot remove item from end of empty deque.");
        Item item = tail.getItem();
        if (size == 1) {
            header = null;
            tail = null;
        }
        else {
            // Advance node.
            tail = tail.getPrev();
            // Remove all links to last node.
            tail.getNext().setPrev(null);
            tail.setNext(null);
        }
        size--;
        return item;
    }
    /**
     * Return an iterator over items in deque in order from front to end.
     *
     * @return Iterator<Item> over items in deque
     */
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        /** The Node representing the current position in DequeIterator. */
        private Node currentPos = header;

        /** Returns true if the current Node has next Node.
         *
         * @return true if the current Node has a next Node
         */
        public boolean hasNext() {
            return currentPos != null;
        }

        /** Returns the Item in the current Node and advances the current Node one 
         * position.
         *
         * @return Item is returned
         * @throws NoSuchElementException if there is no next Node
         */
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException(
                        "There is no next Node.");
            Item item = currentPos.getItem();
            currentPos = currentPos.getNext();
            return item;
        }

        /** Method is not supported in this implementation.
         *
         * @throws UnsupportedOperationException when this method is called
         */
        public void remove() {
            throw new UnsupportedOperationException(
                    "Cannot call remove() method in DequeIterator class.");
        }
    }

    public static void main(String[] args) {
    }
}
