package problems.p1096

/**
 * **LeetCode Performance**
 * - Runtime: `23 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.47 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(2^n)`
 * - Space: `O(2^n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/brace-expansion-ii/solutions/8539765/kotlin-o2n-23ms-o2n-by-alexeyminkin-d2si)
 */
class SolutionImpl1 : Solution {
    override fun braceExpansionII(expression: String): List<String> {
        val expression = expression.toCharArray()
        var i = 0
        fun getBlock(): Set<String> {
            var mul = HashSet<String>()
            mul.add("")
            val res = HashSet<String>()
            while (i < expression.size)
                when (val char = expression[i++]) {
                    '{' -> {
                        val newMul = HashSet<String>()
                        for (next in getBlock())
                            for (prev in mul)
                                newMul.add(prev + next)
                        mul = newMul
                    }

                    '}' -> break

                    ',' -> {
                        res.addAll(mul)
                        mul = HashSet()
                        mul.add("")
                    }

                    else -> {
                        val newMul = HashSet<String>()
                        for (prev in mul)
                            newMul.add(prev + char)
                        mul = newMul
                    }
                }
            res.addAll(mul)
            return res
        }
        return getBlock().sorted()
    }
}