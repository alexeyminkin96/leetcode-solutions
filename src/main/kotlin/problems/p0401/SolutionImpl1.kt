package problems.p0401

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.73 MB` (Beats `97.56%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(h^2 * m^2)`
 * - Space: `O(h^2 + m^2)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/binary-watch/solutions/7585817/kotlin-o2h-2m-1ms-o2h-2m-by-alexeyminkin-wj8u)
 */
class SolutionImpl1 : Solution {
    override fun readBinaryWatch(turnedOn: Int): List<String> {
        var h = 0
        var m = turnedOn
        val result = ArrayList<String>()
        while (m >= 0) {
            for (hour in hours[h++])
                for (minute in minutes[m])
                    if (minute < 10) result.add("$hour:0$minute")
                    else result.add("$hour:$minute")
            m--
        }
        return result
    }

    companion object {
        private val hours = Array(11) { ArrayList<Int>() }
        private val minutes = Array(11) { ArrayList<Int>() }

        init {
            for (i in 0..11) hours[i.countOneBits()].add(i)
            for (i in 0..59) minutes[i.countOneBits()].add(i)
        }
    }
}
