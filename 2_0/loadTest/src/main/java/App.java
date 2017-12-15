public class App {
    public static void main(String[] args) {
        Tester[] testers = new Tester[10];

        for (int i = 0; i < testers.length; i++) {
            testers[i] = new Tester();
        }

        for (Tester t: testers) {
            t.test();
        }

        testers[0].setA1A2("newA1", "newA2");

        for (Tester t: testers) {
            t.test();
        }

    }
}