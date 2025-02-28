package b_february

import kotlin.math.min

/**
 *  Problem 28. Shortest Common Supersequence.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n・m)
 *
 *       - Space complexity: O(n・m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("abac", "cab"),
        Pair("aaaaaaaa", "aaaaaaaa")
    )

    testCases.forEach { test ->
        println("Result ==> ${shortestCommonSupersequence(test.first, test.second)}")
    }

}

fun shortestCommonSupersequence(str1: String, str2: String): String {
    val str1Length = str1.length
    val str2Length = str2.length
    val dp = Array(str1Length + 1) { IntArray(str2Length + 1) }

    for (row in 0..str1Length) {
        dp[row][0] = row
    }

    for (col in 0..str2Length) {
        dp[0][col] = col
    }

    for (row in 1..str1Length) {
        for (col in 1..str2Length) {
            if (str1[row - 1] == str2[col - 1]) {
                dp[row][col] = dp[row - 1][col - 1] + 1
            } else {
                dp[row][col] = (min(dp[row - 1][col], dp[row][col - 1]) + 1)
            }
        }
    }

    val supersequence = StringBuilder()
    var row = str1Length
    var col = str2Length

    while (row > 0 && col > 0) {
        if (str1[row - 1] == str2[col - 1]) {
            supersequence.append(str1[row - 1])
            row--
            col--
        } else if (dp[row - 1][col] < dp[row][col - 1]) {
            supersequence.append(str1[row - 1])
            row--
        } else {
            supersequence.append(str2[col - 1])
            col--
        }
    }

    while (row > 0) {
        supersequence.append(str1[row - 1])
        row--
    }
    while (col > 0) {
        supersequence.append(str2[col - 1])
        col--
    }

    return supersequence.reverse().toString()
}