package problems.p0141

import problems.p0141.Solution.ListNode

class SolutionImpl5 : Solution {
    override fun hasCycle(head: ListNode?): Boolean {
        val set = HashSet<ListNode>()
        var next = head
        while (next != null) {
            if (set.contains(next)) return true
            set.add(next)
            next = next.next
        }
        return false
    }
}