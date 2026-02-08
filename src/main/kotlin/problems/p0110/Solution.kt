package problems.p0110

/**
 * **[Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)**
 */
interface Solution {
    fun isBalanced(root: TreeNode?): Boolean

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
