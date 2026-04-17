package problems.p0141

import problems.p0141.Solution.ListNode

class SolutionImpl3 : Solution {
    override fun hasCycle(head: ListNode?): Boolean {
        val flag = ListNode(0)
        var next = head ?: return false
        while (next != flag) {
            val buf = next.next ?: return false
            next.next = flag
            next = buf
        }
        return true
    }
}