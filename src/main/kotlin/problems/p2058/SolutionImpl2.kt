package problems.p2058

import problems.p2058.Solution.ListNode

class SolutionImpl2 : Solution {
    override fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        var cur = head
        var i = 0
        var firstCrit = -1
        var prevCrit = -1
        var min = Int.MAX_VALUE
        while (cur?.next?.next != null) {
            if (cur.next!!.`val` > Math.max(cur.`val`, cur.next!!.next!!.`val`)
                || cur.next!!.`val` < Math.min(cur.`val`, cur.next!!.next!!.`val`)
            ) {
                if (prevCrit == -1) firstCrit = i else min = Math.min(min, i - prevCrit)
                prevCrit = i
            }
            cur = cur.next
            i++
        }
        return if (min != Int.MAX_VALUE) intArrayOf(min, prevCrit - firstCrit) else intArrayOf(-1, -1)
    }
}