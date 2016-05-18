import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.MinPQ;
import java.util.ArrayList;

/**
 * This class provides the functionality to solve an n-puzzle board.
 */
public class Solver {

    /**
     * This private class represents the SearchNode in the A* algorithm.
     */
    private class SearchNode implements Comparable<SearchNode> {

        /** The current n-puzzle board represented by this SearchNode. */
        private final Board current;

        /** The number of moves made so far. */
        private final int moves;

        /** The previous SearchNode. */
        private final SearchNode previous;

        /** The priority of this SearchNode. */
        private final int priority;

        /**
         * The SearchNode constructor. The priority is computed using the
         * manhattan priority function.
         *
         * @param current the current n-puzzle board
         * @param moves the number of moves
         * @param previous the previous SearchNode
         */
        public SearchNode(Board current, int moves, SearchNode previous) {
            this.current = current;
            this.moves = moves;
            this.previous = previous;
            priority = current.manhattan() + moves;
        }

        /**
         * Return the current n-puzzle board.
         *
         * @return the current n-puzzle board
         */
        public Board getCurrent() {
            return current;
        }

        /**
         * Return the number of moves made so far.
         *
         * @return the number of moves made so far
         */
        public int getMoves() {
            return moves;
        }

        /**
         * Return the previous SearchNode.
         *
         * @return the previous SearchNode
         */
        public SearchNode getPrevious() {
            return previous;
        }

        /**
         * Implements the compareTo() method as required when implementing the
         * Comparable interface. Returns less than zero if this SearchNode's
         * priority is less that SearchNode's; returns greater than zero if this
         * SearchNode's priority is more than that SearchNode's priority; and
         * return zero if this SearchNode's priority is equal to that SearchNode's
         * priority.
         *
         * @param that SearchNode
         * @return less than zero if this SearchNode's priority is less than that
         * SearchNode's priority; greater than zero if this SearchNode's priority
         * is more than that SearchNode's priority; and zero if this SearchNode's
         * priority is equal to that SearchNode's priority.
         */
        public int compareTo(SearchNode that) {
            return Integer.compare(this.priority, that.priority);
        }
    }

    /** A representation of the solution. */
    private ArrayList<Board> solution;
    
    /** A boolean representing whether the n-puzzle board is solvable. */
    private boolean solvable;

    /**
     * The Solver constructor. Employs the A* search algorithm.
     *
     * @param intial the n-puzzle board to be solved
     * @throws NullPointerException if the parameter is null
     */
    public Solver(Board initial) {
        if (initial == null)
            throw new NullPointerException();

        MinPQ<SearchNode> queue = new MinPQ<>();
        queue.insert(new SearchNode(initial, 0, null));

        MinPQ<SearchNode> twin_queue = new MinPQ<>();
        twin_queue.insert(new SearchNode(initial.twin(), 0, null));

        SearchNode end = null;
        SearchNode twin_end = null;

        while (true) {
            end = queue.delMin();
            twin_end = twin_queue.delMin();

            if (end.getCurrent().isGoal()) {
                solvable = true;
                break;
            }
            else if (twin_end.getCurrent().isGoal()) {
                solvable = false;
                break;
            }
            else {
                if (end.getPrevious() == null)
                    for (Board board : end.getCurrent().neighbors())
                        queue.insert(new SearchNode(board, end.getMoves() + 1, end));
                else
                    for (Board board : end.getCurrent().neighbors())
                        if (!board.equals(end.getPrevious().getCurrent()))
                            queue.insert(new SearchNode(board, end.getMoves() + 1,
                                        end));
                if (twin_end.getPrevious() == null)
                    for (Board twin_board : twin_end.getCurrent().neighbors())
                        twin_queue.insert(new SearchNode(twin_board,
                                    twin_end.getMoves() + 1, twin_end));
                else
                    for (Board twin_board : twin_end.getCurrent().neighbors())
                        if (!twin_board.equals(twin_end.getPrevious().getCurrent()))
                            twin_queue.insert(new SearchNode(twin_board,
                                        twin_end.getMoves() + 1, twin_end));
            }
        }
        if (solvable) {
            java.util.Stack<Board> stack = new java.util.Stack<>();
            solution = new ArrayList<>();
            do {
                stack.add(end.getCurrent());
                end = end.getPrevious();
            } while (end != null);

            while (!stack.isEmpty())
                solution.add(stack.pop());
        }
    }

    /**
     * Returns true if the n-puzzle is solvable.
     *
     * @return true if the n-puzzle is solvable
     */
    public boolean isSolvable() {
        return solvable;
    }

    /**
     * Return the number of moves used to solve the n-puzzle board.
     *
     * @return the number of moves used to solve the n-puzzle board
     */
    public int moves() {
        if (solvable)
            return solution.size() - 1;
        else
            return -1;
    }

    /**
     * Returns an Iterable<Board> representation of the solution to the n-puzzle
     * board.
     *
     * @return an Iterable<Board> representation of the solution to the n-puzzle
     * board.
     */
    public Iterable<Board> solution() {
        return solution;
    }

    /**
     * Solver test client.
     */
    public static void main(String[] args) {
        // Create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // Solve the puzzle
        Solver solver = new Solver(initial);

        // Print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
