package f_june

import kotlin.math.min


/**
 *  Problem 21. Minimum Deletions to Make String K-Special.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + c^2)
 *
 *       - Space complexity: O(c)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("aabcaba", 0),
        Pair("dabdcbdcdcd", 2)
    )

    testCases.forEach { (word, k) ->
        println("Result ==> ${minimumDeletions(word, k)}")
    }

}

fun minimumDeletions(word: String, k: Int): Int {
    val cnt: MutableMap<Char, Int> = HashMap()
    for (ch in word.toCharArray()) {
        cnt.put(ch, cnt.getOrDefault(ch, 0) + 1)
    }
    var res = word.length
    for (a in cnt.values) {
        var deleted = 0
        for (b in cnt.values) {
            if (a > b) {
                deleted += b
            } else if (b > a + k) {
                deleted += b - (a + k)
            }
        }
        res = min(res, deleted)
    }
    return res
}
