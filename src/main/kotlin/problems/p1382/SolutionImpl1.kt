package problems.p1382

import problems.p1382.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.69 MB` (Beats `84.62%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/balance-a-binary-search-tree/solutions/7565506/kotlin-on-2ms-on-by-alexeyminkin-s9jo)
 */
class SolutionImpl1 : Solution {
    override fun balanceBST(root: TreeNode?): TreeNode? {
        val sort = ArrayList<TreeNode>()
        dfs(root, sort)
        return bs(0, sort.size - 1, sort)
    }

    private fun dfs(node: TreeNode?, sort: MutableList<TreeNode>) {
        if (node == null) return
        dfs(node.left, sort)
        sort.add(node)
        dfs(node.right, sort)
    }

    private fun bs(l: Int, r: Int, sort: List<TreeNode>): TreeNode? {
        if (l > r) return null
        val mid = (l + r) / 2
        val cur = sort[mid]
        cur.left = bs(l, mid - 1, sort)
        cur.right = bs(mid + 1, r, sort)
        return cur
    }
}