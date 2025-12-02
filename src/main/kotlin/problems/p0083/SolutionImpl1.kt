package problems.p0083

import problems.p0083.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.45 MB` (Beats `88.10%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/remove-duplicates-from-sorted-list/solutions/7388155/kotlin-on-0ms-o1-by-alexeyminkin-wi8v)
 */
class SolutionImpl1 : Solution {
    override fun deleteDuplicates(head: ListNode?): ListNode? {
        var current = head

        while (current != null) {
            if (current.`val` == current.next?.`val`)
                current.next = current.next?.next
            else current = current.next
        }

        return head
    }
}