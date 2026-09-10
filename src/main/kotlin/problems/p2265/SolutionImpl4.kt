package problems.p2265

import problems.p2265.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `109 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.40 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/solutions/8513347/kotlin-on-109ms-on-primitives-only-by-al-8yj1)
 */
class SolutionImpl4 : Solution {
    override fun averageOfSubtree(root: TreeNode?): Int {
        var res = 0
        var count = 0
        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0
            val prevCount = count++
            val sum = dfs(node.left) + dfs(node.right) + node.`val`
            if (sum / (count - prevCount) == node.`val`) res++
            return sum
        }
        dfs(root)
        return res
    }
}