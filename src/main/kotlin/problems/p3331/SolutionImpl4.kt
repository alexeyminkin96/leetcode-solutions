package problems.p3331

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `42 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `168.17 MB` (Beats `33.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-subtree-sizes-after-changes/solutions/8619846/kotlin-on-42ms-on-primitives-only-by-ale-u3aj)
 */
class SolutionImpl4 : Solution {
    override fun findSubtreeSizes(parent: IntArray, s: String): IntArray {
        val n = parent.size

        val starts = IntArray(n + 1)
        for (i in 1 until n)
            starts[parent[i] + 1]++
        for (i in 1..n)
            starts[i] += starts[i - 1]

        val children = IntArray(n - 1)
        val pos = Arrays.copyOf(starts, starts.size)
        for (i in 1 until n)
            children[pos[parent[i]]++] = i

        val closestParent = IntArray(n) { -1 }
        val subTreeSizes = IntArray(n) { 1 }
        val charToParent = IntArray(26) { -1 }

        fun dfs(i: Int) {
            closestParent[i] = charToParent[s[i] - 'a']
            charToParent[s[i] - 'a'] = i
            for (j in starts[i] until starts[i + 1])
                dfs(children[j])
            charToParent[s[i] - 'a'] = closestParent[i]
            if (i == 0) return
            val p = if (closestParent[i] != -1) closestParent[i] else parent[i]
            subTreeSizes[p] += subTreeSizes[i]
        }
        dfs(0)

        return subTreeSizes
    }
}