package problems.p1385

import java.util.Arrays

class SolutionImpl3 : Solution {
    override fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        Arrays.sort(arr1)
        Arrays.sort(arr2)
        var j = 0
        var res = 0
        for (num1 in arr1) {
            while (j < arr2.size && arr2[j] < num1 - d) j++
            if (j == arr2.size || arr2[j] > num1 + d) res++
        }
        return res
    }
}