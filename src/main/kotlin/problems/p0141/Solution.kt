package problems.p0141

/**
 * **[Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)**
 */
interface Solution {
    fun hasCycle(head: ListNode?): Boolean

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
