package ru.rsatu;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String canonicalClassName, boolean resolve) throws ClassNotFoundException {
        String currentPackageName = getClass().getPackage().getName();

        Class<?> c;

        if (canonicalClassName.contains(currentPackageName)) {
            byte[] bt = loadClassData(canonicalClassName);
            c = defineClass(canonicalClassName, bt, 0, bt.length);
            if (resolve) resolveClass(c);

        } else {
            ClassLoader parent = getParent();
            if (parent != null) {
                c = parent.loadClass(canonicalClassName);

            } else {
                throw new ClassNotFoundException("ClassLoader has no parent");
            }
        }

        return c;
    }

    private byte[] loadClassData(String canonicalClassName) {
        InputStream is = getResourceAsStream(canonicalClassName.replace(".", "/") + ".class");

        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();

        int len;
        try {
            while((len=is.read()) != -1) {
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteSt.toByteArray();
    }
}