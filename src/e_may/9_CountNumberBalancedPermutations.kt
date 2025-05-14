package e_may

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 9. Count Number of Balanced Permutations.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2 * s)
 *
 *       - Space complexity: O(n^2 + ns)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "123"
    )


}

internal class Solution {
    fun countBalancedPermutations(num: String): Int {
        var tot = 0
        val n = num.length
        val cnt = IntArray(10)
        for (ch in num.toCharArray()) {
            val d = ch.code - '0'.code
            cnt[d]++
            tot += d
        }
        if (tot % 2 != 0) {
            return 0
        }

        val target = tot / 2
        val maxOdd = (n + 1) / 2
        val comb = Array(maxOdd + 1) { LongArray(maxOdd + 1) }
        val f = Array(target + 1) { LongArray(maxOdd + 1) }

        for (i in 0..maxOdd) {
            comb[i][0] = 1
            comb[i][i] = comb[i][0]
            for (j in 1..<i) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD
            }
        }

        f[0][0] = 1
        var psum = 0
        var totSum = 0
        for (i in 0..9) {
            psum += cnt[i]
            totSum += i * cnt[i]
            for (oddCnt in min(psum, maxOdd) downTo max(0, (psum - (n - maxOdd)))) {
                val evenCnt: Int = psum - oddCnt
                for (curr in min(totSum, target) downTo max(0, (totSum - target))) {
                    var res: Long = 0
                    var j = max(0.0, (cnt[i] - evenCnt).toDouble()).toInt()
                    while (j <= min(cnt[i].toDouble(), oddCnt.toDouble()) && i * j <= curr
                    ) {
                        val ways = (comb[oddCnt][j] * comb[evenCnt][cnt[i] - j]) % MOD
                        res = (res + ((ways * f[curr - i * j][oddCnt - j]) % MOD)) % MOD
                        j++
                    }
                    f[curr][oddCnt] = res % MOD
                }
            }
        }

        return f[target][maxOdd].toInt()
    }

    companion object {
        const val MOD: Long = 1000000007
    }
}