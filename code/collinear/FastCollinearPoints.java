import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;
import java.util.ArrayList;

/**
 * This class helps identify sets of collinear points (of length 4+) using an
 * optimized sort-based approach. The time complexity is roughly O(N^3*lg(N))..
 * I think.
 */
public class FastCollinearPoints {

    /** A list to store collinear points as line segments. */
    private ArrayList<LineSegment> segments = new ArrayList<>();

    /**
     * Constructor reads in a set of points and fills segments list. Time complexity
     * is roughly O(N^3*lg(N)) in the input.
     *
     * @param points Point[] array to be read into constructor
     * @throws NullPointerException when points is null or if point contained in
     * points is null
     * @throws IllegalArgumentException if there is a duplicate point in points
     */
    public FastCollinearPoints(Point[] points) {
        if (points == null || hasNullElement(points))
            throw new NullPointerException(
                    "Constructor argument or Point objects cannot be null.");
        if (hasDuplicates(points))
            throw new IllegalArgumentException("Cannot have duplicate points.");

        for (int k = 0; k < points.length; k++) {
            Point ref = points[k];
            Comparator<Point> comparer = ref.slopeOrder();
            Point[] sortedPoints = points.clone();
            java.util.Arrays.sort(sortedPoints, comparer);

            double slope = 0;
            ArrayList<Point> collinearPoints = new ArrayList<>();
            for (int i = 1; i < sortedPoints.length; i++) {
                if (i == 1)
                    slope = ref.slopeTo(sortedPoints[i]);
                if (Double.compare(slope, ref.slopeTo(sortedPoints[i])) == 0) {
                    collinearPoints.add(sortedPoints[i]);
                    if (i == sortedPoints.length - 1) {
                        if (collinearPoints.size() >= 3) {
                            collinearPoints.add(ref);
                            Point min = findMin(collinearPoints);
                            Point max = findMax(collinearPoints);
                            if (ref == min)
                                segments.add(new LineSegment(min, max));
                        }
                    }
                }
                else {
                    if (collinearPoints.size() >= 3) {
                        collinearPoints.add(ref);
                        Point min = findMin(collinearPoints);
                        Point max = findMax(collinearPoints);
                        if (ref == min)
                            segments.add(new LineSegment(min, max));
                    }
                    collinearPoints.clear();
                    collinearPoints.add(sortedPoints[i]);
                    slope = ref.slopeTo(sortedPoints[i]);
                }
            }

        }
    }

    /**
     * Returns true if points contain a null point. Time complexity in worse-case
     * is O(N) in the input.
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
     * Returns the minimum point according to the compareTo() method. Time complexity
     * is O(N) in the input.
     *
     * @param list an ArrayList<Point>
     * @return minimum point according to compareTo() method
     */
    private static Point findMin(ArrayList<Point> list) {
        if (list.size() == 0)
            return null;
        Point min = list.get(0);
        for (Point p : list)
            if (p.compareTo(min) < 0)
                min = p;
        return min;
    }

    /**
     * Returns the maximum point according to the compareTo() method. Time complexity
     * is O(N) in the input.
     *
     * @param list an ArrayList<Point>
     * @return maximum point according to compareTo() method
     */
    private static Point findMax(ArrayList<Point> list) {
        if (list.size() == 0)
            return null;
        Point max = list.get(0);
        for (Point p : list)
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
     * collinear points. Time complexity is O(N) in the size of the segments array.
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
     * Unit tests the FastCollinearPoints data type.
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
    }
}
