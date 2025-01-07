package a_january

/**
 *  Problem 7. String Matching in an Array.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf("mass", "as", "hero", "superhero"),
        arrayOf("leetcode", "et", "code"),
        arrayOf("blue", "green", "bu")
    )

    testCases.forEach { words ->
        println("Result ==> ${stringMatching(words)}")
    }

}

// TC - O(n^2 * k) :: SC - O(n * k)
fun stringMatching(words: Array<String>): List<String> {
    val result = mutableListOf<String>()
    for (word in words) { // O(n)
        if (weHaveSubString(words, word)) result.add(word)
    }
    return result
}

private fun weHaveSubString(words: Array<String>, word: String): Boolean {
    var currCount = 0
    for (word1 in words) { // O(n)
        if (word1.contains(word)) currCount++
        if (currCount >= 2) return true
    }
    return false
}