package main.utils;

public class NumberUtils {

    public static Double getHalfNumber(int number) {
        return Math.ceil(number / 2);
    }

    public static Double getHalfNumber(Double number) {
        return Math.ceil(number / 2);
    }
}
