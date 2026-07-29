package problems.p3518

class SolutionImpl2 : Solution {
    override fun smallestPalindrome(s: String, k: Int): String {
        val s = s.toCharArray()
        val n = s.size
        if (n == 1 && k > 1) return ""
        val half = n shr 1
        val charCount = IntArray(26)
        for (i in 0 until half) charCount[s[i] - 'a']++
        var k = k.toLong()
        outer@ for (i in 0 until half) {
            for (cur in 0 until 26) {
                if (charCount[cur] == 0) continue
                charCount[cur]--
                s[i] = 'a' + cur
                s[n - 1 - i] = 'a' + cur
                var perms = 1L
                var places = half - 1 - i
                for (other in 0 until 26) {
                    val same = charCount[other]
                    perms *= placeSameToPerms[places][Math.min(same, places - same)]
                    places -= charCount[other]
                    if (perms >= k) continue@outer
                }
                k -= perms
                charCount[cur]++
            }
            return ""
        }
        return String(s)
    }
}

private val placeSameToPerms = run {
    val maxS = 10_000
    val maxK = 1_000_000
    val placeSameToPerms = Array((maxS shr 1) + 1) { IntArray(it shr 1) + 1 }
    placeSameToPerms[0][0] = 1
    for (place in 1 until placeSameToPerms.size) {
        placeSameToPerms[place][0] = 1
        for (same in 1 until placeSameToPerms[place].size) {
            val l = placeSameToPerms[place - 1][Math.min(same - 1, place - same)]
            val r = placeSameToPerms[place - 1][Math.min(same, place - same - 1)]
            placeSameToPerms[place][same] = Math.min(l + r, maxK)
        }
    }
    placeSameToPerms
}