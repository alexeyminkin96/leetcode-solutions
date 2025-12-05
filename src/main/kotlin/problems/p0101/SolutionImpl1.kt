package problems.p0101

import java.util.LinkedList
import problems.p0101.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `22.67%` of Kotlin submissions)
 * - Memory: `41.67 MB` (Beats `72.97%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/symmetric-tree/solutions/7393377/kotlin-on-1ms-on-not-recursive-by-alexey-thuh)
 */
class SolutionImpl1 : Solution {
    override fun isSymmetric(root: TreeNode?): Boolean {
        val stack = LinkedList<TreeNode?>()
        stack.add(root?.right)
        stack.add(root?.left)

        while (!stack.isEmpty()) {
            val lNode = stack.removeLast()
            val rNode = stack.removeLast()
            if (lNode != null && rNode != null) {
                if (lNode.`val` != rNode.`val`) return false
                stack.add(rNode.right)
                stack.add(lNode.left)
                stack.add(lNode.right)
                stack.add(rNode.left)
            } else if ((lNode == null) xor (rNode == null))
                return false
        }
        return true
    }
}