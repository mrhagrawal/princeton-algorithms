import edu.princeton.cs.algs4.Point2D;

class stream {
    public static void main(String[] args) {
        java.util.List<Point2D> setA = new java.util.ArrayList<>();
        setA.add(new Point2D(0.4, 0.4)); setA.add(new Point2D(0.5, 0.5));

        java.util.List<Point2D> setB = new java.util.ArrayList<>();
        setB.add(new Point2D(0.4, 0.4)); setB.add(new Point2D(0.5, 0.5));

        System.out.println(setA.equals(setB));
    }
}
