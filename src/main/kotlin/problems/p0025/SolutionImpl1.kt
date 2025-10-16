package problems.p0025

import problems.p0025.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `69.94%` of Kotlin submissions)
 * - Memory: `44.13 MB` (Beats `98.27%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + k)` (effectively O(n))
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Use pointer `right` to detect if there are enough nodes for the next group.
 * - Reverse each group of `k` nodes in-place.
 * - Connect the last node of the reversed group to the start of the next group.
 * - Continue until there are fewer than `k` nodes left.
 *
 * **Techniques:**
 * - Linked List
 * - Two Pointers
 * - Iterative Reversal
 *
 * **Notes:**
 * - Works in one traversal, no counting or recursion.
 * - [Full explanation](https://leetcode.com/problems/reverse-nodes-in-k-group/solutions/7280078/kotlin-o-n-k-o-1-not-counting-not-recursion-single-pass-one-function-detailed-expl)
 */
class SolutionImpl1 : Solution {
    override fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var right = head
        for (i in 1 until k)
            right = right?.next

        val result = right ?: head

        var current = head
        var next = current?.next

        while (right != null) {
            val headOfCurrentRange = current
            for (i in 1..k) {
                right = right?.next
                val afterNext = next?.next
                next?.next = current
                current = next
                next = afterNext
            }
            current?.next = next
            headOfCurrentRange?.next = right ?: current
        }

        return result
    }
}