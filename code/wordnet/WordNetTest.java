public class WordNetTest {

    private static void WordNetConstructorTest() {
        TestSuite.testMessage("Testing WordNet Constructor:");

        /* SETUP */
        boolean validConstruction;

        /* START TESTS */

        // Test 1
        try {
            WordNet wn = new WordNet(null, null);
            validConstruction = true;
        } catch (NullPointerException e) {
            validConstruction = false;
        }
        TestSuite.assertFalse(validConstruction);

        // Test 2
        try {
            WordNet wn = new WordNet("A", null);
            validConstruction = true;
        } catch (NullPointerException e) {
            validConstruction = false;
        }
        TestSuite.assertFalse(validConstruction);

        // Test 3
        try {
            WordNet wn = new WordNet(null, "A");
            validConstruction = true;
        } catch (NullPointerException e) {
            validConstruction = false;
        }
        TestSuite.assertFalse(validConstruction);

        // Test 4
        try {
            WordNet wn = new WordNet("A", "B");
            validConstruction = true;
            wn = null;
        } catch (NullPointerException e) {
            validConstruction = false;
        }
        TestSuite.assertTrue(validConstruction);

        /* END TESTS */
        System.out.println();
    }

    private static void nounsTest() {
        TestSuite.testMessage("Testing nouns() method:");
    }

    private static void isNounTest() {
        TestSuite.testMessage("Testing isNoun() method:");
    }

    private static void distanceTest() {
        TestSuite.testMessage("Testing distance() method:");
    }

    private static void sapTest() {
        TestSuite.testMessage("Testing sap() method:");
    }

    private static void runTests() {
        WordNetConstructorTest();
        nounsTest();
        isNounTest();
        distanceTest();
        sapTest();
    }

    public static void main(String[] args) {
        TestSuite.startMessage("WordNet");
        runTests();
        TestSuite.endMessage("WordNet");
    }
}
