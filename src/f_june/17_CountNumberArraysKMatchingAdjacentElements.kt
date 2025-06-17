package f_june

/**
 *  Problem 17. Count the Number of Arrays with K Matching Adjacent Elements.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(log(n−k))
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

}

class Solution {
    fun comb(n: Int, m: Int): Long {
        return (((fact[n] * invFact[m]) % MOD) * invFact[n - m]) % MOD
    }

    fun countGoodArrays(n: Int, m: Int, k: Int): Int {
        return ((((comb(n - 1, k) * m) % MOD) * qpow((m - 1).toLong(), n - k - 1)) %
                MOD).toInt()
    }

    companion object {
        val MOD: Int = 1e9.toInt() + 7
        const val MX: Int = 100000
        var fact: LongArray = LongArray(MX)
        var invFact: LongArray = LongArray(MX)

        fun qpow(x: Long, n: Int): Long {
            var x = x
            var n = n
            var res: Long = 1
            while (n > 0) {
                if ((n and 1) == 1) {
                    res = (res * x) % MOD
                }
                x = (x * x) % MOD
                n = n shr 1
            }
            return res
        }

        init {
            fact[0] = 1
            for (i in 1..<MX) {
                fact[i] = (fact[i - 1] * i) % MOD
            }
            invFact[MX - 1] = qpow(fact[MX - 1], MOD - 2)
            for (i in MX - 1 downTo 1) {
                invFact[i - 1] = (invFact[i] * i) % MOD
            }
        }
    }
}