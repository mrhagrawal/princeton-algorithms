import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Subset {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);

        // Enqueue strings into RandomizedQueue.
        RandomizedQueue<String> randQueue = new RandomizedQueue<String>();
        while (!StdIn.isEmpty())
            randQueue.enqueue(StdIn.readString());

        // Print out k random strings taken from RandomizedQueue.
        for (int i = 0; i < k; i++)
            StdOut.println(randQueue.dequeue());
    }
}
