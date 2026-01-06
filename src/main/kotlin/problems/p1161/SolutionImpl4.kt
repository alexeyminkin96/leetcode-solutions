package problems.p1161

import problems.p1161.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `97.92%` of Kotlin submissions)
 * - Memory: `51.80 MB` (Beats `58.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/solutions/7471458/kotlin-on-4ms-on-by-alexeyminkin-vfwy)
 */
class SolutionImpl4 : Solution {
    override fun maxLevelSum(root: TreeNode): Int {
        val sums = IntArray(10_000)
        var maxLevel = 0
        fun dfs(node: TreeNode, level: Int) {
            if (level > maxLevel) maxLevel = level
            sums[level] += node.`val`
            if (node.left != null) dfs(node.left!!, level + 1)
            if (node.right != null) dfs(node.right!!, level + 1)
        }
        dfs(root, 0)
        var max = 0
        for (i in 1..maxLevel) {
            if (sums[i] > sums[max]) max = i
        }
        return max + 1
    }
}