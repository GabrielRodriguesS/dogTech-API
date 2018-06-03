package main.utils;

public class ParseUtils {

    public static Object convertObjetoToClassObject(Class clazz, Object object) {
        return clazz.cast(object);
    }
}
