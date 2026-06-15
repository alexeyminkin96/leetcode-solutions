package problems.p2095

import problems.p2095.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `43.46%` of Kotlin submissions)
 * - Memory: `67.35 MB` (Beats `87.14%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/solutions/8367640/kotlin-on-5ms-o1-by-alexeyminkin-ap5f)
 */
class SolutionImpl1 : Solution {
    override fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) return null
        var slow = head!!
        var fast = head.next?.next
        while (fast?.next != null) {
            slow = slow.next!!
            fast = fast.next?.next
        }
        slow.next = slow.next!!.next
        return head
    }
}