package g_july

/**
 *  Problem 21. Delete Characters to Make Fancy String.
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
        "leeetcode",
        "aaabaaaa",
        "aab"
    )

    testCases.forEach { s ->
        println("Result ==> ${makeFancyString(s)}")
    }

}

fun makeFancyString(s: String): String {
    val sb = StringBuilder()
    var cnt = 1
    var last = ' '
    for (ch in s) {
        if (last == ch) {
            if (++cnt <= 2) sb.append(ch)
        } else {
            cnt = 1
            sb.append(ch)
        }
        last = ch
    }
    return sb.toString()
}