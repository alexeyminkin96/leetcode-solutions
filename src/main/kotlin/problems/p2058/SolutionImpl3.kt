package problems.p2058

import problems.p2058.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `70.72 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/solutions/8493200/kotlin-on-6ms-o1-by-alexeyminkin-umk3)
 */
class SolutionImpl3 : Solution {
    override fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        var left = head
        var mid = left?.next
        var right = mid?.next
        var i = 0
        var firstCrit = -1
        var prevCrit = -1
        var min = Int.MAX_VALUE
        while (right != null) {
            if (left!!.`val` < mid!!.`val` && mid.`val` > right.`val` || left.`val` > mid.`val` && mid.`val` < right.`val`) {
                if (prevCrit == -1) firstCrit = i
                else min = Math.min(min, i - prevCrit)
                prevCrit = i
            }
            left = mid
            mid = right
            right = right.next
            i++
        }
        return if (min != Int.MAX_VALUE) intArrayOf(min, prevCrit - firstCrit) else intArrayOf(-1, -1)
    }
}