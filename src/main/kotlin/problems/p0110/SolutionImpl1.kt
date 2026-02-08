package problems.p0110

import kotlin.math.abs
import problems.p0110.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.84 MB` (Beats `81.27%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/balanced-binary-tree/solutions/7562912/kotlin-on-0ms-on-by-alexeyminkin-7mmz)
 */
class SolutionImpl1 : Solution {
    override fun isBalanced(root: TreeNode?): Boolean {
        return dfs(root) != -1
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0
        val left = dfs(node.left)
        if (left == -1) return -1
        val right = dfs(node.right)
        if (right == -1) return -1
        if (abs(left - right) > 1) return -1
        return maxOf(left, right) + 1
    }
}