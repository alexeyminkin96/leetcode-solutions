package problems.p2130

import problems.p2130.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `85.87%` of Kotlin submissions)
 * - Memory: `60.65 MB` (Beats `79.20%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/solutions/8367614/kotlin-on-6ms-o1-by-alexeyminkin-wws8)
 */
class SolutionImpl1 : Solution {
    override fun pairSum(head: ListNode?): Int {
        var slow = head
        var fast = head
        var prev: ListNode? = null
        while (fast != null) {
            fast = fast.next?.next
            val next = slow!!.next!!
            slow.next = prev
            prev = slow
            slow = next
        }
        var res = 0
        while (prev != null) {
            res = Math.max(res, prev.`val` + slow!!.`val`)
            prev = prev.next
            slow = slow.next
        }
        return res
    }
}