package problems.p0101

import problems.p0101.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.15 MB` (Beats `98.26%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/symmetric-tree/solutions/7393395/kotlin-on-0ms-on-recursive-by-alexeymink-aybn)
 */
class SolutionImpl2 : Solution {
    override fun isSymmetric(root: TreeNode?): Boolean {
        return isSymmetric(root?.left, root?.right)
    }

    private fun isSymmetric(l: TreeNode?, r: TreeNode?): Boolean {
        return (l == null && r == null) ||
            l?.`val` == r?.`val` && isSymmetric(l?.left, r?.right) && isSymmetric(l?.right, r?.left)
    }
}