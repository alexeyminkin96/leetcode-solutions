package problems.p1022

/**
 * **[Sum of Root To Leaf Binary Numbers](https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/)**
 */
interface Solution {
    fun sumRootToLeaf(root: TreeNode): Int

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
