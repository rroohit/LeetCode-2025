package e_may

import java.util.*


/**
 *  Problem 15. Longest Unequal Adjacent Groups Subsequence I.
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
        Pair(
            arrayOf("e", "a", "b"),
            intArrayOf(0, 0, 1)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${getLongestSubsequence(test.first, test.second)}")
    }

}

fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
    val ans: MutableList<String> = ArrayList()
    val n = words.size
    for (i in 0..<n) {
        if (i == 0 || groups[i] != groups[i - 1]) {
            ans.add(words[i])
        }
    }
    return ans
}

// TC - O(n^2) :: SC - O(n)
fun getLongestSubsequence1(words: Array<String>, groups: IntArray): List<String> {
    val n = words.size
    val dp = IntArray(n)
    val prev = IntArray(n)
    var maxLen = 1
    var endIndex = 0

    for (i in 0..<n) {
        dp[i] = 1
        prev[i] = -1
    }

    for (i in 1..<n) {
        var bestLen = 1
        var bestPrev = -1
        for (j in i - 1 downTo 0) {
            if (groups[i] != groups[j] && dp[j] + 1 > bestLen) {
                bestLen = dp[j] + 1
                bestPrev = j
            }
        }
        dp[i] = bestLen
        prev[i] = bestPrev
        if (dp[i] > maxLen) {
            maxLen = dp[i]
            endIndex = i
        }
    }

    val res: MutableList<String> = ArrayList()
    var i = endIndex
    while (i != -1) {
        res.add(words[i])
        i = prev[i]
    }

    res.reverse()
    return res
}