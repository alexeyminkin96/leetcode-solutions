package problems.p1161

/**
 * **[Maximum Level Sum of a Binary Tree](https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/)**
 */
interface Solution {
    fun maxLevelSum(root: TreeNode): Int

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
