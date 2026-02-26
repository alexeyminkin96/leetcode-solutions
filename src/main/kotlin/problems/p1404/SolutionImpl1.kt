package problems.p1404

class SolutionImpl1 : Solution {
    override fun numSteps(s: String): Int {
        val s = s.toByteArray()
        var count = 0
        var carry = 0
        for (i in s.size - 1 downTo 1) {
            val num = s[i] - 48 + carry
            val rem = num and 1
            count += rem + 1
            carry = (num + rem) ushr 1
        }
        return count + carry
    }
}
