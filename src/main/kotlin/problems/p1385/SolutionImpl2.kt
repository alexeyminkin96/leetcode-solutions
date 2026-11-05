package problems.p1385

import java.util.Arrays

class SolutionImpl2 : Solution {
    override fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        Arrays.sort(arr2)
        var res = 0
        for (num1 in arr1) {
            val idx = Arrays.binarySearch(arr2, num1)
            if (idx < 0 &&
                (-idx - 2 < 0 || arr2[-idx - 2] + d < num1) &&
                (-idx - 1 == arr2.size || num1 < arr2[-idx - 1] - d)
            ) res++
        }
        return res
    }
}