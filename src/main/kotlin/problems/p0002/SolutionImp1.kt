package problems.p0002

import problems.p0002.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `86.29%` of Kotlin submissions)
 * - Memory: `46.12 MB` (Beats `67.64%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(max(m, n))`
 * - Space: `O(max(m, n))`
 *
 * **Approach:**
 * - Traverse both lists simultaneously with two pointers
 * - At each step, sum current digits plus carry
 * - Append a new node with `sum % 10`, update carry as `sum / 10`
 * - Continue while there are nodes or a remaining carry
 *
 * **Techniques:**
 * - Linked list traversal
 * - Dummy head node
 * - Carry propagation
 *
 * **Notes:**
 * - Uses a dummy head to simplify edge cases; the actual result starts at `dummy.next`
 * - Handles unequal list lengths and final carry without extra passes
 */
class SolutionImp1 : Solution {
    override fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1CurrentNode = l1
        var l2CurrentNode = l2
        var addToNextVal = 0
        var currentVal: Int

        val result = ListNode(0)
        var lastNode = result

        while (l1CurrentNode != null || l2CurrentNode != null || addToNextVal != 0) {
            currentVal = (l1CurrentNode?.`val` ?: 0) + (l2CurrentNode?.`val` ?: 0) + addToNextVal

            lastNode.next = ListNode(currentVal % 10)
            lastNode = lastNode.next!!

            addToNextVal = currentVal / 10
            l1CurrentNode = l1CurrentNode?.next
            l2CurrentNode = l2CurrentNode?.next
        }

        return result.next
    }
}