import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;

/**
 * This class helps identify sets of collinear points (of length 4+) using a
 * brute-force approach. The time complexity is roughly O(N^4) in the input.
 */
public class BruteCollinearPoints {

    /** A list to store collinear points as line segments. */
    private ArrayList<LineSegment> segments = new ArrayList<>();

    /**
     * Constructor reads in a set of points and fills segments list. Time
     * complexity is roughly O(N^4) in the input.
     *
     * @param points Point[] array to be read into constructor
     * @throws NullPointerException when points is null or if point
     * contained in points is null
     * @throws IllegalArgumentException if there is a duplicate point in points
     * points 
     */
    public BruteCollinearPoints(Point[] points) {
        if (points == null || hasNullElement(points))
            throw new NullPointerException(
                    "Constructor argument or Point objects cannot be null.");
        if (hasDuplicates(points))
            throw new IllegalArgumentException("Cannot have duplicate points.");

        int N = points.length;
        for (int i = 0; i < N - 3; i++)
            for (int j = i + 1; j < N - 2; j++) {
                // Slope[i->j]
                double slope_ij = points[i].slopeTo(points[j]);

                for (int k = j + 1; k < N - 1; k++) {
                    // Slope[i->k]
                    double slope_ik = points[i].slopeTo(points[k]);

                    // If slope[i->j] != slope[i->k], continue to next index
                    if (slope_ij != slope_ik) continue;

                    for (int L = k + 1; L < N; L++) {
                        double slope_iL = points[i].slopeTo(points[L]);
                        // If all slopes are equal i.e.
                        // slope[i->j] == slope[i->k] == slope[i->L]
                        if (slope_ij == slope_iL) {
                             Point min = findMin(points[i], points[j],
                                     points[k], points[L]);
                             Point max = findMax(points[i], points[j],
                                     points[k], points[L]);
                             segments.add(new LineSegment(min, max));
                        }
                    }
                }
            }
    }

    /**
     * Returns true if points contain a null point. Time complexity in worst-case is
     * O(N) in the input.
     *
     * @param points Point[] array
     * @return true if points contain a null point
     */
    private boolean hasNullElement(Point[] points) {
        for (Point i : points)
            if (i == null)
                return true;
        return false;
    }

    /**
     * Returns true if points contain a duplicate point. Time complexity in
     * worst-case is O(N*lg(N)) in the input.
     *
     * @param points Point[] array
     * @return true if points contain a duplicate point
     */
    private boolean hasDuplicates(Point[] points) {
        Point[] sorted = points.clone();
        java.util.Arrays.sort(sorted);
        for (int i = 1; i < sorted.length; i++)
            if (sorted[i - 1].compareTo(sorted[i]) == 0)
                return true;
        return false;
    }

    /**
     * Returns the minimum point according to the compareTo() method. Time
     * complexity is O(N) in the input.
     *
     * @param pts varargs Point[] array
     * @return mininum point according to compareTo() method
     */
    private Point findMin(Point... pts) {
        if (pts.length == 0)
            return null;
        Point min = pts[0];
        for (Point p : pts)
            if (p.compareTo(min) < 0)
                min = p;
        return min;
    }

    /**
     * Returns the maximum point according to the compareTo() method. Time
     * complexity is O(N) in the input.
     *
     * @param pts varargs Point[] array
     * @return maximum point according to compareTo() method
     */
    private Point findMax(Point... pts) {
        if (pts.length == 0)
            return null;
        Point max = pts[0];
        for (Point p : pts)
            if (p.compareTo(max) > 0)
                max = p;
        return max;
    }

    /**
     * Returns the number of line segments with 4+ collinear points.
     *
     * @return number of line segments with 4+ collinear points
     */
    public int numberOfSegments() {
        return segments.size();
    }

    /**
     * Returns a LineSegment[] array containing line segments each with 4+
     * collinear points. Time complexity is O(N) in the size of segments array.
     *
     * @return a LineSegment[] array containing line segments each with 4+
     * collinear points
     */
    public LineSegment[] segments() {
        int N = segments.size();
        LineSegment[] list = new LineSegment[N];
        for (int i = 0; i < N; i++)
            list[i] = segments.get(i);
        return list;
    }
    
    /**
     * Unit tests the BruteCollinearPoints data type.
     */
    public static void main(String[] args) {
        // Read the N points from a file
        In in = new In(args[0]);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // Draw the points
        StdDraw.show(0);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // Print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
    }
}
