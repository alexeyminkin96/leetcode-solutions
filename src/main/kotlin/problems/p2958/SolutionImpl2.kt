package problems.p2958

/**
 * **LeetCode Performance:**
 * - Runtime: `17 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `66.45 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/solutions/8456355/kotlin-on-17ms-on-by-alexeyminkin-01x2)
 */
class SolutionImpl2 : Solution {
    override fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        val n = nums.size
        val counts = MapIntInt(n)
        var l = 0
        var r = 0
        var hasMoreK = false
        var res = 0
        while (r < n) {
            hasMoreK = if (!hasMoreK) counts.incr(nums[r++]) > k else counts.decr(nums[l++]) < k
            if (!hasMoreK) res = Math.max(res, r - l)
        }
        return res
    }

    class MapIntInt(cap: Int) {
        private val capacity = Integer.highestOneBit(Math.max(cap, 16) - 1) shl 1
        private val keys = IntArray(capacity)
        private val emptyKey = 0
        private val values = IntArray(capacity)

        fun incr(key: Int): Int {
            val pos = getPos(key)
            keys[pos] = key
            return ++values[pos]
        }

        fun decr(key: Int): Int {
            return --values[getPos(key)]
        }

        private fun getPos(key: Int): Int {
            var pos = pos(key)
            while (pos < capacity && keys[pos] != emptyKey && keys[pos] != key) pos++
            if (pos == capacity) {
                pos = 0
                while (keys[pos] != emptyKey && keys[pos] != key) pos++
            }
            return pos
        }

        private fun pos(key: Int): Int {
            return hash(key) and (capacity - 1)
        }

        private fun hash(key: Int): Int {
            var x = key
            x = x xor (x ushr 16)
            x *= 0x7feb352d
            x = x xor (x ushr 15)
            x *= -0x7b935975
            x = x xor (x ushr 16)
            return x
        }
    }
}