package problems.p2265

/**
 * **[2265. Count Nodes Equal to Average of Subtree](https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/)**
 */
interface Solution {
    fun averageOfSubtree(root: TreeNode?): Int

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
