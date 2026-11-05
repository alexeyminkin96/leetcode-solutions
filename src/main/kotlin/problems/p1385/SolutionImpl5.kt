package problems.p1385

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.46 MB` (Beats `11.11%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m + C)`
 * - Space: `O(C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-distance-value-between-two-arrays/solutions/8602496/kotlin-omnc-3ms-oc-by-alexeyminkin-vru1)
 */
class SolutionImpl5 : Solution {
    override fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        val a1 = IntArray(2001)
        val a2 = BooleanArray(2001)
        for (num1 in arr1) a1[num1 + 1000]++
        for (num2 in arr2) a2[num2 + 1000] = true
        var j = 0
        var res = 0
        for (i in 0 until 2001) {
            if (a1[i] == 0) continue
            while (j < 2001 && (!a2[j] || j < i - d)) j++
            if (j == 2001 || j > i + d) res += a1[i]
        }
        return res
    }
}