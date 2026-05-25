package problems.p1871

class SolutionImpl1 : Solution {
    override fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
        val n = s.length
        val s = s.toCharArray()
        s[0]--
        for (i in 0 until n) {
            if (s[i] == '/')
                for (j in i + minJump..Math.min(i + maxJump, n - 1))
                    if (s[j] == '0') s[j]--
        }
        return s[n - 1] == '/'
    }
}
