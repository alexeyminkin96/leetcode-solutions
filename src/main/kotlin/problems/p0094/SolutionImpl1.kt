package problems.p0094

import java.util.LinkedList
import problems.p0094.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100%` of Kotlin submissions)
 * - Memory: `41.12 MB` (Beats `61.27%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/binary-tree-inorder-traversal/solutions/7392228/kotlin-on-0ms-on-by-alexeyminkin-f8p0)
 */
class SolutionImpl1 : Solution {
    override fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = ArrayList<Int>()
        val stack = LinkedList<TreeNode>()
        if (root != null)
            stack.add(root)

        while (!stack.isEmpty()) {
            val node = stack.removeLast()
            if (node.right != null) {
                stack.add(node.right!!)
                node.right = null
            }
            if (node.left != null) {
                stack.add(node)
                stack.add(node.left!!)
                node.left = null
            } else
                result.add(node.`val`)
        }
        return result
    }
}