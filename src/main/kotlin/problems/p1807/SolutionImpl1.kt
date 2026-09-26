package problems.p1807

class SolutionImpl1 : Solution {
    override fun evaluate(s: String, knowledge: List<List<String>>): String {
        val n = s.length
        val map = HashMap<String, String>(knowledge.size)
        for (pair in knowledge)
            map[pair[0]] = pair[1]
        var sI = 0
        val res = CharArray(n * 10 / 3 + 10)
        var resI = 0
        while (sI < n) {
            while (sI < n && s[sI] != '(') res[resI++] = s[sI++]
            if (sI == n) break
            val left = ++sI
            while (s[sI] != ')') sI++
            for (c in map[s.substring(left, sI++)] ?: "?")
                res[resI++] = c
        }
        return String(res, 0, resI)
    }
}