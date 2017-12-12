class Tester {
    static private String a1 = Printer.print("1. static private a1");

    static String a2 = Printer.print("2. static public String a2");

    static {
        String c = Printer.print("3. static block String c");
    }

    private String d1 = Printer.print("4. public String a2");
    private String d2;

    Tester() {
        d2 = Printer.print("5. this.d");
    }

    void test() {
        System.out.println(a1);
        System.out.println(a2);
        System.out.println();
    }

    void setA1A2(String newValueA1, String newValueA2) {
        a1 = newValueA1;
        a2 = newValueA2;
    }


}
