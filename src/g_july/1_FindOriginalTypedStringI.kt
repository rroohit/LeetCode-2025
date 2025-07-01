package g_july

/**
 *  Problem 1. Find the Original Typed String I.
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
        "abbcccc",
        "abcd",
        "aaaa"
    )

    testCases.forEach { word ->
        println("Result ==> ${possibleStringCount(word)}")
    }

}

fun possibleStringCount(word: String): Int {
    var count = 1
    for (i in 1..<word.length) {
        if (word[i - 1] == word[i]) count++
    }
    return count
}