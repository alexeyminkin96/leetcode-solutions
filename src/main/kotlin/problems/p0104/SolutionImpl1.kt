package problems.p0104

import java.util.LinkedList
import problems.p0104.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `14.84%` of Kotlin submissions)
 * - Memory: `43.12 MB` (Beats `49.18%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-depth-of-binary-tree/solutions/7394039/kotlin-on-4ms-on-not-recursive-by-alexey-l0p1)
 */
class SolutionImpl1 : Solution {
    override fun maxDepth(root: TreeNode?): Int {
        var result = 0
        val stack = LinkedList<TreeNode>()
        val depths = LinkedList<Int>()

        if (root != null) {
            stack.add(root)
            depths.add(1)
        }

        while (!stack.isEmpty()) {
            val node = stack.removeLast()
            val depth = depths.removeLast()
            result = Math.max(result, depth)
            if (node.left != null) {
                stack.add(node.left!!)
                depths.add(depth + 1)
            }

            if (node.right != null) {
                stack.add(node.right!!)
                depths.add(depth + 1)
            }
        }

        return result
    }
}