public class BoardTest {

    private static void boardConstructorTest() {
        TestSuite.testMessage("Testing Board Constructor:");

        /* SETUP */
        Board a;
        Board b;
        Board c;
        Board d;

        boolean validBoard;

        /* BEGIN TESTS */
        
        // Test 1
        try {
            a = new Board(null);
            validBoard = true;
        } catch (NullPointerException e) {
            validBoard = false;
        }
        TestSuite.assertFalse(validBoard);

        // Test 2
        try {
            b = new Board(new int[][] {{1, 2}, {3, 0}});
            validBoard = true;
        } catch (IllegalArgumentException e) {
            validBoard = false;
        }
        TestSuite.assertTrue(validBoard);

        // Test 3
        try {
            c = new Board(new int[][] {{1, 2}, {3, 4}});
            validBoard = true;
        } catch (IllegalArgumentException e) {
            validBoard = false;
        }
        TestSuite.assertFalse(validBoard);

        // Test 4
        try {
            c = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
            validBoard = true;
        } catch (IllegalArgumentException e) {
            validBoard = false;
        }
        TestSuite.assertTrue(validBoard);

        // Test 5
        try {
            c = new Board(new int[][] {{5, 2}, {3, 0}});
            validBoard = true;
        } catch (IllegalArgumentException e) {
            validBoard = false;
        }
        TestSuite.assertFalse(validBoard);

        // Test 6
        try {
            d = new Board(new int[][] {{1, 1}, {3, 0}});
            validBoard = true;
        } catch (IllegalArgumentException e) {
            validBoard = false;
        }
        TestSuite.assertFalse(validBoard);

        /* END TESTS */
        System.out.println();
    }

