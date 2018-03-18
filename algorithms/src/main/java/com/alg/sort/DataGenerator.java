package com.alg.sort;

import java.util.Random;

/**
 * Created by Administrator on 2018/3/18 0018.
 */
public class DataGenerator {
    public static int[] getIntArray(int length) {
        int [] result = new int[length];
        Random random = new Random(1000);
        for (int i = 0 ; i < length; i++) {
            result[i] = random.nextInt();
        }
        return result;
    }
}
