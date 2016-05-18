import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import java.util.ArrayList;
import java.util.List;

public class PointSETTest {

    private static void PointSETConstructorTest() {
        TestSuite.testMessage("Testing PointSET Constructor:");

        /* SETUP */
        boolean validConstruction;

        /* START TESTS */

        // Test 1
        try {
            PointSET pSET = new PointSET();
            validConstruction = true;
        }
        catch (Exception e) {
            validConstruction = false;
        }
        TestSuite.assertTrue(validConstruction);

        /* END TESTS */
        System.out.println();
    }

    private static void isEmptyTest() {
        TestSuite.testMessage("Testing isEmpty() method:");
        TestSuite.dependencyMessage("insert() method must implemented correctly");

        /* SETUP */
        PointSET pSETa = new PointSET();

        PointSET pSETb = new PointSET();
        pSETb.insert(new Point2D(0.5, 0.5));

        /* START TESTS */
        
        // Test 1
        TestSuite.assertTrue(pSETa.isEmpty());

        // Test 2
        TestSuite.assertFalse(pSETb.isEmpty());

        /* END TESTS */
        System.out.println();
    }

    private static void sizeTest() {
        TestSuite.testMessage("Testing size() method:");
        TestSuite.dependencyMessage("insert() method must implemented correctly");

        /* SETUP */
        PointSET pSETa = new PointSET();

        PointSET pSETb = new PointSET();
        pSETb.insert(new Point2D(0.5, 0.5));

        PointSET pSETc = new PointSET();
        for (int i = 0; i < 5; i++)
            pSETc.insert(new Point2D(i / 5.0, i / 5.0));

        PointSET pSETd = new PointSET();
        for (int i = 0; i < 25; i++)
            pSETd.insert(new Point2D(i / 25.0, i / 25.0));

        PointSET pSETe = new PointSET();
        for (int i = 0; i < 100; i++)
            pSETe.insert(new Point2D(i / 100.0, i / 100.0));

        PointSET pSETf = new PointSET();
        for (int i = 0; i < 1000; i++)
            pSETf.insert(new Point2D(i / 1000.0, i / 1000.0));

        PointSET pSETg = new PointSET();
        for (int i = 0; i < 10000; i++)
            pSETg.insert(new Point2D(i / 10000.0, i / 10000.0));

        PointSET pSETh = new PointSET();
        for (int i = 0; i < 100000; i++)
            pSETh.insert(new Point2D(i / 100000.0, i / 100000.0));

        PointSET pSETi = new PointSET();
        for (int i = 0; i < 1000000; i++)
            pSETi.insert(new Point2D(i / 1000000.0, i / 1000000.0));

        /* START TESTS */

        // Test 1
        TestSuite.assertEqual(pSETa.size(), 0);

        // Test 2
        TestSuite.assertEqual(pSETb.size(), 1);

        // Test 3
        TestSuite.assertEqual(pSETc.size(), 5);

        // Test 4
        TestSuite.assertEqual(pSETd.size(), 25);

        // Test 5
        TestSuite.assertEqual(pSETe.size(), 100);

        // Test 6
        TestSuite.assertEqual(pSETf.size(), 1000);

        // Test 7
        TestSuite.assertEqual(pSETg.size(), 10000);

        // Test 8
        TestSuite.assertEqual(pSETh.size(), 100000);

        // Test 9
        TestSuite.assertEqual(pSETi.size(), 1000000);

        /* END TESTS */
        System.out.println();
    }

