package problems.p3751

class SolutionImpl1 : Solution {
    override fun totalWaviness(num1: Int, num2: Int): Int {
        var res = 0
        for (it in num1..num2) {
            var num = it
            while (num >= 100) {
                val l = num / 100 % 10
                val m = num / 10 % 10
                val r = num % 10
                if (m > l && m > r || m < l && m < r) res++
                num /= 10
            }
        }
        return res
    }
}