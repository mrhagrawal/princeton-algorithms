public class SolverTest {

    private static void solverConstructorTest() {
        TestSuite.testMessage("Testing Solver Constructor:");

        /* SETUP */

        /* BEGIN TESTS */

        /* END TESTS */
        System.out.println();
    }

    private static void isSolvableTest() {
        TestSuite.testMessage("Testing isSolvable() method:");

        /* SETUP */

        /* BEGIN TESTS */

        /* END TESTS */
        System.out.println();
    }

    private static void movesTest() {
        TestSuite.testMessage("Testing moves() method:");

        /* SETUP */

        /* BEGIN TESTS */

        /* END TESTS */
        System.out.println();
    }

    private static void solutionTest() {
        TestSuite.testMessage("Testing solution() method:");

        /* SETUP */

        /* BEGIN TESTS */

        /* END TESTS */
        System.out.println();
    }

    private static void runTests() {
        solverConstructorTest();
        isSolvableTest();
        movesTest();
        solutionTest();
    }

    public static void main(String[] args) {
        TestSuite.startMessage("Solver");
        runTests();
        TestSuite.endMessage("Solver");
    }
}
