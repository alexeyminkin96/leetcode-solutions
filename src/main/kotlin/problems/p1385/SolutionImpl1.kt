package problems.p1385

class SolutionImpl1 : Solution {
    override fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        var res = 0
        outer@ for (num1 in arr1) {
            for (num2 in arr2)
                if (Math.abs(num1 - num2) <= d) continue@outer
            res++
        }
        return res
    }
}