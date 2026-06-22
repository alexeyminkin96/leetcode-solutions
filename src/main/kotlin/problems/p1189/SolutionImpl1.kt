package problems.p1189

class SolutionImpl1 : Solution {
    override fun maxNumberOfBalloons(text: String): Int {
        var b = 0
        var a = 0
        var l = 0
        var o = 0
        var n = 0
        for (c in text.toCharArray())
            when (c) {
                'b' -> b++
                'a' -> a++
                'l' -> l++
                'o' -> o++
                'n' -> n++
            }
        return minOf(b, a, l shr 1, o shr 1, n)
    }
}