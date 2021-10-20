package com.company;

import java.util.Stack;

public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode resultRoot = null;

        if (root1 != null) {
            stack.push(root1);
            resultRoot = new TreeNode(root1.val);
        }

        if (root2 != null) {
            if (resultRoot != null) {
                resultRoot.val += root2.val;
            } else {
                resultRoot = new TreeNode(root2.val);
                stack.push(new TreeNode());
            }
            stack.push(root2);
        } else {
            if (resultRoot != null) {
                stack.push(new TreeNode());
            }
        }

        if (resultRoot != null) {
            stack.push(resultRoot);
        }

        while (!stack.empty()) {

            TreeNode current1 = null;
            TreeNode current2 = null;
            TreeNode currentResult;

            currentResult = stack.pop();
            current2 = stack.pop();
            current1 = stack.pop();

            if (current1.left != null) {
                stack.push(current1.left);
                currentResult.left = new TreeNode(current1.left.val);
            }

            if (current2.left != null) {
                if (currentResult.left != null) {
                    currentResult.left.val += current2.left.val;
                } else {
                    currentResult.left = new TreeNode(current2.left.val);
                    stack.push(new TreeNode());
                }
                stack.push(current2.left);
            } else {
                if (currentResult.left != null) {
                    stack.push(new TreeNode());
                }
            }

            if (currentResult.left != null) {
                stack.push(currentResult.left);
            }

            if (current1.right != null) {
                stack.push(current1.right);
                currentResult.right = new TreeNode(current1.right.val);
            }

            if (current2.right != null) {
                if (currentResult.right != null) {
                    currentResult.right.val += current2.right.val;
                } else {
                    currentResult.right = new TreeNode(current2.right.val);
                    stack.push(new TreeNode());
                }
                stack.push(current2.right);
            } else {
                if (currentResult.right != null) {
                    stack.push(new TreeNode());
                }
            }

            if (currentResult.right != null) {
                stack.push(currentResult.right);
            }
        }

        return resultRoot;
    }
}
