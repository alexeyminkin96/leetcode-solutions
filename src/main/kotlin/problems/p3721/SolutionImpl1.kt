package problems.p3721

/**
 * **LeetCode Performance:**
 * - Runtime: `160 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `76.15 MB` (Beats `88.89%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun longestBalanced(nums: IntArray): Int {
        val segTree = SegTree(nums.size)
        val map = HashMap<Int, Int>()
        var result = 0
        for (i in 0 until nums.size) {
            val num = nums[i]
            val prevInd = map[num] ?: -1
            map[num] = i
            val c = ((num and 1) shl 1) - 1
            segTree.add(prevInd + 1, i, c)
            val leftZero = segTree.getMin(i)
            if (leftZero != -1)
                result = maxOf(result, i - leftZero + 1)
        }
        return result
    }

    class SegTree(size: Int) {
        private val root: Node = node(0, size - 1)!!

        fun add(l: Int, r: Int, v: Int) {
            add(l, r, v, root)
        }

        fun getMin(r: Int): Int {
            return getMin(r, root)
        }

        private fun getMin(r: Int, node: Node?): Int {
            if (node == null || node.l > r || node.min > 0 || node.max < 0) return -1
            if (node.l == node.r) return node.l
            push(node)
            val left = getMin(r, node.left)
            return if (left != -1) left else getMin(r, node.right)
        }

        private fun add(l: Int, r: Int, v: Int, node: Node) {
            if (r < node.l || l > node.r) return
            if (l <= node.l && r >= node.r) return addV(node, v)
            push(node)
            add(l, r, v, node.left!!)
            add(l, r, v, node.right!!)
            pull(node)
        }

        private fun push(node: Node) {
            if (node.v == 0 || node.left == null) return
            addV(node.left, node.v)
            addV(node.right!!, node.v)
            node.v = 0
        }

        private fun pull(node: Node) {
            node.min = minOf(node.left!!.min, node.right!!.min)
            node.max = maxOf(node.left.max, node.right.max)
        }

        private fun addV(node: Node, v: Int) {
            node.v += v
            node.min += v
            node.max += v
        }

        private fun node(l: Int, r: Int): Node? {
            if (l > r) return null
            if (l == r) return Node(l, r, null, null, 0, 0, 0)
            val mid = (l + r) ushr 1
            return Node(l, r, node(l, mid), node(mid + 1, r), 0, 0, 0)
        }

        data class Node(
            val l: Int,
            val r: Int,
            val left: Node?,
            val right: Node?,
            var min: Int,
            var max: Int,
            var v: Int,
        )
    }
}