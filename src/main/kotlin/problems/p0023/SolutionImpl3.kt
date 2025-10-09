package problems.p0023

import java.util.PriorityQueue
import problems.p0023.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `91.00%` of Kotlin submissions)
 * - Memory: `46.42 MB` (Beats `63.80%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(nk log k)`
 * - Space: `O(k)`
 *
 * **Approach:**
 * - Use PriorityQueue
 * - Poll min, push next node
 *
 * **Techniques:**
 * - Min-heap
 * - Comparator
 */
class SolutionImpl3 : Solution {

    private val comparator = Comparator.comparingInt<ListNode> { it.`val` }

    override fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.size == 0) return null
        if (lists.size == 1) return lists[0]

        val priorityQueue = PriorityQueue(lists.size, comparator)
        for (listNode in lists) {
            if (listNode != null) priorityQueue.add(listNode)
        }

        val beforeHead = ListNode(0)
        var current = beforeHead

        while (priorityQueue.size > 0) {
            current.next = priorityQueue.poll()
            current = current.next!!
            if (current.next != null)
                priorityQueue.add(current.next!!)
        }

        return beforeHead.next
    }
}