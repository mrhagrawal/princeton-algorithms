public class TestSuite {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String WARNING = "\u001B[2m\u001B[3m";

    private static int testNumber = 1;

    public static void startMessage(String className) {
        System.out.println(color("<<<<< Starting " + className + " Test Suite >>>>>"
                    , WHITE) + "\n");
    }

    public static void endMessage(String className) {
        System.out.println(color("<<<<< Finished " + className + " Test Suite >>>>>"
                    , WHITE) + "\n");
    }

    public static void testMessage(String message) {
        System.out.println(color(message, YELLOW));
    }

    public static void dependencyMessage(String message) {
        System.out.println(color("Dependencies: " + message, WARNING));
    }

    public static void assertEqual(byte expected, byte actual) {
        System.out.println(Byte.compare(expected, actual) == 0 ? (GREEN + "Test "
                    + testNumber + ": " + "\tPASS" + RESET) : (RED + "Test " +
                        testNumber + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertEqual(short expected, short actual) {
        System.out.println(Short.compare(expected, actual) == 0 ? (GREEN + "Test "
                    + testNumber + ": " + "\tPASS" + RESET) : (RED + "Test " +
                        testNumber + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertEqual(int expected, int actual) {
        System.out.println(Integer.compare(expected, actual) == 0 ? (GREEN + "Test "
                    + testNumber + ": " + "\tPASS" + RESET) : (RED + "Test " +
                        testNumber + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertEqual(long expected, long actual) {
        System.out.println(Long.compare(expected, actual) == 0 ? (GREEN + "Test "
                    + testNumber + ": " + "\tPASS" + RESET) : (RED + "Test " +
                        testNumber + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertEqual(double expected, double actual) {
        System.out.println(Double.compare(expected, actual) == 0 ? (GREEN + "Test "
                    + testNumber + ": " + "\tPASS" + RESET) : (RED + "Test " +
                        testNumber + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertEqual(char expected, char actual) {
        System.out.println(Character.compare(expected, actual) == 0 ? (GREEN +
                    "Test " + testNumber + ": " + "\tPASS" + RESET) : (RED + "Test "
                        + testNumber + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertEqual(String expected, String actual) {
        System.out.println(expected.equals(actual) ? (GREEN + "Test " + testNumber +
                    ": " + "\tPASS" + RESET) : (RED + "Test " + testNumber + ": " +
                        " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertNotEqual(byte expected, byte actual) {
        System.out.println(Byte.compare(expected, actual) != 0 ? (GREEN + "Test " +
                    testNumber + ": " + "\tPASS" + RESET) : (RED + "Test " +
                        testNumber + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertNotEqual(short expected, short actual) {
        System.out.println(Short.compare(expected, actual) != 0 ? (GREEN + "Test "
                    + testNumber + ": " + "\tPASS" + RESET) : (RED + "Test " +
                        testNumber + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertNotEqual(int expected, int actual) {
        System.out.println(Integer.compare(expected, actual) != 0 ? (GREEN + "Test "
                    + testNumber + ": " + "\tPASS" + RESET) : (RED + "Test " +
                        testNumber + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertNotEqual(long expected, long actual) {
        System.out.println(Long.compare(expected, actual) != 0 ? (GREEN + "Test "
                    + testNumber + ": " + "\tPASS" + RESET) : (RED + "Test " +
                        testNumber + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertNotEqual(double expected, double actual) {
        System.out.println(Double.compare(expected, actual) != 0 ? (GREEN + "Test "
                    + testNumber + ": " + "\tPASS" + RESET) : (RED + "Test " +
                        testNumber + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertNotEqual(char expected, char actual) {
        System.out.println(Character.compare(expected, actual) != 0 ? (GREEN +
                    "Test " + testNumber + ": " + "\tPASS" + RESET) : (RED +
                        "Test " + testNumber + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertNotEqual(String expected, String actual) {
        System.out.println(!expected.equals(actual) ? (GREEN + "Test " + testNumber +
                    ": " + "\tPASS" + RESET) : (RED + "Test " + testNumber
                        + ": " + " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertTrue(boolean result) {
        System.out.println(result ? (GREEN + "Test " + testNumber + ": " +
                    "\tPASS" + RESET) : (RED + "Test " + testNumber + ": " +
                        " \tFAIL" + RESET));
        testNumber++;
    }

    public static void assertFalse(boolean result) {
        System.out.println(!result ? (GREEN + "Test " + testNumber + ": " +
                    "\tPASS" + RESET) : (RED + "Test " + testNumber + ": " +
                        " \tFAIL" + RESET));
        testNumber++;
    }

    public static String color(String s, String color) {
        return color + s + RESET;
    }
}
