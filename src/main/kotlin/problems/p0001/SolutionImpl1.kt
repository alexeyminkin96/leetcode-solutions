package problems.p0001

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `98.52%` of Kotlin submissions)
 * - Memory: `45.94 MB` (Beats `94.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Approach:**
 * - Iterate over the array once
 * - For each element, calculate its complement (`target - nums[i]`)
 * - Check if the complement exists in the HashMap
 * - If yes → return indices; otherwise store current element in the map
 *
 * **Techniques:**
 * - HashMap lookup
 * - Single-pass traversal
 *
 * **Notes:**
 * - Preallocates the HashMap with `nums.size` for efficiency
 * - Stops immediately once the pair is found
 * - Indices returned in ascending order of appearance
 */
class SolutionImpl1 : Solution {
    override fun twoSum(nums: IntArray, target: Int): IntArray {
        val elementToIndexMap = HashMap<Int, Int>(nums.size)

        for (index in nums.indices) {
            val currentElement = nums[index]
            val pairElementIndex = elementToIndexMap[target - currentElement]
            if (pairElementIndex != null)
                return intArrayOf(pairElementIndex, index)
            else
                elementToIndexMap[currentElement] = index
        }

        throw RuntimeException("Sum not found")
    }
}