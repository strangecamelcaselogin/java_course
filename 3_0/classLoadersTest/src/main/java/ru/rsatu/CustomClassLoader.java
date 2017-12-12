package ru.rsatu;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {

    @Override
    public Class<?> findClass(String canonicalClassName) throws ClassNotFoundException {
        String currentPackageName = getClass().getPackage().getName();

        byte[] bt = loadClassData(canonicalClassName);

        if (canonicalClassName.contains(currentPackageName)) {
            return defineClass(canonicalClassName, bt, 0, bt.length);
        }
        else {
            return super.defineClass(canonicalClassName, bt, 0, bt.length);
        }
    }

    private byte[] loadClassData(String className) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/") + ".class");

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