package b_february

/**
 *  Problem 10. Clear Digits.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "abc",
        "cb34",
        "1abc"
    )

    testCases.forEach { s: String ->
        println("Result ==> ${clearDigits(s)}")
    }

}

fun clearDigits(s: String): String {
    val sb = StringBuilder()
    for (ch in s) {
        if (ch.isDigit()) {
            if (sb.isEmpty()) continue
            sb.deleteCharAt(sb.length - 1)
        } else {
            sb.append(ch)
        }
    }
    return sb.toString()
}