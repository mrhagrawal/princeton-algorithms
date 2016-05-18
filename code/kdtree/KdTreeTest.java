import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import java.util.List;
import java.util.ArrayList;

public class KdTreeTest {

    private static void KdTreeConstructorTest() {
        TestSuite.testMessage("Testing KdTree Constructor:");

        /* SETUP */
        boolean validConstruction;

        /* START TESTS */

        // Test 1
        try {
            KdTree kT = new KdTree();
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
        KdTree kTa = new KdTree();

        KdTree kTb = new KdTree();
        kTb.insert(new Point2D(0.5, 0.5));

        /* START TESTS */
        
        // Test 1
        TestSuite.assertTrue(kTa.isEmpty());

        // Test 2
        TestSuite.assertFalse(kTb.isEmpty());

        /* END TESTS */
        System.out.println();
    }

    private static void sizeTest() {
        TestSuite.testMessage("Testing size() method:");
        TestSuite.dependencyMessage("insert() method must implemented correctly");

        /* SETUP */
        KdTree kTa = new KdTree();

        KdTree kTb = new KdTree();
        kTb.insert(new Point2D(0.5, 0.5));

        KdTree kTc = new KdTree();
        for (int i = 0; i < 5; i++)
            kTc.insert(new Point2D(i / 5.0, i / 5.0));

        KdTree kTd = new KdTree();
        for (int i = 0; i < 25; i++)
            kTd.insert(new Point2D(i / 25.0, i / 25.0));

        KdTree kTe = new KdTree();
        for (int i = 0; i < 100; i++)
            kTe.insert(new Point2D(i / 100.0, i / 100.0));

        KdTree kTf = new KdTree();
        for (int i = 0; i < 1000; i++)
            kTf.insert(new Point2D(i / 1000.0, i / 1000.0));

        KdTree kTg = new KdTree();
        for (int i = 0; i < 10000; i++)
            kTg.insert(new Point2D(i / 10000.0, i / 10000.0));

        KdTree kTh = new KdTree();
        for (int i = 0; i < 100000; i++)
            kTh.insert(new Point2D(i / 100000.0, i / 100000.0));

        KdTree kTi = new KdTree();
        for (int i = 0; i < 1000000; i++)
            kTi.insert(new Point2D(i / 1000000.0, i / 1000000.0));

        /* START TESTS */

        // Test 1
        TestSuite.assertEqual(kTa.size(), 0);

        // Test 2
        TestSuite.assertEqual(kTb.size(), 1);

        // Test 3
        TestSuite.assertEqual(kTc.size(), 5);

        // Test 4
        TestSuite.assertEqual(kTd.size(), 25);

        // Test 5
        TestSuite.assertEqual(kTe.size(), 100);

        // Test 6
        TestSuite.assertEqual(kTf.size(), 1000);

        // Test 7
        TestSuite.assertEqual(kTg.size(), 10000);

        // Test 8
        TestSuite.assertEqual(kTh.size(), 100000);

        // Test 9
        TestSuite.assertEqual(kTi.size(), 1000000);

        /* END TESTS */
        System.out.println();
    }

    private static void insertTest() {
        TestSuite.testMessage("Testing insert() method:");
        TestSuite.dependencyMessage("size() method must implemented correctly");

        /* SETUP */
        KdTree kTa = new KdTree();
        boolean throwsException;

        KdTree kTb = new KdTree();
        kTb.insert(new Point2D(0.5, 0.5));

        KdTree kTc = new KdTree();
        kTc.insert(new Point2D(0.5, 0.5));
        kTc.insert(new Point2D(0.5, 0.5));

        KdTree kTd = new KdTree();
        kTd.insert(new Point2D(0.5, 0.5));
        kTd.insert(new Point2D(0.5, 0.5));
        kTd.insert(new Point2D(0.7, 0.7));
        kTd.insert(new Point2D(0.7, 0.7));

        KdTree kTe = new KdTree();
        kTe.insert(new Point2D(0.5, 0.5));
        kTe.insert(new Point2D(0.5, 0.5));
        kTe.insert(new Point2D(0.7, 0.7));
        kTe.insert(new Point2D(0.7, 0.7));
        kTe.insert(new Point2D(0.9, 0.9));
        kTe.insert(new Point2D(0.9, 0.9));

        KdTree kTf = new KdTree();
        kTf.insert(new Point2D(0.5, 0.5));
        kTf.insert(new Point2D(0.5, 0.5));
        kTf.insert(new Point2D(0.7, 0.7));
        kTf.insert(new Point2D(0.7, 0.7));
        kTf.insert(new Point2D(0.9, 0.9));
        kTf.insert(new Point2D(0.9, 0.9));
        kTf.insert(new Point2D(0.6, 0.6));
        kTf.insert(new Point2D(0.6, 0.6));

        KdTree kTg = new KdTree();
        kTg.insert(new Point2D(0.5, 0.5));
        kTg.insert(new Point2D(0.5, 0.5));
        kTg.insert(new Point2D(0.7, 0.7));
        kTg.insert(new Point2D(0.7, 0.7));
        kTg.insert(new Point2D(0.9, 0.9));
        kTg.insert(new Point2D(0.9, 0.9));
        kTg.insert(new Point2D(0.6, 0.6));
        kTg.insert(new Point2D(0.6, 0.6));
        kTg.insert(new Point2D(0.4, 0.4));
        kTg.insert(new Point2D(0.4, 0.4));


        /* START TESTS */

        // Test 1
        try {
            kTa.insert(null);
            throwsException = false;
        } catch (NullPointerException e) {
            throwsException = true;
        }
        TestSuite.assertTrue(throwsException);

        // Test 2
        TestSuite.assertEqual(kTb.size(), 1);

        // Test 3
        TestSuite.assertEqual(kTc.size(), 1);

        // Test 4
        TestSuite.assertEqual(kTd.size(), 2);

        // Test 5
        TestSuite.assertEqual(kTe.size(), 3);

        // Test 6
        TestSuite.assertEqual(kTf.size(), 4);

        // Test 7
        TestSuite.assertEqual(kTg.size(), 5);

        /* END TESTS */
        System.out.println();
    }

    private static void containsTest() {
        TestSuite.testMessage("Testing contains() method:");
        TestSuite.dependencyMessage("insert() method must be implemented correctly");

        /* SETUP */
        KdTree kTa = new KdTree();
        boolean throwsException;

        KdTree kTb = new KdTree();
        kTb.insert(new Point2D(0.5, 0.5));

        KdTree kTc = new KdTree();
        kTc.insert(new Point2D(0.5, 0.5));
        kTc.insert(new Point2D(0.4, 0.4));

        /* START TESTS */

        // Test 1
        try {
            kTa.contains(null);
            throwsException = false;
        } catch (NullPointerException e) {
            throwsException = true;
        }
        TestSuite.assertTrue(throwsException);

        // Test 2
        TestSuite.assertTrue(kTb.contains(new Point2D(0.5, 0.5)));

        // Test 3
        TestSuite.assertFalse(kTb.contains(new Point2D(0.4, 0.4)));

        // Test 4
        TestSuite.assertTrue(kTc.contains(new Point2D(0.4, 0.4)));

        // Test 5
        TestSuite.assertFalse(kTc.contains(new Point2D(0.3, 0.3)));

        // Test 6
        TestSuite.assertTrue(kTc.contains(new Point2D(0.5, 0.5)));

        /* END TESTS */
        System.out.println();
    }

    //private static void drawTest() {
    //}

    private static void rangeTest() {
        TestSuite.testMessage("Testing range() method:");
        TestSuite.dependencyMessage("insert() method must be implemented correctly");

        /* SETUP */
        KdTree kTa = new KdTree();
        boolean throwsException;

        KdTree kTb = new KdTree();
        kTb.insert(new Point2D(0.5, 0.5));
        List<Point2D> setB = (ArrayList<Point2D>) kTb.range(new RectHV(0.0, 0.0, 1.0, 1.0));
        List<Point2D> matchB = new ArrayList<>();
        matchB.add(new Point2D(0.5, 0.5));

        KdTree kTc = new KdTree();
        kTc.insert(new Point2D(0.5, 0.5));
        kTc.insert(new Point2D(0.3, 0.3));
        List<Point2D> setC = (ArrayList<Point2D>) kTc.range(new RectHV(0.0, 0.0, 1.0, 1.0));
        List<Point2D> matchC = new ArrayList<>();
        matchC.add(new Point2D(0.5, 0.5));
        matchC.add(new Point2D(0.3, 0.3));

        KdTree kTd = new KdTree();
        kTd.insert(new Point2D(0.1, 0.1));
        kTd.insert(new Point2D(0.2, 0.2));
        List<Point2D> setD = (ArrayList<Point2D>) kTd.range(new RectHV(0.0, 0.0, 0.5, 0.5));
        List<Point2D> matchD = new ArrayList<>();
        matchD.add(new Point2D(0.1, 0.1));
        matchD.add(new Point2D(0.2, 0.2));

        KdTree kTe = new KdTree();
        kTe.insert(new Point2D(0.1, 0.1));
        kTe.insert(new Point2D(0.2, 0.2));
        List<Point2D> setE = (ArrayList<Point2D>) kTe.range(new RectHV(0.0, 0.0, 0.5, 0.5));
        List<Point2D> matchE = new ArrayList<>();
        matchE.add(new Point2D(0.6, 0.6));
        matchE.add(new Point2D(0.2, 0.2));

        KdTree kTf = new KdTree();
        kTf.insert(new Point2D(0.1, 0.1));
        kTf.insert(new Point2D(0.2, 0.2));
        kTf.insert(new Point2D(0.6, 0.6));
        kTf.insert(new Point2D(0.7, 0.7));
        List<Point2D> setF = (ArrayList<Point2D>) kTf.range(new RectHV(0.5, 0.5, 1.0, 1.0));
        List<Point2D> matchF = new ArrayList<>();
        matchF.add(new Point2D(0.6, 0.6));
        matchF.add(new Point2D(0.7, 0.7));

        /* START TESTS */

        // Test 1
        try {
            kTa.range(null);
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
        KdTree kTa = new KdTree();
        boolean throwsException;

        KdTree kTb = new KdTree();

        KdTree kTc = new KdTree();
        kTc.insert(new Point2D(0.0, 0.0));
        kTc.insert(new Point2D(1.0, 1.0));

        KdTree kTd = new KdTree();
        kTd.insert(new Point2D(0.0, 0.0));
        kTd.insert(new Point2D(0.0, 1.0));
        kTd.insert(new Point2D(1.0, 1.0));
        kTd.insert(new Point2D(1.0, 0.0));

        /* START TESTS */

        // Test 1
        try {
            kTa.nearest(null);
            throwsException = false;
        } catch (NullPointerException e) {
            throwsException = true;
        }
        TestSuite.assertTrue(throwsException);

        // Test 2
        TestSuite.assertTrue(kTb.nearest(new Point2D(0.0, 0.0)) == null);

        // Test 3
        TestSuite.assertTrue(kTc.nearest(new Point2D(0.4, 0.4)).equals(new Point2D(0.0, 0.0)));

        // Test 4
        TestSuite.assertTrue(kTc.nearest(new Point2D(0.6, 0.6)).equals(new Point2D(1.0, 1.0)));

        // Test 5
        TestSuite.assertTrue(kTd.nearest(new Point2D(0.25, 0.25)).equals(new Point2D(0.0, 0.0)));

        // Test 6
        TestSuite.assertTrue(kTd.nearest(new Point2D(0.25, 0.75)).equals(new Point2D(0.0, 1.0)));

        // Test 7
        TestSuite.assertTrue(kTd.nearest(new Point2D(0.75, 0.75)).equals(new Point2D(1.0, 1.0)));

        // Test 8
        TestSuite.assertTrue(kTd.nearest(new Point2D(0.75, 0.25)).equals(new Point2D(1.0, 0.0)));

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
        KdTreeConstructorTest();
        isEmptyTest();
        sizeTest();
        insertTest();
        containsTest();
        //drawTest();
        rangeTest();
        nearestTest();
    }

    public static void main(String[] args) {
        TestSuite.startMessage("KdTree");
        runTests();
        TestSuite.endMessage("KdTree");
    }
}
