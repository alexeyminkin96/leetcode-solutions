package problems.p0141

import problems.p0141.Solution.ListNode

class SolutionImpl4 : Solution {
    override fun hasCycle(head: ListNode?): Boolean {
        var next = head ?: return false
        var point = next
        var k = 1
        for (i in 0 until 10_001) {
            if (i == k) {
                k = k shl 1
                point = next
            }
            next = next.next ?: return false
            if (next == point) return true
        }
        return true
    }
}