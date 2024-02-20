package org.example.Anwer4b;


// Question Summary:
// I ma provided with a balanced binary search tree containing unique integer values and a target value
// �
// k. My task is to return
// �
// x number of values that are closest to the given target
// �
// k. The
// �
// x closest values should be returned in ascending order.

// Answer Summary:
// The provided solution implements an iterative approach using a stack to traverse the binary search tree in an inorder manner. It maintains a list of the
// �
// x closest values encountered so far while traversing the tree. If the list size is less than
// �
// x, it adds the current node's value directly to the list. Otherwise, it compares the difference between the current node's value and the target value with the maximum difference among the existing closest values. If the current node's value has a smaller difference, it replaces the value with the maximum difference in the list. This process continues until the entire tree is traversed or the list contains
// �
// x closest values. Finally, the list of closest values is returned as the result.

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int value;
    TreeNode leftChild, rightChild;

    public TreeNode(int value) {
        this.value = value;
        this.leftChild = this.rightChild = null;
    }
}

public class ClosestValuesInBST {

    public static List<Integer> findClosestValues(TreeNode rootNode, double targetValue, int numberOfClosestValues) {
        List<Integer> closestValuesList = new ArrayList<>();
        if (rootNode == null || numberOfClosestValues == 0)
            return closestValuesList;

        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode currentNode = rootNode;

        while (currentNode != null || !nodeStack.isEmpty()) {
            while (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.leftChild;
            }

            currentNode = nodeStack.pop();
            if (closestValuesList.size() < numberOfClosestValues) {
                closestValuesList.add(currentNode.value);
            } else {
                double currentDifference = Math.abs(currentNode.value - targetValue);
                double maxDifference = Math.abs(closestValuesList.get(0) - targetValue);

                if (currentDifference < maxDifference) {
                    closestValuesList.remove(0);
                    closestValuesList.add(currentNode.value);
                } else {
                    break; // No need to explore further if the difference exceeds the smallest difference
                    // in the result list
                }
            }

            currentNode = currentNode.rightChild;
        }

        return closestValuesList;
    }

    public static void main(String[] args) {
        /*
         * Given Tree:
         * 4
         * / \
         * 2 5
         * / \
         * 1 3
         */
        TreeNode rootNode = new TreeNode(4);
        rootNode.leftChild = new TreeNode(2);
        rootNode.rightChild = new TreeNode(5);
        rootNode.leftChild.leftChild = new TreeNode(1);
        rootNode.leftChild.rightChild = new TreeNode(3);

        double targetValue = 3.8;
        int numberOfClosestValues = 2;

        List<Integer> closestValues = findClosestValues(rootNode, targetValue, numberOfClosestValues);
        System.out.println("Closest values to " + targetValue + " are: " + closestValues); // Output: [4, 5]
    }
}

