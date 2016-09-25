import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Anand Dyavanapalli
 * @version 1.0
 */
public class PercolationStats {

    /** The number of trials T to conduct. */
    private int T;

    /** An array to hold each percolation value from the systems variable. */
    private double[] percolationValues;

    /**
     * Perform T independent experiments on an N-by-N grid.
     *
     * @param N the size of the N-by-N percolation system.
     * @param T the number of trials T to conduct.
     * @throws IllegalArgumentException if either N or T < 1.
     */
    public PercolationStats(int N, int T) {
        if (N < 1 || T < 1)
            throw new IllegalArgumentException("The value of N in the N-by-N" +
                    " grid or T may not be less than 1.");

        this.T = T;
        // Initializing percolation system and value array.
        Percolation system;
        percolationValues = new double[T];

        // Initializing count of percolating systems.
        double count;
        
        // Initialzing coordinates.
        int i, j;

        // Running the trials.
        for (int k = 0; k < T; k++) {
            system = new Percolation(N);

            count = 0;
            while (!system.percolates()) {
                i = StdRandom.uniform(N) + 1;
                j = StdRandom.uniform(N) + 1;
                if (!system.isOpen(i, j)) {
                    system.open(i, j);
                    count++;
                }
            }
            percolationValues[k] = count / (N * N);
        }
    }

    /**
     * Computes the sample mean of the percolation threshold.
     *
     * @return a double representing the sample mean of the percolation threshold.
     */
    public double mean() {
        return StdStats.mean(percolationValues);
    }

    /**
     * Computes the sample standard deviation of the percolation threshold.
     *
     * @return a double representing the sample standard deviation of the 
     * percolation threshold.
     */
    public double stddev() {
        return StdStats.stddev(percolationValues);
    }

    /**
     * Computes the lower endpoint of the 95% confidence interval.
     *
     * @return a double representing the lower endpoint of the 95% confidence 
     * threshold.
     */
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }

    /**
     * Computes the upper endpoint of the 95% confidence interval.
     *
     * @return a double representing the upper endpoint of the 95% confidence 
     * threshold.
     */
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }

    public static void main(String[] args) {
        // The dimension N of an N-by-N percolation system.
        int N = Integer.parseInt(args[0]);

        // The number of times T that a percolation system should be simulated.
        int T = Integer.parseInt(args[1]);

        // Producing statistics.
        PercolationStats percStats = new PercolationStats(N, T);
        StdOut.println("mean\t\t\t = " + percStats.mean());
        StdOut.println("stddev\t\t\t = " + percStats.stddev());
        StdOut.println("95% confidence interval\t = " + percStats.confidenceLo() 
                + ", " + percStats.confidenceHi());
    }
}
