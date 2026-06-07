package problems.p2196

/**
 * **[2196. Create Binary Tree From Descriptions](https://leetcode.com/problems/create-binary-tree-from-descriptions/)**
 */
interface Solution {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode?

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
