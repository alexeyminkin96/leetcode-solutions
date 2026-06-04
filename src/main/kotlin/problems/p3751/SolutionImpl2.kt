package problems.p3751

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.09 MB` (Beats `79.63%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(С)` precompute, `O(1)` method
 * - Space: `O(С)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/solutions/8365907/kotlin-oc-0ms-oc-precompute-by-alexeymin-l3mu)
 */
class SolutionImpl2 : Solution {
    override fun totalWaviness(num1: Int, num2: Int): Int {
        return counts[num2] - counts[num1 - 1]
    }
}

private val max = 100_000
private val triple = IntArray(1000) {
    val l = it / 100
    val m = it / 10 % 10
    val r = it % 10
    if (m > l && m > r || m < l && m < r) 1 else 0
}
private val wave = IntArray(max + 1)
private var count = 0
private val counts = IntArray(max + 1) {
    wave[it] = if (it >= 100) wave[it / 10] + triple[it % 1000] else 0
    count += wave[it]
    count
}