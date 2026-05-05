package problems.p0061

import problems.p0061.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.36 MB` (Beats `88.24%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/rotate-list/solutions/8142753/kotlin-on-0ms-o1-by-alexeyminkin-x46l)
 */
class SolutionImpl1 : Solution {
    override fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (k == 0) return head
        var cur = head?.next ?: return head
        var count = 1
        while (cur.next != null) {
            count++
            cur = cur.next!!
        }
        cur.next = head
        for (i in 0 until (count - k % count) % count)
            cur = cur.next!!
        val res = cur.next
        cur.next = null
        return res
    }
}