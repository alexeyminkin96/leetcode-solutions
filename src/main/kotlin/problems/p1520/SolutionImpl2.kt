package problems.p1520

class SolutionImpl2 : Solution {
    override fun maxNumOfSubstrings(s: String): List<String> {
        val n = s.length
        val s = s.toCharArray()
        val l = Array(26) { IntArray(n + 1) { -1 } }
        val r = Array(26) { IntArray(n) { -1 } }
        r[s[n - 1] - 'a'][n - 1] = n - 1
        for (i in 0 until n) {
            for (j in 0 until 26) l[j][i + 1] = l[j][i]
            l[s[i] - 'a'][i + 1] = i
        }
        for (i in n - 2 downTo 0) {
            for (j in 0 until 26) r[j][i] = r[j][i + 1]
            r[s[i] - 'a'][i] = i
        }
        val ints = mutableListOf<Pair<Int, Int>>()
        outer@ for (code in 0 until 26) {
            val leftMost = r[code][0]
            var rightMost = l[code][n]
            if (leftMost == -1) continue
            var changedRightMost = true
            while (changedRightMost) {
                changedRightMost = false
                for (j in 0 until 26)
                    if (r[j][leftMost] != -1 && r[j][leftMost] < rightMost) {
                        if (l[j][leftMost] >= 0) continue@outer
                        if (l[j][n] > rightMost) {
                            rightMost = l[j][n]
                            changedRightMost = true
                        }
                    }
            }
            ints.add(Pair(leftMost, rightMost))
        }
        ints.sortBy { it.second }
        val res = mutableListOf<String>()
        var prevR = -1
        for ((l, r) in ints)
            if (l > prevR) {
                res.add(String(s, l, r - l + 1))
                prevR = r
            }
        return res
    }
}