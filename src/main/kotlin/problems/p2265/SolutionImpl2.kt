package problems.p2265

import problems.p2265.Solution.TreeNode

class SolutionImpl2 : Solution {
    override fun averageOfSubtree(root: TreeNode?): Int {
        var res = 0
        fun dfs(node: TreeNode?): Long {
            if (node == null) return 0
            val ret = dfs(node.left) + dfs(node.right) + (node.`val`.toLong() shl 32) + 1
            if ((ret shr 32) / (ret.toInt()) == node.`val`.toLong()) res++
            return ret
        }
        dfs(root)
        return res
    }
}