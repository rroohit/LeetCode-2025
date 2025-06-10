package f_june

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 8. Maximum Difference Between Even and Odd Frequency I.
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

    val testCases = listOf("aaaaabbc", "abcabcab")

    testCases.forEach { s ->
        println("Result ==> ${maxDifference(s)}")
    }

}

fun maxDifference(s: String): Int {
    val count = IntArray(26)
    for (ch in s) count[ch - 'a']++
    var odd = 0
    var even = Int.MAX_VALUE
    for (cnt in count) {
        if (cnt == 0) continue
        if (cnt % 2 == 0) {
            even = min(even, cnt)
        } else {
            odd = max(odd, cnt)
        }
    }
    return odd - even
}