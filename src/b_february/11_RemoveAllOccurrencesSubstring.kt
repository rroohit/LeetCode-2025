package b_february

/**
 *  Problem 11. Remove All Occurrences of a Substring.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n ^ 2 / m)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {


    val testCases = listOf(
        Pair("daabcbaabcbc", "abc")
    )

    testCases.forEach { test ->
        println("Result ==> ${removeOccurrences(test.first, test.second)}")
    }

}

fun removeOccurrences(s: String, part: String): String {
    var ss = s
    while (ss.contains(part)) {
        val partStartIndex = ss.indexOf(part)
        ss = ss.substring(0, partStartIndex) + ss.substring(partStartIndex + part.length)
    }
    return ss
}