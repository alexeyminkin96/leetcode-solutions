package problems.p0024

/**
 * **[Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)**
 *
 * **Description:**
 * - Given a linked list, swap every two adjacent nodes and return its head.
 * - The values of nodes must not be modified, only links may be changed.
 *
 * **Constraints:**
 * - 0 <= number of nodes <= 100
 * - 0 <= Node.val <= 100
 *
 * **Examples:**
 * - Input: head = [1,2,3,4]
 * - Output: [2,1,4,3]
 * - Explanation: 1↔2 and 3↔4 are swapped.
 */
interface Solution {
    fun swapPairs(head: ListNode?): ListNode?

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
