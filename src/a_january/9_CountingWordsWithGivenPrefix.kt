package a_january

import kotlin.math.min

/**
 *  Problem 9. Counting Words With a Given Prefix.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf("pay", "attention", "practice", "attend"), "at"

        ),
        Pair(
            arrayOf("leetcode", "win", "loops", "success"), "code"
        )
    )

    testCases.forEach { test ->

        println("Result ==> ${prefixCount(test.first, test.second)}")
    }

}

// TC - O(N * M) :: SC - O(n)
fun prefixCount(words: Array<String>, pref: String): Int {
    var prefCount = 0
    for (word in words) {
        var i = 0
        while (i < min(word.length, pref.length) && pref[i] == word[i]) i++
        if (i == pref.length) prefCount++
    }
    return prefCount
}