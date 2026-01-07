package problems.p1339

import problems.p1339.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `61.38 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(h)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/solutions/7474725/kotlin-on-7ms-oh-by-alexeyminkin-aq9s)
 */
class SolutionImpl2 : Solution {
    override fun maxProduct(root: TreeNode): Int {
        val sum = sum(root)
        val minGap = minGap(root, sum)
        return (((sum.toLong() * sum - minGap.toLong() * minGap) / 4) % 1_000_000_007).toInt()
    }

    private fun sum(node: TreeNode?): Int {
        if (node == null) return 0
        node.`val` += sum(node.left) + sum(node.right)
        return node.`val`
    }

    private fun minGap(node: TreeNode?, sum: Int): Int {
        if (node == null) return sum
        return minOf(Math.abs(2 * node.`val` - sum), minGap(node.left, sum), minGap(node.right, sum))
    }
}