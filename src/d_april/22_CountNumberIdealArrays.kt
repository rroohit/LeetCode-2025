package d_april

import kotlin.math.min


/**
 *  Problem 22. Count the Number of Ideal Arrays.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O((n+ω(m))⋅ω(m)+mω(m))
 *
 *       - Space complexity: O((n+log(m))⋅log(m))
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(2, 5),
        Pair(5, 3)
    )

    testCases.forEach { test ->
        val solution = Solution22()
        println("Result ==> ${solution.idealArrays(test.first, test.second)}")
    }

}


internal class Solution22 {
    companion object {
        var MOD: Int = 1000000007
        var MAX_N: Int = 10010
        var MAX_P: Int = 15
        var c: Array<IntArray> = Array(MAX_N + MAX_P) { IntArray(MAX_P + 1) }
        var sieve: IntArray = IntArray(MAX_N)
        var ps: Array<MutableList<Int>?> = arrayOfNulls(MAX_N)
    }

    init {
        for (i in 0..<MAX_N) {
            ps[i] = ArrayList()
        }

        for (i in 2..<MAX_N) {
            if (sieve[i] == 0) {
                var j = i
                while (j < MAX_N) {
                    if (sieve[j] == 0) {
                        sieve[j] = i
                    }
                    j += i
                }
            }
        }

        for (i in 2..<MAX_N) {
            var x = i
            while (x > 1) {
                val p = sieve[x]
                var cnt = 0
                while (x % p == 0) {
                    x /= p
                    cnt++
                }
                ps[i]?.add(cnt)
            }
        }

        c[0][0] = 1
        for (i in 1..<MAX_N + MAX_P) {
            c[i][0] = 1
            for (j in 1..min(i.toDouble(), MAX_P.toDouble()).toInt()) {
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD
            }
        }
    }

    fun idealArrays(n: Int, maxValue: Int): Int {
        var ans: Long = 0
        for (x in 1..maxValue) {
            var mul: Long = 1
            for (p in ps[x]!!) {
                mul = (mul * c[n + p - 1][p]) % MOD
            }
            ans = (ans + mul) % MOD
        }
        return ans.toInt()
    }

}