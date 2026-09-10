package problems.p2265

import problems.p2265.Solution.TreeNode

class SolutionImpl1 : Solution {
    override fun averageOfSubtree(root: TreeNode?): Int {
        var res = 0
        fun dfs(node: TreeNode?): Return {
            if (node == null) return Return(0, 0)
            val l = dfs(node.left)
            val r = dfs(node.right)
            val ret = Return(l.sum + r.sum + node.`val`, l.count + r.count + 1)
            if (ret.sum / ret.count == node.`val`) res++
            return ret
        }
        dfs(root)
        return res
    }

    private data class Return(
        val sum: Int,
        val count: Int
    )
}