    private static void insertTest() {
        TestSuite.testMessage("Testing insert() method:");
        TestSuite.dependencyMessage("size() method must implemented correctly");

        /* SETUP */
        PointSET pSETa = new PointSET();
        boolean throwsException;

        PointSET pSETb = new PointSET();
        pSETb.insert(new Point2D(0.5, 0.5));

        PointSET pSETc = new PointSET();
        pSETc.insert(new Point2D(0.5, 0.5));
        pSETc.insert(new Point2D(0.5, 0.5));

        PointSET pSETd = new PointSET();
        pSETd.insert(new Point2D(0.5, 0.5));
        pSETd.insert(new Point2D(0.5, 0.5));
        pSETd.insert(new Point2D(0.7, 0.7));
        pSETd.insert(new Point2D(0.7, 0.7));

        PointSET pSETe = new PointSET();
        pSETe.insert(new Point2D(0.5, 0.5));
        pSETe.insert(new Point2D(0.5, 0.5));
        pSETe.insert(new Point2D(0.7, 0.7));
        pSETe.insert(new Point2D(0.7, 0.7));
        pSETe.insert(new Point2D(0.9, 0.9));
        pSETe.insert(new Point2D(0.9, 0.9));

        PointSET pSETf = new PointSET();
        pSETf.insert(new Point2D(0.5, 0.5));
        pSETf.insert(new Point2D(0.5, 0.5));
        pSETf.insert(new Point2D(0.7, 0.7));
        pSETf.insert(new Point2D(0.7, 0.7));
        pSETf.insert(new Point2D(0.9, 0.9));
        pSETf.insert(new Point2D(0.9, 0.9));
        pSETf.insert(new Point2D(0.6, 0.6));
        pSETf.insert(new Point2D(0.6, 0.6));

        PointSET pSETg = new PointSET();
        pSETg.insert(new Point2D(0.5, 0.5));
        pSETg.insert(new Point2D(0.5, 0.5));
        pSETg.insert(new Point2D(0.7, 0.7));
        pSETg.insert(new Point2D(0.7, 0.7));
        pSETg.insert(new Point2D(0.9, 0.9));
        pSETg.insert(new Point2D(0.9, 0.9));
        pSETg.insert(new Point2D(0.6, 0.6));
        pSETg.insert(new Point2D(0.6, 0.6));
        pSETg.insert(new Point2D(0.4, 0.4));
        pSETg.insert(new Point2D(0.4, 0.4));


        /* START TESTS */

        // Test 1
        try {
            pSETa.insert(null);
            throwsException = false;
        } catch (NullPointerException e) {
            throwsException = true;
        }
        TestSuite.assertTrue(throwsException);

        // Test 2
        TestSuite.assertEqual(pSETb.size(), 1);

        // Test 3
        TestSuite.assertEqual(pSETc.size(), 1);

        // Test 4
        TestSuite.assertEqual(pSETd.size(), 2);

        // Test 5
        TestSuite.assertEqual(pSETe.size(), 3);

        // Test 6
        TestSuite.assertEqual(pSETf.size(), 4);

        // Test 7
        TestSuite.assertEqual(pSETg.size(), 5);

        /* END TESTS */
        System.out.println();
    }

    private static void containsTest() {
        TestSuite.testMessage("Testing contains() method:");
        TestSuite.dependencyMessage("insert() method must be implemented correctly");

        /* SETUP */
        PointSET pSETa = new PointSET();
        boolean throwsException;

        PointSET pSETb = new PointSET();
        pSETb.insert(new Point2D(0.5, 0.5));

        PointSET pSETc = new PointSET();
        pSETc.insert(new Point2D(0.5, 0.5));
        pSETc.insert(new Point2D(0.4, 0.4));

        /* START TESTS */

        // Test 1
        try {
            pSETa.contains(null);
            throwsException = false;
        } catch (NullPointerException e) {
            throwsException = true;
        }
        TestSuite.assertTrue(throwsException);

        // Test 2
        TestSuite.assertTrue(pSETb.contains(new Point2D(0.5, 0.5)));

        // Test 3
        TestSuite.assertFalse(pSETb.contains(new Point2D(0.4, 0.4)));

        // Test 4
        TestSuite.assertTrue(pSETc.contains(new Point2D(0.4, 0.4)));

        // Test 5
        TestSuite.assertFalse(pSETc.contains(new Point2D(0.3, 0.3)));

        // Test 6
        TestSuite.assertTrue(pSETc.contains(new Point2D(0.5, 0.5)));

        /* END TESTS */
        System.out.println();
    }

    //private static void drawTest() {
    //}

