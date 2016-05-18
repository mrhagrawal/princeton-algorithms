import edu.princeton.cs.algs4.StdRandom;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * An implementation of a Randomized Queue.
 *
 * @author Anand Dyavanapalli
 * @version 1.0
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    /** Items are kept in an Item[] array. */
    private Item[] randQueue;

    /** The number of items in queue. */
    private int size;
    
    /** Header points to the first item in the queue. */
    private int header;

    /** Tail points to the place after the last item in the queue. */
    private int tail;

    /** 
     * Create an empty RandomizedQueue object.
     */
    public RandomizedQueue() {
        randQueue = (Item[]) new Object[2];
    }

    /**
     * Check whether randomized queue is empty.
     *
     * @return true if randomized queue is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return size of randomized queue.
     *
     * @return size of deque
     */
    public int size() {
        return size;
    }

    /**
     * Enqueue item to randomized queue.
     *
     * @param item added to randomized queue
     * @throws NullPointerException if parameter is null item
     */
    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException(
                    "Cannot add null item to randomized queue.");
        // Resize RandomizedQueue if size = # of items.
        if (size == randQueue.length)
            resize(2 * randQueue.length);
        randQueue[tail] = item;
        tail++;

        // Allows the RandomizedQueue to wrap around.
        if (tail == randQueue.length)
            tail = 0;
        size++;
    }

    /**
     * Resize randomized queue and copy all elements in old randomized queue to 
     * new randomized queue.
     *
     * @param amount the dimension of the new randomized queue
     */
    private void resize(int amount) {
        Item[] newRandQueue = (Item[]) new Object[amount];
        for (int i = 0; i < size; i++) {
            newRandQueue[i] = randQueue[(header + i) % randQueue.length];
        }
        randQueue = newRandQueue;
        header = 0;
        tail = size;
    }

    /**
     * Dequeue an item from the randomized queue randomly.
     *
     * @return Item returned
     */
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException(
                    "Cannot dequeue from empty randomized queue.");
        // Picks a random Item from RandomizedQueue and switches it with the 
        // header Item. Then header Item is deleted.
        int i = (StdRandom.uniform(size) + header) % randQueue.length;
        Item item = randQueue[i];
        randQueue[i] = randQueue[header];
        randQueue[header] = null;

        size--;
        header++;
        // Allows the RandomizedQueue to wrap around.
        if (header == randQueue.length)
            header = 0;
        if (size > 0 && size == randQueue.length / 4)
            resize(randQueue.length / 2);
        return item;
    }

    /**
     * Randomly choose an item from the randomized queue, and return it.
     *
     * @return Item returned
     */
    public Item sample() {
        if (size == 0)
            throw new NoSuchElementException(
                    "Cannot sample from empty randomized queue.");
        // Returns an index of array with wrapping around.
        int i = (StdRandom.uniform(size) + header) % randQueue.length;
        return randQueue[i];
    }

    /**
     * Return an iterator over items in deque in random order.
     *
     * @return Iterator<Item> over items in deque
     */
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        
        /** Index tracks position to be returned. */
        private int index;

        /** Array allowing random enumeration. */
        private int[] enumerate = new int[size];
        {
            for (int i = 0; i < size; i++)
                enumerate[i] = (i + header) % randQueue.length;
            StdRandom.shuffle(enumerate);
        }

        /** Returns true if there is at least one more item to iterate over.
         *
         * @return true if there is at least one more item to iterate over.
         */
        public boolean hasNext() {
            return index < size;
        }

        /**
         * Returns the Item in the current position and advances to the next 
         * position.
         *
         * @return Item returned
         * @throws NoSuchElementException if there is no next position
         */
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException(
                        "No more items to iterate through.");
            Item item = randQueue[enumerate[index]];
            index++;
            return item;
        }

        /**
         * Method is not supported in this implementation.
         *
         * @throws UnsupportedOperationException when this method is called
         */
        public void remove() {
            throw new UnsupportedOperationException(
                    "Cannot call remove() method in RandomizedQueueIterator class.");
        }
    }

    public static void main(String[] args) {
    }
}
