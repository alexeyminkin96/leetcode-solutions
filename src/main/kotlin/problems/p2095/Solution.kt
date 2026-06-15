package problems.p2095

/**
 * **[Delete the Middle Node of a Linked List](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/)**
 */
interface Solution {
    fun deleteMiddle(head: ListNode?): ListNode?

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
