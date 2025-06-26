package f_june

import kotlin.math.ln

/**
 *  Problem 26. Longest Binary Subsequence Less Than or Equal to K.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("1001010", 5)
    )

    testCases.forEach { (s, k) ->
        println("Result ==> ${longestSubsequence(s, k)}")
    }

}

fun longestSubsequence(s: String, k: Int): Int {
    var sm = 0
    var cnt = 0
    val bits = (ln(k.toDouble()) / ln(2.0)).toInt() + 1
    for (i in 0..<s.length) {
        val ch = s[s.length - 1 - i]
        if (ch == '1') {
            if (i < bits && sm + (1 shl i) <= k) {
                sm += 1 shl i
                cnt++
            }
        } else {
            cnt++
        }
    }
    return cnt
}
