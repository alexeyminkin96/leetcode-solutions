package problems.p0019

/**
 * **[Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)**
 *
 * **Description:**
 * - Remove the n-th node from the end of a singly linked list and return its head.
 *
 * **Constraints:**
 * - The number of nodes in the list is [1, 30].
 * - 1 <= n <= size of list
 *
 * **Example:**
 * - Input: head = [1,2,3,4,5], n = 2
 * - Output: [1,2,3,5]
 */
interface Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode?

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
