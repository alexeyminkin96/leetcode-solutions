package problems.p0025

/**
 * **[Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)**
 *
 * **Description:**
 * - Reverse every group of `k` nodes in a linked list.
 *
 * **Constraints:**
 * - The number of nodes in the list is in the range [0, 5000].
 * - 0 <= Node.val <= 1000
 * - 1 <= k <= 5000
 *
 * **Notes:**
 * - Better be solved in O(1) extra space.
 * - Nodes can be reversed only by changing their `next` pointers.
 *
 * **Examples:**
 * - Input: head = [1,2,3,4,5], k = 2
 * - Output: [2,1,4,3,5]
 * - Explanation: Reverse nodes in pairs.
 *
 * - Input: head = [1,2,3,4,5], k = 3
 * - Output: [3,2,1,4,5]
 * - Explanation: Reverse each full group of 3 nodes.
 */
interface Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode?

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
