package problems.p0023

import java.util.Arrays
import problems.p0023.Solution.ListNode

/**
 * **LeetCode Performance:**
 * - Runtime: `16 ms` (Beats `36.20%` of Kotlin submissions)
 * - Memory: `46.06 MB` (Beats `70.84%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(nk²)`
 * - Space: `O(k)`
 *
 * **Approach:**
 * - Sort lists by heads
 * - Take smallest, insert next with binary search
 * - Maintain sorted range
 *
 * **Techniques:**
 * - Binary Search
 * - Array shifting
 * - Comparator
 *
 * **Notes:**
 * - Manual PQ imitation
 * - Higher complexity due to sorting and array shifts
 */
class SolutionImpl1 : Solution {

    private val comparator = Comparator.comparingInt<ListNode> { it.`val` }
    private val nullableComparator = Comparator.nullsLast(comparator)

    override fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.size == 0) return null
        if (lists.size == 1) return lists[0]

        Arrays.sort(lists, 0, lists.size, nullableComparator)

        var firstNull = 0
        for (i in lists.size - 1 downTo 0) {
            if (lists[i] != null) {
                firstNull = i + 1
                break
            }
        }

        val beforeHead = ListNode(0)
        var current = beforeHead
        var next: ListNode?
        var nextIndex: Int

        while (firstNull > 0) {
            current.next = lists[0]!!
            current = current.next!!
            next = current.next

            if (next != null) {
                nextIndex = Arrays.binarySearch(lists, 1, firstNull, next, comparator)
                if (nextIndex < 0) nextIndex = -nextIndex - 2 else nextIndex--
                if (nextIndex > 0)
                    System.arraycopy(lists, 1, lists, 0, nextIndex)
                lists[nextIndex] = next
            } else {
                System.arraycopy(lists, 1, lists, 0, --firstNull)
            }
        }

        return beforeHead.next
    }
}