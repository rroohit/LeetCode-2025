package f_june

import kotlin.math.max

/**
 *  Problem 29. Number of Subsequences That Satisfy the Given Sum Condition.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(3, 5, 6, 7), 9)
    )

    testCases.forEach { (n, t) ->
        println("Result ==> ${numSubseq(n, t)}")
    }

}

fun numSubseq(n: IntArray, t: Int): Int {
    val M = 1_000_000_007; n.sort();
    var cnt = 0
    val f = IntArray(n.size + 2); f[1] = 1
    for ((i, x) in n.withIndex()) {
        f[i + 2] = (f[i + 1] * 2) % M
        var lo = 0;
        var hi = i;
        var j = -1
        while (lo <= hi) {
            val m = (lo + hi) / 2
            if (x + n[m] <= t) {
                j = max(j, m); lo = m + 1
            } else hi = m - 1
        }
        cnt = (cnt + f[i - j]) % M
    }
    return (f[n.size + 1] - cnt - 1 + M) % M
}