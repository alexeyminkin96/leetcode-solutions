package problems.p0141

import problems.p0141.Solution.ListNode

class SolutionImpl1 : Solution {
    override fun hasCycle(head: ListNode?): Boolean {
        var next = head
        for (i in 0 until 10_001)
            next = next?.next ?: return false
        return true
    }
}