package problems.p0024

import problems.p0024.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100%` of Kotlin submissions)
 * - Memory: `40.57 MB` (Beats `93.55%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Use dummy head to simplify swaps
 * - Iterate and swap nodes in pairs by relinking pointers
 * - Move pointer forward by two nodes each step
 */
class SolutionImpl1 : Solution {
    override fun swapPairs(head: ListNode?): ListNode? {
        val beforeHead = ListNode(0)
        beforeHead.next = head

        var current = beforeHead
        var next: ListNode
        var afterNext: ListNode

        while (current.next?.next != null) {
            next = current.next!!
            afterNext = next.next!!

            current.next = afterNext
            next.next = afterNext.next
            afterNext.next = next

            current = next
        }

        return beforeHead.next
    }
}