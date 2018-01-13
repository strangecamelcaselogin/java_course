public class App {
    public static void main(String args[]) throws IllegalAccessException {
        Test t = new Test();
        Inspector inspector = new Inspector();
        inspector.inspect(t);
    }
}
