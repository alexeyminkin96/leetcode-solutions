package problems.p0104

/**
 * **[Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)**
 */
interface Solution {
    fun maxDepth(root: TreeNode?): Int

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
