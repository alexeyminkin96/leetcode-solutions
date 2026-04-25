package problems.p3464

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `15 ms` (Beats `99.03%` of Kotlin submissions)
 * - Memory: `54.84 MB` (Beats `99.03%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * k * log side)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun maxDistance(side: Int, points: Array<IntArray>, k: Int): Int {
        val side = side.toLong()
        val ar = LongArray(points.size) {
            val point = points[it]
            val x = point[0].toLong()
            val y = point[1].toLong()
            when {
                y == 0L -> x
                x == side -> y + side
                y == side -> side * 3 - x
                else -> side * 4 - y
            }
        }

        Arrays.sort(ar)
        val n = ar.size
        val p = side shl 2
        val ar2 = LongArray(n * 2) { i ->
            ar[i % n] + if (i >= n) p else 0L
        }

        fun check(dist: Long): Boolean {
            val next = IntArray(n * 2) { n * 2 }
            var j = 0

            for (i in 0 until n * 2) {
                if (j <= i) j = i + 1

                while (j < n * 2 && ar2[j] - ar2[i] < dist)
                    j++

                next[i] = j
            }

            for (start in 0 until n) {
                var cur = start
                var count = 1

                while (count < k && cur < start + n) {
                    cur = next[cur]
                    count++
                }

                if (count == k && cur < start + n && ar2[start] + p - ar2[cur] >= dist)
                    return true
            }

            return false
        }

        var l = 1L
        var r = side
        var res = 0L
        while (l <= r) {
            val mid = (l + r) shr 1
            if (check(mid)) {
                res = mid
                l = mid + 1
            } else
                r = mid - 1

        }
        return res.toInt()
    }
}