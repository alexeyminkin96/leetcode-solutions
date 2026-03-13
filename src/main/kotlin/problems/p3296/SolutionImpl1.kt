package problems.p3296

/**
 * **LeetCode Performance:**
 * - Runtime: `13 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.80 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*log(mt * mh^2))` mt - minimum time in workerTimes, mh - mountainHeight size
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero/solutions/7645279/kotlin-onlogmt-mh2-13ms-o1-by-alexeymink-5y20)
 */
class SolutionImpl1 : Solution {
    override fun minNumberOfSeconds(mountainHeight: Int, workerTimes: IntArray): Long {
        var minTime = Int.MAX_VALUE
        for (time in workerTimes) minTime = Math.min(minTime, time)
        var l = minTime.toLong() * mountainHeight / workerTimes.size * (mountainHeight / workerTimes.size + 1) / 2
        var r = minTime.toLong() * mountainHeight * (mountainHeight + 1) / 2
        while (l < r) {
            val mid = (l + r) ushr 1
            var layers = 0L
            for (time in workerTimes)
                layers += ((-1 + Math.sqrt(1 + 8.0 * mid / time)) / 2).toLong()
            if (layers < mountainHeight) l = mid + 1 else r = mid
        }
        return l
    }
}
