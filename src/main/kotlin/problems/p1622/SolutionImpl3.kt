package problems.p1622

/**
 * **LeetCode Performance:**
 * - Runtime: `132 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `134.26 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * log n)`
 * - Space: `O(M)` M - max appends (100_000)
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/fancy-sequence/solutions/7649703/kotlin-on-logn-132ms-om-segment-tree-by-u1avo)
 */
class SolutionImpl3 : Solution {
    private val n = 100_000
    private val mod = 1_000_000_007
    private val lazyAdd = IntArray(4 * n)
    private val lazyMul = IntArray(4 * n) { 1 }
    private var size = 0

    override fun append(`val`: Int) {
        mulAndAdd(size, size++, 1, `val`, 1, 0, n - 1)
    }

    override fun addAll(inc: Int) {
        mulAndAdd(0, size - 1, 1, inc, 1, 0, n - 1)
    }

    override fun multAll(m: Int) {
        mulAndAdd(0, size - 1, m, 0, 1, 0, n - 1)
    }

    override fun getIndex(idx: Int): Int {
        if (idx >= size) return -1
        return find(idx, 1, 0, n - 1)
    }

    private fun find(i: Int, parent: Int, from: Int, to: Int): Int {
        if (from == to) return lazyAdd[parent]
        push(parent)
        val mid = (from + to) ushr 1
        return if (i <= mid) find(i, parent shl 1, from, mid)
        else find(i, (parent shl 1) + 1, mid + 1, to)
    }

    private fun mulAndAdd(l: Int, r: Int, m: Int, inc: Int, parent: Int, from: Int, to: Int) {
        if (r < from || l > to) return
        if (r >= to && l <= from) return mulAndAddV(m, inc, parent)
        push(parent)
        val mid = (from + to) ushr 1
        mulAndAdd(l, r, m, inc, parent shl 1, from, mid)
        mulAndAdd(l, r, m, inc, (parent shl 1) + 1, mid + 1, to)
    }

    private fun push(parent: Int) {
        mulAndAddV(lazyMul[parent], lazyAdd[parent], parent shl 1)
        mulAndAddV(lazyMul[parent], lazyAdd[parent], (parent shl 1) + 1)
        lazyMul[parent] = 1
        lazyAdd[parent] = 0
    }

    private fun mulAndAddV(m: Int, inc: Int, parent: Int) {
        var mul = lazyMul[parent].toLong() * m
        if (mul >= mod) mul %= mod
        lazyMul[parent] = mul.toInt()

        var add = lazyAdd[parent].toLong() * m + inc
        if (add >= mod) add %= mod
        lazyAdd[parent] = add.toInt()
    }
}