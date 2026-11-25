package problems.p3934

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `75 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `100.23 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-unique-subarray/solutions/8624464/kotlin-onlogn-75ms-on-primitives-only-by-1e6v)
 */
class SolutionImpl4 : Solution {
    override fun smallestUniqueSubarray(nums: IntArray): Int {
        val n = nums.size
        var l = 1
        var r = n
        val hashCounts = MapLongLong(n)
        outer@ while (l < r) {
            hashCounts.clear()
            val len = (l + r) shr 1
            var hash = 0L
            for (i in 0 until len)
                hash = hash.rotateLeft(1) xor nums[i].toLong()
            hashCounts.incrAndGet(hash)
            var uniqueCount = 1
            for (i in len until n) {
                hash = hash xor nums[i - len].toLong().rotateLeft(len - 1)
                hash = hash.rotateLeft(1) xor nums[i].toLong()
                when (hashCounts.incrAndGet(hash)) {
                    1L -> uniqueCount++
                    2L -> uniqueCount--
                }
            }
            if (uniqueCount > 0) r = len
            else l = len + 1
        }
        return l
    }

    class MapLongLong(cap: Int) {
        private val capacity = Integer.highestOneBit(Math.max(cap, 16) - 1) shl 1
        private val emptyValue = 0L
        private val keys = LongArray(capacity)
        private val values = LongArray(capacity)

        fun incrAndGet(key: Long): Long {
            val pos = getPos(key)
            keys[pos] = key
            return ++values[pos]
        }

        fun clear() {
            Arrays.fill(values, emptyValue)
        }

        private fun getPos(key: Long): Int {
            var pos = pos(key)
            while (pos < capacity && values[pos] != emptyValue && keys[pos] != key) pos++
            if (pos == capacity) {
                pos = 0
                while (values[pos] != emptyValue && keys[pos] != key) pos++
            }
            return pos
        }

        private fun pos(key: Long): Int {
            return (hash(key) and (capacity - 1).toLong()).toInt()
        }

        private fun hash(key: Long): Long {
            var x = key
            x = x xor (x ushr 33)
            x *= -49064778989728563L
            x = x xor (x ushr 33)
            x *= -4265267296055464877L
            x = x xor (x ushr 33)
            return x
        }
    }
}