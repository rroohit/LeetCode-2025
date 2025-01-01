package a_january

import kotlin.math.max

/**
 *  Problem 1. Maximum Score After Splitting a String.
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
        "011101",
        "00111",
        "1111",
        "11",
        "00",
        "101",
        "011"
    )

    testCases.forEach { str ->
        println("Result ==> ${maxScore(str)}")
    }

}

fun maxScore(s: String): Int {
    var ones = 0
    for (ch in s) if (ch == '1') ones++
    var maxScore = 0
    var zeros = 0

    for (i in 0..<s.length - 1) {
        val ch = s[i]
        if (ch == '1') ones--
        if (ch == '0') zeros++
        maxScore = max(ones + zeros, maxScore)
    }

    return maxScore
}