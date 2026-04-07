package problems.p2069

/**
 * **LeetCode Performance:**
 * - Runtime: `118 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `78.62 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)` per operation
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/walking-robot-simulation-ii/solutions/7810982/kotlin-o1-118ms-o1-perimeter-by-alexeymi-vscj)
 */
class SolutionImpl1(private val w: Int, private val h: Int) : Solution {
    private val p = (w + h) * 2 - 4
    private val xy = IntArray(2)
    private var pos = 0

    override fun step(num: Int) {
        pos = (pos + num - 1) % p + 1
    }

    override fun getPos(): IntArray {
        xy[0] = Math.min(Math.min(pos, w - 1), Math.max((p - h + 1) - pos, 0))
        xy[1] = Math.min(Math.min(p - pos, h - 1), Math.max(pos - (w - 1), 0))
        return xy
    }

    override fun getDir(): String =
        when {
            pos < w -> "East"
            pos < w + h - 1 -> "North"
            pos < p - h + 2 -> "West"
            else -> "South"
        }
}