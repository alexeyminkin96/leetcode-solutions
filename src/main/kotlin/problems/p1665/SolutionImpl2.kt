package problems.p1665

import java.util.Arrays

class SolutionImpl2 : Solution {
    override fun minimumEffort(tasks: Array<IntArray>): Int {
        val bits = 14
        val mask = (1 shl bits) - 1
        val n = tasks.size
        val ar = IntArray(n)
        var res = 0
        for (i in 0 until n) {
            val task = tasks[i]
            ar[i] = (task[1] - task[0]) shl bits or task[0]
            res += task[0]
        }
        Arrays.sort(ar)
        var min = res
        for (i in n - 1 downTo 0) {
            val taskAct = ar[i] and mask
            val taskMin = (ar[i] shr bits) + taskAct
            if (min < taskMin) {
                res += taskMin - min
                min = taskMin
            }
            min -= taskAct
        }
        return res
    }
}