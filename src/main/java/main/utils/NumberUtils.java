package main.utils;

public class NumberUtils {

    public static int getHalfNumber(int number) {
        Double halfNumber = Math.ceil(number / 2);
        return halfNumber.intValue();
    }

}
