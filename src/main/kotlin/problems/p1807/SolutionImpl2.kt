package problems.p1807

/**
 * **LeetCode Performance**
 * - Runtime: `24 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `92.64 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(n + k)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/solutions/8541015/kotlin-onk-24ms-ok-primitives-only-by-al-8ha5)
 */
class SolutionImpl2 : Solution {
    override fun evaluate(s: String, knowledge: List<List<String>>): String {
        val n = s.length
        val map = MapLongLong(knowledge.size shl 1)
        fun addCharToLong(long: Long, char: Char): Long = (long shl 5) or (char - 'a' + 1).toLong()
        for (pair in knowledge) {
            var key = 0L
            for (c in pair[0]) key = addCharToLong(key, c)
            var value = 0L
            for (i in pair[1].length - 1 downTo 0) value = addCharToLong(value, pair[1][i])
            map[key] = value
        }
        val s = s.toCharArray()
        var sI = 0
        val res = CharArray(n * 10 / 3 + 10)
        var resI = 0
        while (sI < n) {
            while (sI < n && s[sI] != '(') res[resI++] = s[sI++]
            if (sI++ == n) break
            var key = 0L
            while (s[sI] != ')') key = addCharToLong(key, s[sI++])
            sI++
            var value = map[key]
            if (value == 0L) res[resI++] = '?'
            else while (value > 0) {
                res[resI++] = 'a' + (value and 0b1_1111).toInt() - 1
                value = value ushr 5
            }
        }
        return String(res, 0, resI)
    }

    class MapLongLong(cap: Int) {
        private val capacity = Integer.highestOneBit(Math.max(cap, 16) - 1) shl 1
        private val emptyKey = 0L
        private val keys = LongArray(capacity)
        private val values = LongArray(capacity)

        operator fun get(key: Long): Long {
            return values[getPos(key)]
        }

        operator fun set(key: Long, value: Long) {
            val pos = getPos(key)
            keys[pos] = key
            values[pos] = value
        }

        private fun getPos(key: Long): Int {
            var pos = pos(key)
            while (pos < capacity && keys[pos] != emptyKey && keys[pos] != key) pos++
            if (pos == capacity) {
                pos = 0
                while (keys[pos] != emptyKey && keys[pos] != key) pos++
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