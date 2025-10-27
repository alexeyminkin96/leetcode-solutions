package problems.p0012

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `84.77%` of Kotlin submissions)
 * - Memory: `44.96 MB` (Beats `97.97%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)` — proportional to number of Roman symbols appended
 * - Space: `O(1)` — constant extra memory
 *
 * **Approach:**
 * - Step 1: Predefine numeral-value pairs.
 * - Step 2: Iterate from largest to smallest.
 * - Step 3: Append symbols while reducing number.
 * - Step 4: Stop when number reaches zero.
 *
 * **Techniques:**
 * - Greedy algorithm
 * - Precomputed arrays
 * - CharArray for efficient concatenation
 *
 * **Notes:**
 * - Efficient string building using CharArray avoids GC overhead.
 */
class SolutionImpl1 : Solution {

    private val s = arrayOf(
        charArrayOf('M'),
        charArrayOf('C', 'M'),
        charArrayOf('D'),
        charArrayOf('C', 'D'),
        charArrayOf('C'),
        charArrayOf('X', 'C'),
        charArrayOf('L'),
        charArrayOf('X', 'L'),
        charArrayOf('X'),
        charArrayOf('I', 'X'),
        charArrayOf('V'),
        charArrayOf('I', 'V'),
        charArrayOf('I')
    )

    private val v = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)

    override fun intToRoman(num: Int): String {
        var varNum = num

        val result = CharArray(15)
        var resultIndex = 0

        for (i in s.indices) {
            repeat(varNum / v[i]) {
                for (c in s[i]) {
                    result[resultIndex++] = c
                }
            }
            varNum %= v[i]
            if (varNum == 0) break
        }

        return String(result, 0, resultIndex)
    }
}