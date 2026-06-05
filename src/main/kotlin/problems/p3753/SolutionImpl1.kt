package problems.p3753

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.74 MB` (Beats `99.37%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log num2)`
 * - Space: `O(1)`
 *
 * - [Full explanation](https://leetcode.com/problems/total-waviness-of-numbers-in-range-ii/solutions/8366203/kotlin-olognum2-1ms-o1-by-alexeyminkin-2cwz)
 */
class SolutionImpl1 : Solution {
    override fun totalWaviness(num1: Long, num2: Long): Long {
        return calc(num2) - calc(num1 - 1)
    }

    private fun calc(n: Long): Long {
        var res = 0L
        var num = n
        var mul = 1L
        while (num >= 100) {
            val rem = (num % 1000).toInt()
            res += total * (num / 1000 - 1) * mul
            res += fTotal * mul
            res += if (rem > 0) counts[rem - 1] * mul else 0
            res += triple[rem] * (n % mul + 1)
            num /= 10
            mul *= 10
        }
        return res
    }
}

private var total = 0L
private val counts = LongArray(1000)
private val triple = LongArray(1000) {
    val l = it / 100
    val m = it / 10 % 10
    val r = it % 10
    val cur = if (m > l && m > r || m < l && m < r) 1L else 0L
    total += cur
    counts[it] = total
    cur
}
private val fTotal = total - counts[99]
