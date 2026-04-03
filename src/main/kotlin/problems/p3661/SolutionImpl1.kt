package problems.p3661

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun maxWalls(robots: IntArray, distance: IntArray, walls: IntArray): Int {
        val n = robots.size
        val robs = LongArray(n + 1)
        for (i in 0 until n) robs[i] = (robots[i].toLong() shl 17) or distance[i].toLong()
        robs[n] = Int.MAX_VALUE.toLong() shl 17
        Arrays.sort(robs)
        Arrays.sort(walls)

        var dpl = 0
        var l = 0
        var dpr = 0
        var r = 0

        for (i in 0 until n) {
            val pos = (robs[i] shr 17).toInt()
            val dist = (robs[i] and ((1 shl 17) - 1)).toInt()

            val ll = Math.max(r + 1, pos - dist)
            var c1 = Arrays.binarySearch(walls, ll)
            if (c1 < 0) c1 = -c1 - 1
            var c2 = Arrays.binarySearch(walls, pos)
            if (c2 < 0) c2 = -c2 - 1 else c2++
            val c = c2 - c1

            val lll = Math.max(l + 1, pos - dist)
            var c3 = Arrays.binarySearch(walls, lll)
            if (c3 < 0) c3 = -c3 - 1
            val cc = c2 - c3

            l = pos
            val nexdpl = Math.max(dpr + c, dpl + cc)

            r = Math.min(pos + dist, (robs[i + 1] shr 17).toInt() - 1)
            var c5 = Arrays.binarySearch(walls, r)
            if (c5 < 0) c5 = -c5 - 1 else c5++
            var c6 = Arrays.binarySearch(walls, pos)
            if (c6 < 0) c6 = -c6 - 1
            dpr = Math.max(dpr, dpl) + c5 - c6

            dpl = nexdpl
        }
        return Math.max(dpl, dpr)
    }
}