package problems.p1382

/**
 * **[Balance a Binary Search Tree](https://leetcode.com/problems/balance-a-binary-search-tree/)**
 */
interface Solution {
    fun balanceBST(root: TreeNode?): TreeNode?

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
