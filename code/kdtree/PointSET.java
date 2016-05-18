import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.RedBlackBST;
import java.util.ArrayList;

/**
 *
 */
public class PointSET {

    /** */
    private RedBlackBST<Point2D, Integer> pSET;

    /**
     *
     */
    public PointSET() {
        pSET = new RedBlackBST<>();
    }

    /**
     *
     */
    public boolean isEmpty() {
        return pSET.size() == 0;
    }

    /**
     *
     */
    public int size() {
        return pSET.size();
    }

    /**
     *
     */
    public void insert(Point2D p) {
        if (p == null)
            throw new NullPointerException("Cannot insert null Point2D into PointSET.");
        pSET.put(p, 0);
    }

    /**
     *
     */
    public boolean contains(Point2D p) {
        if (p == null)
            throw new NullPointerException("Cannot look for null Point2D in PointSET.");
        return pSET.contains(p);
    }

    /**
     *
     */
    public void draw() {
        for (Point2D p : pSET.keys())
            p.draw();
    }

    /**
     *
     */
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null)
            throw new NullPointerException("Cannot look for range in null RectHV.");

        ArrayList<Point2D> list = new ArrayList<Point2D>();
        for (Point2D p : pSET.keys())
            if (rect.contains(p))
                list.add(p);
        return list;
    }

    /**
     *
     */
    public Point2D nearest(Point2D p) {
        if (p == null)
            throw new NullPointerException("Cannot find nearest point to null Point2D.");
        if (isEmpty())
            return null;

        // Highest minimum distance is 2
        double min = 2.1;

        Point2D nearest = new Point2D(5.0, 5.0);
        for (Point2D q : pSET.keys()) {
            if (p.distanceSquaredTo(q) < min) {
                min = p.distanceSquaredTo(q);
                nearest = q;
            }
        }
        return nearest;
    }

    /**
     * Unit tests PointSET data type.
     */
    public static void main(String[] args) {
    }
}
