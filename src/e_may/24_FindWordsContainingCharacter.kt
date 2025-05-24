package e_may

/**
 *  Problem 24. Find Words Containing Character.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * l)
 *          - n - size of the words array
 *          - l - max length of word from words
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf("leet", "code"),
            'e'
        )
    )

    testCases.forEach { (words, x) ->
        println("Result ==> ${findWordsContaining(words, x)}")
    }

}

fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
    val result = mutableListOf<Int>()
    for (i in words.indices) {
        for (ch in words[i]) {
            if (ch == x) {
                result.add(i)
                break
            }
        }
    }
    return result
}


