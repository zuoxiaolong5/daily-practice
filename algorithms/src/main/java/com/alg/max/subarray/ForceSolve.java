package com.alg.max.subarray;

import com.alg.DataGenerator;
import com.alibaba.fastjson.JSON;

/**
 * Created by zuoxiaolong5 on 2018/3/23.
 * 暴力求解
 * 依次遍历 寻找所有组合情况
 */
public class ForceSolve {

    public void findMaxSubArray(int[] data) {
        int resultSum = data[0];
        int resultStart = 0, resultEnd = 0;
        // 每次循环从第 i 个开始找
        for (int i = 0; i < data.length; i++) {
            int sum = data[i];
            // 找所有子序列 (j --> 子序列长度) 和
            for (int j = 1; j < data.length - i; j++) {
                sum += data[j + i];
                if (sum >= resultSum) {
                    resultSum = sum;
                    resultStart = i;
                    resultEnd = j;
                }
            }
        }
        System.out.println("----------------------------------");
        System.out.println("最大子序列start:" + resultStart + ", end:" + resultEnd + ",sum:" + resultSum);
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        int[] data = DataGenerator.getIntArray(10, -5, 10);
        System.out.println(JSON.toJSONString(data));
        ForceSolve solve = new ForceSolve();
        solve.findMaxSubArray(data);
    }
}
