import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    
    private int N;
    private WeightedQuickUnionUF system;
    private boolean[][] grid;

    public Percolation(int N) {
        if (N <= 0)
            throw new IllegalArgumentException();
        this.N = N;

        system = new WeightedQuickUnionUF(N * N + 3);
        grid = new boolean[N + 1][N + 1];
    }

    private int ijToN(int i, int j) {
        return N * (i - 1) + j;
    }

    public void open(int i, int j) {
        if (i < 1 || i > N || j < 1 || j > N)
            throw new IndexOutOfBoundsException();
        if (isOpen(i, j))
            return;
        grid[i][j] = true;

        // If site[i, j] is in the top or bottom row, connect to virtual site
        // Top
        if (i == 1) {
            system.union(ijToN(i, j), N * N + 1);
        }
        // Bottom
        if (i == N) {
            system.union(ijToN(i, j), N * N + 2);
        }

        // Now connect to surrounding sites if they're open
        // Top
        if (i != 1)
            if (isOpen(i - 1, j)) {
                system.union(ijToN(i, j), ijToN(i - 1, j));
            }
        // Right
        if (j != N)
            if (isOpen(i, j + 1)) {
                system.union(ijToN(i, j), ijToN(i, j + 1));
            }
        // Bottom
        if (i != N)
            if (isOpen(i + 1, j)) {
                system.union(ijToN(i, j), ijToN(i + 1, j));
            }
        // Left
        if (j != 1)
            if (isOpen(i, j - 1)) {
                system.union(ijToN(i, j), ijToN(i, j - 1));
            }
    }

    public boolean isOpen(int i, int j) {
        if (i < 1 || i > N || j < 1 || j > N)
            throw new IndexOutOfBoundsException();
        return grid[i][j];
    }

    public boolean isFull(int i, int j) {
        if (i < 1 || i > N || j < 1 || j > N)
            throw new IndexOutOfBoundsException();
        return isOpen(i, j) && system.connected(ijToN(i, j), N * N + 1);
    }

    public boolean percolates() {
        return system.connected(N * N + 1, N * N + 2);
    }

    public static void main(String[] args) {
    }
}
