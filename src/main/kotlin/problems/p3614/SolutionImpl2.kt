package problems.p3614

class SolutionImpl2 : Solution {
    override fun processStr(s: String, k: Long): Char {
        val s = s.toCharArray()
        var length = 0L
        var i = 0
        while (i < s.size) when (s[i++]) {
            '*' -> if (length > 0) length--
            '#' -> length = length shl 1
            '%' -> {}
            else -> length++
        }
        if (k >= length) return '.'
        var k = k
        while (k != length) when (s[--i]) {
            '*' -> length++
            '#' -> {
                length = length shr 1
                if (k >= length) k -= length
            }

            '%' -> k = length - 1 - k
            else -> length--
        }
        return s[i]
    }
}