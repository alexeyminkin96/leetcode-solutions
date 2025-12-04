package problems.p0100

import java.util.LinkedList
import problems.p0100.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100%` of Kotlin submissions)
 * - Memory: `40.65 MB` (Beats `79.88%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/same-tree/solutions/7392250/kotlin-on-0ms-on-not-recursive-by-alexey-p66t)
 */
class SolutionImpl1 : Solution {
    override fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        val pStack = LinkedList<TreeNode?>()
        pStack.add(p)
        val qStack = LinkedList<TreeNode?>()
        qStack.add(q)

        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            val pNode = pStack.removeLast()
            val qNode = qStack.removeLast()
            if (pNode != null && qNode != null) {
                if (pNode.`val` != qNode.`val`) return false
                pStack.add(pNode.left)
                pStack.add(pNode.right)
                qStack.add(qNode.left)
                qStack.add(qNode.right)
            } else if ((pNode == null) xor (qNode == null))
                return false
        }

        return pStack.size == qStack.size
    }
}