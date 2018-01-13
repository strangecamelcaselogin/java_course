import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Inspector {
    public void inspect(TestInterface t) throws IllegalAccessException {
        Class <?> testClass = t.getClass();

        System.out.println("name: " + testClass.getName());

        System.out.println("\nimplement interfaces: ");
        for (Class i: testClass.getInterfaces()) {
            System.out.println(i.getName());
        }

        System.out.println("\nsuper class: " + testClass.getSuperclass().toString());

        System.out.println("\nclassLoader: " + testClass.getClassLoader().toString());

        System.out.println("\ngetDeclaredFields:");
        for (Field f: testClass.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println("\t" + f + " = " + f.get(t).toString());
        }

        System.out.println("\ngetDeclaredMethods:");
        for (Method m: testClass.getDeclaredMethods()) {
            System.out.println("\t" + m);
        }

        // TODO все интерфейсы
        // TODO все парент классы до Object
        // TODO все параметры методов

    }
}
