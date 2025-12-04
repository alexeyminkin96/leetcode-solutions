package problems.p0094

/**
 * **[Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)**
 */
interface Solution {
    fun inorderTraversal(root: TreeNode?): List<Int>

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
