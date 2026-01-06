package problems.p1161

import java.util.LinkedList
import problems.p1161.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `13 ms` (Beats `79.17%` of Kotlin submissions)
 * - Memory: `51.92 MB` (Beats `54.17%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun maxLevelSum(root: TreeNode): Int {
        var maxSum = root.`val`
        var maxSumLevel = 1
        var level = 1
        var from = LinkedList<TreeNode>()
        from.add(root)
        var to = LinkedList<TreeNode>()
        while (!from.isEmpty()) {
            var levelSum = 0
            while (!from.isEmpty()) {
                val node = from.pop()
                levelSum += node.`val`
                if (node.left != null) to.add(node.left!!)
                if (node.right != null) to.add(node.right!!)
            }
            if (levelSum > maxSum) {
                maxSum = levelSum
                maxSumLevel = level
            }
            level++
            val buf = from
            from = to
            to = buf
        }
        return maxSumLevel
    }
}