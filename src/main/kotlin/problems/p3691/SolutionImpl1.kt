package problems.p3691

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `154 ms` (Beats `72.44%` of Kotlin submissions)
 * - Memory: `77.68 MB` (Beats `63.46%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + k) * log(n))`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun maxTotalValue(nums: IntArray, k: Int): Long {
        val n = nums.size
        val pq = PriorityQueue<Node> { a, b -> b.abs - a.abs }
        var min = nums[n - 1]
        var max = nums[n - 1]
        for (i in n - 1 downTo 0) {
            min = Math.min(min, nums[i])
            max = Math.max(max, nums[i])
            pq.offer(Node(max - min, i, n - 1))
        }
        var res = 0L
        val tree = SegmentTree(nums)
        for (i in 0 until k) {
            val cur = pq.poll()
            res += cur.abs
            if (--cur.r >= cur.l) {
                cur.abs = tree.abs(cur.l, cur.r)
                pq.offer(cur)
            }
        }
        return res
    }

    private data class Node(
        var abs: Int,
        var l: Int,
        var r: Int
    )

    private class SegmentTree(nums: IntArray) {
        private val root = build(nums, 0, nums.size - 1)

        private fun build(nums: IntArray, l: Int, r: Int): Node {
            if (l == r) return Node(l, r, nums[l], nums[l])
            val m = (l + r) / 2
            val left = build(nums, l, m)
            val right = build(nums, m + 1, r)
            return Node(l, r, Math.min(left.min, right.min), Math.max(left.max, right.max), left, right)
        }

        fun abs(l: Int, r: Int): Int {
            val node = query(root, l, r)
            return node.max - node.min
        }

        private fun query(node: Node, l: Int, r: Int): MinMax {
            if (node.l == l && node.r == r) return MinMax(node.min, node.max)
            val m = (node.l + node.r) / 2
            if (r <= m) return query(node.left!!, l, r)
            if (l > m) return query(node.right!!, l, r)
            val left = query(node.left!!, l, m)
            val right = query(node.right!!, m + 1, r)
            return MinMax(Math.min(left.min, right.min), Math.max(left.max, right.max))
        }

        private class Node(
            val l: Int,
            val r: Int,
            val min: Int,
            val max: Int,
            val left: Node? = null,
            val right: Node? = null
        )

        private data class MinMax(val min: Int, val max: Int)
    }
}