package problems.p0104

import problems.p0104.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.62 MB` (Beats `83.52%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl2 : Solution {
    override fun maxDepth(root: TreeNode?): Int {
        return maxDepth(root, 0)
    }

    private fun maxDepth(node: TreeNode?, depth: Int): Int {
        if (node == null) return depth
        return Math.max(maxDepth(node.left, depth + 1), maxDepth(node.right, depth + 1))
    }
}