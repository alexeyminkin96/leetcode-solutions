package problems.p0019

import problems.p0019.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%`)
 * - Memory: `41.17 MB` (Beats `95.66%`)
 *
 * **Complexity:**
 * - Time: O(n)
 * - Space: O(1)
 *
 * **Approach:**
 * - Use dummy node before head.
 * - Move right pointer n+1 steps ahead.
 * - Move left and right together until right hits end.
 * - Remove node after left.
 *
 * **Techniques:**
 * - Two Pointers
 * - Dummy Head
 *
 * **Notes:**
 * - One-pass optimal solution.
 * - Handles head removal without special cases.
 */
class SolutionImpl1 : Solution {
    override fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val beforeHead = ListNode(0)
        beforeHead.next = head

        var left: ListNode? = beforeHead
        var right: ListNode? = beforeHead

        for (i in 0 .. n) {
            right = right?.next
        }

        while (right != null) {
            right = right.next
            left = left?.next
        }

        left?.next = left?.next?.next

        return beforeHead.next
    }
}