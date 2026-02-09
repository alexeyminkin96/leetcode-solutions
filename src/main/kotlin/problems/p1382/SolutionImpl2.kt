package problems.p1382

import java.util.LinkedList
import problems.p1382.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `20 ms` (Beats `23.08%` of Kotlin submissions)
 * - Memory: `51.57 MB` (Beats `30.77%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl2 : Solution {
    private val lBase = 10_000_000_000L
    private val rBase = 100_000L
    override fun balanceBST(root: TreeNode?): TreeNode? {
        val sort = ArrayList<TreeNode>()
        val stack = LinkedList<TreeNode>()
        if (root != null) stack.addLast(root)
        while (!stack.isEmpty()) {
            val node = stack.peekLast()
            if (node.left != null) {
                stack.addLast(node.left!!)
                node.left = null
            } else {
                stack.removeLast()
                sort.add(node)
                if (node.right != null) stack.add(node.right!!)
                node.right = null
            }
        }

        sort.add(0, TreeNode(0))
        val bs = LinkedList<Long>()
        bs.add(1 * lBase + (sort.size - 1) * rBase)
        while (!bs.isEmpty()) {
            val n = bs.pollLast()
            val l = n / lBase
            val r = (n - l * lBase) / rBase
            if (l > r) continue
            val mid = (l + r).toInt() / 2
            val cur = sort[mid]
            val parentId = (n - l * lBase - r * rBase).toInt()
            val parent = sort[parentId]
            if (l < parentId) parent.left = cur
            else parent.right = cur
            bs.add(l * lBase + (mid - 1) * rBase + mid)
            bs.add((mid + 1) * lBase + r * rBase + mid)
        }

        return sort[0].right
    }
}