package problems.p0141

import problems.p0141.Solution.ListNode

class SolutionImpl6 : Solution {
    override fun hasCycle(head: ListNode?): Boolean {
        var fast = head ?: return false
        var slow = fast
        for (i in 0 until 10_001) {
            fast = fast.next?.next ?: return false
            slow = slow.next!!
            if (fast == slow) return true
        }
        return false
    }
}