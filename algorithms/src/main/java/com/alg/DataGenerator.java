package com.alg;

/**
 * Created by Administrator on 2018/3/18 0018.
 */
public class DataGenerator {
    public static int[] getIntArray(int length) {
        int [] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (int)(Math.random() * 1000);
        }
        return result;
    }

    public static int[] getIntArray(int length, int min, int max) {
        int [] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = min + (int)(Math.random() * ((max - min) + 1));
        }
        return result;
    }
}
