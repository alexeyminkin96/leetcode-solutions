package problems.p0021

import problems.p0021.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.80 MB` (Beats `51.41%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Compare heads
 * - Append smaller node
 * - Advance pointers
 * - Continue until both merged
 *
 * **Techniques:**
 * - Two pointers
 * - Linked list
 *
 * **Notes:**
 * - Handles nulls directly
 */
class SolutionImpl1 : Solution {
    override fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val beforeHead = ListNode(0)
        var current = beforeHead

        var listNode1 = list1
        var listNode2 = list2

        while (listNode1 != null || listNode2 != null) {
            if (listNode1 != null && (listNode2 == null || listNode1.`val` < listNode2.`val`)) {
                current.next = listNode1
                current = listNode1
                listNode1 = listNode1.next
            } else {
                current.next = listNode2
                current = listNode2!!
                listNode2 = listNode2.next
            }
        }

        return beforeHead.next
    }
}