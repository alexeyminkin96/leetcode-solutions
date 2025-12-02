package problems.p0083

/**
 * **[Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)**
 */
interface Solution {
    fun deleteDuplicates(head: ListNode?): ListNode?

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
