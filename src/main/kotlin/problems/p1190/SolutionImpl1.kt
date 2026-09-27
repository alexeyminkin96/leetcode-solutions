package problems.p1190

class SolutionImpl1 : Solution {
    override fun reverseParentheses(s: String): String {
        val mark = '{'
        val n = s.length
        val res = CharArray(n)
        var resI = 0
        val s = s.toCharArray()
        var count = 0
        for (i in 0 until n)
            when (s[i]) {
                '(' -> res[resI++] = mark + i

                ')' -> {
                    s[i] = res[--resI]
                    s[res[resI] - mark] = mark + i
                }

                else -> count++
            }
        var sI = 0
        var move = 1
        while (resI < count)
            when {
                s[sI] >= mark -> {
                    move *= -1
                    sI = s[sI] - mark + move
                }

                else -> {
                    res[resI++] = s[sI]
                    sI += move
                }
            }
        return String(res, 0, count)
    }
}