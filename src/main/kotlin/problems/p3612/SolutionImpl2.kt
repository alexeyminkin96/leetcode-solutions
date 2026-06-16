package problems.p3612

class SolutionImpl2 : Solution {
    override fun processStr(s: String): String {
        var l = 1 shl 20
        var r = l
        var reverse = false
        for (c in s)
            when (c) {
                '*' -> if (l != r) if (reverse) l++ else r--

                '#' -> {
                    val len = r - l
                    if (reverse) {
                        System.arraycopy(ar, l, ar, l - len, len)
                        l -= len
                    } else {
                        System.arraycopy(ar, l, ar, r, len)
                        r += len
                    }
                }

                '%' -> reverse = !reverse

                else -> if (reverse) ar[--l] = c.code.toByte() else ar[r++] = c.code.toByte()
            }
        if (reverse) {
            var tl = l
            var tr = r - 1
            while (tl < tr) {
                val buf = ar[tl]
                ar[tl++] = ar[tr]
                ar[tr--] = buf
            }
        }
        return String(ar, l, r - l)
    }
}

private val ar = ByteArray(1 shl 21)