    private static void dimensionTest() {
        TestSuite.testMessage("Testing dimension() method:");

        /* SETUP */
        Board a = new Board(new int[][]{{0, 1}, {2, 3}});
        Board b = new Board(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        Board c = new Board(new int[][]{{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11},
            {12, 13, 14, 15}});
        Board d = new Board(init(10));
        Board e = new Board(init(100));

        boolean result;
        int expected;
        int actual;

        /* BEGIN TESTS */

        // TEST 1
        expected = 2;
        actual = a.dimension();
        TestSuite.assertEqual(expected, actual);
        
        // TEST 2
        expected = 3;
        actual = b.dimension();
        TestSuite.assertEqual(expected, actual);

        // TEST 3
        expected = 4;
        actual = c.dimension();
        TestSuite.assertEqual(expected, actual);

        // TEST 4
        expected = 10;
        actual = d.dimension();
        TestSuite.assertEqual(expected, actual);

        // TEST 5
        expected = 100;
        actual = e.dimension();
        TestSuite.assertEqual(expected, actual);

        /* END TESTS */
        System.out.println();
    }

    private static void hammingTest() {
        TestSuite.testMessage("Testing hamming() method:");

        /* SETUP */

        // 2x2 Boards
        Board a1 = new Board(new int[][] {{0, 1}, {2, 3}});
        Board a2 = new Board(new int[][] {{0, 1}, {3, 2}});
        Board a3 = new Board(new int[][] {{0, 2}, {1, 3}});
        Board a4 = new Board(new int[][] {{0, 2}, {3, 1}});
        Board a5 = new Board(new int[][] {{0, 3}, {1, 2}});
        
        // 3x3 Boards
        Board b1 = new Board(new int[][] {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        Board b2 = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        Board b3 = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {8, 7, 0}});
        Board b4 = new Board(new int[][] {{1, 2, 3}, {4, 6, 5}, {7, 8, 0}});
        Board b5 = new Board(new int[][] {{1, 2, 4}, {3, 6, 5}, {7, 8, 0}});

        boolean result;
        int expected;
        int actual;

        /* BEGIN TESTS */

        // Test 1
        expected = 3;
        actual = a1.hamming();
        TestSuite.assertEqual(expected, actual);

        // Test 2
        expected = 2;
        actual = a2.hamming();
        TestSuite.assertEqual(expected, actual);

        // Test 3
        expected = 2;
        actual = a3.hamming();
        TestSuite.assertEqual(expected, actual);

        // Test 4
        expected = 1;
        actual = a4.hamming();
        TestSuite.assertEqual(expected, actual);

        // Test 5
        expected = 3;
        actual = a5.hamming();
        TestSuite.assertEqual(expected, actual);

        // Test 6
        expected = 8;
        actual = b1.hamming();
        TestSuite.assertEqual(expected, actual);

        // Test 7
        expected = 0;
        actual = b2.hamming();
        TestSuite.assertEqual(expected, actual);

        // Test 8
        expected = 2;
        actual = b3.hamming();
        TestSuite.assertEqual(expected, actual);

        // Test 9
        expected = 2;
        actual = b4.hamming();
        TestSuite.assertEqual(expected, actual);

        // Test 10
        expected = 4;
        actual = b5.hamming();
        TestSuite.assertEqual(expected, actual);

        /* END TESTS */
        System.out.println();
    }

    private static void manhattanTest() {
        TestSuite.testMessage("Testing manhattan() method:");

        /* SETUP */

        // 2x2 Boards
        Board a1 = new Board(new int[][] {{0, 1}, {2, 3}});
        Board a2 = new Board(new int[][] {{0, 1}, {3, 2}});
        Board a3 = new Board(new int[][] {{0, 2}, {1, 3}});
        Board a4 = new Board(new int[][] {{0, 2}, {3, 1}});
        Board a5 = new Board(new int[][] {{0, 3}, {1, 2}});
        
        // 3x3 Boards
        Board b1 = new Board(new int[][] {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        Board b2 = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        Board b3 = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {8, 7, 0}});
        Board b4 = new Board(new int[][] {{1, 2, 3}, {4, 6, 5}, {7, 8, 0}});
        Board b5 = new Board(new int[][] {{1, 2, 4}, {3, 6, 5}, {7, 8, 0}});

        boolean result;
        int expected;
        int actual;

        /* BEGIN TESTS */

        // Test 1
        expected = 4;
        actual = a1.manhattan();
        TestSuite.assertEqual(expected, actual);

        // Test 2
        expected = 2;
        actual = a2.manhattan();
        TestSuite.assertEqual(expected, actual);

        // Test 3
        expected = 2;
        actual = a3.manhattan();
        TestSuite.assertEqual(expected, actual);

        // Test 4
        expected = 2;
        actual = a4.manhattan();
        TestSuite.assertEqual(expected, actual);

        // Test 5
        expected = 4;
        actual = a5.manhattan();
        TestSuite.assertEqual(expected, actual);

        // Test 6
        expected = 12;
        actual = b1.manhattan();
        TestSuite.assertEqual(expected, actual);

        // Test 7
        expected = 0;
        actual = b2.manhattan();
        TestSuite.assertEqual(expected, actual);

        // Test 8
        expected = 2;
        actual = b3.manhattan();
        TestSuite.assertEqual(expected, actual);

        // Test 9
        expected = 2;
        actual = b4.manhattan();
        TestSuite.assertEqual(expected, actual);

        // Test 10
        expected = 8;
        actual = b5.manhattan();
        TestSuite.assertEqual(expected, actual);

        /* END TESTS */
        System.out.println();
    }

    private static void isGoalTest() {
        TestSuite.testMessage("Testing isGoal() method:");

        /* SETUP */
        Board a = new Board(new int[][] {{1, 2}, {3, 0}});
        Board b = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        Board c = new Board(new int[][] {{0, 1}, {2, 3}});
        Board d = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}});
        Board e = new Board(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
            {13, 14, 15, 0}});

        /* BEGIN TESTS */

        // Test 1
        TestSuite.assertTrue(a.isGoal());

        // Test 2
        TestSuite.assertTrue(b.isGoal());

        // Test 3
        TestSuite.assertFalse(c.isGoal());

        // Test 4
        TestSuite.assertFalse(d.isGoal());

        // Test 5
        TestSuite.assertTrue(e.isGoal());

        /* END TESTS */
        System.out.println();
    }

    private static void twinTest() {
        TestSuite.testMessage("Testing twin() method:");

        /* SETUP */
        Board a = new Board(new int[][] {{1, 2}, {3, 0}});
        Board twinA1 = new Board(new int[][] {{2, 1}, {3, 0}});
        Board twinA2 = new Board(new int[][] {{3, 2}, {1, 0}});
        Board twinA3 = new Board(new int[][] {{1, 3}, {2, 0}});
        Board[] twinsOfa = {twinA1, twinA2, twinA3};

        Board b = new Board(new int[][] {{1, 0}, {2, 3}});
        Board twinB1 = new Board(new int[][] {{2, 0}, {1, 3}});
        Board twinB2 = new Board(new int[][] {{1, 0}, {3, 2}});
        Board twinB3 = new Board(new int[][] {{3, 0}, {2, 1}});
        Board[] twinsOfb = {twinB1, twinB2, twinB3};

        Board c = new Board(new int[][] {{2, 0}, {1, 3}});
        Board twinC1 = new Board(new int[][] {{3, 0}, {1, 2}});
        Board twinC2 = new Board(new int[][] {{1, 0}, {2, 3}});
        Board twinC3 = new Board(new int[][] {{2, 0}, {3, 1}});
        Board[] twinsOfc = {twinC1, twinC2, twinC3};
        
        Board d = new Board(new int[][] {{3, 0}, {1, 2}});
        Board twinD1 = new Board(new int[][] {{1, 0}, {3, 2}});
        Board twinD2 = new Board(new int[][] {{3, 0}, {2, 1}});
        Board twinD3 = new Board(new int[][] {{2, 0}, {1, 3}});
        Board[] twinsOfd = {twinD1, twinD2, twinD3};

        Board e = new Board(new int[][] {{3, 2}, {0, 1}});
        Board twinE1 = new Board(new int[][] {{2, 3}, {0, 1}});
        Board twinE2 = new Board(new int[][] {{3, 1}, {0, 2}});
        Board twinE3 = new Board(new int[][] {{1, 2}, {0, 3}});
        Board[] twinsOfe = {twinE1, twinE2, twinE3};

        Board f = new Board(new int[][] {{0, 1}, {2, 3}});
        Board twinF1 = new Board(new int[][] {{2, 3}, {0, 1}});
        Board twinF2 = new Board(new int[][] {{3, 1}, {0, 2}});
        Board twinF3 = new Board(new int[][] {{1, 2}, {0, 3}});
        Board[] twinsOff = {twinF1, twinF2, twinF3};

        Board g = new Board(new int[][] {{0, 2}, {1, 3}});
        Board twinG1 = new Board(new int[][] {{2, 3}, {0, 1}});
        Board twinG2 = new Board(new int[][] {{3, 1}, {0, 2}});
        Board twinG3 = new Board(new int[][] {{1, 2}, {0, 3}});
        Board[] twinsOfg = {twinG1, twinG2, twinG3};

        /* BEGIN TESTS */

        // Test 1
        Board twinA = a.twin();
        TestSuite.assertTrue(java.util.Arrays.asList(twinsOfa).contains(twinA));

        // Test 2
        Board twinB = b.twin();
        TestSuite.assertTrue(java.util.Arrays.asList(twinsOfb).contains(twinB));

        // Test 3
        Board twinC = c.twin();
        TestSuite.assertTrue(java.util.Arrays.asList(twinsOfc).contains(twinC));

        // Test 4
        Board twinD = d.twin();
        TestSuite.assertTrue(java.util.Arrays.asList(twinsOfd).contains(twinD));

        // Test 5
        Board twinE = e.twin();
        TestSuite.assertTrue(java.util.Arrays.asList(twinsOfe).contains(twinE));

        // Test 6
        Board twinF = f.twin();
        TestSuite.assertFalse(java.util.Arrays.asList(twinsOff).contains(twinF));

        // Test 7
        Board twinG = g.twin();
        TestSuite.assertFalse(java.util.Arrays.asList(twinsOfg).contains(twinG));

        /* END TESTS */
        System.out.println();
    }

    private static void equalsTest() {
        TestSuite.testMessage("Testing equals() method:");

        /* SETUP */
        Board a = null;
        Board b = new Board(init(10));
        Board c = new Board(new int[][] {{1, 2}, {3, 0}});
        Board d = new Board(new int[][] {{1, 2}, {3, 0}});
        Board e = new Board(new int[][] {{1, 2}, {3, 0}});

        /* BEGIN TESTS */
        
        // Test 1
        TestSuite.assertFalse(b.equals(a));

        // Test 2
        TestSuite.assertTrue(b.equals(b));

        // Test 3
        TestSuite.assertFalse(b.equals(c));

        // Test 4
        TestSuite.assertTrue(c.equals(d));

        // Test 5
        TestSuite.assertTrue(d.equals(e));

        // Test 6
        TestSuite.assertTrue(c.equals(e));

        /* END TESTS */
        System.out.println();
    }

    //private static void hashCodeTest() {
        //System.out.println(color("Testing hashCode method:", YELLOW));

        //[> SETUP <]
        //Board a = new Board(new int[][] {{1, 2}, {3, 0}});
        //Board b = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        //Board c = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});

        //[> BEGIN TESTS <]

        //// Test 1
        //assertEqual(a.hashCode(), a.hashCode());

        //// Test 2
        //assertNotEqual(a.hashCode(), b.hashCode());

        //// Test 3
        //assertEqual(b.hashCode(), c.hashCode());

        //[> END TESTS <]
        //System.out.println();
    //}

    private static void neighborsTest() {
        TestSuite.testMessage("Testing neighbors() method:");

        /* SETUP */
        Board a = new Board(new int[][] {{0, 1}, {2, 3}});
        Board neighborA1 = new Board(new int[][] {{1, 0}, {2, 3}});
        Board neighborA2 = new Board(new int[][] {{2, 1}, {0, 3}});
        java.util.ArrayList<Board> listA = new java.util.ArrayList<>();
        listA.add(neighborA1);
        listA.add(neighborA2);

        Board b = new Board(new int[][] {{1, 2}, {3, 0}});
        Board neighborB1 = new Board(new int[][] {{1, 0}, {3, 2}});
        Board neighborB2 = new Board(new int[][] {{1, 2}, {0, 3}});
        java.util.ArrayList<Board> listB = new java.util.ArrayList<>();
        listB.add(neighborB1);
        listB.add(neighborB2);

        Board c = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        Board neighborC1 = new Board(new int[][] {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}});
        Board neighborC2 = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}});
        java.util.ArrayList<Board> listC = new java.util.ArrayList<>();
        listC.add(neighborC1);
        listC.add(neighborC2);

        Board d = new Board(new int[][] {{1, 2, 3}, {4, 0, 6}, {5, 7, 8}});
        Board neighborD1 = new Board(new int[][] {{1, 0, 3}, {4, 2, 6}, {5, 7, 8}});
        Board neighborD2 = new Board(new int[][] {{1, 2, 3}, {4, 6, 0}, {5, 7, 8}});
        Board neighborD3 = new Board(new int[][] {{1, 2, 3}, {4, 7, 6}, {5, 0, 8}});
        Board neighborD4 = new Board(new int[][] {{1, 2, 3}, {0, 4, 6}, {5, 7, 8}});
        java.util.ArrayList<Board> listD = new java.util.ArrayList<>();
        listD.add(neighborD1);
        listD.add(neighborD2);
        listD.add(neighborD3);
        listD.add(neighborD4);

        Board e = new Board(new int[][] {{1, 0, 3}, {2, 4, 5}, {6, 7, 8}});
        Board neighborE1 = new Board(new int[][] {{1, 3, 0}, {2, 4, 5}, {6, 7, 8}});
        Board neighborE2 = new Board(new int[][] {{1, 4, 3}, {2, 0, 5}, {6, 7, 8}});
        Board neighborE3 = new Board(new int[][] {{0, 1, 3}, {2, 4, 5}, {6, 7, 8}});
        java.util.ArrayList<Board> listE = new java.util.ArrayList<>();
        listE.add(neighborE1);
        listE.add(neighborE2);
        listE.add(neighborE3);

        Board f = new Board(new int[][] {{4, 5, 6}, {1, 0, 2}, {3, 7, 8}});
        Board neighborF1 = new Board(new int[][] {{4, 0, 6}, {1, 5, 2}, {3, 7, 8}});
        Board neighborF2 = new Board(new int[][] {{4, 5, 6}, {1, 2, 0}, {3, 7, 8}});
        Board neighborF3 = new Board(new int[][] {{4, 5, 6}, {1, 7, 2}, {3, 0, 8}});
        Board neighborF4 = new Board(new int[][] {{4, 5, 6}, {0, 1, 2}, {3, 7, 8}});
        java.util.ArrayList<Board> listF = new java.util.ArrayList<>();
        listF.add(neighborF1);
        listF.add(neighborF2);
        listF.add(neighborF3);
        listF.add(neighborF4);
        
        Board g = new Board(new int[][] {{7, 8, 1}, {5, 0, 6}, {2, 3, 4}});
        Board neighborG1 = new Board(new int[][] {{7, 0, 1}, {5, 8, 6}, {2, 3, 4}});
        Board neighborG2 = new Board(new int[][] {{7, 8, 1}, {5, 6, 0}, {2, 3, 4}});
        Board neighborG3 = new Board(new int[][] {{7, 8, 1}, {5, 3, 6}, {2, 0, 4}});
        Board neighborG4 = new Board(new int[][] {{7, 8, 1}, {0, 5, 6}, {2, 3, 4}});
        java.util.ArrayList<Board> listG = new java.util.ArrayList<>();
        listG.add(neighborG1);
        listG.add(neighborG2);
        listG.add(neighborG3);
        listG.add(neighborG4);

        Board h = new Board(new int[][] {{8, 7, 6}, {5, 0, 4}, {3, 2, 1}});
        Board neighborH1 = new Board(new int[][] {{8, 0, 6}, {5, 7, 4}, {3, 2, 1}});
        Board neighborH2 = new Board(new int[][] {{8, 7, 6}, {5, 4, 0}, {3, 2, 1}});
        Board neighborH3 = new Board(new int[][] {{8, 7, 6}, {5, 2, 4}, {3, 0, 1}});
        Board neighborH4 = new Board(new int[][] {{8, 7, 6}, {0, 5, 4}, {3, 2, 1}});
        java.util.ArrayList<Board> listH = new java.util.ArrayList<>();
        listH.add(neighborH1);
        listH.add(neighborH2);
        listH.add(neighborH3);
        listH.add(neighborH4);

        /* BEGIN TESTS */

        // Test 1
        TestSuite.assertTrue(listA.equals(a.neighbors()));

        // Test 2
        TestSuite.assertTrue(listB.equals(b.neighbors()));

        // Test 3
        TestSuite.assertTrue(listC.equals(c.neighbors()));

        // Test 4
        TestSuite.assertTrue(listD.equals(d.neighbors()));

        // Test 5
        TestSuite.assertTrue(listE.equals(e.neighbors()));

        // Test 6
        TestSuite.assertTrue(listF.equals(f.neighbors()));

        // Test 7
        TestSuite.assertTrue(listG.equals(g.neighbors()));

        // Test 8
        TestSuite.assertTrue(listH.equals(h.neighbors()));

        /* END TESTS */
        System.out.println();
    }

    private static void toStringTest() {
        TestSuite.testMessage("Testing toString() method:");

        /* SETUP */
        Board a = new Board(new int[][] {{1, 2}, {3, 0}});
        Board b = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        Board c = new Board(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
            {13, 14, 15, 0}});

        String s;

        /* BEGIN TESTS */

        // Test 1
        s = "2\n 1  2 \n 3  0 \n";
        TestSuite.assertEqual(s, a.toString());

        // Test 2
        s = "3\n 1  2  3 \n 4  5  6 \n 7  8  0 \n";
        TestSuite.assertEqual(s, b.toString());

        // Test 3
        s = "4\n 1  2  3  4 \n 5  6  7  8 \n 9 10 11 12 \n13 14 15  0 \n";
        TestSuite.assertEqual(s, c.toString());

        /* END TESTS */
        System.out.println();
    }

    private static int[][] init(int n) {
        int[][] a = new int[n][n];
        int count = 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = count++ % (n * n);
        return a;
    }

    private static void runTests() {
        boardConstructorTest();
        dimensionTest();
        hammingTest();
        manhattanTest();
        isGoalTest();
        twinTest();
        equalsTest();
        //hashCodeTest();
        neighborsTest();
        toStringTest();
    }

    public static void main(String[] args) {
        TestSuite.startMessage("Board");
        runTests();
        TestSuite.endMessage("Board");
    }
}
