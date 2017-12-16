package ru.rsatu;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String canonicalClassName, boolean resolve) throws ClassNotFoundException {
        String currentPackageName = getClass().getPackage().getName();

        Class<?> c;

        // если имя класса содержит текущий пакет и не содержит Interface, загрузим этот класс
        if (canonicalClassName.contains(currentPackageName) && !canonicalClassName.contains("Interface")) {
            try {
                byte[] bt = loadClassData(canonicalClassName);
                c = defineClass(canonicalClassName, bt, 0, bt.length);  // превратим байты в реальный объект класса
                if (resolve) resolveClass(c);

            } catch (IOException e) {
                throw new ClassNotFoundException("Failed to load file", e);
            }
        // иначе передадим своему родителю
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

    private byte[] loadClassData(String canonicalClassName) throws IOException {
        // откроем файл и вернем его как byte array
        try (InputStream is = getResourceAsStream(canonicalClassName.replace(".", "/") + ".class")) {
            ByteArrayOutputStream byteSt = new ByteArrayOutputStream();

            int len;
            while((len=is.read()) != -1) {
                byteSt.write(len);
            }

            return byteSt.toByteArray();
        }
    }
}