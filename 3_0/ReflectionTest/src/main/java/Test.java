public class Test {
    static String b = "hello";

    static {
        Integer e = 1;
    }

    Integer a = 42;
    public Integer d = 40;
    private Integer f;

    public Test() {
        this.f = 111;
    }

    static void foo() {}
    public int bar() {
        return 41;
    }

    private static int baz() {
        return 41;
    }
}
