package problems.p0061

/**
 * **[Rotate List](https://leetcode.com/problems/rotate-list/)**
 */
interface Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode?

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
