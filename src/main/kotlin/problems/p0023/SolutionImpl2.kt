package problems.p0023

import java.util.TreeSet
import problems.p0023.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `9 ms` (Beats `74.36%` of Kotlin submissions)
 * - Memory: `45.79 MB` (Beats `78.28%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(nk log k)`
 * - Space: `O(k)`
 *
 * **Approach:**
 * - Keep active heads in TreeSet
 * - Poll smallest, insert next
 *
 * **Techniques:**
 * - Balanced tree
 * - Ordered iteration
 *
 * **Notes:**
 * - Comparator must never return 0 to keep duplicates
 */
class SolutionImpl2 : Solution {

    private val comparator = Comparator<ListNode> { a, b -> if (a.`val` < b.`val`) -1 else 1 }

    override fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.size == 0) return null
        if (lists.size == 1) return lists[0]

        val sortedSet = TreeSet(comparator)
        for (listNode in lists) {
            if (listNode != null) sortedSet.add(listNode)
        }

        val beforeHead = ListNode(0)
        var current = beforeHead

        while (sortedSet.size > 0) {
            current.next = sortedSet.pollFirst()
            current = current.next!!
            if (current.next != null)
                sortedSet.add(current.next!!)
        }

        return beforeHead.next
    }
}