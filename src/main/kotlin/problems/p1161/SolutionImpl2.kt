package problems.p1161

import java.util.LinkedList
import problems.p1161.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `13 ms` (Beats `79.17%` of Kotlin submissions)
 * - Memory: `51.06 MB` (Beats `89.58%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl2 : Solution {
    override fun maxLevelSum(root: TreeNode): Int {
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        var maxSum = root.`val`
        var maxSumLevel = 1
        var level = 1
        var levelSum = 0
        var levelSize = 1
        while (!queue.isEmpty()) {
            val node = queue.pop()
            levelSize--
            levelSum += node.`val`
            if (node.left != null) queue.add(node.left!!)
            if (node.right != null) queue.add(node.right!!)
            if (levelSize != 0) continue
            if (levelSum > maxSum) {
                maxSum = levelSum
                maxSumLevel = level
            }
            level++
            levelSum = 0
            levelSize = queue.size
        }
        return maxSumLevel
    }
}