package c_march

import kotlin.math.min


/**
 *  Problem 11. Number of Substrings Containing All Three Characters.
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
        "abcabc",
        "aaacb"
    )

    testCases.forEach { s ->
        println("Result ==> ${numberOfSubstrings(s)}")
    }

}

fun numberOfSubstrings(s: String): Int {
    val len: Int = s.length
    val lastPos = intArrayOf(-1, -1, -1)
    var total = 0

    for (pos in 0..<len) {
        lastPos[s[pos] - 'a'] = pos
        total += 1 + min(lastPos[0], min(lastPos[1], lastPos[2]))
    }

    return total
}