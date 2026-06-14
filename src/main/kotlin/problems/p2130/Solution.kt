package problems.p2130

/**
 * **[Maximum Twin Sum of a Linked List](https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/)**
 */
interface Solution {
    fun pairSum(head: ListNode?): Int

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
