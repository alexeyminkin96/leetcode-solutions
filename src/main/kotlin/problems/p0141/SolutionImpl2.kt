package problems.p0141

import problems.p0141.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `125 ms` (Beats `96.67%` of Kotlin submissions)
 * - Memory: `46.73 MB` (Beats `31.60%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/linked-list-cycle/solutions/7957928/kotlin-on-125ms-o1-by-alexeyminkin-xp6n)
 */
class SolutionImpl2 : Solution {
    override fun hasCycle(head: ListNode?): Boolean {
        var next = head ?: return false
        while (next.`val` != Int.MAX_VALUE) {
            next.`val` = Int.MAX_VALUE
            next = next.next ?: return false
        }
        return true
    }
}