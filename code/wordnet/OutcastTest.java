public class OutcastTest {

    private static void OutcastConstructorTest() {
        TestSuite.testMessage("Testing Outcast Constructor:");
    }

    private static void outcastTest() {
        TestSuite.testMessage("Testing outcast() method:");
    }

    private static void runTests() {
        OutcastConstructorTest();
        outcastTest();
    }

    public static void main(String[] args) {
        TestSuite.startMessage("Outcast");
        runTests();
        TestSuite.endMessage("Outcast");
    }
}
