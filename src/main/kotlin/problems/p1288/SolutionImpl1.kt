package problems.p1288

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        Arrays.sort(intervals, compareBy({ it[0] }, { -it[1] }))
        var r = 0
        var res = 0
        for (interval in intervals)
            if (interval[1] > r) {
                r = interval[1]
                res++
            }
        return res
    }
}