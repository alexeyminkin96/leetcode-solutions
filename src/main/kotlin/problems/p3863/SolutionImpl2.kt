package problems.p3863

class SolutionImpl2 : Solution {
    override fun minOperations(s: String): Int {
        val n = s.length
        val s = s.toCharArray()
        var min = 'z'
        var max = 'a'
        val first = s[0]
        var firstCount = 0
        val last = s[n - 1]
        var lastCount = 0
        var prev = 'a'
        var isNonDecr = true
        for (c in s) {
            if (c == first) firstCount++
            if (c == last) lastCount++
            if (c < min) min = c
            if (c > max) max = c
            if (c < prev) isNonDecr = false
            prev = c
        }
        if (isNonDecr) return 0
        if (n == 2) return -1
        if (first == min || last == max) return 1
        if (first == max && firstCount == 1 && last == min && lastCount == 1) return 3
        return 2
    }
}