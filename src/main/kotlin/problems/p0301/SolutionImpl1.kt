package problems.p0301

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.29 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * 2^n)`
 * - Space: `O(n * 2^n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/remove-invalid-parentheses/solutions/8561448/kotlin-on2n-7ms-on2n-not-dfs-by-alexeymi-idla)
 */
class SolutionImpl1 : Solution {
    override fun removeInvalidParentheses(s: String): List<String> {
        var size = s.length
        val res = ArrayList<CharArray>()
        res.add(s.toCharArray())
        val lastRemoves = ArrayList<Int>()
        lastRemoves.add(0)
        var count = 0
        for (i in 0 until s.length) {
            val c = s[i]
            if (c == '(') count++
            else if (c == ')') {
                if (count > 0) count--
                else {
                    for (j in 0 until res.size) {
                        val str = res.removeFirst()
                        var prevIs = false
                        for (k in lastRemoves.removeFirst()..i) {
                            if (str[k] == ' ') continue
                            if (str[k] == ')') {
                                if (!prevIs) {
                                    val next = str.copyOf()
                                    next[k] = ' '
                                    res.add(next)
                                    lastRemoves.add(k + 1)
                                    prevIs = true
                                }
                            } else prevIs = false
                        }
                    }
                    size--
                }
            }
        }
        count = 0
        lastRemoves.clear()
        for (i in 0 until res.size)
            lastRemoves.add(s.length - 1)
        for (i in s.length - 1 downTo 0) {
            val c = s[i]
            if (c == ')') count++
            else if (c == '(') {
                if (count > 0) count--
                else {
                    for (j in 0 until res.size) {
                        val str = res.removeFirst()
                        var prevIs = false
                        for (k in lastRemoves.removeFirst() downTo  i) {
                            if (str[k] == ' ') continue
                            if (str[k] == '(') {
                                if (!prevIs) {
                                    val next = str.copyOf()
                                    next[k] = ' '
                                    res.add(next)
                                    lastRemoves.add(k - 1)
                                    prevIs = true
                                }
                            } else prevIs = false
                        }
                    }
                    size--
                }
            }
        }
        return res.map {
            var i = 0
            for (c in it)
                if (c != ' ') it[i++] = c
            String(it, 0, size)
        }
    }
}