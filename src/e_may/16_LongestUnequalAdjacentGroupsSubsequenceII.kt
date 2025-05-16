package e_may

import java.util.*


/**
 *  Problem 16. Longest Unequal Adjacent Groups Subsequence II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2 * L)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {


}

fun getWordsInLongestSubsequence(
    words: Array<String>,
    groups: IntArray
): List<String> {
    val n = groups.size
    val dp = IntArray(n)
    val prev = IntArray(n)
    Arrays.fill(dp, 1)
    Arrays.fill(prev, -1)
    var maxIndex = 0
    for (i in 1..<n) {
        for (j in 0..<i) {
            if (check(words[i], words[j]) && dp[j] + 1 > dp[i] && groups[i] != groups[j]
            ) {
                dp[i] = dp[j] + 1
                prev[i] = j
            }
        }
        if (dp[i] > dp[maxIndex]) {
            maxIndex = i
        }
    }
    val ans: MutableList<String> = ArrayList()
    var i = maxIndex
    while (i >= 0) {
        ans.add(words[i])
        i = prev[i]
    }
    ans.reverse()
    return ans
}

private fun check(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) {
        return false
    }
    var diff = 0
    for (i in s1.indices) {
        if (s1[i] != s2[i]) {
            if (++diff > 1) {
                return false
            }
        }
    }
    return diff == 1
}
