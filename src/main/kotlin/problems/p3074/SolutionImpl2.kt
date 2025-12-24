package problems.p3074

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.14 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/apple-redistribution-into-boxes/solutions/7435316/kotlin-onm-1ms-o1-sorting-trick-by-alexe-h0d0)
 */
class SolutionImpl2 : Solution {
    override fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
        var appleCount = 0
        for (i in 0 until apple.size) {
            appleCount += apple[i]
        }
        val boxSizes = IntArray(51)
        for (i in 0 until capacity.size) {
            boxSizes[capacity[i]]++
        }
        var boxSize = boxSizes.size - 1
        var boxCount = 0
        while (appleCount > 0) {
            val count = Math.min(boxSizes[boxSize], (appleCount + boxSize - 1) / boxSize)
            appleCount -= boxSize-- * count
            boxCount += count
        }
        return boxCount
    }
}