package com.alg.sort;

import com.alg.DataGenerator;
import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2018/3/18 0018.
 */
public class InsertionSort implements ISort{

    @Override
    public void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int tem = data[i];
            int j = i - 1;
            // 找到当前元素要插入的位置 -->j
            for (; j >= 0; j--) {
                // 移动元素
                if (data[j] > tem) {
                    data[j + 1] = data[j];
                } else
                    break;
            }
            data[j + 1] = tem;
        }
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] source = DataGenerator.getIntArray(10);
        System.out.println(JSON.toJSONString(source));
        sort.sort(source);
        System.out.println(JSON.toJSONString(source));
    }
}
