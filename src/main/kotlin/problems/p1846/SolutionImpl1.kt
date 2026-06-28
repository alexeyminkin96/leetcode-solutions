package problems.p1846

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        Arrays.sort(arr)
        arr[0] = 1
        for (i in 1 until arr.size)
            if (arr[i] > arr[i - 1]) arr[i] = arr[i - 1] + 1
        return arr[arr.size - 1]
    }
}