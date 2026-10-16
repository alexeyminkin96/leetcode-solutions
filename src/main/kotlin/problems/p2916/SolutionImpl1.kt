package problems.p2916

/**
 * **LeetCode Performance:**
 * - Runtime: `119 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `144.52 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun sumCounts(nums: IntArray): Int {
        val n = nums.size
        val mod = 1_000_000_007
        val segTree = SegTree(n)
        var max = 0
        for (num in nums) if (num > max) max = num
        val last = IntArray(max + 1) { n }
        var cur = 0L
        var res = 0L
        for (i in n - 1 downTo 0) {
            val next = last[nums[i]]
            val s = segTree.query(1, 0, n - 1, i, next - 1)
            cur = (cur + (s shl 1) + next - i) % mod
            res = (res + cur) % mod
            segTree.update(1, 0, n - 1, i, next - 1)
            last[nums[i]] = i
        }
        return res.toInt()
    }

    private class SegTree(n: Int) {
        private val sum = LongArray(n shl 2)
        private val lazy = LongArray(n shl 2)

        fun update(v: Int, l: Int, r: Int, ql: Int, qr: Int) {
            if (ql > r || qr < l) return
            if (ql <= l && qr >= r) {
                sum[v] += r - l + 1L
                lazy[v]++
                return
            }
            val m = (l + r) shr 1
            if (lazy[v] != 0L) {
                val d = lazy[v]
                sum[v shl 1] += d * (m - l + 1)
                sum[(v shl 1) + 1] += d * (r - m)
                lazy[v shl 1] += d
                lazy[(v shl 1) + 1] += d
                lazy[v] = 0
            }
            update(v shl 1, l, m, ql, qr)
            update((v shl 1) + 1, m + 1, r, ql, qr)
            sum[v] = sum[v shl 1] + sum[(v shl 1) + 1]
        }

        fun query(v: Int, l: Int, r: Int, ql: Int, qr: Int): Long {
            if (ql > r || qr < l) return 0
            if (ql <= l && qr >= r) return sum[v]
            val m = (l + r) shr 1
            if (lazy[v] != 0L) {
                val d = lazy[v]
                sum[v shl 1] += d * (m - l + 1)
                sum[(v shl 1) + 1] += d * (r - m)
                lazy[v shl 1] += d
                lazy[(v shl 1) + 1] += d
                lazy[v] = 0
            }
            return query(v shl 1, l, m, ql, qr) + query((v shl 1) + 1, m + 1, r, ql, qr)
        }
    }
}