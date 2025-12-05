package problems.p0108

/**
 * **[Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)**
 */
interface Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode?

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
