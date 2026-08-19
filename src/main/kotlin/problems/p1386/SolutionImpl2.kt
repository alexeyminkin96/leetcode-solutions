package problems.p1386

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `58.89 MB` (Beats `71.43%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m)` average, where `m = reservedSeats.size`
 * - Space: `O(m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/cinema-seat-allocation/solutions/8469934/kotlin-om-7ms-om-primitives-only-by-alex-wrfp)
 */
class SolutionImpl2 : Solution {
    override fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
        val map = MapIntInt(reservedSeats.size shl 1)
        for (reservedSeat in reservedSeats) map.or(reservedSeat[0], 1 shl (reservedSeat[1] - 1))
        var res = n shl 1
        fun has(v: Int, seats: Int): Int = if (v and seats == 0) 1 else 0
        for (v in map.getValues())
            if (v == 0) continue
            else res += -2 + Math.max(has(v, 0b01_1110_0000) + has(v, 0b00_0001_1110), has(v, 0b00_0111_1000))
        return res
    }

    class MapIntInt(cap: Int) {
        private val capacity = Integer.highestOneBit(Math.max(cap, 16) - 1) shl 1
        private val keys = IntArray(capacity)
        private val emptyKey = 0
        private val values = IntArray(capacity)

        fun getValues(): IntArray {
            return values
        }

        fun or(key: Int, or: Int) {
            val pos = getPos(key)
            keys[pos] = key
            values[pos] = values[pos] or or
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
