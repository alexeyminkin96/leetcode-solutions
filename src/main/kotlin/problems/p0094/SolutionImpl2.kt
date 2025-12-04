package problems.p0094

import problems.p0094.Solution.TreeNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100%` of Kotlin submissions)
 * - Memory: `40.92 MB` (Beats `76.71%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl2 : Solution {
    override fun inorderTraversal(root: TreeNode?): List<Int> {
        return inorderTraversal(root, ArrayList())
    }

    private fun inorderTraversal(node: TreeNode?, result: MutableList<Int>): List<Int> {
        if (node == null) return result
        inorderTraversal(node.left, result)
        result.add(node.`val`)
        return inorderTraversal(node.right, result)
    }
}