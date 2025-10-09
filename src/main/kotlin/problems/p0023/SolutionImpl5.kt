package problems.p0023

import problems.p0023.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `91.00%` of Kotlin submissions)
 * - Memory: `45.35 MB` (Beats `84.54%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(nk log k)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Merge pairs iteratively
 * - Double gap each pass
 *
 * **Techniques:**
 * - Divide and conquer
 * - Two-pointer merge
 */
class SolutionImpl5 : Solution {

    override fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.size == 0) return null

        var gap = 1
        while (gap < lists.size) {
            for (i in 0 until lists.size step gap * 2) {
                if (i + gap < lists.size)
                    lists[i] = mergeTwoLists(lists[i], lists[i + gap])
            }
            gap *= 2
        }

        return lists[0]
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val beforeHead = ListNode(0)
        var current = beforeHead

        var listNode1 = list1
        var listNode2 = list2

        while (listNode1 != null && listNode2 != null) {
            if (listNode1.`val` < listNode2.`val`) {
                current.next = listNode1
                current = listNode1
                listNode1 = listNode1.next
            } else {
                current.next = listNode2
                current = listNode2
                listNode2 = listNode2.next
            }
        }

        current.next = listNode1 ?: listNode2

        return beforeHead.next
    }
}