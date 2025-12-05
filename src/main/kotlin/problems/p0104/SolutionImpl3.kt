package problems.p0104

import problems.p0104.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.14 MB` (Beats `49.18%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl3 : Solution {
    override fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}