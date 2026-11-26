package problems.p3360

class SolutionImpl1 : Solution {
    override fun canAliceWin(n: Int): Boolean {
        var n = n
        var i = 10
        while (n >= i) n -= i--
        return i and 1 == 1
    }
}