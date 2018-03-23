package com.alg.sort;

import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2018/3/18 0018.
 */
public class MergeSort implements ISort{

    @Override
    public void sort(int[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    /**
     * 将数据分为两部分分别进行归并排序
     * 得到两个有序集合后对两个有序集合进行合并
     * @param data
     * @param start
     * @param end
     */
    private void mergeSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(data, start, mid);
        mergeSort(data, mid + 1, end);
        merge(data, start, mid, end);
    }

    /**
     * 数组的两部分 start -- mid 和 mid + 1 -- end 都是有序的
     * 对这两部分数据进行合并 合并完返回整体有序的新数组
     * @param data
     * @param start
     * @param mid
     * @param end
     */
    private int[] merge(int[] data, int start, int mid, int end) {
        int[] result = new int[end - start + 1];
        int start1 = start, end1 = mid, start2 = mid + 1, end2 = end;
        int i = 0;
        while (true) {
            if (start1 > end1 || start2 > end) {
                break;
            }
            if (data[start1] < data[start2]) {
                result[i++] = data[start1++];
            }
            if (data[start2] <= data[start1]) {
                result[i++] = data[start2++];
            }
        }

        while (start1 <= end1) {
            result[i++] = data[start1++];
        }
        while (start2 <= end2) {
            result[i++] = data[start2++];
        }
        for (int j = 0; j < result.length; j++) {
            data[start++] = result[j];
        }
        return data;
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] source = DataGenerator.getIntArray(10);
        System.out.println(JSON.toJSONString(source));
        sort.sort(source);
        System.out.println(JSON.toJSONString(source));
    }
}
