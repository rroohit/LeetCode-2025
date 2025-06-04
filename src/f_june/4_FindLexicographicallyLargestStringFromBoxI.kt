package f_june

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 4. Find the Lexicographically Largest String From the Box I.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1) or O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("dbca", 2)
    )

    testCases.forEach { (word, numFriends) ->
        println("Result ==> ${answerString(word, numFriends)}")
    }

}

fun answerString(word: String, numFriends: Int): String? {
    if (numFriends == 1) {
        return word
    }
    val last = lastSubstring(word)
    val n = word.length
    val m = last.length

    return last.substring(0, min(m, n - numFriends + 1))
}

fun lastSubstring(s: String): String {
    var i = 0
    var j = 1
    val n = s.length
    while (j < n) {
        var k = 0
        while (j + k < n && s[i + k] == s[j + k]) {
            k++
        }
        if (j + k < n && s[i + k] < s[j + k]) {
            val t = i
            i = j
            j = max(j + 1, t + k + 1)
        } else {
            j = j + k + 1
        }
    }
    return s.substring(i)
}

