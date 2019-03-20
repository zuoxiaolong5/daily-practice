package com.alg.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 构建一个完全二叉树
 * 给二叉树的每个节点添加一个next指针指向同层的右侧节点
 * 算法思路：
 * 首先借助队列实现同层遍历
 * 1、构建一个空队列
 * 2、将二叉树的根节点放入队列中
 * 3、如果队列不为空循环从队列中取出节点 node
 * 4、如果node的左右子节点不为空将子节点放入队列中
 * （到此如果队列遍历完便实现了二叉树的按层遍历）
 * 5、添加next指针：将node左节点的next指向右节点
 * 如果node的next指针不为空且node的next节点左子节点不为空
 * 将node的右节点next指向node 的 next节点的左子节点
 *
 */
class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private TreeNode next;
    private int value;
    public void next(TreeNode node) {
        this.next = node;
    }
    public TreeNode(int v) {
        this.value = v;
    }
    public void left(TreeNode node) {
        this.left = node;
    }

    public void right(TreeNode node) {
        this.right = node;
    }
    public TreeNode getLeft() {
        return this.left;
    }
    public TreeNode getRight() {
        return this.right;
    }

    public TreeNode getNext() {
        return this.next;
    }
}
public class TreeNodeNext {
    public static void main(String[] args) throws Exception{

        TreeNode testTree = new TreeNode(1);

        testTree.left(new TreeNode(2));
        testTree.right(new TreeNode(3));
        testTree.getLeft().left(new TreeNode(4));
        testTree.getLeft().right(new TreeNode(5));
        testTree.getRight().left(new TreeNode(6));
        testTree.getRight().right(new TreeNode(7));
        testTree.getLeft().getLeft().left(new TreeNode(8));
        testTree.getLeft().getLeft().right(new TreeNode(9));
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(testTree);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = ((LinkedList<TreeNode>) queue).pop();
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
                node.getLeft().next(node.getRight());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
                if (node.getNext() != null) {
                    node.getRight().next(node.getNext().getLeft());
                }
            }
        }
        System.out.println();
    }
}
