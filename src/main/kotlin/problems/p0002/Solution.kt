package problems.p0002

/**
 * **[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)**
 *
 * **Description:**
 * - You are given two non-empty linked lists representing two non-negative integers.
 * - The digits are stored in reverse order, and each node contains a single digit.
 * - Add the two numbers and return the sum as a linked list (also in reverse order).
 *
 * **Constraints:**
 * - The number of nodes in each linked list is in the range `[1, 100]`
 * - `0 <= Node.val <= 9`
 * - The input lists represent numbers with no leading zeros (except the number `0` itself)
 *
 * **Notes:**
 * - Lists can have different lengths
 * - Carry may produce an extra node at the end
 *
 * **Examples:**
 * - Input: l1 = [2,4,3], l2 = [5,6,4]
 * - Output: [7,0,8]
 * - Explanation: 342 + 465 = 807
 */
interface Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode?

    class ListNode(
        var `val`: Int
    ) {
        var next: ListNode? = null
    }
}