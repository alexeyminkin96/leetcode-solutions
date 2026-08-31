package problems.p2058

import problems.p2058.Solution.ListNode

class SolutionImpl1 : Solution {
    override fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        var cur = head
        var i = 0
        while (cur?.next?.next != null) {
            if (cur.`val` < cur.next!!.`val` && cur.next!!.`val` > cur.next!!.next!!.`val`
                || cur.`val` > cur.next!!.`val` && cur.next!!.`val` < cur.next!!.next!!.`val`
            ) break
            cur = cur.next!!
            i++
        }
        val firstCrit = i
        var prevCrit = i++
        cur = cur?.next
        var min = Int.MAX_VALUE
        while (cur?.next?.next != null) {
            if (cur.`val` < cur.next!!.`val` && cur.next!!.`val` > cur.next!!.next!!.`val`
                || cur.`val` > cur.next!!.`val` && cur.next!!.`val` < cur.next!!.next!!.`val`
            ) {
                min = Math.min(min, i - prevCrit)
                prevCrit = i
            }
            cur = cur.next!!
            i++
        }
        val res = IntArray(2) { -1 }
        if (min != Int.MAX_VALUE) {
            res[0] = min
            res[1] = prevCrit - firstCrit
        }
        return res
    }
}