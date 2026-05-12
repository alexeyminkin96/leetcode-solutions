package problems.p1665

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun minimumEffort(tasks: Array<IntArray>): Int {
        Arrays.sort(tasks, compareBy { it[0] - it[1] })
        var res = 0
        for (i in 0 until tasks.size)
            res += tasks[i][0]
        var min = res
        for (i in 0 until tasks.size) {
            val taskMin = tasks[i][1]
            if (min < taskMin) {
                res += taskMin - min
                min = taskMin
            }
            min -= tasks[i][0]
        }
        return res
    }
}