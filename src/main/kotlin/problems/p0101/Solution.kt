package problems.p0101

/**
 * **[Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)**
 */
interface Solution {
    fun isSymmetric(root: TreeNode?): Boolean

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
