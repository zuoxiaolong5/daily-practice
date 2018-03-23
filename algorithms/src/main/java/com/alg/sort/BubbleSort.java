package com.alg.sort;

import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2018/3/18 0018.
 */
public class BubbleSort implements ISort{

    @Override
    public void sort(int[] data) {
        // 每次比较相邻两个,较大的一个放到右边 一次循环结束能找到最大的

    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] source = DataGenerator.getIntArray(10);
        System.out.println(JSON.toJSONString(source));
        sort.sort(source);
        System.out.println(JSON.toJSONString(source));
    }
}
