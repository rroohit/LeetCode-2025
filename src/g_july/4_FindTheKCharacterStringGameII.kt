package g_july

import kotlin.io.path.Path

/**
 *  Problem 4. Find the K-th Character in String Game II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(logk)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(5L, intArrayOf(0, 0, 0))
    )

    testCases.forEach { (k, operations) ->
        println("Result ==> ${kthCharacter(k, operations)}")
    }

}

fun kthCharacter(k: Long, operations: IntArray): Char {
    var kVar = k
    var ans = 0
    var t: Int

    while (kVar != 1L) {
        t = 63 - kVar.countLeadingZeroBits()
        if ((1L shl t) == kVar) {
            t--
        }
        kVar -= (1L shl t)
        if (operations[t] != 0) {
            ans++
        }
    }

    return ('a' + (ans % 26))
}