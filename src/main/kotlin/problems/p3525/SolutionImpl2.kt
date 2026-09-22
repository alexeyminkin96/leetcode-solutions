package problems.p3525

/**
 * **LeetCode Performance**
 * - Runtime: `204 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `109.12 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O((n + q log n) * k)`
 * - Space: `O(n * k)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-x-value-of-array-ii/solutions/8534245/kotlin-oknqlogn-204ms-okn-by-alexeyminki-qkct)
 */
class SolutionImpl2 : Solution {
    override fun resultArray(nums: IntArray, k: Int, queries: Array<IntArray>): IntArray {
        val segTree = SegTree(nums, k)
        return IntArray(queries.size) { qI ->
            val query = queries[qI]
            segTree.change(query[0], query[1])
            segTree.findCountX(query[3], query[2])
        }
    }

    private class SegTree(
        private val nums: IntArray,
        private val k: Int
    ) {
        private val root: Node = init(0, nums.size - 1)

        fun findCountX(x: Int, start: Int): Int {
            return find(start, root).rems[x]
        }

        private fun find(start: Int, node: Node): Result {
            return if (node.l == node.r) {
                Result(node.rems.copyOf(), node.mul)
            } else if (start <= node.left!!.r) {
                val left = find(start, node.left)
                for (rem in 0 until k)
                    left.rems[left.mul * rem % k] += node.right!!.rems[rem]
                Result(left.rems, left.mul * node.right!!.mul % k)
            } else {
                find(start, node.right!!)
            }
        }

        fun change(index: Int, value: Int) {
            change(index, value, root)
        }

        private fun change(index: Int, value: Int, node: Node) {
            if (node.l == node.r) {
                node.mul = value % k
                node.rems.fill(0)
                node.rems[node.mul]++
            } else {
                change(index, value, if (index <= node.left!!.r) node.left else node.right!!)
                merge(node)
            }
        }

        private fun init(l: Int, r: Int): Node {
            if (l == r) {
                val mul = nums[l] % k
                val rems = IntArray(k)
                rems[mul]++
                return Node(rems, mul, l, r)
            }
            return merge(Node(IntArray(k), 0, l, r, init(l, ((l + r) shr 1)), init(((l + r) shr 1) + 1, r)))
        }

        private fun merge(node: Node): Node {
            node.mul = node.left!!.mul * node.right!!.mul % k
            node.rems.fill(0)
            for (rem in 0 until k) {
                node.rems[rem] += node.left.rems[rem]
                node.rems[node.left.mul * rem % k] += node.right.rems[rem]
            }
            return node
        }
    }

    private class Node(
        val rems: IntArray,
        var mul: Int,
        val l: Int,
        val r: Int,
        val left: Node? = null,
        val right: Node? = null
    )

    private class Result(
        val rems: IntArray,
        var mul: Int
    )
}