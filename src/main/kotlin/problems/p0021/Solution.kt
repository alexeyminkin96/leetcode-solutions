package problems.p0021

/**
 * **[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)**
 *
 * **Description:**
 * - Merge two sorted linked lists into one sorted list.
 * - Return the head of the merged linked list.
 *
 * **Constraints:**
 * - Lists are sorted in non-decreasing order.
 * - 0 <= list length <= 50.
 * - -100 <= Node.val <= 100.
 *
 * **Examples:**
 * - Input: list1 = [1,2,4], list2 = [1,3,4]
 * - Output: [1,1,2,3,4,4]
 * - Explanation: Merge nodes in sorted order.
 */
interface Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode?

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
