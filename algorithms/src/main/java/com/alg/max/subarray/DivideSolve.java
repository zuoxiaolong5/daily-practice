package com.alg.max.subarray;

/**
 * Created by zuoxiaolong5 on 2018/3/26.
 * 分治法求解最大子数组问题
 * 将数组data[start,end] 分成两个子数组 data[start,mid], data[mid + 1, end]
 * 数组data[start,end] 的最大子数组data[i,j]有三种情况
 * 1、最大子数组完全在data[start,mid] 中 start <= i <= j <= mid
 * 2、最大子数组完全在data[mid + 1,end] 中 mid + 1 <= i <= j <= end
 * 3、最大子数组跨越中节点 start <= i <= mid <= j <= end
 * 比较三种情况 ，三种情况的结果中最大的结果就是最终结果
 *
 * 跨越中节点的子数组最容易查找，时间复杂度为线性时间复杂度
 * 定义 查找跨越中节点子数组的方法 findMaxCrossingSubArray
 * 使用分治法地柜求解
 */
public class DivideSolve {

    public void findMaxSubArray(int[] data) {
        ResultElement result = divideSolve(data, 0, data.length - 1);
        System.out.println("----------------------------------");
        System.out.println("DivideSolve最大子序列start:" + result.getLeft() + ", end:" + result.getRight() + ",sum:" + result.getSum());
        System.out.println("----------------------------------");
    }

    private ResultElement divideSolve(int[] data, int start, int end) {
        if (start == end) {
            return new ResultElement(data, start, end, data[start], 0);
        }
        int mid = (start + end) / 2;
        ResultElement leftResult = divideSolve(data, start, mid);
        ResultElement rightResult = divideSolve(data, mid + 1, end);
        ResultElement crossResult = findMaxCrossingSubArray(data, start, mid, end);
        return getMax(leftResult, rightResult, crossResult);
    }

    /**
     * 寻找跨越中点mid的最大子数组
     * 必须保证 start < end
     * @param data
     * @param start
     * @param mid
     * @param end
     * @return
     */
    private ResultElement findMaxCrossingSubArray(int[] data, int start, int mid, int end) {
        int leftMaxSum = data[mid];
        int left = mid;
        int sum = leftMaxSum;
        for (int i = mid - 1; i >= start; i--) {
            sum += data[i];
            if (sum >= leftMaxSum) {
                leftMaxSum = sum;
                left = i;
            }
        }

        int rightMaxSum = data[mid + 1];
        int right = mid + 1;
        sum = rightMaxSum;
        for (int i = mid + 2; i <= end; i++) {
            sum += data[i];
            if (sum >= rightMaxSum) {
                rightMaxSum = sum;
                right = i;
            }
        }

        return new ResultElement(data, left, right, leftMaxSum, rightMaxSum);
    }

    private ResultElement getMax(ResultElement o1, ResultElement o2, ResultElement o3) {
        ResultElement result = o1.getSum() > o2.getSum() ? o1 : o2;
        return result.getSum() > o3.getSum() ? result : o3;
    }
    public static void main (String[] args) {
        DivideSolve solve = new DivideSolve();

        for (int i = 9; i < 8; i++) {
            System.out.println("ffffffffffff");
        }
    }
}
