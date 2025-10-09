package problems.p0023

import problems.p0023.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `82 ms` (Beats `18.59%` of Kotlin submissions)
 * - Memory: `64.98 MB` (Beats `16.63%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(nk²)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Merge lists sequentially
 *
 * **Techniques:**
 * - Two-pointer merge
 */
class SolutionImpl4 : Solution {

    override fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val beforeHead = ListNode(0)

        for (list in lists) {
            beforeHead.next = mergeTwoLists(beforeHead.next, list)
        }

        return beforeHead.next
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