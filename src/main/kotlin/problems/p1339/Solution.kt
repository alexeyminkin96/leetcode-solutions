package problems.p1339

/**
 * **[Maximum Product of Splitted Binary Tree](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/)**
 */
interface Solution {
    fun maxProduct(root: TreeNode): Int

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
