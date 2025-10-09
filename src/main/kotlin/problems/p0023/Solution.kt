package problems.p0023

/**
 * **[Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)**
 *
 * **Description:**
 * - Merge k sorted linked lists into one sorted list.
 *
 * **Constraints:**
 * - k in [0, 10^4]
 * - Total nodes ≤ 10^4
 * - Node values in [-10^4, 10^4]
 *
 * **Notes:**
 * - Empty or single list edge cases.
 *
 * **Examples:**
 * - Input: [[1,4,5],[1,3,4],[2,6]]
 * - Output: [1,1,2,3,4,4,5,6]
 */

interface Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode?

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
