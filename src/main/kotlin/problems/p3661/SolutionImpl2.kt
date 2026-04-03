package problems.p3661

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `92 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `88.26 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + m) log m + n log n)`
 * - Space: `O(n + m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/solutions/7748946/kotlin-omn-2ms-on-by-alexeyminkin-clt7)
 */
class SolutionImpl2 : Solution {
    override fun maxWalls(robots: IntArray, distance: IntArray, walls: IntArray): Int {
        val n = robots.size
        val robs = LongArray(n + 1)
        for (i in 0 until n) robs[i] = (robots[i].toLong() shl 17) or distance[i].toLong()
        robs[n] = Int.MAX_VALUE.toLong() shl 17
        Arrays.sort(robs)
        Arrays.sort(walls)

        var dpl = 0
        var lw = 0
        var dpr = 0
        var rw = 0

        for (i in 0 until n) {
            val pos = (robs[i] shr 17).toInt()
            val dist = (robs[i] and ((1 shl 17) - 1)).toInt()

            val curWall = Arrays.binarySearch(walls, rw, walls.size, pos)
            val lWall = if (curWall < 0) -curWall - 1 else curWall + 1
            val rWall = if (curWall < 0) -curWall - 1 else curWall

            var leftShot = Arrays.binarySearch(walls, lw, walls.size, pos - dist)
            if (leftShot < 0) leftShot = -leftShot - 1

            val rDist = Math.min(pos + dist, (robs[i + 1] shr 17).toInt() - 1)
            var rightShot = Arrays.binarySearch(walls, rWall, walls.size, rDist)
            if (rightShot < 0) rightShot = -rightShot - 1 else rightShot++

            val nexdpl = Math.max(dpl - Math.max(leftShot, lw), dpr - Math.max(leftShot, rw)) + lWall
            dpr = Math.max(dpl, dpr) + rightShot - rWall
            dpl = nexdpl

            lw = lWall
            rw = rightShot
        }
        return Math.max(dpl, dpr)
    }
}
