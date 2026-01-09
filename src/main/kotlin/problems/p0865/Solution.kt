package problems.p0865

/**
 * **[Smallest Subtree with all the Deepest Nodes](https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/)**
 */
interface Solution {
    fun subtreeWithAllDeepest(root: TreeNode): TreeNode

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
