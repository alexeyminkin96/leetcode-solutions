package problems.p2058

/**
 * **[2058. Find the Minimum and Maximum Number of Nodes Between Critical Points](https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/)**
 */
interface Solution {
    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
