package problems.p1385

class SolutionImpl4 : Solution {
    override fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        val minConst = -1000
        val maxConst = 1000
        val all = maxConst - minConst + 1
        val left = IntArray(all) { Int.MIN_VALUE }
        val right = IntArray(all) { Int.MAX_VALUE }
        for (num2 in arr2) {
            left[num2 - minConst] = num2 - minConst
            right[num2 - minConst] = num2 - minConst
        }
        for (i in 1 until all) {
            left[i] = Math.max(left[i], left[i - 1])
            right[all - 1 - i] = Math.min(right[all - 1 - i], right[all - i])
        }
        var res = 0
        for (num1 in arr1)
            if (left[num1 - minConst] + d < num1 - minConst && num1 - minConst < right[num1 - minConst] - d) res++
        return res
    }
}