package problems.p3723

import java.util.Arrays

class SolutionImpl2 : Solution {
    override fun maxSumOfSquares(num: Int, sum: Int): String {
        if (num * 9 < sum) return ""
        val res = CharArray(num)
        Arrays.fill(res, 0, sum / 9, '9')
        if (num * 9 > sum)
            res[sum / 9] = '0' + sum % 9
        if (num * 9 - 9 > sum)
            Arrays.fill(res, sum / 9 + 1, res.size, '0')
        return String(res)
    }
}