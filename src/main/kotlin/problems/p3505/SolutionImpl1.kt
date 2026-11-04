package problems.p3505

import java.util.Arrays
import java.util.TreeMap

/**
 * **LeetCode Performance:**
 * - Runtime: `505 ms` (Beats `50.00%` of Kotlin submissions)
 * - Memory: `243.26 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * (log x + k))`
 * - Space: `O(n * k + x)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/solutions/8601717/kotlin-onklogx-505ms-onk-by-alexeyminkin-r7x3)
 */
class SolutionImpl1 : Solution {
    override fun minOperations(nums: IntArray, x: Int, k: Int): Long {
        val n = nums.size
        var med = findMedian(nums, x)

        var lSum = 0L
        var lCount = 0
        var rSum = 0L
        var rCount = 0
        val tree = TreeMap<Int, Int>()
        for (i in 0 until x) {
            if (nums[i] < med) {
                lCount++
                lSum += nums[i]
            } else if (nums[i] > med) {
                rCount++
                rSum += nums[i]
            }
            tree.compute(nums[i]) { _, v -> (v ?: 0) + 1 }
        }

        var medLCount = ((x - 1) shr 1) - lCount
        lSum += medLCount.toLong() * med
        lCount = (x - 1) shr 1
        var medRCount = (x shr 1) - rCount
        rSum += medRCount.toLong() * med
        rCount = x shr 1

        val moves = LongArray(n - x + 1)
        moves[0] = (lCount.toLong() * med - lSum) + (rSum - rCount.toLong() * med)
        for (i in 0 until n - x) {
            val del = nums[i]
            when {
                del < med -> {
                    lCount--
                    lSum -= del
                }

                del > med -> {
                    rCount--
                    rSum -= del
                }

                else -> {
                    if (lCount == rCount) {
                        lCount--
                        if (medLCount > 0) {
                            lSum -= del
                            medLCount--
                        } else {
                            medRCount = 0
                            med = tree.lowerKey(med)
                            medLCount = tree[med]!! - 1
                            lSum -= med
                        }
                    } else {
                        rCount--
                        if (medRCount > 0) {
                            rSum -= del
                            medRCount--
                        } else {
                            medLCount = 0
                            med = tree.higherKey(med)
                            medRCount = tree[med]!! - 1
                            rSum -= med
                        }
                    }
                }
            }
            tree.compute(del) { _, v -> if (v!! > 1) v - 1 else null }

            val add = nums[i + x]
            when {
                add < med -> {
                    lCount++
                    lSum += add
                }

                add > med -> {
                    rCount++
                    rSum += add
                }

                else -> {
                    if (lCount == rCount) {
                        rCount++
                        rSum += add
                        medRCount++
                    } else {
                        lCount++
                        lSum += add
                        medLCount++
                    }
                }
            }
            tree.compute(add) { _, v -> (v ?: 0) + 1 }

            if (lCount > rCount) {
                rCount++
                lCount--
                if (medLCount > 0) {
                    medRCount++
                    rSum += med
                    medLCount--
                    lSum -= med
                } else {
                    medRCount = 0
                    rSum += med
                    med = tree.lowerKey(med)
                    medLCount = tree[med]!! - 1
                    lSum -= med
                }
            } else if (lCount + 1 < rCount) {
                lCount++
                rCount--
                if (medRCount > 0) {
                    medLCount++
                    lSum += med
                    medRCount--
                    rSum -= med
                } else {
                    medLCount = 0
                    lSum += med
                    med = tree.higherKey(med)
                    medRCount = tree[med]!! - 1
                    rSum -= med
                }
            }

            moves[i + 1] = (lCount.toLong() * med - lSum) + (rSum - rCount.toLong() * med)
        }


        val dp = Array(k + 1) { LongArray(moves.size + 1) }

        for (i in 0 until moves.size)
            for (j in 1..Math.min(k, i / x + 1)) {
                val take = moves[i] + if (j == 1) 0L else dp[j - 1][i - x + 1]
                dp[j][i + 1] = if (i == (j - 1) * x) take else Math.min(dp[j][i], take)
            }

        return dp[k][moves.size]
    }

    private fun findMedian(nums: IntArray, x: Int): Int {
        val buf = IntArray(x)
        System.arraycopy(nums, 0, buf, 0, x)
        Arrays.sort(buf)
        return buf[(x - 1) shr 1]
    }
}