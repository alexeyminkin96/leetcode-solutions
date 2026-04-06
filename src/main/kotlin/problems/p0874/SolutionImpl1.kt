package problems.p0874

/**
 * **LeetCode Performance:**
 * - Runtime: `12 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `69.75 MB` (Beats `83.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*k + o)`,
 * - Space: `O(o)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/walking-robot-simulation/solutions/7792126/kotlin-onko-12ms-oo-by-alexeyminkin-j66a)
 */
class SolutionImpl1 : Solution {
    override fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        val m = 30_000
        val bits = 16
        val obs = HashSet<Int>(obstacles.size shl 1)
        for (i in 0 until obstacles.size)
            obs.add(((obstacles[i][0] + m) shl bits) or (obstacles[i][1] + m))
        var ver = 1
        var hor = 0
        var y = 0
        var x = 0
        var res = 0
        for (i in 0 until commands.size) {
            val com = commands[i]
            if (com < 0) {
                val rot = (com shl 1) + 3
                val buf = ver
                ver = -rot * hor
                hor = rot * buf
                continue
            }
            for (k in 0 until com) {
                if (obs.contains(((x + hor + m) shl bits) or (y + ver + m))) break
                x += hor
                y += ver
            }
            res = Math.max(res, y * y + x * x)
        }
        return res
    }
}
