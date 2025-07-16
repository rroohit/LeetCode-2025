package g_july

/**
 *  Problem 15. Valid Word.
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
        "234Adas",
        "b3"
    )

    testCases.forEach { word ->
        println("Result ==> ${isValid(word)}")
    }

}

fun isValid(word: String): Boolean {
    if (word.length < 3) return false

    var hasVowel = false
    var hasConsonant = false

    for (ch in word) {
        if (ch.isLetter()) {
            val ch = ch.lowercaseChar()
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                hasVowel = true
            } else {
                hasConsonant = true
            }
        } else if (!ch.isDigit()) {
            return false
        }
    }
    return hasVowel && hasConsonant
}
