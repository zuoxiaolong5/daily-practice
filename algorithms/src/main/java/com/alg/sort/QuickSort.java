package com.alg.sort;

import com.alg.DataGenerator;
import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2018/3/18 0018.
 */
public class QuickSort implements ISort{

    @Override
    public void sort(int[] data) {
        this.quickSort(data, 0, data.length - 1);
    }

    /**
     * 将数组 start - end 之间 的数据以 data[start] 为基准 baseNum
     * 大于 baseNum 的数据在其右侧 小于 baseNum的数据在其左侧
     * 返回 baseNum最后的位置
     * 算法 思路：
     * 定义两个游标 i、j 初始值 i = start  j = end
     * 1、从 j 开始依次向前查找，找到第一个小于baseNum的数据时记录其位置 j
     * 2、将data[j] 移动到位置 i
     * 2、从 i 开始依次向后查找 找到第一个大于baseNum的数据时记录其位置 i
     * 3、将data[i] 移动到位置j
     * 4、如果 j == i 时 查找结束 j 就是最后baseNum所在的位置
     * 5、将data[start] 数据 放到 data[j]
     * 6、返回 j 查找结束
     * @param data
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] data, int start, int end) {
        int i = start, j = end;
        int baseNum = data[start];
        while (i < j) {
            while (j > i && data[j] >= baseNum) {
                j--;
            }
            data[i] = data[j];
            while (i < j && data[i] <= baseNum) {
                i++;
            }
            data[j] = data[i];
        }
        data[i] = baseNum;
        return i;
    }

    private void quickSort(int[] data, int start, int end) {
        if (end - start < 1) {
            return;
        }
        if (end - start == 1) {
            if (data[start] < data[end]) {
                return;
            } else {
                int tem = data[start];
                data[start] = data[end];
                data[end] = tem;
            }
        }
        int p = this.partition(data, start, end);
        // 位置 p 的数据一定是最终位置
        // 所以只需要对 p 之前 和 p 之后的数组重新排序即可
        quickSort(data, start, p - 1);
        quickSort(data, p + 1, end);
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] source = DataGenerator.getIntArray(11);
        System.out.println(JSON.toJSONString(source));
        sort.sort(source);
        System.out.println(JSON.toJSONString(source));
    }
}
