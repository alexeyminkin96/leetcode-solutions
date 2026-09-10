package problems.p2265

import problems.p2265.Solution.TreeNode

class SolutionImpl3 : Solution {
    override fun averageOfSubtree(root: TreeNode?): Int {
        var res = 0
        var count = 0
        var sum = 0
        fun dfs(node: TreeNode?) {
            if (node == null) return
            val prevCount = count++
            val prevSum = sum
            sum += node.`val`
            dfs(node.left)
            dfs(node.right)
            if ((sum - prevSum) / (count - prevCount) == node.`val`) res++
        }
        dfs(root)
        return res
    }
}