package problems.p0100

/**
 * **[Same Tree](https://leetcode.com/problems/same-tree/)**
 */
interface Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
