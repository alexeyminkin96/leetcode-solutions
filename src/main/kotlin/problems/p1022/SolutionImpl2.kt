package problems.p1022

import problems.p1022.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.14 MB` (Beats `75.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/solutions/7604706/kotlin-on-0ms-i-on-no-recursion-by-alexe-gdz9)
 */
class SolutionImpl2 : Solution {
    override fun sumRootToLeaf(root: TreeNode): Int {
        val stack = arrayOfNulls<TreeNode>(1000)
        var count = 0
        stack[count++] = root
        var sum = 0
        while (count != 0) {
            val node = stack[--count]!!
            val left = node.left
            val right = node.right
            if (left == null && right == null) {
                sum += node.`val`
                continue
            }
            if (left != null) {
                left.`val` = (node.`val` shl 1) or left.`val`
                stack[count++] = left
            }
            if (right != null) {
                right.`val` = (node.`val` shl 1) or right.`val`
                stack[count++] = right
            }
        }
        return sum
    }
}