package problems.p0021

import problems.p0021.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `20.32%` of Kotlin submissions)
 * - Memory: `42.77 MB` (Beats `54.41%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Store refs in array
 * - Use node value as index
 * - Link smaller node
 * - Merge rest
 *
 * **Techniques:**
 * - Two pointers
 * - Pointer juggling
 *
 * **Notes:**
 * - Just for fun
 * - Weird but works :)
 */
class SolutionImpl3 : Solution {
    override fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val ar = Array<ListNode?>(4) { null }
        ar[0] = list1
        ar[1] = list2
        ar[2] = ListNode(0)
        ar[3] = ar[2]

        while (ar[0] != null && ar[1] != null) {
            ar[3]!!.`val` = if (ar[0]!!.`val` < ar[1]!!.`val`) 0 else 1
            ar[2]!!.next = ar[ar[3]!!.`val`]
            ar[2] = ar[ar[3]!!.`val`]
            ar[ar[3]!!.`val`] = ar[ar[3]!!.`val`]!!.next
        }

        ar[2]!!.next = if (ar[0] != null) ar[0] else ar[1]

        return ar[3]!!.next
    }
}