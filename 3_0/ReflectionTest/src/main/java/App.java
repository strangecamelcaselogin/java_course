import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App {
    public static void main(String args[]) throws IllegalAccessException {
        Test t = new Test();
        Class <?> testClass = t.getClass();

        System.out.println("getName: " + testClass.getName());

        System.out.println("getDeclaredFields:");
        for (Field f: testClass.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println("\t" + f + " = " + f.get(t).toString());
        }

        System.out.println("getDeclaredMethods:");
        for (Method m: testClass.getDeclaredMethods()) {
            System.out.println("\t" + m);
        }
    }
}
