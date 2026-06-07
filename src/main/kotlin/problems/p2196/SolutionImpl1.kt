package problems.p2196

import problems.p2196.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `14 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `76.73 MB` (Beats `47.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/create-binary-tree-from-descriptions/solutions/8366281/kotlin-on-14ms-oc-by-alexeyminkin-ui0g)
 */
class SolutionImpl1 : Solution {
    override fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val nodes = arrayOfNulls<TreeNode>(100_001)
        val hasParent = BooleanArray(100_001)
        for (d in descriptions) {
            val parent = d[0]
            val child = d[1]
            if (nodes[parent] == null) nodes[parent] = TreeNode(parent)
            if (nodes[child] == null) nodes[child] = TreeNode(child)
            if (d[2] == 1)
                nodes[parent]!!.left = nodes[child]
            else
                nodes[parent]!!.right = nodes[child]
            hasParent[child] = true
        }
        var i = 0
        while (hasParent[descriptions[i][0]]) i++
        return nodes[descriptions[i][0]]
    }
}