    private static void rangeTest() {
        TestSuite.testMessage("Testing range() method:");
        TestSuite.dependencyMessage("insert() method must be implemented correctly");

        /* SETUP */
        PointSET pSETa = new PointSET();
        boolean throwsException;

        PointSET pSETb = new PointSET();
        pSETb.insert(new Point2D(0.5, 0.5));
        List<Point2D> setB = (ArrayList<Point2D>) pSETb.range(new RectHV(0.0, 0.0, 1.0, 1.0));
        List<Point2D> matchB = new ArrayList<>();
        matchB.add(new Point2D(0.5, 0.5));

        PointSET pSETc = new PointSET();
        pSETc.insert(new Point2D(0.5, 0.5));
        pSETc.insert(new Point2D(0.3, 0.3));
        List<Point2D> setC = (ArrayList<Point2D>) pSETc.range(new RectHV(0.0, 0.0, 1.0, 1.0));
        List<Point2D> matchC = new ArrayList<>();
        matchC.add(new Point2D(0.5, 0.5));
        matchC.add(new Point2D(0.3, 0.3));

        PointSET pSETd = new PointSET();
        pSETd.insert(new Point2D(0.1, 0.1));
        pSETd.insert(new Point2D(0.2, 0.2));
        List<Point2D> setD = (ArrayList<Point2D>) pSETd.range(new RectHV(0.0, 0.0, 0.5, 0.5));
        List<Point2D> matchD = new ArrayList<>();
        matchD.add(new Point2D(0.1, 0.1));
        matchD.add(new Point2D(0.2, 0.2));

        PointSET pSETe = new PointSET();
        pSETe.insert(new Point2D(0.1, 0.1));
        pSETe.insert(new Point2D(0.2, 0.2));
        List<Point2D> setE = (ArrayList<Point2D>) pSETe.range(new RectHV(0.0, 0.0, 0.5, 0.5));
        List<Point2D> matchE = new ArrayList<>();
        matchE.add(new Point2D(0.6, 0.6));
        matchE.add(new Point2D(0.2, 0.2));

        PointSET pSETf = new PointSET();
        pSETf.insert(new Point2D(0.1, 0.1));
        pSETf.insert(new Point2D(0.2, 0.2));
        pSETf.insert(new Point2D(0.6, 0.6));
        pSETf.insert(new Point2D(0.7, 0.7));
        List<Point2D> setF = (ArrayList<Point2D>) pSETf.range(new RectHV(0.5, 0.5, 1.0, 1.0));
        List<Point2D> matchF = new ArrayList<>();
        matchF.add(new Point2D(0.6, 0.6));
        matchF.add(new Point2D(0.7, 0.7));

        /* START TESTS */

        // Test 1
        try {
            pSETa.range(null);
            throwsException = false;
        } catch (NullPointerException e) {
            throwsException = true;
        }
        TestSuite.assertTrue(throwsException);

        // Test 2
        TestSuite.assertTrue(equal(setB, matchB));

        // Test 3
        TestSuite.assertTrue(equal(setC, matchC));

        // Test 4
        TestSuite.assertTrue(equal(setD, matchD));
        
        // Test 5
        TestSuite.assertFalse(equal(setE, matchE));

        // Test 6
        TestSuite.assertTrue(equal(setF, matchF));

        /* END TESTS */
        System.out.println();
    }

    private static void nearestTest() {
        TestSuite.testMessage("Testing nearest() method:");
        TestSuite.dependencyMessage("insert() method must be implemented correctly");

        /* SETUP */
        PointSET pSETa = new PointSET();
        boolean throwsException;

        PointSET pSETb = new PointSET();

        PointSET pSETc = new PointSET();
        pSETc.insert(new Point2D(0.0, 0.0));
        pSETc.insert(new Point2D(1.0, 1.0));

        PointSET pSETd = new PointSET();
        pSETd.insert(new Point2D(0.0, 0.0));
        pSETd.insert(new Point2D(0.0, 1.0));
        pSETd.insert(new Point2D(1.0, 1.0));
        pSETd.insert(new Point2D(1.0, 0.0));

        /* START TESTS */

        // Test 1
        try {
            pSETa.nearest(null);
            throwsException = false;
        } catch (NullPointerException e) {
            throwsException = true;
        }
        TestSuite.assertTrue(throwsException);

        // Test 2
        TestSuite.assertTrue(pSETb.nearest(new Point2D(0.0, 0.0)) == null);

        // Test 3
        TestSuite.assertTrue(pSETc.nearest(new Point2D(0.4, 0.4)).equals(new Point2D(0.0, 0.0)));

        // Test 4
        TestSuite.assertTrue(pSETc.nearest(new Point2D(0.6, 0.6)).equals(new Point2D(1.0, 1.0)));

        // Test 5
        TestSuite.assertTrue(pSETd.nearest(new Point2D(0.25, 0.25)).equals(new Point2D(0.0, 0.0)));

        // Test 6
        TestSuite.assertTrue(pSETd.nearest(new Point2D(0.25, 0.75)).equals(new Point2D(0.0, 1.0)));

        // Test 7
        TestSuite.assertTrue(pSETd.nearest(new Point2D(0.75, 0.75)).equals(new Point2D(1.0, 1.0)));

        // Test 8
        TestSuite.assertTrue(pSETd.nearest(new Point2D(0.75, 0.25)).equals(new Point2D(1.0, 0.0)));

        /* END TESTS */
        System.out.println();
    }

    private static boolean equal(List<Point2D> listA, List<Point2D> listB) {
        if (listA.size() != listB.size())
            return false;
        for (Point2D p : listA)
            if (!listB.contains(p))
                return false;
        return true;
    }

    private static void runTests() {
        PointSETConstructorTest();
        isEmptyTest();
        sizeTest();
        insertTest();
        containsTest();
        //drawTest();
        rangeTest();
        nearestTest();
    }

    public static void main(String[] args) {
        TestSuite.startMessage("PointSET");
        runTests();
        TestSuite.endMessage("PointSET");
    }
}
