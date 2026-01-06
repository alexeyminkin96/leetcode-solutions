package problems.p1161

import problems.p1161.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `97.92%` of Kotlin submissions)
 * - Memory: `51.24 MB` (Beats `83.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl3 : Solution {
    override fun maxLevelSum(root: TreeNode): Int {
        val queue = arrayOfNulls<TreeNode>(10_000)
        queue[0] = root
        var last = 0
        var cur = 0
        var levelLast = 0
        var maxSum = root.`val`
        var maxSumLevel = 1
        var level = 1
        var levelSum = 0
        while (cur <= last) {
            val node = queue[cur]!!
            levelSum += node.`val`
            if (node.left != null) queue[++last] = node.left
            if (node.right != null) queue[++last] = node.right
            if (cur++ < levelLast) continue
            if (levelSum > maxSum) {
                maxSum = levelSum
                maxSumLevel = level
            }
            level++
            levelSum = 0
            levelLast = last
        }
        return maxSumLevel
    }
}