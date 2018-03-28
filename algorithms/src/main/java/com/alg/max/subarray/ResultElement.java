package com.alg.max.subarray;

/**
 * Created by zuoxiaolong5 on 2018/3/28.
 */
public class ResultElement {
    private int[] data;
    private  int left;
    private int right;
    private int leftMaxSum;
    private int rightMaxSum;
    private int sum;

    public ResultElement(int[] data, int left, int right, int leftMaxSum, int rightMaxSum) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.leftMaxSum = leftMaxSum;
        this.rightMaxSum = rightMaxSum;
        this.sum = leftMaxSum + rightMaxSum;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getLeftMaxSum() {
        return leftMaxSum;
    }

    public void setLeftMaxSum(int leftMaxSum) {
        this.leftMaxSum = leftMaxSum;
    }

    public int getRightMaxSum() {
        return rightMaxSum;
    }

    public void setRightMaxSum(int rightMaxSum) {
        this.rightMaxSum = rightMaxSum;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
