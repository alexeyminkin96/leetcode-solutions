package problems.p3551

import java.util.Arrays

class SolutionImpl2 : Solution {
    override fun minSwaps(nums: IntArray): Int {
        val n = nums.size
        val vToI = MapIntInt(n shl 1)
        val sort = LongArray(n) {
            vToI[nums[it]] = it
            (digSum(nums[it]).toLong() shl 32) or nums[it].toLong()
        }
        Arrays.sort(sort)
        var res = 0
        for (newI in 0 until n) {
            val newValue = sort[newI].toInt()
            val oldValue = nums[newI]
            if (nums[newI] == newValue) continue
            val oldI = vToI[newValue]
            vToI[oldValue] = oldI
            vToI[newValue] = newI
            nums[oldI] = oldValue
            nums[newI] = newValue
            res++
        }
        return res
    }

    private fun digSum(num: Int): Int {
        var num = num
        var digSum = 0
        while (num != 0) {
            digSum += num % 10
            num /= 10
        }
        return digSum
    }

    class MapIntInt(cap: Int) {
        private val capacity = Integer.highestOneBit(Math.max(cap, 16) - 1) shl 1
        private val keys = IntArray(capacity)
        private val emptyKey = 0
        private val values = IntArray(capacity)

        operator fun get(key: Int): Int {
            return values[getPos(key)]
        }

        operator fun set(key: Int, value: Int) {
            val pos = getPos(key)
            keys[pos] = key
            values[pos] = value
        }

        private fun getPos(key: Int): Int {
            var pos = pos(key)
            while (pos < capacity && keys[pos] != emptyKey && keys[pos] != key) pos++
            if (pos == capacity) {
                pos = 0
                while (keys[pos] != emptyKey && keys[pos] != key) pos++
            }
            return pos
        }

        private fun pos(key: Int): Int {
            return hash(key) and (capacity - 1)
        }

        private fun hash(key: Int): Int {
            var x = key
            x = x xor (x ushr 16)
            x *= 0x7feb352d
            x = x xor (x ushr 15)
            x *= -0x7b935975
            x = x xor (x ushr 16)
            return x
        }
    }
}