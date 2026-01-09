package problems.p0865

import problems.p0865.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.25 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(h)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/solutions/7480568/kotlin-on-0ms-oh-without-extra-class-by-ks5wk)
 */
class SolutionImpl1 : Solution {
    override fun subtreeWithAllDeepest(root: TreeNode): TreeNode {
        var head = root
        var maxDepth = 0
        fun dfs(node: TreeNode?, depth: Int): Int {
            if (node == null) return depth - 1
            val lDepth = dfs(node.left, depth + 1)
            val rDepth = dfs(node.right, depth + 1)
            val curDepth = Math.max(lDepth, rDepth)
            if (lDepth == rDepth && curDepth >= maxDepth) {
                maxDepth = curDepth
                head = node
            }
            return curDepth
        }
        dfs(root, 0)
        return head
    }
}