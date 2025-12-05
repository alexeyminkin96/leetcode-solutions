package problems.p0108

import problems.p0108.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.55 MB` (Beats `99.44%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(log(n))`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solutions/7394152/kotlin-on-0ms-ologn-recursive-by-alexeym-ck4d)
 */
class SolutionImpl1 : Solution {
    override fun sortedArrayToBST(nums: IntArray): TreeNode? {
        fun node(l: Int, r: Int): TreeNode? {
            if (r < l) return null
            val i = (l + r) / 2
            val node = TreeNode(nums[i])
            node.left = node(l, i - 1)
            node.right = node(i + 1, r)
            return node
        }
        return node(0, nums.size - 1)
    }
}