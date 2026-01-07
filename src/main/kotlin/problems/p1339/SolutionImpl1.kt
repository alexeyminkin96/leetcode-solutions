package problems.p1339

import problems.p1339.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `63.01 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(h)`
 */
class SolutionImpl1 : Solution {
    override fun maxProduct(root: TreeNode): Int {
        val sum = sum(root)
        var minGap = sum
        fun findMinGap(node: TreeNode?): Long {
            if (node == null) return 0
            val curSum = node.`val` + findMinGap(node.left) + findMinGap(node.right)
            val gap = Math.abs(2 * curSum - sum)
            if (gap < minGap) minGap = gap
            return curSum
        }
        findMinGap(root)
        return (((sum * sum - minGap * minGap) / 4) % 1_000_000_007).toInt()
    }

    private fun sum(node: TreeNode?): Long {
        if (node == null) return 0
        return node.`val` + sum(node.left) + sum(node.right)
    }
}