package i_september

/**
 *  Problem 15. Maximum Number of Words You Can Type.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *          - n length of text
 *          - m length of brokenLetters
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            "hello world",
            "ad"
        ),
        Pair(
            "leet code",
            "lt"
        ),
        Pair(
            "leet code",
            "e"
        )
    )

    testCases.forEach { (text, brokenLetters) ->
        println("Result ==> ${canBeTypedWords(text, brokenLetters)}")
    }

}

fun canBeTypedWords(text: String, brokenLetters: String): Int {
    val brokenMap = BooleanArray(26) { false }
    for (ch in brokenLetters) {
        brokenMap[ch - 'a'] = true
    }

    var count = 0
    var ableToType = true
    for (ch in text) {
        if (ch == ' ') {
            if (ableToType) count++
            ableToType = true
        } else if (brokenMap[ch - 'a']) {
            ableToType = false
        }
    }

    if (ableToType) count++

    return count
}