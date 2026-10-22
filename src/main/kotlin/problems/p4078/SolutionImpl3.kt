package problems.p4078

import java.util.Arrays

class SolutionImpl3 : Solution {
    override fun threeFibonacciSum(n: Int): Boolean {
        return (n and 1 == 0) && (Arrays.binarySearch(fibs, n shr 1) >= 0)
    }
}

private val fibs = run {
    val fibs = IntArray(44)
    var f1 = 0
    var f2 = 1
    var i = 1
    while (f2 <= 500_000_000) {
        val next = f1 + f2
        f1 = f2
        f2 = next
        fibs[i++] = f1
    }
    fibs
}