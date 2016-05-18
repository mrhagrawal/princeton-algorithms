import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

/**
 *
 */
public class KdTree {

    /**
     *
     */
    private class Point implements Comparable<Point> {

        private Point2D point;
        private String color;
        private Point right;
        private Point left;

        public Point(Point2D point) {
            this.point = point;
        }

        public int compareTo(Point that) {
            if (that.color.equals("RED"))
                return Double.compare(this.point.x(), that.point.x());
            else // that.color == "BLUE"
                return Double.compare(this.point.y(), that.point.y());
        }
    }

    private Point root;
    private int size;

    /**
     *
     */
    public KdTree() {
        root = null;
        size = 0;
    }

    /**
     *
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     */
    public int size() {
        return size;
    }

    /**
     *
     */
    public void insert(Point2D p) {
    }

    /**
     *
     */
    public boolean contains(Point2D p) {
        return false;
    }

    /**
     *
     */
    public void draw() {
    }

    /**
     *
     */
    public Iterable<Point2D> range(RectHV rect) {
        return null;
    }

    /**
     *
     */
    public Point2D nearest(Point2D p) {
        return null;
    }

    /**
     * Unit tests KdTree data type.
     */
    public static void main(String[] args) {
        KdTree tree = new KdTree();
        tree.insert(new Point2D(1, 1));
        tree.insert(new Point2D(2, 2));
        System.out.println(tree.size());
    }
}
