package problems.p0100

import problems.p0100.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100%` of Kotlin submissions)
 * - Memory: `40.54 MB` (Beats `88.95%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/same-tree/solutions/7392267/kotlin-on-0ms-o1-recursive-one-line-by-a-firj)
 */
class SolutionImpl2 : Solution {
    override fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return (p === q || p?.`val` == q?.`val` && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right))
    }
}