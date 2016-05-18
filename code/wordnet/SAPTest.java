public class SAPTest {

    private static void SAPConstructorTest() {
        TestSuite.testMessage("Testing SAP Constructor:");
    }

    private static void lengthTest() {
        TestSuite.testMessage("Testing length() method:");
    }

    private static void ancestorTest() {
        TestSuite.testMessage("Testing ancestor() method:");
    }

    private static void lengthSetTest() {
        TestSuite.testMessage("Testing length() set method:");
    }

    private static void ancestorSetTest() {
        TestSuite.testMessage("Testing ancestor() set method:");
    }

    private static void runTests() {
        SAPConstructorTest();
        lengthTest();
        ancestorTest();
        lengthSetTest();
        ancestorSetTest();
    }

    public static void main(String[] args) {
        TestSuite.startMessage("SAP");
        runTests();
        TestSuite.endMessage("SAP");
    }
}
