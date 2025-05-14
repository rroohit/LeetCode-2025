package e_may


/**
 *  Problem 14. Total Characters in String After Transformations II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n+ logt × ∣Σ∣^3)
 *
 *       - Space complexity: O(∣Σ∣^2)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(
            "abcyy",
            2,
            listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2)
        )
    )

    testCases.forEach { test ->
        val solution = Solution14()
        println("Result ==> ${solution.lengthAfterTransformations(test.first, test.second, test.third)}")
    }

}

internal class Solution14 {
    companion object {
        private const val MOD = 1000000007
        private const val L = 26
    }

    fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
        val T = Mat()
        for (i in 0..<L) {
            for (j in 1..nums[i]) {
                T.a[(i + j) % L][i] = 1
            }
        }

        val res = quickmul(T, t)
        val f = IntArray(L)
        for (ch in s.toCharArray()) {
            f[ch.code - 'a'.code]++
        }
        var ans = 0
        for (i in 0..<L) {
            for (j in 0..<L) {
                ans = ((ans + res.a[i][j].toLong() * f[j]) % MOD).toInt()
            }
        }
        return ans
    }

    class Mat {
        var a: Array<IntArray> = Array(L) { IntArray(L) }

        constructor()
        constructor(copyFrom: Mat) {
            for (i in 0..<L) {
                System.arraycopy(copyFrom.a[i], 0, a[i], 0, L)
            }
        }

        fun mul(other: Mat): Mat {
            val result = Mat()
            for (i in 0..<L) {
                for (j in 0..<L) {
                    for (k in 0..<L) {
                        result.a[i][j] = ((result.a[i][j] + a[i][k].toLong() * other.a[k][j]) % MOD).toInt()
                    }
                }
            }
            return result
        }
    }

    private fun I(): Mat {
        val m = Mat()
        for (i in 0..<L) {
            m.a[i][i] = 1
        }
        return m
    }

    private fun quickmul(x: Mat, y: Int): Mat {
        var y = y
        var ans = I()
        var cur = Mat(x)
        while (y > 0) {
            if ((y and 1) == 1) {
                ans = ans.mul(cur)
            }
            cur = cur.mul(cur)
            y = y shr 1
        }
        return ans
    }
}