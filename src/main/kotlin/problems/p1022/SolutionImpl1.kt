package problems.p1022

import problems.p1022.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.44 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(h)`
 */
class SolutionImpl1 : Solution {
    override fun sumRootToLeaf(root: TreeNode): Int {
        return sum(root, 0)
    }

    private fun sum(node: TreeNode?, parentSum: Int): Int {
        if (node == null) return 0
        val curSum = (parentSum shl 1) or node.`val`
        if (node.left == null && node.right == null) return curSum
        return sum(node.left, curSum) + sum(node.right, curSum)
    }
}