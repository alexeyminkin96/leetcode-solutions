package problems.p4078

class SolutionImpl2 : Solution {
    override fun threeFibonacciSum(n: Int): Boolean {
        return (n and 1 == 0) && fibs.contains(n shr 1)
    }
}

private val fibs = run {
    val fibs = HashSet<Int>(128)
    var f1 = 0
    var f2 = 1
    fibs.add(f1)
    while (f2 <= 500_000_000) {
        val next = f1 + f2
        f1 = f2
        f2 = next
        fibs.add(f1)
    }
    fibs
}