package f_june

import java.util.*
import kotlin.math.max
import kotlin.math.min


/**
 *  Problem 11. Maximum Difference Between Even and Odd Frequency II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n×∣Σ∣ ^ 2)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("12233", 4)
    )

    testCases.forEach { (s, k) ->
        println("Result ==> ${maxDifference(s, k)}")
    }

}

fun maxDifference(s: String, k: Int): Int {
    val n = s.length
    var ans = Int.Companion.MIN_VALUE
    var a = '0'
    while (a <= '4') {
        var b = '0'
        while (b <= '4') {
            if (a == b) {
                ++b
                continue
            }
            val best = IntArray(4)
            Arrays.fill(best, Int.Companion.MAX_VALUE)
            var cntA = 0
            var cntB = 0
            var prevA = 0
            var prevB = 0
            var left = -1

            for (right in 0..<n) {
                cntA += if (s[right] == a) 1 else 0
                cntB += if (s[right] == b) 1 else 0

                while (right - left >= k && cntB - prevB >= 2) {
                    val leftStatus = getStatus(prevA, prevB)
                    best[leftStatus] = min(
                        best[leftStatus],
                        prevA - prevB
                    )
                    ++left
                    prevA += if (s.get(left) == a) 1 else 0
                    prevB += if (s.get(left) == b) 1 else 0
                }

                val rightStatus = getStatus(cntA, cntB)
                if (best[rightStatus xor 2] != Int.Companion.MAX_VALUE) {
                    ans = max(
                        ans,
                        cntA - cntB - best[rightStatus xor 2]
                    )
                }
            }
            ++b
        }
        ++a
    }
    return ans
}

private fun getStatus(cntA: Int, cntB: Int): Int {
    return ((cntA and 1) shl 1) or (cntB and 1)
}
