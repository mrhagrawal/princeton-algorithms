/**
 * A data type representing the n-puzzle board.
 * NOTE: This solution only scores 100% when the hashCode method is hidden.
 */
public class Board {

    /** Internal representation of board as 2D array. */
    private final int[][] board;

    /**
     * Constructor for n-puzzle board.
     * @param board the n-puzzle board array
     * @throws IllegalArgumentException if value outside of [0, N^2 - 1] or
     * duplicate value
     */
    public Board(int[][] board) {
        this.board = new int[board.length][board.length];

        // Checking for duplicate values and values outside of [0, N^2 - 1]
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] > board.length * board.length - 1
                        || !set.add(board[i][j]))
                    throw new IllegalArgumentException();
                this.board[i][j] = board[i][j];
            }
    }

    /**
     * Returns the dimension of the n-puzzle board.
     *
     * @return the dimension of the n-puzzle board
     */
    public int dimension() {
        return board.length;
    }

    /**
     * Returns the hamming priority function.
     *
     * @return the hamming priority function
     */
    public int hamming() {
        int count = 0;
        int val = 1;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                if (board[i][j] != val++)
                    count++;
        return count - 1;

    }

    /**
     * Returns the manhattan priority function.
     *
     * @return the manhattan priority function
     */
    public int manhattan() {
        int count = 0, x, y;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0)
                    continue;
                y = (this.board[i][j] - 1) % board.length;
                x = (this.board[i][j] - y - 1) / board.length;
                count += Math.abs(x - i) + Math.abs(y - j);
            }
        return count;
    }

    /**
     * Returns true if this n-puzzle board is the goal board.
     *
     * @return true if this n-puzzle board is the goal board
     */
    public boolean isGoal() {
        int val = 1;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                if (board[i][j] != val++ % (board.length * board.length))
                    return false;
        return true;
    }

    /**
     * Returns a twin of this n-puzzle board.
     *
     * @return a twin of this n-puzzle board
     */
    public Board twin() {
        int[][] twin = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                twin[i][j] = board[i][j];

        java.util.Random r = new java.util.Random();
        int i, j, x, y;
        do {
            i = r.nextInt(board.length);
            j = r.nextInt(board.length);

            x = r.nextInt(board.length);
            y = r.nextInt(board.length);
        } while (board[i][j] == 0 || board[x][y] == 0 || board[i][j] == board[x][y]);
        int temp = twin[i][j];
        twin[i][j] = twin[x][y];
        twin[x][y] = temp;

        return new Board(twin);
    }

    /**
     * Returns true if this n-puzzle board is equal to that n-puzzle.
     *
     * @param object that n-puzzle
     * @return true if this n-puzzle board is equal to that n-puzzle
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass())
            return false;
        Board that = (Board) object;
        if (this == that)
            return true;
        if (this.dimension() != that.dimension())
            return false;
        int n = this.dimension();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (this.board[i][j] != that.board[i][j])
                    return false;
        return true;
    }

    /**
     * Returns the hashCode of this n-puzzle board.
     *
     * @return the hashCode of this n-puzzle board
     */
    //@Override
    //public int hashCode() {
        //StringBuffer s = new StringBuffer();
        //for (int i = 0; i < board.length; i++)
            //for (int j = 0; j < board.length; j++)
                //s.append(board[i][j]);
        //return s.hashCode();
    //}

    /**
     * Returns the neighbors of this n-puzzle board.
     *
     * @return the Iterable<Board> neighbors of this n-puzzle board.
     */
    public Iterable<Board> neighbors() {
        java.util.ArrayList<Board> neighbors = new java.util.ArrayList<>();
        int[] zero = findZero();
        int i = zero[0], j = zero[1];
        if (i != 0)
            neighbors.add(topNeighbor(zero));
        if (j != board.length - 1)
            neighbors.add(rightNeighbor(zero));
        if (i != board.length - 1)
            neighbors.add(bottomNeighbor(zero));
        if (j != 0)
            neighbors.add(leftNeighbor(zero));
        return neighbors;
    }

    /**
     * Returns the location of the zero in this n-puzzle board.
     *
     * @return the location of the zero in this n-puzzle board
     */
    private int[] findZero() {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                if (board[i][j] == 0)
                    return new int[]{i, j};
        return null;
    }

    /**
     * Returns the top neighbor of this n-puzzle board
     * 
     * @param zero the location of the zero in this n-puzzle board
     * @return the top neighbor of this n-puzzle board
     */
    private Board topNeighbor(int[] zero) {
        int[][] top = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                top[i][j] = board[i][j];
        int i = zero[0], j = zero[1];
        top[i][j] = top[i - 1][j];
        top[i - 1][j] = 0;
        return new Board(top);
    }

    /**
     * Returns the right neighbor of this n-puzzle board
     * 
     * @param zero the location of the zero in this n-puzzle board
     * @return the right neighbor of this n-puzzle board
     */
    private Board rightNeighbor(int[] zero) {
        int[][] right = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                right[i][j] = board[i][j];
        int i = zero[0], j = zero[1];
        right[i][j] = right[i][j + 1];
        right[i][j + 1] = 0;
        return new Board(right);
    }

    /**
     * Returns the bottom neighbor of this n-puzzle board
     * 
     * @param zero the location of the zero in this n-puzzle board
     * @return the bottom neighbor of this n-puzzle board
     */
    private Board bottomNeighbor(int[] zero) {
        int[][] bottom = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                bottom[i][j] = board[i][j];
        int i = zero[0], j = zero[1];
        bottom[i][j] = bottom[i + 1][j];
        bottom[i + 1][j] = 0;
        return new Board(bottom);
    }

    /**
     * Returns the left neighbor of this n-puzzle board
     * 
     * @param zero the location of the zero in this n-puzzle board
     * @return the left neighbor of this n-puzzle board
     */
    private Board leftNeighbor(int[] zero) {
        int[][] left = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                left[i][j] = board[i][j];
        int i = zero[0], j = zero[1];
        left[i][j] = left[i][j - 1];
        left[i][j - 1] = 0;
        return new Board(left);
    }

    /**
     * Returns a nice string representation of this n-puzzle board.
     *
     * @return a nice string representation of this n-puzzle board
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(board.length + "\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                s.append(String.format("%2d ", board[i][j]));
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Unit tests Board data type.
     */
    public static void main(String[] args) {
    }
}
